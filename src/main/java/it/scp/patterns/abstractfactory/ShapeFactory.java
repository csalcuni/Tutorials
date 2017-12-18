package it.scp.patterns.abstractfactory;

public class ShapeFactory extends AbstractFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null)
            return null;
        if (shapeType.equalsIgnoreCase("RECTANGLE"))
            return new Rectangle();
        if (shapeType.equalsIgnoreCase("CIRCLE"))
            return new Circle();
        if (shapeType.equalsIgnoreCase("SQUARE"))
            return new Square();

        return null;
    }

    @Override
    Color getColor(String color) {
        return null;
    }
}
