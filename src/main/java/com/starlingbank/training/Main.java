package com.starlingbank.training;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.starlingbank.training.company.persistence.Database;
import com.starlingbank.training.company.resources.AppResourceConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletContext;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

public class Main {

  public static void main(String[] args) {

    Server server = new Server(8080); // Port 8080
    // startup code
    try {
      server.setHandler(getRESTEasyHandler());
      server.start();
      server.join();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  private static Handler getRESTEasyHandler() {


    Injector injector = Guice.createInjector(new CompanyModule());

    ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

    handler.addEventListener(injector.getInstance(
        GuiceResteasyBootstrapServletContextListener.class));

    ServletHolder servlet = handler.addServlet(HttpServletDispatcher.class, "/");

    servlet.setInitParameter("javax.ws.rs.Application",
        AppResourceConfig.class.getCanonicalName());


    return handler;
  }



  private static void insertExample() {
    Database database = new Database();

    String query = "SELECT  * FROM employee";

    try (Connection conn = database.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)) {

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {

        String employeeUid = resultSet.getString("employee_uid");
        String name = resultSet.getString("name");
        Timestamp dateJoined = resultSet.getTimestamp("date_joined");

        System.out.println(employeeUid);
        System.out.println(name);
        System.out.println(dateJoined);
      }

    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
