package plantillas;


  public abstract class Button {

public abstract Response createButton();

public abstract Response addDocument(Integer idButton,Integer idDocument);

public abstract Response getActiveButtons(Integer idPage,Boolean active);

public abstract Response getDocumentByButton(Integer idButton);

public abstract Response getButtonByID(Integer idButton);

public abstract Response ModifyButton(Integer idButton);

public abstract Response deleteButtonByID(Integer idButton);


}


  public abstract class Page {

public abstract Response createPage();

public abstract Response getAllPages();

public abstract Response getPageById(Integer idPage);

public abstract Response (Integer idPage);

public abstract Response getPageButtons(Integer idPage);


}


  public abstract class Document {

public abstract Response getDocumentById(Integer idDocument);

public abstract Response ModifyDocument(Integer idDocument);

public abstract Response getAllDocuments();

public abstract Response createDocument();

public abstract Response addButton(Integer idDocument,Integer idButton);

public abstract Response test(String url);

public abstract Response UploadFile(Object name);

public abstract Response DeleteNode(String node);

public abstract Response Refreshacopy();

public abstract Response resetPicture(String link);


}


  public abstract class Line {

public abstract Response getAllLines();

public abstract Response getLineById(Integer idLine);


}
