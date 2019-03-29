package br.com.cassandraconverter.utils;

import ch.qos.logback.core.db.DriverManagerConnectionSource;

import java.sql.Connection;
import java.sql.SQLException;

public final class MySqlConnect {

    public static Connection getConnect() throws SQLException {
        DriverManagerConnectionSource driverManager = new DriverManagerConnectionSource();
        driverManager.setUrl("jdbc:mysql://localhost:3306/invoice_system_univali?useTimezone=true&serverTimezone=UTC");
        driverManager.setDriverClass("com.mysql.cj.jdbc.Driver");
        driverManager.setUser("admin");
        driverManager.setPassword("admin");
        return driverManager.getConnection();
    }
}
