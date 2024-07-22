package com.iub.summitpower.core.entities.fucntional;

import com.iub.summitpower.core.entities.database.BaseUser;

import java.util.List;

public class Budget<T> extends BaseFunctional {

    public final static String ENTITY_NAME = "Budget";

    public Budget() {
        super();
    }

    private double budgetAmount;
    private double budgetLeft;
    private BaseUser allocatedBy;
    private List<T> budgetSharedBy;

    public Budget(int id, double budgetAmount, double budgetLeft, BaseUser allocatedBy, List<T> budgetSharedBy) {
        super(id, ENTITY_NAME);
        this.budgetAmount = budgetAmount;
        this.budgetLeft = budgetLeft;
        this.allocatedBy = allocatedBy;
        this.budgetSharedBy = budgetSharedBy;
    }

    public double getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public double getBudgetLeft() {
        return budgetLeft;
    }

    public void setBudgetLeft(double budgetLeft) {
        this.budgetLeft = budgetLeft;
    }

    public BaseUser getAllocatedBy() {
        return allocatedBy;
    }

    public void setAllocatedBy(BaseUser allocatedBy) {
        this.allocatedBy = allocatedBy;
    }

    public List<T> getBudgetSharedBy() {
        return budgetSharedBy;
    }

    public void setBudgetSharedBy(List<T> budgetSharedBy) {
        this.budgetSharedBy = budgetSharedBy;
    }
}
