package com.iub.summitpower.core.entities.database;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

    private int id;
    private String modelName;

    public BaseEntity() {
        // this is to accommodate conversion from Hashmap to Model
    }

    public BaseEntity(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String toString() {
        return this.modelName + " with ID " + this.id;
    }
}
