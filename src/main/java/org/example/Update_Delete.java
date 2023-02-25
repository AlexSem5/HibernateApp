package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Update_Delete {
    public static void main(String[] args) {
//        По умолчанию класс Configuration читает конфигурацию из hibernate.properties
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
//            Person person = session.get(Person.class, 3);
//            person.setName("New name");
//            Person person = session.get(Person.class, 6);
//            session.delete(person);
            Person person = new Person("Some name", 50);
            session.save(person);
            session.getTransaction().commit();
//            Получаем id:
            System.out.println(person.getId());
        } finally {
            sessionFactory.close();
        }
    }
}
