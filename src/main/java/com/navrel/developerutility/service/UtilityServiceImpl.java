package com.navrel.developerutility.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UtilityServiceImpl  implements  UtilityService{
    @Override
    public List<Object> findAllRecords() {
        List<Object> obj = new ArrayList<>();
        String str = "hello";
        obj.add(str);
        return obj;
    }
}
