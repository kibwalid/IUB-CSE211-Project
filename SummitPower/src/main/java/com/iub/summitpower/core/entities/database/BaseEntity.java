package com.iub.summitpower.core.entities.database;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class BaseEntity implements Serializable {

    private int id;
    private String modelName;

    private LocalDateTime addedAt;

    public BaseEntity() {
        // this is to accommodate conversion from Hashmap to Model
    }

    public BaseEntity(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
        this.addedAt = LocalDateTime.now();
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
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
