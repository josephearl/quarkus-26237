package com.example;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@FilterDef(name = "active", defaultCondition = "active = true")
public class ChildEntity {
    @Id private int id;
    private String name;
    private boolean active;
    private int parentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
