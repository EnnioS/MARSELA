package com.gmc.marsela.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void establecerConnection(){
      /*  String databaseName = "marsela_db_ices_2022";
        String databaseUser = "root";
        String databasePassword = "123456";
        String url ="jdbc:mysql://localhost/"+databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }

    public void closeConnection() {
      /*  try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }
}
