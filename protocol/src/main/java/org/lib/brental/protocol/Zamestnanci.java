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
import org.lib.brental.model.Zamestnanec;

/**
 *
 * @author john
 */
@XmlRootElement
public class Zamestnanci implements Serializable {
    private Collection<Zamestnanec> item = new ArrayList<>();
    
    public Zamestnanci (Collection<Zamestnanec> item){
        this.item=item;
    }

    public Collection<Zamestnanec> getItem() {
        return item;
    }

    public void setItem(Collection<Zamestnanec> item) {
        this.item = item;
    }
    
    
    @Override
    public String toString(){
        return item.toString();
    }
}
