package org.example;

import org.example.model.Item;
import org.example.model.PersonOneToMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;

public class Cascade {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(PersonOneToMany.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
//            PersonOneToMany person = new PersonOneToMany("Test cascading person", 31);
//            Item item = new Item("Test cascading item", person);
//            person.setItems(new ArrayList<>(Collections.singletonList(item)));
//          метод persist похож на метод save, но учитывает каскадирование:
//           за нас hibernate сделает session.persist(item)
//           session.persist(person);
//            В курсе используем метод save(), т.к. есть аннотация @Cascade:
//            session.save(person);
            
            PersonOneToMany personOneToMany = new PersonOneToMany("New cascade test", 39);
//            Создаём новый метод addItem(Item item) в модели:
            personOneToMany.addItem(new Item("Item1", personOneToMany));
            personOneToMany.addItem(new Item("Item2", personOneToMany));
            personOneToMany.addItem(new Item("Item3", personOneToMany));
            session.save(personOneToMany);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
