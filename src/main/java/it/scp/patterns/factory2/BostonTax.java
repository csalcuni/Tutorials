package it.scp.patterns.factory2;

public class BostonTax extends SalesTax {

    @Override
    double getRate() {
        return 0.0875;
    }
}
