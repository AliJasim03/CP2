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
public class PolytechnicStudent extends Member{
    private String major;
    private String team;

    public PolytechnicStudent(String firstName, String lastName, String address, String phone, String gender, String birthDate,String course, String team) {
        super(firstName, lastName, address, phone, gender, birthDate);
        this.major = course;
        this.team = team;
    }

    
    
    //Getters and setter (Auto generated)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    
    
}
