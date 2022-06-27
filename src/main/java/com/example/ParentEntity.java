package com.example;

import org.hibernate.annotations.Filter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ParentEntity {
    @Id private int id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "parentId", updatable = false, insertable = false)
    @Filter(name = "active")
    private List<ChildEntity> children;

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

    public List<ChildEntity> getChildren() {
        return children;
    }

    public void setChildren(List<ChildEntity> children) {
        this.children = children;
    }
}
