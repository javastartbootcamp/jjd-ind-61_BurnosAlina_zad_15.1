package pl.javastart.task;

import java.util.Comparator;

public class FirstNameComparator implements Comparator<Participant> {
    @Override
    public int compare(Participant participant1, Participant participant2) {
        return participant1.getFirstName().compareTo(participant2.getFirstName());
    }
}
