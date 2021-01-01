package com.root101.module.control.licence.consume.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.root101.module.control.licence.consume.usecase_def.LicenceUseCaseConsume;
import com.root101.module.control.licence.consume.usecase_impl.LicenceUseCaseImpl;
import com.root101.module.control.licence.core.usecase_def.*;

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
