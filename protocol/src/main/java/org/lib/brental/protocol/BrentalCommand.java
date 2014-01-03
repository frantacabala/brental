/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.protocol;

import java.io.Serializable;
import org.lib.brental.bussines.BrentalFacadeInterface;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public abstract class BrentalCommand implements Serializable{
    public static final Ok OK= new Ok();
    public static final int port = 3456;
    
    public abstract Object execute(BrentalFacadeInterface brentalFacede) throws BRentalException;
    
    
    @Override
    public String toString(){
        return String.format("%s", getClass().getSimpleName());
    }
    
}
