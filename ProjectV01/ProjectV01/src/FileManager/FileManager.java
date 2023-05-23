/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManager;

import Logic.*;
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

//    File path = new File("src/FileManager/");
    public void ReadFile(File fileToRead) {
        Object content = null;
        try {
            Scanner inFile = new Scanner(fileToRead);
            while (inFile.hasNextLine()) {
                String nxtLine = inFile.nextLine();
                //content = content + nxtLine + "\n";
                System.out.println(content);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
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

    public void WriteFile(File fileToWrite, String content) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(new FileOutputStream(
                    fileToWrite,
                    true /* append = true */));
            writer.write(content);
            writer.println();
            writer.close();
            System.out.println("Have been written succefully!");
        } catch (FileNotFoundException e) {
            System.out.println("Error ouccred");
        }
    }

    public void loadStartupFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        File serializedFile = new File("src/FileManager/Data/serializedData.ser");
        if (serializedFile.exists()) {
//            // deserialize the data and use it to populate the system
//            FileInputStream fis = new FileInputStream(serializedFile);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            GymSystem.employees = (ArrayList<Employee>) ois.readObject();
//            GymSystem.members = (ArrayList<Member>) ois.readObject();
//            ois.close();
//            fis.close();
        } else {
            // load the startup file and use it to populate the system
            int totalEmployees;
            String employe;
            String firstName;
            String lastName;
            String address;
            String phone;
            double salary;
            String gender;
            String birthDate;
            String position;
            String department;
            String course;
            String team;
            int totalMembers;
            int number = 0;
            Employee employee = null;
            Member member = null;

            File startupFile = new File("src/FileManager/Data/startup.txt");
            Scanner scan = new Scanner(startupFile);
            totalEmployees = scan.nextInt();
            scan.nextLine(); // skip the newline character after the number of employees
            while (scan.hasNext()) {
                employe = scan.nextLine();
                if (employe.equalsIgnoreCase("E")) {
                    firstName = scan.nextLine();
                    lastName = scan.nextLine();
                    address = scan.nextLine();
                    phone = scan.nextLine();
                    salary = scan.nextDouble();
                    employee = new Employee(firstName, lastName, address, phone, salary);
                    GymSystem.employees.add(employee);
                } else if (employe.equalsIgnoreCase("PT")) {
                    firstName = scan.nextLine();
                    lastName = scan.nextLine();
                    address = scan.nextLine();
                    phone = scan.nextLine();
                    salary = scan.nextDouble();

                    // check if a personal trainer with the same details already exists
                    boolean trainerExists = false;
                    for (Employee emp : GymSystem.employees) {
                        if (emp instanceof PersonalTrainer && emp.getFirstName().equalsIgnoreCase(firstName)
                                && emp.getLastName().equalsIgnoreCase(lastName) && emp.getAddress().equalsIgnoreCase(address)
                                && emp.getPhone().equalsIgnoreCase(phone) && emp.getSalary() == salary) {
                            trainerExists = true;
                            employee = emp;
                            break;
                        }
                    }

                    if (!trainerExists) {
                        employee = new PersonalTrainer(firstName, lastName, address, phone, salary);
                        GymSystem.employees.add(employee);
                    }

                    totalMembers = scan.nextInt();
                    scan.nextLine(); // skip the newline character after the number of members
                    while (number < totalMembers) {
                        String memberType = scan.nextLine();
                        if (memberType.equalsIgnoreCase("staff")) {
                            firstName = scan.nextLine();
                            lastName = scan.nextLine();
                            address = scan.nextLine();
                            phone = scan.nextLine();
                            gender = scan.nextLine();
                            birthDate = scan.nextLine();
                            position = scan.nextLine();
                            department = scan.nextLine();

                            member = new PolytechnicStaff(firstName, lastName, address, phone, gender, birthDate, position, department);
                        } else if (memberType.equalsIgnoreCase("student")) {
                            firstName = scan.nextLine();
                            lastName = scan.nextLine();
                            address = scan.nextLine();
                            phone = scan.nextLine();
                            gender = scan.nextLine();
                            birthDate = scan.nextLine();
                            course = scan.nextLine();
                            team = scan.nextLine();

                            member = new PolytechnicStudent(firstName, lastName, address, phone, gender, birthDate, course, team);
                        }
                        GymSystem.members.add(member);
                        number++;
                    }
                    number = 0;
                }
            }
            scan.close();

            // serialize the data and save it to a file
            FileOutputStream fos = new FileOutputStream(serializedFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(GymSystem.employees);
            oos.writeObject(GymSystem.members);
            oos.close();
            fos.close();
        }
    }

}
