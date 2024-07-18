package com.iub.summitpower.core.entities.fucntional;

import com.iub.summitpower.core.enums.Status;

import java.time.LocalDateTime;

public class Issues extends Task {

    public final static String ENTITY_NAME = "Issues";

    private double budgetToFix;

    public Issues() {
        super();
    }

    public Issues(int id, String modelName,String taskName, String description, Status status, LocalDateTime deadline, double budgetToFix) {
        super(id, modelName,taskName, description, status, deadline);
        this.budgetToFix = budgetToFix;
    }

    public double getBudgetToFix() {
        return budgetToFix;
    }

    public void setBudgetToFix(double budgetToFix) {
        this.budgetToFix = budgetToFix;
    }
}
