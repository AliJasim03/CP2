package Logic;

/**
 * Represents a polytechnic student, which extends the Member class. This class
 * adds additional fields for major and team.
 *
 * @author Danial Alajmi
 */
public class PolytechnicStudent extends Member {

    private String major;
    private String team;

    /**
     * Constructs a new PolytechnicStudent with the provided first name, last
     * name, address, phone, gender, birth date, course, and team. Calls the
     * superclass constructor with the first name, last name, address, phone,
     * gender, and birth date.
     *
     * @param firstName the first name of the polytechnic student
     * @param lastName the last name of the polytechnic student
     * @param address the address of the polytechnic student
     * @param phone the phone number of the polytechnic student
     * @param gender the gender of the polytechnic student
     * @param birthDate the birth date of the polytechnic student
     * @param course the course of the polytechnic student
     * @param team the team of the polytechnic student
     */
    public PolytechnicStudent(String firstName, String lastName, String address, String phone, String gender, String birthDate, String course, String team) {
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
