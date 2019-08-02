@POST
@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public Response getAccountById(@QueryParam()Integer idAccount) {

return delegate.getAccountById(idAccount);
}

@POST
@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createAccount() {

return delegate.createAccount();
}

@PUT
@Path("/account/updateAccount")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateAccount(@QueryParam()Integer idAccount,@QueryParam()String newPassword,@QueryParam()String newName) {

return delegate.updateAccount(idAccount,newPassword,newName);
}

@PUT
@Path("/account/assignLineRole")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response assignLineRole(@QueryParam()Integer idAccount,@QueryParam()Integer idLine,@QueryParam()Integer idRole) {

return delegate.assignLineRole(idAccount,idLine,idRole);
}

@GET
@Path("/account/getAccounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAccounts() {

return delegate.getAccounts();
}

@PUT
@Path("/account/enableOrDisableAccount")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response enableOrDisableAccount(@QueryParam()Integer idAccount,@QueryParam()Boolean disable) {

return delegate.enableOrDisableAccount(idAccount,disable);
}

@GET
@Path("/bom/BomWithRelations")
@Produces(MediaType.APPLICATION_JSON)
public Response getBomWithRelations(@QueryParam()Integer idBom) {

return delegate.getBomWithRelations(idBom);
}

@GET
@Path("/bom/BomWithRelations")
@Produces(MediaType.APPLICATION_JSON)
public Response getBomById(@PathParam()Integer idBom) {

return delegate.getBomById(idBom);
}

@PUT
@Path("/bom/{idBom}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateBom(@PathParam()Integer idBom) {

return delegate.updateBom(idBom);
}

@GET
@Path("/bom/{idBom}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllBoms(@QueryParam()Integer idPart,@QueryParam()Integer idClient,@QueryParam()String partText) {

return delegate.getAllBoms(idPart,idClient,partText);
}

@POST
@Path("/bom")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createBom() {

return delegate.createBom();
}

@POST
@Path("/bom/assignInputs/{idBom}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response assignInputs(@PathParam()Integer idBom,@PathParam()List inputs) {

return delegate.assignInputs(idBom,inputs);
}

@GET
@Path("/bom/assignInputs/{idBom}")
@Produces(MediaType.APPLICATION_JSON)
public Response getBomDefinitionById(@PathParam()Integer idBomDefinition) {

return delegate.getBomDefinitionById(idBomDefinition);
}

@PUT
@Path("/bomDefinition/{idBomDefinition}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateBomDefinition(@PathParam()Integer idBomDefinition) {

return delegate.updateBomDefinition(idBomDefinition);
}

@GET
@Path("/bomDefinition")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllBomDefinitions(@QueryParam()Integer idCell,@QueryParam()Integer idBom) {

return delegate.getAllBomDefinitions(idCell,idBom);
}

@POST
@Path("/bomDefinition/assignationToCells/{idBom}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response assignationToCells(@PathParam()Integer idBom) {

return delegate.assignationToCells(idBom);
}

@GET
@Path("/bomDefinition/assignationToCells/{idBom}")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllCells(@QueryParam()Integer idLine,@QueryParam()Integer idStation) {

return delegate.getAllCells(idLine,idStation);
}

@POST
@Path("/cells")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response cellsPost() {

return delegate.cellsPost();
}

@GET
@Path("/cells")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getCellById(@PathParam()Integer idCell) {

return delegate.getCellById(idCell);
}

@PUT
@Path("/cells/{idCell}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateCell(@PathParam()Integer idCell) {

return delegate.updateCell(idCell);
}

@GET
@Path("/cells/{idCell}")
@Produces(MediaType.APPLICATION_JSON)
public Response getClientById(@PathParam()Integer idClient) {

return delegate.getClientById(idClient);
}

@PUT
@Path("/client/{idClient}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateClient(@PathParam()Integer idClient) {

return delegate.updateClient(idClient);
}

@GET
@Path("/client/{idClient}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllClients() {

return delegate.getAllClients();
}

@POST
@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createClient() {

return delegate.createClient();
}

@GET
@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllClientEvents() {

return delegate.getAllClientEvents();
}

@POST
@Path("/clientEvent")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createClientEvent() {

return delegate.createClientEvent();
}

@GET
@Path("/clientEvent")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getClientEventById(@PathParam()Integer idClientEvent) {

return delegate.getClientEventById(idClientEvent);
}

@PUT
@Path("/clientEvent/{idClientEvent}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateClientEvent(@PathParam()Integer idClientEvent) {

return delegate.updateClientEvent(idClientEvent);
}

@GET
@Path("/clientEvent/{idClientEvent}")
@Produces(MediaType.APPLICATION_JSON)
public Response getDesignById(@PathParam()Integer idDesign) {

return delegate.getDesignById(idDesign);
}

@PUT
@Path("/design/{idDesign}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateDesign(@PathParam()Integer idDesign) {

return delegate.updateDesign(idDesign);
}

@GET
@Path("/design/{idDesign}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllDesigns(@QueryParam()Integer idProject,@QueryParam()Integer idVehicle) {

return delegate.getAllDesigns(idProject,idVehicle);
}

@POST
@Path("/design")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createDesign() {

return delegate.createDesign();
}

@GET
@Path("/design")
@Produces(MediaType.APPLICATION_JSON)
public Response getDesignVersionById(@PathParam()Integer idDesignVersion) {

return delegate.getDesignVersionById(idDesignVersion);
}

@PUT
@Path("/designVersion/{idDesignVersion}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateDesignVersion(@PathParam()Integer idDesignVersion) {

return delegate.updateDesignVersion(idDesignVersion);
}

@GET
@Path("/designVersion/{idDesignVersion}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllDesignVersions(@QueryParam()Integer idDesign) {

return delegate.getAllDesignVersions(idDesign);
}

@POST
@Path("/designVersion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createDesignVersion() {

return delegate.createDesignVersion();
}

@GET
@Path("/designVersion")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllGroups(@QueryParam()Integer idLine) {

return delegate.getAllGroups(idLine);
}

@POST
@Path("/groups")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createGroup() {

return delegate.createGroup();
}

@GET
@Path("/groups")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getGroupById(@PathParam()Integer idGroup) {

return delegate.getGroupById(idGroup);
}

@PUT
@Path("/groups/{idGroup}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateGroup(@PathParam()Integer idGroup) {

return delegate.updateGroup(idGroup);
}

@GET
@Path("/groups/{idGroup}")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllIntervalsRecords(@QueryParam()Integer idUnit) {

return delegate.getAllIntervalsRecords(idUnit);
}

@PUT
@Path("/interval/getAllIntervalsRecords")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateInterval(@PathParam()Integer idInterval) {

return delegate.updateInterval(idInterval);
}

@POST
@Path("/interval")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createInterval() {

return delegate.createInterval();
}

@GET
@Path("/interval/getAllIntervals")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllIntervals(@QueryParam()Integer idUnit,@QueryParam()String attribute,@QueryParam()Integer limit,@QueryParam()Integer offset,@QueryParam()Integer page,@QueryParam()String value,@QueryParam()List sort) {

return delegate.getAllIntervals(idUnit,attribute,limit,offset,page,value,sort);
}

@GET
@Path("/lineShiftSummary")
@Produces(MediaType.APPLICATION_JSON)
public Response getLineShiftSummaries(@QueryParam()Integer idLine,@QueryParam()Integer idLineShiftSummary,@QueryParam()Integer idShift,@QueryParam()String shiftDate) {

return delegate.getLineShiftSummaries(idLine,idLineShiftSummary,idShift,shiftDate);
}

@GET
@Path("/lineShiftSummary/current/{idLine}")
@Produces(MediaType.APPLICATION_JSON)
public Response getCurrentLineShiftSummary(@PathParam()Integer idLine) {

return delegate.getCurrentLineShiftSummary(idLine);
}

@GET
@Path("/lineShiftSummary/{idLineShiftSummary}")
@Produces(MediaType.APPLICATION_JSON)
public Response getLineShiftSummaryById(@PathParam()Integer idLineShiftSummary) {

return delegate.getLineShiftSummaryById(idLineShiftSummary);
}

@GET
@Path("/lineShiftSummary/previous/{idLineShiftSummary}")
@Produces(MediaType.APPLICATION_JSON)
public Response getPreviousLineShiftSummary(@PathParam()Integer idLineShiftSummary) {

return delegate.getPreviousLineShiftSummary(idLineShiftSummary);
}

@GET
@Path("/lines/getAllLineRecords")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllLineRecords(@QueryParam()Integer idCell,@QueryParam()Integer idGroup,@QueryParam()Integer idPlant) {

return delegate.getAllLineRecords(idCell,idGroup,idPlant);
}

@GET
@Path("/lines/getAllLineRecords")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllLines(@QueryParam()Integer idCell,@QueryParam()Integer idGroup,@QueryParam()Integer idPlant,@QueryParam()String attribute,@QueryParam()Integer limit,@QueryParam()Integer offset,@QueryParam()Integer page,@QueryParam()String value,@QueryParam()List sort) {

return delegate.getAllLines(idCell,idGroup,idPlant,attribute,limit,offset,page,value,sort);
}

@POST
@Path("/lines")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createLine() {

return delegate.createLine();
}

@GET
@Path("/lines")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getLineById(@PathParam()Integer idLine) {

return delegate.getLineById(idLine);
}

@PUT
@Path("/lines/{idLine}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateLine(@PathParam()Integer idLine) {

return delegate.updateLine(idLine);
}

@GET
@Path("/lines/{idLine}")
@Produces(MediaType.APPLICATION_JSON)
public Response getOrganizationById(@PathParam()Integer idOrganization) {

return delegate.getOrganizationById(idOrganization);
}

@PUT
@Path("/organizations/{idOrganization}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateOrganization(@PathParam()Integer idOrganization) {

return delegate.updateOrganization(idOrganization);
}

@GET
@Path("/organizations/getAllOrganizationRecords")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllOrganizationRecords() {

return delegate.getAllOrganizationRecords();
}

@GET
@Path("/organizations/getAllOrganizationRecords")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllOrganizations(@QueryParam()String attribute,@QueryParam()Integer limit,@QueryParam()Integer offset,@QueryParam()Integer page,@QueryParam()String value,@QueryParam()List sort) {

return delegate.getAllOrganizations(attribute,limit,offset,page,value,sort);
}

@POST
@Path("/organizations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createOrganization() {

return delegate.createOrganization();
}

@GET
@Path("/package/getAllPackageRecords")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllPackageRecords(@QueryParam()String name,@QueryParam()String code) {

return delegate.getAllPackageRecords(name,code);
}

@GET
@Path("/package/getAllPackageRecords")
@Produces(MediaType.APPLICATION_JSON)
public Response getPackageById(@PathParam()Integer idPackage) {

return delegate.getPackageById(idPackage);
}

@PUT
@Path("/package/{idPackage}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updatePackage(@PathParam()Integer idPackage) {

return delegate.updatePackage(idPackage);
}

@GET
@Path("/package/{idPackage}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllPackages(@QueryParam()String name,@QueryParam()String code,@QueryParam()String attribute,@QueryParam()Integer limit,@QueryParam()Integer offset,@QueryParam()Integer page,@QueryParam()String value,@QueryParam()List sort) {

return delegate.getAllPackages(name,code,attribute,limit,offset,page,value,sort);
}

@POST
@Path("/package")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createPackage() {

return delegate.createPackage();
}

@GET
@Path("/part/versions/{idPart}")
@Produces(MediaType.APPLICATION_JSON)
public Response getPartByIdWithVersions(@PathParam()Integer idPart) {

return delegate.getPartByIdWithVersions(idPart);
}

@PUT
@Path("/part/ActivatePartVersion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response activatePartVersion(@QueryParam()Integer idPartVersion) {

return delegate.activatePartVersion(idPartVersion);
}

@PUT
@Path("/part/DeactivatePartVersion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response deactivatePartVersion(@QueryParam()Integer idPartVersion) {

return delegate.deactivatePartVersion(idPartVersion);
}

@PUT
@Path("/part/updatePartVersion/{idPart}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updatePartVersion(@PathParam()Integer idPart) {

return delegate.updatePartVersion(idPart);
}

@PUT
@Path("/part/NewVersion/{idPart}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createNewPartVersion(@PathParam()Integer idPart,@QueryParam()String code) {

return delegate.createNewPartVersion(idPart,code);
}

@PUT
@Path("/part/addPackages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response addPackage(@QueryParam()Integer idPart) {

return delegate.addPackage(idPart);
}

@GET
@Path("/part/addPackages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllParts(@QueryParam()Integer idDesign,@QueryParam()Integer idType,@QueryParam()Boolean onlyActivedPartVersion,@QueryParam()String code,@QueryParam()String name,@QueryParam()Integer limit,@QueryParam()Integer offset,@QueryParam()List sort) {

return delegate.getAllParts(idDesign,idType,onlyActivedPartVersion,code,name,limit,offset,sort);
}

@POST
@Path("/part")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createPart() {

return delegate.createPart();
}

@GET
@Path("/part/getAllRecords")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllRecords(@QueryParam()Integer idDesign,@QueryParam()Integer idType,@QueryParam()String code,@QueryParam()String name,@QueryParam()Boolean onlyActivedPartVersion) {

return delegate.getAllRecords(idDesign,idType,code,name,onlyActivedPartVersion);
}

@GET
@Path("/part/getAllRecords")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getPartById(@PathParam()Integer idPart) {

return delegate.getPartById(idPart);
}

@PUT
@Path("/part/{idPart}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updatePart(@PathParam()Integer idPart) {

return delegate.updatePart(idPart);
}

@GET
@Path("/partWithPackages/{idPart}")
@Produces(MediaType.APPLICATION_JSON)
public Response getPartWithPackagesById(@PathParam()Integer idPart) {

return delegate.getPartWithPackagesById(idPart);
}

@GET
@Path("/parttype")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllPartTypes() {

return delegate.getAllPartTypes();
}

@GET
@Path("/parttype/{idPartType}")
@Produces(MediaType.APPLICATION_JSON)
public Response getPartTypeById(@PathParam()Integer idPartType) {

return delegate.getPartTypeById(idPartType);
}

@GET
@Path("/parttype/{idPartType}")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllPersonals() {

return delegate.getAllPersonals();
}

@POST
@Path("/personals")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createPersonal() {

return delegate.createPersonal();
}

@GET
@Path("/personals")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getPersonalById(@PathParam()Integer idPersonal) {

return delegate.getPersonalById(idPersonal);
}

@PUT
@Path("/personals/{idPersonal}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updatePersonal(@PathParam()Integer idPersonal) {

return delegate.updatePersonal(idPersonal);
}

@GET
@Path("/plants/getAllPlantRecords")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllPlantRecords(@QueryParam()Integer idOrganization,@QueryParam()Integer idLine) {

return delegate.getAllPlantRecords(idOrganization,idLine);
}

@GET
@Path("/plants/getAllPlantRecords")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllPlants(@QueryParam()Integer idOrganization,@QueryParam()Integer idLine,@QueryParam()String attribute,@QueryParam()Integer limit,@QueryParam()Integer offset,@QueryParam()Integer page,@QueryParam()String value,@QueryParam()List sort) {

return delegate.getAllPlants(idOrganization,idLine,attribute,limit,offset,page,value,sort);
}

@POST
@Path("/plants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createPlant() {

return delegate.createPlant();
}

@GET
@Path("/plants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getPlantById(@PathParam()Integer idPlant) {

return delegate.getPlantById(idPlant);
}

@PUT
@Path("/plants/{idPlant}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updatePlant(@PathParam()Integer idPlant) {

return delegate.updatePlant(idPlant);
}

@GET
@Path("/plants/{idPlant}")
@Produces(MediaType.APPLICATION_JSON)
public Response getProjectById(@PathParam()Integer idProject) {

return delegate.getProjectById(idProject);
}

@PUT
@Path("/project/{idProject}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateProject(@PathParam()Integer idProject) {

return delegate.updateProject(idProject);
}

@GET
@Path("/project/{idProject}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllProjects(@QueryParam()Integer idClient) {

return delegate.getAllProjects(idClient);
}

@POST
@Path("/project")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createProject() {

return delegate.createProject();
}

@GET
@Path("/project")
@Produces(MediaType.APPLICATION_JSON)
public Response getShiftById(@PathParam()Integer idShift) {

return delegate.getShiftById(idShift);
}

@PUT
@Path("/shift/{idShift}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateShift(@PathParam()Integer idShift) {

return delegate.updateShift(idShift);
}

@GET
@Path("/shift/{idShift}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllShifts(@QueryParam()Integer idPlant) {

return delegate.getAllShifts(idPlant);
}

@POST
@Path("/shift")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createShift() {

return delegate.createShift();
}

@GET
@Path("/shift")
@Produces(MediaType.APPLICATION_JSON)
public Response getStationById(@PathParam()Integer stationId) {

return delegate.getStationById(stationId);
}

@PUT
@Path("/stations/{stationId}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateStation(@PathParam()Integer stationId) {

return delegate.updateStation(stationId);
}

@GET
@Path("/stations/{stationId}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllStations(@QueryParam()Integer idCell) {

return delegate.getAllStations(idCell);
}

@POST
@Path("/stations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createStation() {

return delegate.createStation();
}

@GET
@Path("/supplier")
@Produces(MediaType.APPLICATION_JSON)
public Response getSupplierById() {

return delegate.getSupplierById();
}

@GET
@Path("/supplier")
@Produces(MediaType.APPLICATION_JSON)
public Response getSystemEventById(@PathParam()Integer idSystemEvent) {

return delegate.getSystemEventById(idSystemEvent);
}

@PUT
@Path("/systemEvent/{idSystemEvent}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateSystemEvent(@PathParam()Integer idSystemEvent) {

return delegate.updateSystemEvent(idSystemEvent);
}

@GET
@Path("/systemEvent/{idSystemEvent}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllSystemEvents() {

return delegate.getAllSystemEvents();
}

@POST
@Path("/systemEvent")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createSystemEvent() {

return delegate.createSystemEvent();
}

@GET
@Path("/systemEvent")
@Produces(MediaType.APPLICATION_JSON)
public Response getTimeUnitById(@PathParam()Integer idUnit) {

return delegate.getTimeUnitById(idUnit);
}

@PUT
@Path("/timeUnit/{idUnit}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateTimeUnit(@PathParam()Integer idUnit) {

return delegate.updateTimeUnit(idUnit);
}

@GET
@Path("/timeUnit/{idUnit}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllTimeUnits() {

return delegate.getAllTimeUnits();
}

@POST
@Path("/timeUnit")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createTimeUnit() {

return delegate.createTimeUnit();
}

@GET
@Path("/timeUnit")
@Produces(MediaType.APPLICATION_JSON)
public Response getToolsetById(@PathParam()Integer idToolset) {

return delegate.getToolsetById(idToolset);
}

@PUT
@Path("/toolset/{idToolset}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateToolset(@PathParam()Integer idToolset) {

return delegate.updateToolset(idToolset);
}

@GET
@Path("/toolset/{idToolset}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllToolsets() {

return delegate.getAllToolsets();
}

@POST
@Path("/toolset")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createToolset() {

return delegate.createToolset();
}

@GET
@Path("/unit/getAllUnitRecords")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllUnitRecords() {

return delegate.getAllUnitRecords();
}

@GET
@Path("/unit/getAllUnitRecords")
@Produces(MediaType.APPLICATION_JSON)
public Response getUnitById(@PathParam()Integer idUnit) {

return delegate.getUnitById(idUnit);
}

@PUT
@Path("/unit/{idUnit}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateUnit(@PathParam()Integer idUnit) {

return delegate.updateUnit(idUnit);
}

@GET
@Path("/unit/{idUnit}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getAllUnits(@QueryParam()String attribute,@QueryParam()Integer limit,@QueryParam()Integer offset,@QueryParam()Integer page,@QueryParam()String value,@QueryParam()List sort) {

return delegate.getAllUnits(attribute,limit,offset,page,value,sort);
}

@POST
@Path("/unit")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createUnit() {

return delegate.createUnit();
}

@GET
@Path("/unit")
@Produces(MediaType.APPLICATION_JSON)
public Response getAllVehicles(@QueryParam()Integer idProject,@QueryParam()Integer idDesign) {

return delegate.getAllVehicles(idProject,idDesign);
}

@POST
@Path("/vehicle")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createVehicle() {

return delegate.createVehicle();
}

@GET
@Path("/vehicle")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response getVehicleById(@PathParam()Integer idVehicle) {

return delegate.getVehicleById(idVehicle);
}

@PUT
@Path("/vehicle")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateVehicle(@PathParam()Integer idVehicle) {

return delegate.updateVehicle(idVehicle);
}

@PUT
@Path("/vehicle")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateVehicle(@PathParam()Integer idVehicle) {

return delegate.updateVehicle(idVehicle);
}

@CREATEINPUTOUTPUT
@Path("/vehicle")
public Response () {

return delegate.();
}

