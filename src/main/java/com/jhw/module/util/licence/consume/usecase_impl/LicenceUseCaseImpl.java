/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.licence.consume.usecase_impl;

import com.clean.core.app.usecase.*;
import com.jhw.module.util.licence.consume.module.LicenceConsumeCoreModule;
import com.jhw.module.util.licence.consume.repo_impl.*;
import com.jhw.module.util.licence.consume.usecase_def.*;
import com.jhw.module.util.licence.core.domain.*;

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