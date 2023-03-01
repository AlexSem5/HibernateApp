package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HQL {
    public static void main(String[] args) {
//        По умолчанию класс Configuration читает конфигурацию из hibernate.properties
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
//            HQL работает с сущностями @Entity, а не с таблицами БД:
//            List<Person> people = session.createQuery("from Person where name like 'T%'").getResultList();
//            people.forEach(person -> System.out.println(person));
            session.createQuery("update Person set name = 'Test' where age = 30").executeUpdate();
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
