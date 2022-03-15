package com.navrel.developerutility.api;

import com.navrel.developerutility.service.UtilityService;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@RequestMapping("/api")
public class UtilityApi {

    @Autowired
    UtilityService utilityService;

    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
            @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
    })
    @GetMapping("/developer-utility/findAllRecord")
    public ResponseEntity<List<Object>> getAllRecords () {
        List<Object> footballers = utilityService.findAllRecords();
        return new ResponseEntity<>(footballers, HttpStatus.OK);
    }

}


