package org.example;

import org.example.model.Actor;
import org.example.model.Item;
import org.example.model.Movie;
import org.example.model.PersonOneToMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManyToMany {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//            Movie movie = new Movie("Pulp fiction", 1994);
//            Actor actor1 = new Actor("actor first", 55);
//            Actor actor2 = new Actor("actor second", 35);
//            movie.setActors(new ArrayList<>(List.of(actor1,actor2)));
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            Не настраивали каскадирования, поэтому делаем всё вручную:
//            session.save(movie);
//            session.save(actor1);
//            session.save(actor2);
//            Movie movie = session.get(Movie.class, 1);
//            System.out.println(movie.getActors());
//            Actor actor = session.get(Actor.class, 1);
//            System.out.println(actor.getMovies());
            
//            Movie movie = new Movie("Dogs", 1992);
//            Actor actor = session.get(Actor.class,1);
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//            session.save(movie);

//            Удалим связь между фильмом и актёром:
            Actor actor = session.get(Actor.class,1);
            Movie movieToRemove = actor.getMovies().get(0);
            
            actor.getMovies().remove(0);
            movieToRemove.getActors().remove(actor);
            
            session.getTransaction().commit();
        }
    }
}
