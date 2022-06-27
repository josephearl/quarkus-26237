package com.example;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ChildEntityRepository implements PanacheRepositoryBase<ChildEntity, Integer> {
}
