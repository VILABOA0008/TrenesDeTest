@GET
@Path('/cells/{idCell}')
@Produces(MediaType.APPLICATION_JSON)
public Response getClientById(@PathParam(ID_PAGE) Integer id, final PageDto pageRepresentation) {

return delegate.updatePage(id, pageRepresentation);
}

@PUT
@Path('/client/{idClient}')
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateClient(@PathParam(ID_PAGE) Integer id, final PageDto pageRepresentation) {

return delegate.updatePage(id, pageRepresentation);
}

@GET
@Path('/client/{idClient}')
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllClients(@PathParam(ID_PAGE) Integer id, final PageDto pageRepresentation) {

return delegate.updatePage(id, pageRepresentation);
}

@POST
@Path(/client)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createClient(@PathParam(ID_PAGE) Integer id, final PageDto pageRepresentation) {

return delegate.updatePage(id, pageRepresentation);
}

