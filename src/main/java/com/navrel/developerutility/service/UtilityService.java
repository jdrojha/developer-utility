package com.navrel.developerutility.service;

import com.navrel.developerutility.domain.CyberRisk;

import java.util.List;

public interface UtilityService {

    public List<Object> findDataFromMemory();

    void loadDataFromMemory();
}
