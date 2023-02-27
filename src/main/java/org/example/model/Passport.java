package org.example.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Аннотацией @Entity помечаем класс, который связан с бд
 * Класс с @Entity должен иметь пустой конструктор и поле с аннотацией @Id (Это primary key)
 */
@Entity
@Table(name = "Passport")
public class Passport {
//    Эта сущность является owning side - владеющая сторона (foreign key), так ка есть @JoinColumn
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "passport_number")
    private int passportNumber;
    
//    Эта сущность является owning side - владеющая сторона (владеет foreign key)
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private PersonOneToOne owner;
    
    public Passport() {
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Passport(PersonOneToOne owner, int passportNumber) {
        this.owner = owner;
        this.passportNumber = passportNumber;
    }
    
    public PersonOneToOne getOwner() {
        return owner;
    }
    
    public void setOwner(PersonOneToOne owner) {
        this.owner = owner;
    }
    
    public int getPassportNumber() {
        return passportNumber;
    }
    
    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
    
    @Override
    public String toString() {
        return "Passport{" +
               "id=" + id +
               ", passportNumber=" + passportNumber +
               '}';
    }
}
