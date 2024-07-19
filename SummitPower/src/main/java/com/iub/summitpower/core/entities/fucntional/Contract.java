package com.iub.summitpower.core.entities.fucntional;

import com.iub.summitpower.core.entities.database.CustomerAgent;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Contract extends BaseFunctional {


    public final static String ENTITY_NAME = "Contract";


    public Contract(){
        super();
    }

    private String name;
    private String description;
    private List<String> terms;
    private LocalDateTime contractStartDate;
    private LocalDateTime contractEndDate;
    private String customerCompanyName;
    private CustomerAgent customerAgent;

    private double kwPerMonth;
    private double totalContractAmount;
    private boolean isActive;

    public Contract(int id, String name, String description, List<String> terms, LocalDateTime contractStartDate, LocalDateTime contractEndDate, String customerCompanyName, CustomerAgent customerAgent, double kwPerMonth, double totalContractAmount, boolean isActive) {
        super(id, ENTITY_NAME);
        this.name = name;
        this.description = description;
        this.terms = terms;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.customerCompanyName = customerCompanyName;
        this.customerAgent = customerAgent;
        this.kwPerMonth = kwPerMonth;
        this.totalContractAmount = totalContractAmount;
        this.isActive = isActive;
    }


    public double durationInMonthNumbers() {
        Duration duration = Duration.between(this.contractStartDate, this.contractEndDate);
        return (double) duration.getSeconds() / (60 * 60 * 24 * 30);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTerms() {
        return terms;
    }

    public void setTerms(List<String> terms) {
        this.terms = terms;
    }

    public LocalDateTime getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDateTime contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDateTime getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDateTime contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getCustomerCompanyName() {
        return customerCompanyName;
    }

    public void setCustomerCompanyName(String customerCompanyName) {
        this.customerCompanyName = customerCompanyName;
    }

    public CustomerAgent getCustomerAgent() {
        return customerAgent;
    }

    public void setCustomerAgent(CustomerAgent customerAgent) {
        this.customerAgent = customerAgent;
    }

    public double getKwPerMonth() {
        return kwPerMonth;
    }

    public void setKwPerMonth(double kwPerMonth) {
        this.kwPerMonth = kwPerMonth;
    }

    public double getTotalContractAmount() {
        return totalContractAmount;
    }

    public void setTotalContractAmount(double totalContractAmount) {
        this.totalContractAmount = totalContractAmount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
