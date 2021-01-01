package com.jhw.module.util.licence.consume.module;

import com.root101.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Modulo de Contabilidad_Empresarial-consume-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LicenceConsumeCoreModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new LicenceConsumeCoreInjectionConfig());

    private static LicenceConsumeCoreModule INSTANCE;

    public static LicenceConsumeCoreModule getInstance() {
        if (INSTANCE == null) {
            init();
        }
        return INSTANCE;
    }

    private static void init() {
        INSTANCE = new LicenceConsumeCoreModule();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "Licence Consume Core Module";
    }

}
