
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProductGenerator {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("John Laptop", "Gaming Laptop", "P001", 1000.00));
        products.add(new Product("Johnny Phone", "Smartphone", "P002", 700.00));
        products.add(new Product("Charles Helmet", " Xavier's Power", "P003", 300.00));

        // Create src folder path dynamically
        String srcFolder = System.getProperty("user.dir") + File.separator + "src";
        String filePath = srcFolder + File.separator + "products.txt";

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Product p : products) {
                writer.write(p.toCSV() + "\n");
            }
            System.out.println("Products generated successfully at: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
