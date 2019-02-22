package com.tma.tlab.api;


import com.tma.tlab.api.util.CmdbPropertie;
import io.katharsis.spring.boot.v3.KatharsisConfigV3;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;


/**
 * Hello world!
 */
@Import({KatharsisConfigV3.class})
@SpringBootApplication
@ComponentScan({"com.tma.tlab.api.repository"})
@EntityScan ("com.tma.tlab.api.model")
@EnableJpaRepositories ("com.tma.tlab.api.util")

public class App extends SpringBootServletInitializer{
    private static Logger logger = LoggerFactory.getLogger(App.class);

    @Autowired
    private CmdbPropertie cmdbProperties;

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    @PostConstruct
    public void init() {

        logger.info(cmdbProperties.toString());
    }

}
