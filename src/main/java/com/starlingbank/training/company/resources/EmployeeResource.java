package com.starlingbank.training.company.resources;

import com.starlingbank.training.company.entities.Employee;
import com.starlingbank.training.company.persistence.DatabaseEmployeePersistenceService;
import com.starlingbank.training.company.persistence.EmployeePersistenceService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api/employees")
public class EmployeeResource {

  private final EmployeePersistenceService employeePersistenceService;

  @Inject
  public EmployeeResource(EmployeePersistenceService employeePersistenceService) {
    this.employeePersistenceService = employeePersistenceService;
  }

  @GET // GET request
  @Produces(MediaType.APPLICATION_JSON) // Response type
  public List<Employee> getEmployeesNames() {
    return employeePersistenceService.getAllEmployees();
  }

  @GET // GET request
  @Produces(MediaType.APPLICATION_JSON) // Response type
  @Path("{employeeId}") // Endpoint path
  public Employee getEmployeesNames(@PathParam("employeeId") Integer employeeId) {
    return employeePersistenceService.getEmployer(employeeId);
  }

  @POST
  public void createNewEmployee(EmployeeRequest employeeRequest) {
    System.out.println("employeeRequest = " + employeeRequest);
  }
}
