/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.licence.consume.repo_impl;

import static com.jhw.module.util.licence.core.ModuleLicenceConstants.*;
import com.jhw.module.util.licence.core.domain.LicenceDomain;
import com.jhw.module.util.licence.core.usecase_def.LicenceUseCase;
import com.jhw.module.util.rest_config.services.RESTHandler;
import com.jhw.utils.spring.client.ConsumerRepoTemplate;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LicenceRepoImpl extends ConsumerRepoTemplate<LicenceDomain> implements LicenceUseCase {

    public LicenceRepoImpl() {
        super(LicenceDomain.class, RESTHandler.urlActualREST() + LICENCE_LICENCE_GENERAL_PATH);
    }

    @Override
    protected RestOperations template() {
        return RESTHandler.OAuth2RestTemplate();
    }

    @Override
    public boolean isActive() {
        return template().getForObject(urlGeneral + LICENCE_IS_ACTIVE_PATH, Boolean.class);
    }

    @Override
    public void activate(String activationCode) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int daysUntilActivation() {
        return template().getForObject(urlGeneral + LICENCE_DAYS_LEFT_PATH, Integer.class);
    }

    @Override
    public LicenceDomain read() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(LicenceDomain licence) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
