package pl.javastart.task;

import java.util.*;

public class TournamentStats {

    private static final String STOP = "STOP";
    private static final int FIRST_NAME = 1;
    private static final int LAST_NAME = 2;
    private static final int RESULT = 3;
    private static final int DESCENDING = 2;

    void run(Scanner scanner) {
        String result;
        List<Participant> participants = new ArrayList<>();
        do {
            result = getResult(scanner);
            addParticipantResult(result, participants);
        } while (!result.equals(STOP));
        sortByParameter(scanner, participants);
        sortAscendingOrDescending(scanner, participants);
        TournamentStatsWriter writer = new TournamentStatsWriter();
        writer.writeStatsToFile(participants);
    }

    private void sortAscendingOrDescending(Scanner scanner, List<Participant> participants) {
        System.out.println("Sortować rosnąco czy malejąco? (1 - rosnąco, 2 - malejąco)");
        int option = scanner.nextInt();
        if (option == DESCENDING) {
            Collections.reverse(participants);
        }
    }

    private void sortByParameter(Scanner scanner, List<Participant> participants) {
        System.out.println("Po jakim parametrze posortować? (1 - imię, 2 - nazwisko, 3 - wynik)");
        int option = scanner.nextInt();
        if (option == FIRST_NAME) {
            participants.sort(new FirstNameComparator());
        } else if (option == LAST_NAME) {
            participants.sort(new LastNameComparator());
        } else if (option == RESULT) {
            Collections.sort(participants);
        }
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
