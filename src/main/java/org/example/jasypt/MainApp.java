package org.example.jasypt;

import org.apache.camel.CamelContext;
import org.apache.camel.Component;
import org.apache.camel.Endpoint;
import org.apache.camel.component.jasypt.JasyptPropertiesParser;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;

import java.util.Map;

public class MainApp {

    public static void main(String... args) throws Exception {
        Main main = new Main();

        System.setProperty("jasyptMasterPassword", "secret");

        main.configure().addRoutesBuilder(new MyRouteBuilder());
        main.run(args);
    }

}

