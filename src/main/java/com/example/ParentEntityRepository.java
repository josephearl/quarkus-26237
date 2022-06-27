package com.example;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ParentEntityRepository implements PanacheRepositoryBase<ParentEntity, Integer> {
}
