package pl.javastart.task;

import java.util.*;

public class TournamentStats {

    private static final String STOP = "STOP";
    private static final int FIRST_NAME = 1;
    private static final int LAST_NAME = 2;
    private static final int RESULT = 3;

    private static final int ASCENDING = 1;
    private static final int DESCENDING = 2;

    void run(Scanner scanner) {
        String result;
        List<Participant> participants = new ArrayList<>();
        do {
            result = getResult(scanner);
            addParticipantResult(result, participants);
        } while (!result.equals(STOP));
        Comparator<Participant> sortComparator = createComparator(scanner);
        participants.sort(sortComparator);
        TournamentStatsWriter writer = new TournamentStatsWriter();
        writer.writeStatsToFile(participants);
    }

    private Comparator<Participant> createComparator(Scanner scanner) {
        Comparator<Participant> sortComparator = null;
        System.out.println("Po jakim parametrze posortować? (" + FIRST_NAME + " - imię, "
                + LAST_NAME + " - nazwisko, " + RESULT + " - wynik)");
        int option = scanner.nextInt();
        System.out.println("Sortować rosnąco czy malejąco? (" + ASCENDING + " - rosnąco, " + DESCENDING + " - malejąco)");
        int option2 = scanner.nextInt();
        if (option == FIRST_NAME && option2 == ASCENDING) {
            sortComparator = new FirstNameComparator();
        } else if (option == FIRST_NAME && option2 == DESCENDING) {
            sortComparator = new FirstNameComparator().reversed();
        } else if (option == LAST_NAME && option2 == ASCENDING) {
            sortComparator = new LastNameComparator();
        } else if (option == LAST_NAME && option2 == DESCENDING) {
            sortComparator = new LastNameComparator().reversed();
        } else if (option == RESULT && option2 == ASCENDING) {
            sortComparator = new ResultComparator();
        } else if (option == RESULT && option2 == DESCENDING) {
            sortComparator = new ResultComparator().reversed();
        }
        return sortComparator;
    }

    private void addParticipantResult(String result, List<Participant> participants) {
        if (!result.equals(STOP)) {
            String[] resultArray = result.split(" ");
            participants.add(new Participant(resultArray[0], resultArray[1], Integer.parseInt(resultArray[2])));
        }
    }

    private String getResult(Scanner scanner) {
        System.out.println("Podaj wynik kolejnego gracza (lub stop):");
        return scanner.nextLine();
    }
}
