package com.iub.summitpower.core.entities.fucntional;

import com.iub.summitpower.core.entities.database.BaseUser;

import java.util.List;

public class Budget<T> extends BaseFunctional {

    public final static String ENTITY_NAME = "Contract";

    public Budget() {
        super();
    }

    private double budgetAmount;
    private BaseUser allocatedBy;
    private List<T> budgetSharedBy;


}
