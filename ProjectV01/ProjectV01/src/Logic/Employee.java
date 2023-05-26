package Logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author Danial Alajmi Represents an employee with attributes such as ID,
 * first name, last name, address, phone, and salary. Implements the
 * Serializable interface for object serialization.
 */
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private double salary;
    static int totalEmployee;

    /**
     * Constructs a new Employee object with the specified first name, last
     * name, address, phone, and salary. The ID is assigned as the total number
     * of employees plus one.
     *
     * @param firstName the first name of the employee
     * @param lastName the last name of the employee
     * @param address the address of the employee
     * @param phone the phone number of the employee
     * @param salary the salary of the employee
     */
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
        return getFirstName() + " " + getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1);;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1);;
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

    // Static methods to save and load the total number of employees
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
