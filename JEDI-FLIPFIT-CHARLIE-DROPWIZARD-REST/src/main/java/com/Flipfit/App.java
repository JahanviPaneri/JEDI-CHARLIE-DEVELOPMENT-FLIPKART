package com.Flipfit;

import com.Flipfit.rest.AdminController;
import com.Flipfit.rest.CustomerController;
import com.Flipfit.rest.GymOwnerController;
import com.Flipfit.rest.LandingController;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Environment;

public class App extends Application<AppConfiguration> {

    public static void main(final String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(final AppConfiguration configuration, final Environment environment) {

        environment.jersey().register(new AdminController());
        environment.jersey().register(new CustomerController());
        environment.jersey().register(new GymOwnerController());
        environment.jersey().register(new LandingController());

    }
}