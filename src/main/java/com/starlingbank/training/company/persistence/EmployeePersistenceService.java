package com.starlingbank.training.company.persistence;

import com.starlingbank.training.company.entities.Employee;
import java.util.List;

public interface EmployeePersistenceService {

  List<Employee> getAllEmployees();
  Employee getEmployer(int employeeId);
}
