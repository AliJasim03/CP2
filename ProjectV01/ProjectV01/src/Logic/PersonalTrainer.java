/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.util.ArrayList;

/**
 *
 * @author alija
 */
public class PersonalTrainer extends Employee{
    private ArrayList<Member> members;

    public PersonalTrainer(String firstName, String lastName, String address, String phone, double salary) {
        super(firstName, lastName, address, phone, salary);
        this.members = new ArrayList<Member>();
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    
    
}
