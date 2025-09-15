public class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;

    // Constructor
    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getID() { return ID; }
    public double getCost() { return cost; }

    public String toCSV() {
        return ID + "," + name + "," + description + "," + cost;
    }
    public String toJSON() {
        return "{\"ID\":\"" + ID + "\",\"name\":\"" + name + "\",\"description\":\"" + description + "\",\"cost\":" + cost + "}";
    }

    public String toXML() {
        return "<Product><ID>" + ID + "</ID><Name>" + name + "</Name><Description>" + description + "</Description><Cost>" + cost + "</Cost></Product>";
    }

    // Equals based on ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return ID.equals(product.ID);
    }
}


