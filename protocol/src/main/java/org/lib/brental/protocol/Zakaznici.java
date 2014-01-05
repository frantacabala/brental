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
import org.lib.brental.model.Zakaznik;


/**
 *
 * @author john
 */
@XmlRootElement
public class Zakaznici implements Serializable {
    private Collection<Zakaznik> item = new ArrayList<>();

    public Zakaznici(Collection<Zakaznik> item) {
    }

    public Collection<Zakaznik> getItem() {
        return item;
    }

    public void setItem(Collection<Zakaznik> item) {
        this.item = item;
    }
    
    @Override
    public String toString(){
        return item.toString();
    }

    
    
}
