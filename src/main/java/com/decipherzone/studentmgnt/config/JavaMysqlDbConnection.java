package com.decipherzone.studentmgnt.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class JavaMysqlDbConnection {
    public Connection javaMysqlConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student?useSSL=false", "root", "root");
            return con;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
