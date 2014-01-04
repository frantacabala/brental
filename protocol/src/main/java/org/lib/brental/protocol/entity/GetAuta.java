/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.protocol.entity;

import org.lib.brental.protocol.entity.Auta;
import org.lib.brental.bussines.BrentalFacadeInterface;
import org.lib.brental.protocol.BrentalCommand;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class GetAuta extends BrentalCommand {

    public GetAuta(){
    }

    @Override
    public Object execute(BrentalFacadeInterface brentalFacade) throws BRentalException {
        return new Auta(brentalFacade.getAuta());
    }
}
