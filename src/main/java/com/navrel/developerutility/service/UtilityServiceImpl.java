package com.navrel.developerutility.service;

import com.navrel.developerutility.domain.CyberRisk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UtilityServiceImpl implements UtilityService {

    Logger logger = LogManager.getLogger(UtilityServiceImpl.class);

    List<CyberRisk> cyberRiskList; //Need to keep in Caching

    @Override
    public List<CyberRisk> findCyberRiskAllRecords() {
        logger.info("Entering findCyberRiskAllRecords"+this.cyberRiskList);
        return this.cyberRiskList;

    }

    @Override
    public void initializeCyberRiskData() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            TypeReference<List<CyberRisk>> typeReference = new TypeReference<List<CyberRisk>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/InputPayload.json");

            List<CyberRisk> cyberRiskList  = new ArrayList<CyberRisk>();
            Map<String, Object> map =       mapper.readValue(inputStream, Map.class);
            logger.info("Map ->"+map);
            CyberRisk cyberRisk = new CyberRisk();
            cyberRisk.setCyberRiskType((String) map.get("cyberRiskType"));
            cyberRisk.setInitialRiskConsequence((String) map.get("cyberRiskType"));
            cyberRisk.setRiskStatus((String) map.get("cyberRiskType"));
            cyberRisk.setInitialRiskLikelihood((String) map.get("cyberRiskType"));
            cyberRisk.setIdentificationDate((String) map.get("cyberRiskType"));
            cyberRisk.setNodeName((String) map.get("cyberRiskType"));
            cyberRisk.setInitialLevelOfEffort((String) map.get("cyberRiskType"));

            cyberRiskList.add(cyberRisk);
            logger.debug("CyberRiskList ["+cyberRiskList+"]");
            this.cyberRiskList = cyberRiskList;

        } catch (IOException ie) {
            logger.error("Exception in InitializeCyberRiskData"+ie);
        }
    }

}
