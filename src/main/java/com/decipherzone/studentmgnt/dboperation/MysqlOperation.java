package com.decipherzone.studentmgnt.dboperation;

import com.decipherzone.studentmgnt.config.JavaMysqlDbConnection;
import com.decipherzone.studentmgnt.entity.Student;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;

public class MysqlOperation {
    JavaMysqlDbConnection javaMysqlDbConnection=new JavaMysqlDbConnection();
    Connection connection=javaMysqlDbConnection.javaMysqlConnection();

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



    }



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
