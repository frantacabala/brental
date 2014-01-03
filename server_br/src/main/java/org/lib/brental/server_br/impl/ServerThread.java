/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.server_br.impl;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.brental.bussines.BrentalFacadeInterface;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.model.Auto;
import org.lib.brental.model.AutoId;
import org.lib.brental.protocol.BrentalCommand;
import org.lib.brental.server_br.CreateClientTaskService;

/**
 *
 * @author john
 */
public class ServerThread extends Thread{
     static final Logger logger = Logger.getLogger(ServerThread.class.getName());
    static Class[] preloaded = {
        Auto.class,
        AutoId.class
    };
    
    private ServerSocket ss;
    ExecutorService pool;
    
     static BrentalFacadeInterface createServerFacadeProxy() {
        InvocationHandler ih = new InvocationHandler() {
            Lock lock = new ReentrantLock();

            @Override
            public Object invoke(Object o, Method method, Object[] os) throws Throwable {
                logger.log(Level.INFO, "business: {0}", method.getName());
                lock.lock();
                Object response = null;
                try {
                    response = method.invoke(BrentalFacadeService.getDefault(), os);
                    logger.log(Level.INFO, "response: {0}", response);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    logger.log(Level.SEVERE, null, ex);
                } finally {
                    lock.unlock();
                }
                return response;
            }
        };
        return (BrentalFacadeInterface) Proxy.newProxyInstance(BrentalFacadeInterface.class.getClassLoader(),
                new Class<?>[]{BrentalFacadeInterface.class}, ih);
    }

    public ServerThread() {
        pool = Executors.newFixedThreadPool(1000);
        try {
            ss = new ServerSocket(BrentalCommand.port);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        pool.submit(this);
    }

    @Override
    public void run() {
        for (;;) {
            try {
                logger.log(Level.INFO, "waiting for client");
                Socket s = ss.accept();
                pool.execute(CreateClientTaskService.getDefault().createClientTask(s, createServerFacadeProxy()));
            } catch (IOException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
