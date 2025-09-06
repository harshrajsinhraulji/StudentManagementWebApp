
package com.github.harshrajsinhraulji.studentmanagement.model;
import java.sql.Date;

public class Student {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private Date dob;
    private String course;
    private int year;
    
    //Constructors
    public Student(int id, String name, String email, String phoneNumber, String gender, Date dob, String course, int year){
        this.id=id;
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.gender=gender;
        this.dob=dob;
        this.course=course;
        this.year=year;
    }
    
    public Student(String name, String email, String phoneNumber, String gender, Date dob, String course, int year){
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.gender=gender;
        this.dob=dob;
        this.course=course;
        this.year=year;
    }
    
    public Student(){
        //empty constructor
    }
    
    //Getters and Setters
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id=id;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    
    public Date getDob(){
        return dob;
    }
    public void setDob(Date dob){
        this.dob=dob;
    }
    
    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course=course;
    }
    
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year=year;
    }
    
    //toString method
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "', phoneNumber='" + phoneNumber
               + "', gender='" + gender + "', dob=" + dob + ", course='" + course + "', year=" + year + "}";
    }
    
    //equals method
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null||getClass()!=obj.getClass()){
            return false;
        }
        Student other=(Student) obj;
        return this.id==other.id;
    }
}
