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
package com.root101.module.control.licence.ui.module;

import com.root101.clean.core.app.services.NotificationHandler;
import com.root101.clean.core.app.services.NotificationsGeneralType;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.clean.swing.app.AbstractSwingApplication;
import com.root101.clean.swing.app.DefaultAbstractSwingMainModule;
import com.root101.clean.swing.app.dashboard.DashBoardSimple;
import com.root101.clean.swing.app.dashboard.DashboardConstants;
import com.root101.module.control.licence.consume.module.LicenceConsumeCoreModule;
import com.root101.module.control.licence.core.usecase_def.LicenceUseCase;
import com.root101.module.control.licence.service.ResourceKeys;
import com.root101.module.control.licence.service.ResourceServiceClientImplementation;
import com.jhw.swing.material.standards.MaterialIcons;
import com.root101.module.control.licence.services.LicenceResourceService;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class LicenceSwingModule extends DefaultAbstractSwingMainModule {

    private final LicenceModuleNavigator navigator = new LicenceModuleNavigator();

    public static LicenceUseCase licenceUC;

    static {
        licenceUC = LicenceConsumeCoreModule.getInstance().getImplementation(LicenceUseCase.class);
    }

    private LicenceSwingModule() {
    }

    public static LicenceSwingModule init() {
        System.out.println("Creando 'Licencia'");

        LicenceResourceService.init();
        ResourceServiceClientImplementation.init();

        return new LicenceSwingModule();
    }

    @Override
    public void register(AbstractSwingApplication app) {
        registerLicence(app);
    }

    private void registerLicence(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();

        dash.putKeyValue(DashboardConstants.DOWN_LICENCE,
                new AbstractAction(
                        licenceUC.daysUntilActivation() + " " + ResourceHandler.getString(ResourceKeys.MSG_DAY_TO_ACTIVE
                ),
                        MaterialIcons.SECURITY.deriveIcon(16)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                NotificationHandler.showConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR, "ACTIVAR LICENCIA");
            }
        });
    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

}
