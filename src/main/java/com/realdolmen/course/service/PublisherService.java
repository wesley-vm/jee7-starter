package com.realdolmen.course.service;

import com.realdolmen.course.domain.Address;
import com.realdolmen.course.domain.Book;
import com.realdolmen.course.domain.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PublisherService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

    public void create(Publisher publisher) {
        logger.info("Creating publisher " + publisher.getName());
        em.persist(publisher);
    }

    public Publisher findById(int id) {
        logger.info("Finding publisher by id " + id);
        return em.find(Publisher.class, id);
    }

    public List<Publisher> findAll() {
        logger.info("Finding all publishers");
        return em.createQuery("select p from Publisher p order by p.name").getResultList();
    }

    public List<Book> findBooksByPublisher(int id) {
        return em.getReference(Publisher.class, id).getBooks();
    }

    public List<Book> findBooksByPublisher(String name, Address address) {
        logger.info("Finding books by publisher " + name + " " + address);
        return em.createQuery("select p.books from Publisher p where p.name = :name and p.address = :address")
                .setParameter("name", name)
                .setParameter("address", address)
                .getResultList();
    }
}
