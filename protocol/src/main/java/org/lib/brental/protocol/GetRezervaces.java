/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.protocol;

import org.lib.brental.bussines.BrentalFacadeInterface;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class GetRezervaces extends BrentalCommand {

    public GetRezervaces() {
    }

    @Override
    public Object execute(BrentalFacadeInterface brentalFacede) throws BRentalException {
        return new Rezervaces(brentalFacede.getRezervace());
    }

}
