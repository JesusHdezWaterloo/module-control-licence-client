/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.module.control.licence.consume.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.root101.module.control.licence.consume.module.LicenceConsumeCoreModule;
import com.root101.module.control.licence.core.domain.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LicenceUseCaseImpl extends DefaultCRUDUseCase<LicenceDomain> implements LicenceUseCaseConsume {

    private final LicenceRepoImpl repoUC = LicenceConsumeCoreModule.getInstance().getImplementation(LicenceRepoImpl.class);

    public LicenceUseCaseImpl() {
        setRepo(repoUC);
    }

    @Override
    public boolean isActive() {
        return repoUC.isActive();
    }

    @Override
    public void activate(String activationCode) throws Exception {
        repoUC.activate(activationCode);
    }

    @Override
    public int daysUntilActivation() {
        return repoUC.daysUntilActivation();
    }

    @Override
    public LicenceDomain read() throws Exception {
        return repoUC.read();
    }

    @Override
    public void write(LicenceDomain licence) throws Exception {
        repoUC.write(licence);
    }

}
