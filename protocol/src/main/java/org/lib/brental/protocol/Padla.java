package org.lib.brental.protocol;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import org.lib.brental.model.Padlo;
import org.lib.brental.model.Vybaveni;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author john
 */
@XmlRootElement
public class Padla implements Serializable {
    private Collection<Vybaveni> item = new ArrayList<>();
    
    public Padla (Collection<Vybaveni> item){
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