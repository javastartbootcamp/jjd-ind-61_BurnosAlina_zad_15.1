package pl.javastart.task;

public class Participant implements Comparable<Participant> {

    private String firstName;
    private String lastName;
    private int result;

    public Participant(String firstName, String lastName, int result) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.result = result;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ";" + result;
    }

    @Override
    public int compareTo(Participant participant) {
        return Integer.compare(result, participant.result);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
