package Logic;

import java.util.ArrayList;

/**
 * @author Danial Alajmi Represents a personal trainer who manages a list of
 * members.
 */
public class PersonalTrainer extends Employee {

    private ArrayList<Member> members;

    /**
     * Constructs a new PersonalTrainer with the provided first name, last name,
     * address, phone, and salary. Initializes the members ArrayList.
     *
     * @param firstName the first name of the personal trainer
     * @param lastName the last name of the personal trainer
     * @param address the address of the personal trainer
     * @param phone the phone number of the personal trainer
     * @param salary the salary of the personal trainer
     */
    public PersonalTrainer(String firstName, String lastName, String address, String phone, double salary) {
        super(firstName, lastName, address, phone, salary);
        this.members = new ArrayList<Member>();
    }

    /**
     * Returns the list of members managed by this personal trainer.
     *
     * @return the list of members
     */
    public ArrayList<Member> getMembers() {
        return members;
    }

    /**
     * Sets the list of members managed by this personal trainer.
     *
     * @param members the list of members to set
     */
    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

}
