package com.decipherzone.studentmgnt.entity;


/**
 *@purpose: student class for getter and setter method
 */
public class Student {

    private String stdname;
    private int id;
    private int age;

    /**
     * Constructor to intialize
     */
    public Student() {
        int id;
        String stdname;
        int age;
    }

    /**
     * getter method for student name
     *
     * @return student name
     */
    public String getStdname() {
        return stdname;
    }

    /**
     * setter method for student name
     *
     * @param stdname :student name set
     */
    public void setStdname(String stdname) {
        this.stdname = stdname;
    }

    /**
     * getter method for student name
     *
     * @return student id
     */
    public int getId() {
        return id;
    }

    /**
     * setter method for Student id
     *
     * @param id : student name
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter method for student age
     *
     * @return student age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for student age
     *
     * @param age : student age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "" + stdname + " " + id + " " + age + "\n";
    }

}
