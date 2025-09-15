import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {
        SafeObj input = new SafeObj();
        ArrayList<Person> folks = new ArrayList<>();

        // Get working directory and file path
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath(), "src", "personData.txt");

        // Ensure parent directories exist
        try {
            Files.createDirectories(file.getParent());
        } catch (IOException e) {
            System.out.println("Failed to create directories!");
            e.printStackTrace();
            return; // Stop execution if directories can't be created
        }

        // Variables for user input
        boolean done = false;
        String ID, firstname, lastname, title;
        int YOB;

        // Gather person info
        do {
            ID = input.getNonZeroLenString("Enter the ID {6 digits}");
            firstname = input.getNonZeroLenString("Enter the first name");
            lastname = input.getNonZeroLenString("Enter the last name");
            title = input.getNonZeroLenString("Enter the title");
            YOB = input.getRangedInt("Enter the year of birth", 1940, 2010);

            Person p = new Person(firstname, lastname, ID, title, YOB);
            folks.add(p);

            done = input.getYNConfirm("Are you done?");
        } while (!done);

        // Echo to console
        System.out.println("\nPeople entered:");
        for (Person p : folks) {
            System.out.println(p.toCSV());
        }

        // Write to file
        try (BufferedWriter writer = Files.newBufferedWriter(file, CREATE)) {
            for (Person p : folks) {
                writer.write(p.toCSV());
                writer.newLine();
            }
            System.out.println("\nPerson data successfully written to: " + file.toString());
        } catch (IOException e) {
            System.out.println("Error writing to file!");
            e.printStackTrace();
        }
    }
}

