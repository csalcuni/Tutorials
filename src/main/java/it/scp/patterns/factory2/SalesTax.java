package it.scp.patterns.factory2;

public abstract class SalesTax {

    abstract double getRate();

    public void calculateTax(double amount) {
        System.out.printf("$%6.2f", amount * (1.0 + getRate()));
    }

}
