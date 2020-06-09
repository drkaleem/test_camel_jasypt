package org.example.jasypt;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jasypt.JasyptPropertiesParser;
import org.apache.camel.component.properties.PropertiesComponent;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        CamelContext context = super.getContext();

        JasyptPropertiesParser propParser = new JasyptPropertiesParser();
        propParser.setPassword("sys:jasyptMasterPassword");

        PropertiesComponent propComponent = (PropertiesComponent) context.getPropertiesComponent();
        propComponent.setLocation("classpath:application.properties");
        propComponent.setPropertiesParser(propParser);

        from("timer:mytimer?repeatCount=1")
                .log("**** READ PROPERTIES ")
                .log("*** cool.name - {{cool.name}}")
                .log("*** cool.password - {{cool.password}}");
    }

}
