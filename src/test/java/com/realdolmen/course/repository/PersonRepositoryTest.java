package com.realdolmen.course.repository;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.domain.RegularPerson;
import com.realdolmen.course.utilities.persistence.JpaPersistenceTest;

public class PersonRepositoryTest extends JpaPersistenceTest {
    private PersonRepository personRepository;

    private static final long TEST_PERSON_ID = 1000;

    @Before
    public void initializeRepository() {
        personRepository = new PersonRepository();
        personRepository.em = entityManager();
    }

    @Test(expected = ConstraintViolationException.class)
    public void personCanNotBePersistedWithoutFirstName() throws Exception {
        personRepository.save(new RegularPerson(null, "Liskov"));
    }

    @Test(expected = ConstraintViolationException.class)
    public void personCanNotBePersistedWithoutLastName() throws Exception {
        personRepository.save(new RegularPerson("Barbara", null));
    }

    @Test
    public void shouldSaveAPerson() {
        Person p = new RegularPerson("Theo", "Tester");
        personRepository.save(p);
        assertNotNull("Person ID is not supposed to be null after saving", p.getId());
    }

    @Test
    public void shouldReturnAllPersons() {
        List<Person> persons = personRepository.findAll();
        assertNotNull(persons);
        assertEquals(2, persons.size());
    }

    @Test
    public void shouldReturnAPerson() {
        Person p = personRepository.findById(TEST_PERSON_ID);
        assertNotNull(p);
        assertNotNull(p.getId());
        assertEquals("John", p.getFirstName());
    }

    @Test
    public void personCanBeRemoved() throws Exception {
        personRepository.remove(TEST_PERSON_ID);
        assertEquals(1, count(Person.class));
    }

}
