/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManager;

import Logic.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public boolean loadStartupFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        File memberFile = new File("src/FileManager/Data/Members.dat");
        File employeeFile = new File("src/FileManager/Data/Employees.dat");
        if (employeeFile.exists() || memberFile.exists()) {
            ReadMembers();
            ReadEmployees();
            return false;
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
        return true;

    }

    public void generateMarketingReport() {
        Path filePath = Paths.get("src/FileManager/Data/marketingReport.txt");
        Charset charset = StandardCharsets.UTF_8;

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath, charset)) {
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            int totalStaff = 0;

            // Write formatted data using print writer
            printWriter.println("Polytechnic Staffs:");
            for (Member mem : GymSystem.members) {
                if (mem instanceof PolytechnicStaff) {
                    printWriter.write("Full Name:" + mem.getFullName());
                    printWriter.println();
                    printWriter.write("Address:" + mem.getAddress());
                    printWriter.println();
                    printWriter.write("Phone:" + mem.getPhone());
                    printWriter.println();
                    printWriter.write("Position:" + ((PolytechnicStaff) mem).getPosition());
                    printWriter.println();
                    printWriter.write("Department:" + ((PolytechnicStaff) mem).getDepartment());
                    printWriter.println();
                    totalStaff++;
                }
            }
            printWriter.write("Total amount of: " + totalStaff);
            printWriter.println();
            printWriter.println();
            printWriter.write("Polytechnic Students:");
            for (Member mem : GymSystem.members) {
                if (mem instanceof PolytechnicStudent) {
                    printWriter.write("Full Name:" + mem.getFullName());
                    printWriter.println();
                    printWriter.write("Address:" + mem.getAddress());
                    printWriter.println();
                    printWriter.write("Phone:" + mem.getPhone());
                    printWriter.println();
                    printWriter.write("Major:" + ((PolytechnicStudent) mem).getMajor());
                    printWriter.println();
                    printWriter.write("Sport Team:" + ((PolytechnicStudent) mem).getTeam());
                    printWriter.println();
                }
            }
            printWriter.write("Total amount of: " + (GymSystem.members.size() - totalStaff));
        } catch (IOException e) {
            System.out.println("Error occurred");
        }
    }

}
