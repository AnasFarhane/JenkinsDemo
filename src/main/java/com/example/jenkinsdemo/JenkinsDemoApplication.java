package com.example.jenkinsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.File;
import java.util.Properties;

@SpringBootApplication
public class JenkinsDemoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        String configlocation = System.getProperty("global.appconf.dir"); //get the default config directory location

        String configpath = configlocation + File.separator + "springapplication"  + File.separator + "application.yml"; //set the configpath of this application instance exclusively

        logger.info("configpath: " + configpath);
        logger.info("starting to run spring boot app...");

        if(configlocation != null && !configlocation.isEmpty()) {
            Properties props = new Properties();
            props.setProperty("spring.config.location", configpath); //set the config file to use
            application.application().setDefaultProperties(props);
        }else{
            logger.info("no global.appconf.dir property found, starting with default on classpath");
        }

        return application.sources(JenkinsDemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(JenkinsDemoApplication.class, args);
    }

}
