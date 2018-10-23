package com.decipherzone.studentmgnt.task;

import com.decipherzone.studentmgnt.dboperation.MysqlOperation;
import com.decipherzone.studentmgnt.entity.Student;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;

public class TaskSql {
    private  static int id =0;
    private InputStreamReader reader=new InputStreamReader(System.in);
    private BufferedReader bufferedReader=new BufferedReader(reader);

    /**
     * purpose:method for adding student
     * Implementation note:student id is generated
     * student name input from user
     * student age input from user
     * calling  method add student in database

     * exception can occur because user may enter invalid input
     */
    public  void addStudent()//method for adding student details
    {
        try
        {
            id = id + 1;

            System.out.println("Enter Student Name");
            String stdname = bufferedReader.readLine();//student name input from user
            System.out.println("Sucessfully insert Student name :"+stdname);
            System.out.println("Enter Student age");
            int age = Integer.parseInt(bufferedReader.readLine());//student age input from user
            System.out.println("Sucessfully insert Student Age :"+age);
            Student student = new Student() ;
            student.setId(id);
            student.setStdname(stdname);
            student.setAge(age);
            MysqlOperation addStudent=new MysqlOperation();
            addStudent.addStudentSqlDb(student);
            System.out.println("Successfully added student details");
        }
        catch(Exception exception)
        {
            System.out.println("Invalid  input"+exception);
        }


    }

    /**
     * purpose: method to remove
     * implementation : student id input from user which user wants to delete
     calling method remove student from database

     *Exception may occur due to user invalid input
     */

    public  void removeStudent()//method remove student details
    {
        try
        {
            System.out.println("Enter Student ID");
            int id = Integer.parseInt(bufferedReader.readLine());//student Id input from user
            System.out.println("Sucessfully insert Student Id :"+id);

            MysqlOperation deleteStudent=new MysqlOperation();
            deleteStudent.deleteStudentSqlDb(id );

        }
        catch (Exception exception)
        {
            System.out.println("invalid user input");
        }
    }

    /**
     * purpose:Method for display student list
     * implementation:Calling method for display student from database
     */
    public void display()//method for display list of student details
    {
        MysqlOperation retrieveStudent=new MysqlOperation();
        retrieveStudent.retrieveStudentSqlDb();


    }

    /**
     * purpose:Method for update stuident details
     * implementation: student id input from user which user wants to update
     calling method update student from database
     *exception can occur due to user invalid input
     */

    public void update ()//method for  update student details
    {
        try {
            Student student =new Student();
            System.out.println("Enter Student Id");

            int id = Integer.parseInt(bufferedReader.readLine());//enter student id
            System.out.println("Enter Student Name");
            String stdname = bufferedReader.readLine();//student name input from user
            System.out.println("Enter Student age");
            int age = Integer.parseInt(bufferedReader.readLine());//student age input from user
            student.setStdname(stdname);
            student.setAge(age);
            MysqlOperation updateStudent=new MysqlOperation();
            updateStudent.updateStudentSqlDb(id,student);



        }
        catch (Exception exception){
            System.out.println("invalid user input");
        }

    }



}
