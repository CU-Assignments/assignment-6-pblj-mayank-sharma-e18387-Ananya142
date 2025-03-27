import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class Hard {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.99),
            new Product("Smartphone", "Electronics", 899.99),
            new Product("Headphones", "Electronics", 199.99),
            new Product("Refrigerator", "Appliances", 799.99),
            new Product("T-shirt", "Clothing", 25.99),
            new Product("Jeans", "Clothing", 49.99),
            new Product("Smartwatch", "Electronics", 299.99) // Removed the extra comma
        );

        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(groupingBy(Product::getCategory));

        System.out.println("Products Grouped by Category:");
        productsByCategory.forEach((category, productList) -> 
            System.out.println(category + ": " + productList));

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(groupingBy(Product::getCategory, 
                     maxBy(Comparator.comparingDouble(Product::getPrice))));

        System.out.println("Most Expensive Product in Each Category:");
        mostExpensiveByCategory.forEach((category, product) -> 
            System.out.println(category + ": " + product.orElse(null)));

        double averagePrice = products.stream().collect(averagingDouble(Product::getPrice));
        System.out.printf("Average Price of All Products: $%.2f\n", averagePrice);
    }
}
