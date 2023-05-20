/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManager;

import Logic.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
//    public String getContent() {
//        return content;
//    }

}
