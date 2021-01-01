package com.jhw.module.util.licence.ui.module;

import com.root101.clean.core.app.services.NotificationHandler;
import com.root101.clean.core.app.services.NotificationsGeneralType;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.clean.swing.app.AbstractSwingApplication;
import com.root101.clean.swing.app.DefaultAbstractSwingMainModule;
import com.root101.clean.swing.app.dashboard.DashBoardSimple;
import com.root101.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.module.util.licence.consume.module.LicenceConsumeCoreModule;
import com.jhw.module.util.licence.core.usecase_def.LicenceUseCase;
import com.jhw.module.util.licence.service.ResourceKeys;
import com.jhw.module.util.licence.service.ResourceServiceClientImplementation;
import com.jhw.module.util.licence.services.LicenceResourceService;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

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
