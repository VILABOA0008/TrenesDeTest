package plantillas;


  public abstract class Button {


@Override
public Response createButton();

    return Response.ok().entity("").build();
  }

@Override
public Response addDocument(Integer idButton,Integer idDocument);

    return Response.ok().entity("").build();
  }

@Override
public Response getActiveButtons(Integer idPage,Boolean active);

    return Response.ok().entity("").build();
  }

@Override
public Response getDocumentByButton(Integer idButton);

    return Response.ok().entity("").build();
  }

@Override
public Response getButtonByID(Integer idButton);

    return Response.ok().entity("").build();
  }

@Override
public Response ModifyButton(Integer idButton);

    return Response.ok().entity("").build();
  }

@Override
public Response deleteButtonByID(Integer idButton);

    return Response.ok().entity("").build();
  }

}


  public abstract class Page {


@Override
public Response createPage();

    return Response.ok().entity("").build();
  }

@Override
public Response getAllPages();

    return Response.ok().entity("").build();
  }

@Override
public Response getPageById(Integer idPage);

    return Response.ok().entity("").build();
  }

@Override
public Response (Integer idPage);

    return Response.ok().entity("").build();
  }

@Override
public Response getPageButtons(Integer idPage);

    return Response.ok().entity("").build();
  }

}


  public abstract class Document {


@Override
public Response getDocumentById(Integer idDocument);

    return Response.ok().entity("").build();
  }

@Override
public Response ModifyDocument(Integer idDocument);

    return Response.ok().entity("").build();
  }

@Override
public Response getAllDocuments();

    return Response.ok().entity("").build();
  }

@Override
public Response createDocument();

    return Response.ok().entity("").build();
  }

@Override
public Response addButton(Integer idDocument,Integer idButton);

    return Response.ok().entity("").build();
  }

@Override
public Response test(String url);

    return Response.ok().entity("").build();
  }

@Override
public Response UploadFile(Object name);

    return Response.ok().entity("").build();
  }

@Override
public Response DeleteNode(String node);

    return Response.ok().entity("").build();
  }

@Override
public Response Refreshacopy();

    return Response.ok().entity("").build();
  }

@Override
public Response resetPicture(String link);

    return Response.ok().entity("").build();
  }

}


  public abstract class Line {


@Override
public Response getAllLines();

    return Response.ok().entity("").build();
  }

@Override
public Response getLineById(Integer idLine);

    return Response.ok().entity("").build();
  }

}
