/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.utils;

/**
 *
 * @author john
 */
public class BRentalException extends Exception {
    public BRentalException(Throwable t){
        super(t);
    }
    
    public BRentalException(String msg){
        super(msg);
    }
}
