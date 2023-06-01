package Logic;

/**
 * Represents a polytechnic staff member, which extends the Member class. This
 * class adds additional fields for position and department.
 *
 * @author Danial Alajmi
 */
public class PolytechnicStaff extends Member {

    private String position;
    private String department;

    /**
     * Constructs a new PolytechnicStaff with the provided first name, last
     * name, address, phone, gender, birth date, position, and department. Calls
     * the superclass constructor with the first name, last name, address,
     * phone, gender, and birth date.
     *
     * @param firstName the first name of the polytechnic staff member
     * @param lastName the last name of the polytechnic staff member
     * @param address the address of the polytechnic staff member
     * @param phone the phone number of the polytechnic staff member
     * @param gender the gender of the polytechnic staff member
     * @param birthDate the birth date of the polytechnic staff member
     * @param position the position of the polytechnic staff member
     * @param department the department of the polytechnic staff member
     */
    public PolytechnicStaff(String firstName, String lastName, String address, String phone, String gender, String birthDate, String position, String department) {
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
