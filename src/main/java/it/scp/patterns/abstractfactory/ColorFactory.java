package it.scp.patterns.abstractfactory;

public class ColorFactory extends AbstractFactory {
    public Color getColor(String colorType) {
        if (colorType == null)
            return null;
        if (colorType.equalsIgnoreCase("RED"))
            return new Red();
        if (colorType.equalsIgnoreCase("GREEN"))
            return new Green();
        if (colorType.equalsIgnoreCase("BLUE"))
            return new Blue();

        return null;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}
