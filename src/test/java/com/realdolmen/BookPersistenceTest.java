package com.realdolmen;

import com.realdolmen.course.domain.Book;
import com.realdolmen.course.domain.Publisher;
import com.realdolmen.course.utilities.persistence.JpaPersistenceTest;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

public class BookPersistenceTest extends JpaPersistenceTest {
    private EntityManager em;

    @Before
    public void setUp() throws Exception {
        em = entityManager();
    }

    @Test
    public void bookCanBeRetrievedById() throws Exception {
        Book book = em.find(Book.class, 1000);
        assertEquals("Nineteen Eighty Four", book.getTitle());
    }

    @Test
    public void publisherCanBeRetrievedById() throws Exception {
        Publisher publisher = em.find(Publisher.class, 2000);
        assertEquals("Het Kleine Huisje", publisher.getName());
    }

    @Test
    public void bookHasAPublisher() throws Exception {
        assertEquals("Penguin Classics", em.find(Book.class, 1000).getPublisher().getName());
    }
}
