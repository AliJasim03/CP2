/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.io.Serializable;

/**
 *
 * @author alija
 */
public class Member implements Serializable {

    private static final long serialVersionUID = 2L;
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String gender;
    private String birthDate;
    static int totalMember;

    public Member() {

    }

    public Member(String firstName, String lastName, String address, String phone, String gender, String birthDate) {
        this.id = totalMember;
        this.firstName = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1);
        this.lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1);
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.birthDate = birthDate;
        totalMember++;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

}
