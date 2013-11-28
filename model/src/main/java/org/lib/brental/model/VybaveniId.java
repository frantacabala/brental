/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.model;

/**
 *
 * @author john
 */
public class VybaveniId{
    String id;
    public VybaveniId(String id){
        this.id=id;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        return compareTo((VybaveniId) o) == 0;
    }

    

    public int compareTo(VybaveniId t) {
        if(id.equals(t.getId())){
            return 0;
        }else 
           return -1;
   }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    
}
