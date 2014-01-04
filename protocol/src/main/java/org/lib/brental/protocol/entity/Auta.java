/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.protocol.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import org.lib.brental.model.Auto;

/**
 *
 * @author john
 */

@XmlRootElement
public class Auta implements Serializable{
    
    private Collection<Auto> auta=new ArrayList<>();
    
    public Auta(){
        
    } 
    
    public Auta(Collection<Auto> auta){
        this.auta=auta;
    }
    
    public void setAuta(Collection<Auto> auta){
        this.auta=auta;
    }
    
    public Collection<Auto> getAuta(){
        return auta;
    }
    
    
    @Override
    public String toString(){
        return auta.toString();
    }
    
    
    
}