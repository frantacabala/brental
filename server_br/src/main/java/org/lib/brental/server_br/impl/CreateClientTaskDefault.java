/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.server_br.impl;

import java.net.Socket;
import org.lib.brental.bussines.BrentalFacadeInterface;
import org.lib.brental.server_br.CreateClientTaskService;

/**
 *
 * @author john
 */
public class CreateClientTaskDefault extends CreateClientTaskService {

    @Override
    public Runnable createClientTask(Socket socket, BrentalFacadeInterface facade) {
       return new ClientTask(socket, facade);
    }
    
}
