package com.iub.summitpower.core.entities.fucntional;

import java.time.LocalDateTime;

public class WorkHistory extends BaseFunctional {

    public final static String ENTITY_NAME = "WorkHistory";

    private String work;
    private LocalDateTime addedAt;

    public WorkHistory() {
        super();
    }

    public WorkHistory(int id, String work, LocalDateTime addedAt) {
        super(id, ENTITY_NAME);
        this.work = work;
        this.addedAt = addedAt;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }


}
