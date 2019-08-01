package Main;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.transaction.Transactional;

import com.ctag.paperless.psa.totem.dto.button.ButtonCreateDto;
import com.ctag.paperless.psa.totem.dto.button.ButtonDto;
import com.ctag.paperless.psa.totem.dto.page.PageWithButtonsDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@JpaUnit
@Transactional
@Path("button")
@Api(value = "Button")
public class ButtonApi {

  private static final String ID_BUTTON = "idButton";

  private final ButtonApiService delegate;

  @Inject
  public ButtonApi(ButtonApiService delegate) {
    this.delegate = delegate;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createButton(final ButtonCreateDto buttonRepresentation) {
    return delegate.createButton(buttonRepresentation);
  }

  @PUT
  @Path("{idButton}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateButton(
      @PathParam(ID_BUTTON) Integer id, final ButtonDto buttonRepresentation) {
    if (!id.equals(buttonRepresentation.getIdButton())) {
      throw new BadRequestException("Accumulated identifiers from body and URL don't match");
    }

    return delegate.updateButton(id, buttonRepresentation);
  }

  @GET
  @Path("{idButton}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getButtonByID(@PathParam(ID_BUTTON) Integer idButton) {

    return delegate.getById(idButton);
  }

  @DELETE
  @Path("{idButton}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response deleteButton(@PathParam(ID_BUTTON) Integer idButton) {

    return delegate.deleteButton(idButton);
  }

  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  public Response addDocument(
      @QueryParam(ID_BUTTON) Integer idButton, @QueryParam("idDocument") Integer idDocument) {

    return delegate.addDocument(idButton, idDocument);
  }

  @GET
  @ApiOperation(value = "get a Page active Buttons", response = PageWithButtonsDto.class)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getButtons(
 @QueryParam("idPage") Integer idPage,
      @QueryParam("active") Boolean active) {

    return delegate.getFilteredButtons(idPage, active);
  }

  @GET
  @Path("/Document")
  @ApiOperation(value = "get the Documents of a Button")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getDocumentByButton(
@QueryParam("idButton") Integer idButton) {
    return delegate.getDocumentByButton(idButton);
  }

}
