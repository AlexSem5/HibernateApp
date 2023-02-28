package org.example.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Аннотацией @Entity помечаем класс, который связан с бд.
 * Класс с @Entity должен иметь пустой конструктор и поле с аннотацией @Id
 */
@Entity
@Table(name = "Person")
public class PersonOneToMany {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "age")
    private int age;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Item> items;
    
    public PersonOneToMany() {
    }
    
    public PersonOneToMany(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public List<Item> getItems() {
        return items;
    }
    
    public void setItems(List<Item> items) {
        this.items = items;
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
    
    public String toString() {
        return name + ", " + age;
    }
    
    public void addItem(Item item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
        item.setOwner(this);
    }
}
