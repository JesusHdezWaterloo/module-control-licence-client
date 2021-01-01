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
package com.root101.module.control.licence.consume.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.root101.module.control.licence.consume.module.LicenceConsumeCoreModule;
import com.root101.module.control.licence.consume.repo_impl.LicenceRepoImpl;
import com.root101.module.control.licence.consume.usecase_def.LicenceUseCaseConsume;
import com.root101.module.control.licence.core.domain.*;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
