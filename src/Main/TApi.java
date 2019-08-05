@POST
@Path("/report")
@Produces(MediaType.APPLICATION_JSON)
public Response getAll(@QueryParam()Integer idReport,@QueryParam()String startDate,@QueryParam()String endDate,@QueryParam()String name) {

return delegate.getAll(idReport,startDate,endDate,name);
}

@POST
@Path("/report")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createReport() {

return delegate.createReport();
}

@GET
@Path("/report-type")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllTypes(@QueryParam()Integer idReport,@QueryParam()String name,@QueryParam()String parameters) {

return delegate.getAllTypes(idReport,name,parameters);
}

