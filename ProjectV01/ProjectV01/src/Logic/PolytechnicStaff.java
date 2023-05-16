/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.util.Date;

/**
 *
 * @author alija
 */
public class PolytechnicStaff extends Member{
    
    private String position;
    private String department;

    public PolytechnicStaff(String firstName, String lastName, String address, String phone, String gender, Date birthDate,String position, String department) {
        super(firstName, lastName, address, phone, gender, birthDate);
        this.position = position;
        this.department = department;
    }
    
    
    //Getters and setter (Auto generated)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
    
    
}
