package com.decipherzone.studentmgnt.dboperation;

import com.decipherzone.studentmgnt.config.JavaMysqlDbConnection;
import com.decipherzone.studentmgnt.entity.Student;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MysqlOperation {
    private JavaMysqlDbConnection javaMysqlDbConnection;
    private Connection connection;

    public MysqlOperation(){
        this.javaMysqlDbConnection=new JavaMysqlDbConnection();
        this.connection=javaMysqlDbConnection.javaMysqlConnection();
    }

    public void addStudentSqlDb(Student student)
    {

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into student values(?,?,?)");
            preparedStatement.setInt(1,student.getId());
            preparedStatement.setString(2,student.getStdname());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Successfully inserted ");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteStudentSqlDb(int id )
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete  from student where id="+id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Successfully deleted");
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void retrieveStudentSqlDb()
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int id=resultSet.getInt("StudentId");
                String name=resultSet.getString("Name");
                int age =resultSet.getInt("Age");
                System.out.println(" Id : "+id+" Name : "+name+" Age : "+age);
            }

        }catch (Exception ex){ex.printStackTrace();}
    }

    public void updateStudentSqlDb(int id , Student student)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update student set Name = ? , Age = ? where StudentId = ?");
            preparedStatement.setString(1,student.getStdname());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
