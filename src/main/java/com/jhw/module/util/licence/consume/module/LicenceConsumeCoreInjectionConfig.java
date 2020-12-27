package com.jhw.module.util.licence.consume.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jhw.module.util.licence.consume.usecase_def.*;
import com.jhw.module.util.licence.consume.usecase_impl.*;
import com.jhw.module.util.licence.core.usecase_def.*;

/**
 * Configuracion del injection del modulo de PlanTrabajo-consume-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LicenceConsumeCoreInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(LicenceUseCase.class).to(LicenceUseCaseImpl.class).in(Singleton.class);
        bind(LicenceUseCaseConsume.class).to(LicenceUseCaseImpl.class).in(Singleton.class);
    }

}
