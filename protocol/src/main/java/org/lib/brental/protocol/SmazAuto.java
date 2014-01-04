/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.lib.brental.protocol;

import org.lib.brental.bussines.BrentalFacadeInterface;
import org.lib.brental.model.AutoId;
import org.lib.brental.protocol.BrentalCommand;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class SmazAuto extends BrentalCommand {
    AutoId id;

    public SmazAuto(AutoId id) {
        this.id = id;
    }

    public AutoId getId() {
        return id;
    }

    public void setId(AutoId id) {
        this.id = id;
    }

    
    
    @Override
    public Object execute(BrentalFacadeInterface brentalFacede) throws BRentalException {
        brentalFacede.smazAuto(id);
        return OK;
    }
    
}
