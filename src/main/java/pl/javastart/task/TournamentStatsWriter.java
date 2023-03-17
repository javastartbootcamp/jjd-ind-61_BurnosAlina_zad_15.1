package pl.javastart.task;

import java.io.*;
import java.util.List;

public class TournamentStatsWriter {

    void writeStatsToFile(List<Participant> participants) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("stats.csv"))) {
            for (Participant participant : participants) {
                String line = participant.toString();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Dane posortowano i zapisano do pliku stats.csv.");
        } catch (IOException e) {
            System.out.println("Błąd zapisu pliku");
        }
    }
}
