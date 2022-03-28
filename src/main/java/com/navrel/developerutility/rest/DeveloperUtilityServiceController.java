package com.navrel.developerutility.rest;

import com.navrel.developerutility.domain.CyberRisk;
import com.navrel.developerutility.service.UtilityService;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@RestController
@RequestMapping("/api")
public class DeveloperUtilityServiceController {

    Logger logger = LogManager.getLogger(DeveloperUtilityServiceController.class);

    @Autowired
    UtilityService utilityService;

    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
            @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
    })
    @GetMapping("/developer-utility/findDataFromMemory")
    public ResponseEntity<List<Object>> getAllRecords () {
        List<Object> cyberRiskList = utilityService.findDataFromMemory();
        return new ResponseEntity<>(cyberRiskList, HttpStatus.OK);
    }

}


