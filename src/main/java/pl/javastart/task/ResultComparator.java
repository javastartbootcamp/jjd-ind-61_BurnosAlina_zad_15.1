package pl.javastart.task;

import java.util.Comparator;

public class ResultComparator implements Comparator<Participant> {
    @Override
    public int compare(Participant participant1, Participant participant2) {
        return Integer.compare(participant1.getResult(), participant2.getResult());
    }
}
