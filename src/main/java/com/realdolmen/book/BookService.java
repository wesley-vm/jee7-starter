package com.realdolmen.book;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("book")
@Stateless
public class BookService {

	@PersistenceContext
	private EntityManager entityManager;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{bookId}")
	public BookEx findBookById(@PathParam("bookId") Integer bookId) {
		return entityManager.find(BookEx.class, bookId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("all")
	public List<BookEx> findAllBooks() {
		return entityManager.createQuery("select b from BookEx b", BookEx.class).getResultList();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void createBook(BookEx book) {
		entityManager.persist(book);
	}
	
	@DELETE
	@Path("{bookId}")
	public void deleteBook(@PathParam("bookId") Integer bookId) {
		entityManager.remove(findBookById(bookId));
	}
	
	@PUT
	public void updateBook(BookEx book) {
		entityManager.merge(book);
	}
}
