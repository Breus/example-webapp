package dev.breus.webapp;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class SimpleApplication extends ResourceConfig {
    public SimpleApplication() {
        property(ServerProperties.WADL_FEATURE_DISABLE, true);
        packages("dev.breus.webapp.resources");
    }
}
