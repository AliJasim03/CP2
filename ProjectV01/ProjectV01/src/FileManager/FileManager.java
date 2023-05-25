/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManager;

import GUI.Message;
import GlassPanePopup.GlassPanePopup;
import Logic.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ali
 */
public class FileManager {

    //Singleton syntax
    private static FileManager instance;

    private FileManager() {

    }

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public void WriteEmployee() throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream("src/FileManager/Data/Employees.dat")) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(GymSystem.employees); // serializes​
        } catch (FileNotFoundException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

    public void ReadEmployees() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream("src/FileManager/Data/Employees.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
// de-serialize:​
            GymSystem.employees = (ArrayList<Employee>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

    public void WriteMember() throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream("src/FileManager/Data/Members.dat")) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(GymSystem.members); // serializes​
        } catch (FileNotFoundException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

    public void ReadMembers() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream("src/FileManager/Data/Members.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
// de-serialize:​
            GymSystem.members = (ArrayList<Member>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

    public void loadStartupFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        File memberFile = new File("src/FileManager/Data/Members.dat");
        File employeeFile = new File("src/FileManager/Data/Employees.dat");
        if (employeeFile.exists() || memberFile.exists()) {
            ReadMembers();
            ReadEmployees();
        } else {
            // load the startup file and use it to populate the system
            File startupFile = new File("src/FileManager/Data/startup.txt");
            Scanner scan = new Scanner(startupFile);
            int totalEmployees = scan.nextInt();
            scan.nextLine(); // skip the newline character after the number of employees
            for (int i = 0; i < totalEmployees; i++) {
                String employe = scan.nextLine();
                if (employe.equalsIgnoreCase("E")) {
                    String firstName = scan.nextLine();
                    String lastName = scan.nextLine();
                    String address = scan.nextLine();
                    String phone = scan.nextLine();
                    double salary = scan.nextDouble();
                    scan.nextLine();
                    Employee employee = new Employee(firstName, lastName, address, phone, salary);
                    GymSystem.employees.add(employee);
                } else if (employe.equalsIgnoreCase("PT")) {
                    String firstName = scan.nextLine();
                    String lastName = scan.nextLine();
                    String address = scan.nextLine();
                    String phone = scan.nextLine();
                    double salary = scan.nextDouble();
                    scan.nextLine();
                    Employee employee = new PersonalTrainer(firstName, lastName, address, phone, salary);
                    GymSystem.employees.add(employee);
                    int totalMembers = scan.nextInt();
                    scan.nextLine();
                    for (int j = 0; j < totalMembers; j++) {
                        String memberType = scan.nextLine();
                        if (memberType.equalsIgnoreCase("staff")) {
                            String firstNameMem = scan.nextLine();
                            String lastNameMem = scan.nextLine();
                            String addressMem = scan.nextLine();
                            String birthDateMem = scan.nextLine();
                            String phoneMem = scan.nextLine();
                            String genderMem = scan.nextLine();
                            String positionMem = scan.nextLine();
                            String departmentMem = scan.nextLine();
                            Member member = new PolytechnicStaff(firstNameMem, lastNameMem, addressMem, phoneMem, genderMem, birthDateMem, positionMem, departmentMem);
                            GymSystem.members.add(member);
                            ((PersonalTrainer) employee).getMembers().add(member);
                        } else if (memberType.equalsIgnoreCase("student")) {
                            String firstNameMem = scan.nextLine();
                            String lastNameMem = scan.nextLine();
                            String addressMem = scan.nextLine();
                            String birthDateMem = scan.nextLine();
                            String phoneMem = scan.nextLine();
                            String genderMem = scan.nextLine();
                            String majorMem = scan.nextLine();
                            String teamMem = scan.nextLine();
                            Member member = new PolytechnicStudent(firstNameMem, lastNameMem, addressMem, phoneMem, genderMem, birthDateMem, majorMem, teamMem);
                            ((PersonalTrainer) employee).getMembers().add(member);
                            GymSystem.members.add(member);
                        }

                    }
                }
            }
        }
        WriteMember();
        WriteEmployee();
    }

    public void generateMarketingReport() {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(
                    "src/FileManager/Data/marketingReport.txt",
                    true /* append = true */));

            if (new File("src/FileManager/Data/marketingReport.txt").exists()) {
                writer.flush();
            }
            writer.write("Polytechnic Staffs:");
            writer.println();
            int totalStaff = 0;
            for (Member mem : GymSystem.members) {
                if (mem instanceof PolytechnicStaff) {
                    writer.write("Full Name:" + mem.getFullName());
                    writer.println();
                    writer.write("Address:" + mem.getAddress());
                    writer.println();
                    writer.write("Phone:" + mem.getPhone());
                    writer.println();
                    writer.write("Position:" + ((PolytechnicStaff) mem).getPosition());
                    writer.println();
                    writer.write("Department:" + ((PolytechnicStaff) mem).getDepartment());
                    writer.println();
                    totalStaff++;
                }
            }
            writer.write("Total amount of: " + totalStaff);
            writer.write("Polytechnic Studnets:");
            writer.println();
            for (Member mem : GymSystem.members) {
                if (mem instanceof PolytechnicStudent) {
                    writer.write("Full Name:" + mem.getFullName());
                    writer.println();
                    writer.write("Address:" + mem.getAddress());
                    writer.println();
                    writer.write("Phone:" + mem.getPhone());
                    writer.println();
                    writer.write("Major:" + ((PolytechnicStudent) mem).getMajor());
                    writer.println();
                    writer.write("Sport Team:" + ((PolytechnicStudent) mem).getTeam());
                    writer.println();
                }
            }
            writer.write("Total amount of: " + (GymSystem.members.size() - totalStaff));
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error ouccred");
        }
    }

}
