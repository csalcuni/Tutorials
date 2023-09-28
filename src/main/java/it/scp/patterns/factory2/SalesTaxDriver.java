package it.scp.patterns.factory2;

import java.io.IOException;
import java.util.Scanner;

public class SalesTaxDriver {

    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);

        SalesTaxFactory factory = new SalesTaxFactory();

        System.out.println("Enter location (boston/chicago/stlouis): ");
        String location = stdin.nextLine();

        System.out.println("Enter the Dollar amount: ");
        double amount = stdin.nextDouble();

        SalesTax cityTax = factory.makeTaxObject(location);

        System.out.printf("Bill amount for %s of $%6.2f is: ", location, amount);
        cityTax.getRate();
        cityTax.calculateTax(amount);

    }


}
