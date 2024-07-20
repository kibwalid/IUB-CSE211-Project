package com.iub.summitpower.core.entities.fucntional;

import com.iub.summitpower.core.enums.Status;

import java.time.LocalDateTime;

public class Issues extends Task {

    public final static String ENTITY_NAME = "Issues";

    private double costToFix;

    public Issues() {
        super();
    }

    public Issues(int id, String modelName,String taskName, String description, Status status, LocalDateTime deadline, double costToFix) {
        super(id, modelName,taskName, description, status, deadline);
        this.costToFix = costToFix;
    }

    public double getCostToFix() {
        return costToFix;
    }

    public void setCostToFix(double costToFix) {
        this.costToFix = costToFix;
    }
}
