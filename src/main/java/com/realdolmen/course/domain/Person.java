package com.realdolmen.course.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
@NamedQuery(name = Person.FIND_ALL_PERSONS_AGED_GREATER_THAN_AVERAGE, query="SELECT p FROM Person p WHERE p.age > (SELECT avg(p2.age) FROM Person p2)")})

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn (name="disc", discriminatorType = DiscriminatorType.STRING)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Person implements Serializable {
	

	public static final String FIND_ALL_PERSONS_AGED_GREATER_THAN_AVERAGE = "Person.findAllPersonsAgedGreaterThanAverage";
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message="First name should be filled in!")
	@Size(message="First name should be made up of atleast 2 characters!", min = 2)
    private String firstName;

    @NotNull(message="Last name should be filled in!")
	@Size(message="Last name should be made up of atleast 2 characters!", min = 2)
    private String lastName;
    
    private int age;

    /**
     * Used by JPA.
     */
    protected Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String name() {
        return firstName + " " + lastName;
    }
}
