package com.realdolmen.course.web.webservice.soap;

import com.realdolmen.course.domain.Address;
import com.realdolmen.course.domain.Book;
import com.realdolmen.course.domain.Publisher;
import com.realdolmen.course.service.PublisherService;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "PublisherService", targetNamespace = "http://www.realdolmen.com/books")
public class PublisherWebService {
    @Inject
    private PublisherService ps;

    @WebMethod(operationName = "Create")
    @WebResult(name = "publisher")
    public Publisher create(@WebParam(name = "name") String name, @WebParam(name = "address") Address address) {
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisher.setAddress(address);
        ps.create(publisher);
        return publisher;
    }

    @WebMethod(operationName = "QuerySingle")
    @WebResult(name = "publisher")
    public Publisher create(@WebParam(name = "id") int id) {
        return ps.findById(id);
    }

    @WebMethod(operationName = "QueryAll")
    @WebResult(name = "publisher")
    public List<Publisher> findAll() {
        return ps.findAll();
    }

    @WebMethod(operationName = "QueryBooksByPublisher")
    public List<Book> findBooksByPublisher(@WebParam(name = "name") String name, @WebParam(name = "address") Address address) {
        return ps.findBooksByPublisher(name, address);
    }
}

