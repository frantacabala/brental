/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author john
 */
public enum Messages {
    Id,
    nazev,
    jmeno,
    typ,
    kapacita,
    Adresa,
    BRental;
    
    
    //public Messgaes
    
//    public String getM(Object ... msg){
//                
//        try{
//            //String tmpl = msg.name();
//          //  return MessageFormat.format(tmpl, msg);
//        }catch (MissingResourceException | IllegalArgumentException ex){
//            Logger.getLogger(getClass().getName()).log(Level.WARNING,"",ex);
//            return name().replace('_', ' ');
//        }
//    }
//    
}
