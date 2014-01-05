/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.lib.brental.protocol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import org.lib.brental.model.Rezervace;

/**
 *
 * @author john
 */
@XmlRootElement
public class Rezervaces implements Serializable {
    private Collection<Rezervace> item = new ArrayList<>();
    
    public Rezervaces (Collection<Rezervace> item){
        this.item=item;
    }

    public Collection<Rezervace> getItem() {
        return item;
    }

    public void setItem(Collection<Rezervace> item) {
        this.item = item;
    }
    
    
    @Override
    public String toString(){
        return item.toString();
    }
}
