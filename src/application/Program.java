package application;

import entities.Customer;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine());
        Customer customer = new Customer(name,email,birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String orderStatus = sc.nextLine();
        Order order = new Order(customer, new Date(), OrderStatus.valueOf(orderStatus));

        System.out.print("How many items to this order? ");
        int orderItems = sc.nextInt();
        for(int i=1; i<=orderItems; i++){
            sc.nextLine();
            System.out.println("Enter #"+i+" item data:");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            order.addItem(new OrderItem(quantity, new Product(productName,productPrice)));
        }

        System.out.println(order);
        System.out.println(customer);
        System.out.println(order.showItems());
    }
}