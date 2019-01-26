package com.examples.jpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager entityManager;    // 가장 핵심적

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("keesun");
//        account.setPassword("pass");
        account.setPassword("hibernate");

        Study study = new Study();
        study.setNaem(("Spring Data JPA"));
        study.setOwner(account);

//        entityManager.persist(account);
        Session session = entityManager.unwrap(Session.class);
        session.save(account);
    }

}
