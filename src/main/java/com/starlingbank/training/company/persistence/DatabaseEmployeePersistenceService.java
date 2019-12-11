package com.starlingbank.training.company.persistence;

import com.starlingbank.training.company.entities.Employee;
import com.starlingbank.training.company.entities.Programmer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DatabaseEmployeePersistenceService implements EmployeePersistenceService {

  private final Database database;

  public DatabaseEmployeePersistenceService() {
    database = new Database();
  }

  @Override
  public List<Employee> getAllEmployees() {

    List<Employee> employees = new ArrayList<>();

    String query = "SELECT id, name, employee_type, employee_uid, date_joined FROM employee";

    try (Connection conn = database.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)) {


      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String employeeType = resultSet.getString("employee_type");
        Date employeeUid = resultSet.getDate("date_of_birth");
        Timestamp dateJoined = resultSet.getTimestamp("date_joined");


        if(employeeType.equals("PROGRAMMER")) {
          employees.add(new Programmer(
              id,
              name,
              null
          ));
        } else {
          throw new IllegalStateException("employeeType not recognized");
        }
      }

      return employees;

    } catch (SQLException e) {
      throw new IllegalStateException("Something is wrong", e);
    }
  }

  @Override
  public Employee getEmployer(int employeeId) {
    String query = "SELECT id, name, employee_type, employee_uid, date_joined FROM employee WHERE id = ?";

    try (Connection conn = database.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)) {


      preparedStatement.setInt(1, employeeId);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String employeeType = resultSet.getString("employee_type");
        String employeeUid = resultSet.getString("employee_uid");
        Timestamp dateJoined = resultSet.getTimestamp("date_joined");


        if(employeeType.equals("PROGRAMMER")){
          return new Programmer(
              id,
              name,
              null
          );
        }

        throw new IllegalStateException("employeeType not recognized");
      }

    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    }

    throw new IllegalStateException("Something is wrong");
  }

  public void addNewProgrammer(String name) {
    String employeeType = "PROGRAMMER";
    String insertStatement = "INSERT INTO employee (employee_uid, name, employee_type, date_joined) VALUES (?, ?, ?, ?)";

    try (Connection conn = database.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(insertStatement)) {

      preparedStatement.setObject(1, UUID.randomUUID());
      preparedStatement.setString(2, name);
      preparedStatement.setString(3, employeeType);
      preparedStatement.setTimestamp(4, Timestamp.from(Instant.now()));

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    }
  }

}
