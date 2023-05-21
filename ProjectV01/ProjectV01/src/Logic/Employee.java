package Logic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
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
    static int totalEmployee;
    
    public Employee(String firstName, String lastName, String address, String phone, double salary) {
        this.id = totalEmployee;
        this.firstName = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1);
        this.lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1);
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
    
    public static void saveEmpCount() {
        try {
            FileWriter fw = new FileWriter("src/FileManager/Data/empCount.txt");
            fw.write(String.valueOf(totalEmployee));
            fw.close();
        } catch (IOException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

    public static void loadEmpCount() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/FileManager/Data/empCount.txt"));
            totalEmployee = Integer.parseInt(br.readLine());
            br.close();
        } catch (IOException e) {
            totalEmployee = 1;
            System.out.println("Error occured: " + e.getMessage());
        }
    }
}
