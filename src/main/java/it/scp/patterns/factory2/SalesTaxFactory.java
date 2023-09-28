package it.scp.patterns.factory2;

public class SalesTaxFactory {

    public SalesTax makeTaxObject(String location) {
        if (location == null) {
            return null;
        } else if (location.equalsIgnoreCase("boston")) {
            return new BostonTax();
        } else if (location.equalsIgnoreCase("chicago")) {
            return new ChicagoTax();
        } else if (location.equalsIgnoreCase("stlouis")) {
            return new StLouisTax();
        }

        return null;
    }

}
