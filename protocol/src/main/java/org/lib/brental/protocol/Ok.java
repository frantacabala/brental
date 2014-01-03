/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.protocol;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author john
 */
@XmlRootElement
public class Ok implements Serializable{
    
    @Override
    public String toString(){
        return getClass().getSimpleName();
    }
}
