package com.navrel.developerutility.startup;


import com.navrel.developerutility.domain.CyberRisk;
import com.navrel.developerutility.service.UtilityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DevelopUtilityStartupRunner implements ApplicationRunner {

    Logger logger = LogManager.getLogger(DevelopUtilityStartupRunner.class);

    @Autowired
    UtilityService utilityService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Initiated Loading Data");
        utilityService.loadDataFromMemory();
        logger.info("Data Loading Completed");

    }
}
