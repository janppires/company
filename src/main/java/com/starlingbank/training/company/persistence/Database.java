package com.starlingbank.training.company.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

  private static final String DATABASE_URL = "jdbc:postgresql://localhost:15432/template1";

  private final Connection conn;

  public Database() {
    Properties props = new Properties();
//    props.setProperty("user", "jorgepires");
//    props.setProperty("password", "secret");
    try {
      conn = DriverManager.getConnection(DATABASE_URL, props);
    } catch (SQLException e) {
      throw new IllegalStateException("Failed to initiate database connection", e);
    }
  }

  public Connection getConnection() {
    return conn;
  }
}
