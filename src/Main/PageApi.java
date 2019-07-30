package Main;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.transaction.Transactional;

import com.ctag.paperless.psa.totem.domain.model.page.Page;
import com.ctag.paperless.psa.totem.dto.page.PageCreateDto;
import com.ctag.paperless.psa.totem.dto.page.PageDto;
import com.ctag.paperless.psa.totem.dto.page.PageWithButtonsDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@JpaUnit
@Transactional
@Path("page")
@Api(value = "Page")
public class PageApi {

  private static final String ID_PAGE = "idPage";
  private final PageApiService delegate;

  @Inject
  public PageApi(PageApiService delegate) {
    this.delegate = delegate;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @ApiOperation(value = "Create aPage", notes = "Here are some notes", response = Page.class)
  public Response createPage(final PageCreateDto pageResentation) {

    return delegate.createPage(pageResentation);
  }

  @GET
  @Path("{idPage}")
  @ApiOperation(value = "get a Page by id", response = Page.class)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPageById(
      @ApiParam(value = "Id of the Page ", required = true) @PathParam(ID_PAGE) Integer idPage) {

    return delegate.getPageById(idPage);
  }

  @GET
  @Path("buttons/{idPage}")
  @ApiOperation(value = "get a Page Buttons", response = PageWithButtonsDto.class)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPageButtons(
      @ApiParam(value = "Id of the Page ", required = true) @PathParam(ID_PAGE) Integer idPage) {

    return delegate.getPageButtons(idPage);
  }

  @PUT
  @Path("{idPage}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updatePage(@PathParam(ID_PAGE) Integer id, final PageDto pageRepresentation) {

    return delegate.updatePage(id, pageRepresentation);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllPages() {
    return delegate.getAllPages();
  }
  

  @DELETE
  @Path("{idPage}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response deletePage(@PathParam(ID_PAGE) Integer idPage) {

    return delegate.deletePage(idPage);
  }
}
