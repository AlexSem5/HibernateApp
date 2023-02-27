package org.example.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

/**
 * Аннотацией @Entity помечаем класс, который связан с бд.
 * Класс с @Entity должен иметь пустой конструктор и поле с аннотацией @Id
 */

@Entity
@Table(name = "Person")
public class PersonOneToOne {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "age")
    private int age;
    @OneToOne(mappedBy = "owner")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Passport passport;
    
    public PersonOneToOne() {
    }
    
    public PersonOneToOne(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public Passport getPassport() {
        return passport;
    }
//    Двухстороння связь
    public void setPassport(Passport passport) {
        this.passport = passport;
        passport.setOwner(this);
    }
    
    @Override
    public String toString() {
        return "PersonOneToOne{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", passport=" + passport +
               '}';
    }
}
