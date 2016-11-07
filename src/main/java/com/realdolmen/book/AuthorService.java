package com.realdolmen.book;

import java.net.URI;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("author")
@Stateless
public class AuthorService {

	@PersistenceContext
	private EntityManager entityManager;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{authorId}")
	public Author findBookById(@PathParam("authorId") Integer bookId) {
		return entityManager.find(Author.class, bookId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response createAuthor(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName,
			@QueryParam("birthDate") String birthDate) {
		Author author = new Author(firstName, lastName, birthDate);
		entityManager.persist(author);

		Response.ResponseBuilder responseBuilder = Response.ok();
		responseBuilder.status(201);
		URI uri = UriBuilder.fromPath("http://localhost:8080/jee7-starter/my-rest-api/author/" + author.getId()).build();
		responseBuilder.location(uri);
		return responseBuilder.build();
	}

}
