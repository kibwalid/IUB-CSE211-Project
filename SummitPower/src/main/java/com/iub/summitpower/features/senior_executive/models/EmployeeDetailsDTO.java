package com.iub.summitpower.features.senior_executive.models;

public class EmployeeDetailsDTO {
    private String personalInformation;
    private String auditInformation;
    private String workHistory;
    private String signature;

    public EmployeeDetailsDTO(String personalInformation, String auditInformation, String workHistory, String signature) {
        this.personalInformation = personalInformation;
        this.auditInformation = auditInformation;
        this.workHistory = workHistory;
        this.signature = signature;
    }

    public String getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(String personalInformation) {
        this.personalInformation = personalInformation;
    }

    public String getAuditInformation() {
        return auditInformation;
    }

    public void setAuditInformation(String auditInformation) {
        this.auditInformation = auditInformation;
    }

    public String getWorkHistory() {
        return workHistory;
    }

    public void setWorkHistory(String workHistory) {
        this.workHistory = workHistory;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
