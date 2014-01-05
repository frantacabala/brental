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
import org.lib.brental.model.Vesta;
import org.lib.brental.model.Vybaveni;

/**
 *
 * @author john
 */
@XmlRootElement
public class Vesty implements Serializable {
    private Collection<Vybaveni> item = new ArrayList<>();
    
    public Vesty (Collection<Vybaveni> item){
        this.item=item;
    }

    public Collection<Vybaveni> getItem() {
        return item;
    }

    public void setItem(Collection<Vybaveni> item) {
        this.item = item;
    }
    
    
    @Override
    public String toString(){
        return item.toString();
    }
}
