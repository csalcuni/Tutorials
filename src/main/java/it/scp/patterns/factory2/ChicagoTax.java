package it.scp.patterns.factory2;

public class ChicagoTax extends SalesTax {

    @Override
    double getRate() {
        return  0.075;
    }
}
