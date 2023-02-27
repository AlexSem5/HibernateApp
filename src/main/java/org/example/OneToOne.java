package org.example;

import org.example.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOne {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(PersonOneToOne.class)
                .addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            PersonOneToOne person = new PersonOneToOne("Test person",50);
            Passport passport = new Passport(person, 12345);
//            Устанавливаем связь с двух сторон:
            person.setPassport(passport);
            session.save(person);

//            PersonOneToOne personOneToOne = session.get(PersonOneToOne.class, 1);
//            System.out.println(personOneToOne.getPassport().getPassportNumber());
            
//            Passport passport = session.get(Passport.class, 1);
//            System.out.println(passport.getOwner().getName());
            
//            Passport находится в состоянии Persistent managed, поэтому Hibernate
//            отслеживает Passport и Setters:
//            PersonOneToOne personOneToOne = session.get(PersonOneToOne.class, 1);
//            personOneToOne.getPassport().setPassportNumber(55555);
//            PersonOneToOne personOneToOne = session.get(PersonOneToOne.class, 1);
//            session.remove(personOneToOne);
            
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
