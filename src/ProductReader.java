import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductReader {
    public static void main(String[] args) {
        Scanner inFile;
        String line;

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

        ArrayList<Product> ProductList = new ArrayList<>();

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                Path target = chooser.getSelectedFile().toPath();
                inFile = new Scanner(target.toFile());

                // Column headers
                System.out.printf("%-8s %-12s %-25s %-8s%n", "ID#", "Name", "Description", "Cost");
                System.out.println("==========================================================");

                while (inFile.hasNextLine()) {
                    line = inFile.nextLine();
                    String[] parts = line.split(",");

                    if (parts.length == 4) {
                        Product P = new Product(parts[1], parts[2], parts[0], Double.parseDouble(parts[3]));
                        ProductList.add(P);

                        // Print full product info
                        System.out.printf("%-8s %-12s %-25s $%-8.2f%n",
                                P.getID(), P.getName(), P.getDescription(), P.getCost());
                    }
                }
                inFile.close();
            } else {
                System.out.println("Sorry, you must select a file! Terminating!");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }
}
