package it.scp.patterns.factory2;

public class StLouisTax extends SalesTax {

    @Override
    double getRate() {
        return  0.05;
    }
}
