/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.utils;

import java.text.MessageFormat;
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
    
    public String getM(Object ... args){
        ResourceBundle bnd = ResourceBundle.getBundle("org,=.lib.brental.messages");
        try{
            String tmpl = bnd.getString(name());
            return MessageFormat.format(tmpl, args);
        }catch (MissingResourceException | IllegalArgumentException ex){
            Logger.getLogger(getClass().getName()).log(Level.WARNING,"",ex);
            return name().replace('_', ' ');
        }
    }
    
}
