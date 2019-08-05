

  public abstract class Report {

public abstract Response getAll(Integer idReport,String startDate,String endDate,String name);

public abstract Response createReport();


}


  public abstract class ReportType {

public abstract Response getAllTypes(Integer idReport,String name,String parameters);


}
