package Logic;
import java.io.Serializable;
import FileManager.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alija
 */


public class Employee implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private double salary;
    static int totalEmployee = 1;
    
    public Employee(String firstName, String lastName, String address, String phone, double salary) {
        this.id = totalEmployee;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
        totalEmployee++;
    }

    
    //Getters and setter (Auto generated)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //Full Name implementation
    public String getFullName() {
        return getFirstName()+" "+getLastName();
    }
   
    public void setFullName() {
        
    }
    //////
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
