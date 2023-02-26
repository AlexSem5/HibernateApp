package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.example.model.PersonOneToMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OneToMany {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(PersonOneToMany.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
//            Получили товары, имея человека:
//            PersonOneToMany person = session.get(PersonOneToMany.class, 1);
//            System.out.println(person);
//            List<Item> items = person.getItems();
//            System.out.println(items);

//            Получим товар по владельцу:
//            Item item = session.get(Item.class, 3);
//            System.out.println(item);
//            PersonOneToMany owner = item.getOwner();
//            System.out.println(owner);

//            Добавляем новый товар для человека:
//            PersonOneToMany person = session.get(PersonOneToMany.class, 1);
//            Добавляем с двух сторон - на стороне Person и Item:
//            Item newItem = new Item("Item from Hibernate", person);
//            person.getItems().add(newItem);
//            session.save(newItem);

//            Добавим нового человека с одним единственным заказом:
//            PersonOneToMany personOneToMany = new PersonOneToMany("Vasiliy", 31);
//            Item item = new Item("new item",personOneToMany);
//            personOneToMany.setItems(new ArrayList<>(Collections.singletonList(item)));
//            session.save(personOneToMany);
//            session.save(item);

//            Удалим все товары у человека:
//            PersonOneToMany person = session.get(PersonOneToMany.class, 1);
//            List<Item> items = person.getItems();
//            Порождает SQL запрос к БД, то есть удаляем строки из таблицы:
//            items.forEach(item -> session.remove(item));
//            Не порождает SQL, но необходимо для того, чтобы в кэш все было верно
//            items.clear();

//            Удадяем человека с учётом каскадирования (null):
//            PersonOneToMany personOneToMany = session.get(PersonOneToMany.class, 3);
//            Породит SQL запрос к БД, она сделает каскадирование и сама назначит null в БД:
//            session.remove(personOneToMany);
//            Сделаем, чтобы в кэш у каждого item в качестве владельца был null:
//            personOneToMany.getItems().forEach(item -> item.setOwner(null));

//            Поменяем владельца у существующего товара:
            Item item = session.get(Item.class, 3);
            PersonOneToMany personOneToMany = session.get(PersonOneToMany.class, 1);
            item.getOwner().getItems().remove(item);
//            Эта строчка породит SQL-запрос:
            item.setOwner(personOneToMany);
            personOneToMany.getItems().add(item);
            
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
