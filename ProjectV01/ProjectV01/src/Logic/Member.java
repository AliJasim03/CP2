package Logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * Represents a member of an organization or group. This class stores member
 * information such as first name, last name, address, phone, gender, and birth
 * date. It also keeps track of the total number of members.
 *
 * @author Danial Alajmi
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

    /**
     * Constructor with parameters. Creates a new Member object with the
     * provided first name, last name, address, phone, gender, and birth date.
     * Assigns the next available ID to the new member. Increments the total
     * number of members.
     *
     * @param firstName the first name of the member
     * @param lastName the last name of the member
     * @param address the address of the member
     * @param phone the phone number of the member
     * @param gender the gender of the member
     * @param birthDate the birth date of the member
     */
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
        this.firstName = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1);
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

    /**
     * Saves the current member count to a file.
     */
    public static void saveEmpCount() {
        try {
            FileWriter fw = new FileWriter("src/FileManager/Data/memberCount.txt");
            fw.write(String.valueOf(totalMember));
            fw.close();
        } catch (IOException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

    /**
     * Loads the member count from a file and sets the static totalMember
     * variable.
     */
    public static void loadEmpCount() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/FileManager/Data/memberCount.txt"));
            totalMember = Integer.parseInt(br.readLine());
            br.close();
        } catch (IOException e) {
            totalMember = 1;
            System.out.println("Error occured: " + e.getMessage());
        }
    }
}
