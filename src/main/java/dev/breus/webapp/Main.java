package dev.breus.webapp;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.servlet.ServletContainer;

import java.io.File;

public class Main {
    private static final int PORT = 8080;

    public static void main(String[] args) throws LifecycleException {
        new Main().start();
    }

    public void start() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(PORT);

        Context context = tomcat.addWebapp("", new File(".").getAbsolutePath());
        Tomcat.addServlet(context, "jersey-container-servlet", resourceConfig());
        context.addServletMappingDecoded("/*", "jersey-container-servlet");

        tomcat.start();
        tomcat.getConnector();
        tomcat.getServer().await();
    }

    private static ServletContainer resourceConfig() {
        return new ServletContainer(new SimpleApplication());
    }
}
