package com.navrel.developerutility.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


public class CyberRisk {

    private String initialRiskConsequence;

    private String identificationDate;
    private String cyberRiskType;
    private String riskStatus;
    private String initialRiskLikelihood;
    private String initialLevelOfEffort;
    private String nodeName;

    public String getInitialRiskConsequence() {
        return initialRiskConsequence;
    }

    public void setInitialRiskConsequence(String initialRiskConsequence) {
        this.initialRiskConsequence = initialRiskConsequence;
    }

    public String getIdentificationDate() {
        return identificationDate;
    }

    public void setIdentificationDate(String identificationDate) {
        this.identificationDate = identificationDate;
    }

    public String getCyberRiskType() {
        return cyberRiskType;
    }

    public void setCyberRiskType(String cyberRiskType) {
        this.cyberRiskType = cyberRiskType;
    }

    public String getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(String riskStatus) {
        this.riskStatus = riskStatus;
    }

    public String getInitialRiskLikelihood() {
        return initialRiskLikelihood;
    }

    public void setInitialRiskLikelihood(String initialRiskLikelihood) {
        this.initialRiskLikelihood = initialRiskLikelihood;
    }

    public String getInitialLevelOfEffort() {
        return initialLevelOfEffort;
    }

    public void setInitialLevelOfEffort(String initialLevelOfEffort) {
        this.initialLevelOfEffort = initialLevelOfEffort;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    @Override
    public String toString() {
        return "CyberRisk{" +
                "initialRiskConsequence='" + initialRiskConsequence + '\'' +
                ", identificationDate=" + identificationDate +
                ", cyberRiskType='" + cyberRiskType + '\'' +
                ", riskStatus=" + riskStatus +
                ", initialRiskLikelihood='" + initialRiskLikelihood + '\'' +
                ", initialLevelOfEffort='" + initialLevelOfEffort + '\'' +
                ", nodeName='" + nodeName + '\'' +
                '}';
    }
}
