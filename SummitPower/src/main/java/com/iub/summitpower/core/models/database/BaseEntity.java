package com.iub.summitpower.core.models.database;

public abstract class BaseEntity {

    private Integer id;
    private String modelName;

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
