package com.example;

import io.quarkus.panache.common.Parameters;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class ParentEntityRepositoryTest {
    static final int PARENT_ID = 101;

    @Inject ParentEntityRepository parentEntityRepository;
    @Inject ChildEntityRepository childEntityRepository;

    @BeforeEach
    @Transactional
    void insertData() {
        childEntityRepository.deleteById(1);
        childEntityRepository.deleteById(2);
        parentEntityRepository.deleteById(PARENT_ID);

        ParentEntity p = new ParentEntity();
        p.setId(PARENT_ID);
        p.setName("Mary");
        parentEntityRepository.persistAndFlush(p);

        ChildEntity c1 = new ChildEntity();
        c1.setId(1);
        c1.setName("John");
        c1.setActive(true);
        c1.setParentId(PARENT_ID);
        childEntityRepository.persistAndFlush(c1);

        ChildEntity c2 = new ChildEntity();
        c2.setId(2);
        c2.setName("Mark");
        c2.setActive(false);
        c2.setParentId(PARENT_ID);
        childEntityRepository.persistAndFlush(c2);
    }

    @Test
    @Transactional
    void shouldFindParentWithActiveChildrenList() {
        List<ParentEntity> ps = parentEntityRepository.find("id = :id", Parameters.with("id", PARENT_ID)).filter("active").list();

        assertEquals(1, ps.size());
        assertEquals(1, ps.get(0).getChildren().size());
    }

    // This test fails
    @Test
    @Transactional
    void shouldFindParentWithActiveChildrenStreamToList() {
        List<ParentEntity> ps = parentEntityRepository.find("id = :id", Parameters.with("id", PARENT_ID)).filter("active").stream().toList();

        assertEquals(1, ps.size());
        assertEquals(1, ps.get(0).getChildren().size());
    }

    @Test
    @Transactional
    void shouldFindActiveChildren() {
        List<ChildEntity> cs = childEntityRepository.find("active = true").list();

        assertEquals(1, cs.size());
    }
}
