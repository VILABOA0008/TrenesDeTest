

@JpaUnit
@Transactional
@Path("  Button")
@Api(value = " Button  ")
public class ButtonApi {

  private final ButtonApiService delegate;

  @Inject
  public ButtonApi(ButtonApiService delegate) {
    this.delegate = delegate;
  }
  
  
@PUT
@Path("/button")
public Response createButton() {

return delegate.createButton();
}

}
@PUT
@Path("/button")
public Response addDocument(@QueryParam("idButton") Integer idButton,@QueryParam("idDocument") Integer idDocument) {

return delegate.addDocument(idButton,idDocument);
}

}
@GET
@Path("/button")
public Response getActiveButtons(@QueryParam("idPage") Integer idPage,@QueryParam("active") Boolean active) {

return delegate.getActiveButtons(idPage,active);
}

}
@GET
@Path("/button/Document")
public Response getDocumentByButton(@QueryParam("idButton") Integer idButton) {

return delegate.getDocumentByButton(idButton);
}

}
@GET
@Path("/button/{idButton}")
public Response getButtonByID(@PathParam("idButton") Integer idButton) {

return delegate.getButtonByID(idButton);
}

}
@PUT
@Path("/button/{idButton}")
public Response ModifyButton(@PathParam("idButton") Integer idButton) {

return delegate.ModifyButton(idButton);
}

}
@DELETE
@Path("/button/{idButton}")
public Response deleteButtonByID(@PathParam("idButton") Integer idButton) {

return delegate.deleteButtonByID(idButton);
}

}

@JpaUnit
@Transactional
@Path("  Page")
@Api(value = " Page  ")
public class PageApi {

  private final PageApiService delegate;

  @Inject
  public PageApi(PageApiService delegate) {
    this.delegate = delegate;
  }
  
  
@POST
@Path("/page")
public Response createPage() {

return delegate.createPage();
}

}
@GET
@Path("/page")
public Response getAllPages() {

return delegate.getAllPages();
}

}
@GET
@Path("/page/{idPage}")
public Response getPageById(@PathParam("idPage") Integer idPage) {

return delegate.getPageById(idPage);
}

}
@PUT
@Path("/page/{idPage}")
public Response (@PathParam("idPage") Integer idPage) {

return delegate.(idPage);
}

}
@GET
@Path("/page/buttons/{idPage}")
public Response getPageButtons(@PathParam("idPage") Integer idPage) {

return delegate.getPageButtons(idPage);
}

}

@JpaUnit
@Transactional
@Path("  Document")
@Api(value = " Document  ")
public class DocumentApi {

  private final DocumentApiService delegate;

  @Inject
  public DocumentApi(DocumentApiService delegate) {
    this.delegate = delegate;
  }
  
  
@GET
@Path("/document/{idDocument}")
public Response getDocumentById(@PathParam("idDocument") Integer idDocument) {

return delegate.getDocumentById(idDocument);
}

}
@PUT
@Path("/document/{idDocument}")
public Response ModifyDocument(@PathParam("idDocument") Integer idDocument) {

return delegate.ModifyDocument(idDocument);
}

}
@GET
@Path("/document")
public Response getAllDocuments() {

return delegate.getAllDocuments();
}

}
@POST
@Path("/document")
public Response createDocument() {

return delegate.createDocument();
}

}
@PUT
@Path("/document")
public Response addButton(@QueryParam("idDocument") Integer idDocument,@QueryParam("idButton") Integer idButton) {

return delegate.addButton(idDocument,idButton);
}

}
@GET
@Path("/document/repo")
public Response test(@QueryParam("url") String url) {

return delegate.test(url);
}

}
@POST
@Path("/document/repo")
public Response UploadFile(@QueryParam("name") Object name) {

return delegate.UploadFile(name);
}

}
@DELETE
@Path("/document/repo")
public Response DeleteNode(@QueryParam("node") String node) {

return delegate.DeleteNode(node);
}

}
@PUT
@Path("/document/repo")
public Response Refreshacopy() {

return delegate.Refreshacopy();
}

}
@PUT
@Path("/document/reset")
public Response resetPicture(@QueryParam("link") String link) {

return delegate.resetPicture(link);
}

}

@JpaUnit
@Transactional
@Path("  Line")
@Api(value = " Line  ")
public class LineApi {

  private final LineApiService delegate;

  @Inject
  public LineApi(LineApiService delegate) {
    this.delegate = delegate;
  }
  
  
@GET
@Path("/line")
public Response getAllLines() {

return delegate.getAllLines();
}

}
@GET
@Path("/line/{idLine}")
public Response getLineById(@PathParam("idLine") Integer idLine) {

return delegate.getLineById(idLine);
}

}