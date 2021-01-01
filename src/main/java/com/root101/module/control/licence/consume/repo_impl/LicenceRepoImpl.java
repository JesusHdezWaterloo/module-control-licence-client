/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.control.licence.consume.repo_impl;

import static com.root101.module.control.licence.core.ModuleLicenceConstants.*;
import com.root101.module.control.licence.core.domain.LicenceDomain;
import com.root101.module.control.licence.core.usecase_def.LicenceUseCase;
import com.jhw.module.util.rest_config.services.RESTHandler;
import com.jhw.utils.spring.client.ConsumerRepoTemplate;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
