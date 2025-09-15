import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonReader
{
    public static void main(String[] args)
    {
        // Use a relative path to the file in the src folder (SafeObj-friendly)
        Path target = new File("src/personData.txt").toPath();
        Scanner inFile;

        ArrayList<Person> peopleList = new ArrayList<>();

        try  // Code that might trigger the exception goes here
        {
            // Open the file for reading
            inFile = new Scanner(target.toFile());

            // Print header
            System.out.printf("%-8s %-12s %-12s %-8s %-6s%n",
                    "ID#", "Firstname", "Lastname", "Title", "YOB");



            System.out.println("============================================================");

            // Read each line and create Person objects
            while (inFile.hasNextLine()) {
                String line = inFile.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Person p = new Person(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
                    peopleList.add(p);

                    // Optional: print nicely
                    System.out.printf("%-8s %-12s %-12s %-8s %-6d%n",
                            p.ID, p.firstName, p.lastName, p.title, p.YOB);
                }
            }

            // Close the file after reading
            inFile.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }
}
