package pl.javastart.task;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Participant> {
    @Override
    public int compare(Participant participant1, Participant participant2) {
        return participant1.getLastName().compareTo(participant2.getLastName());
    }
}
