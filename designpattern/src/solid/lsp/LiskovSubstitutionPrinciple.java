package solid.lsp;

// Invented by Liskov


class Rectangle {
    protected int width, height;

    public Rectangle() {}

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rectangle{");
        sb.append("width=").append(width);
        sb.append(", height=").append(height);
        sb.append('}');
        return sb.toString();
    }
}

/* Not necessary to implement Square class, rather implement a method for detecting
 * both sides are equals or implementing a factory class in order to return the proper
 * rectangle shape. That way the Liskov Substitution is not violated by inheritance.
 * That is the key point of LSP */
/*class Square extends Rectangle {

    public Square() {}

    public Square(int size) {
        width = height = size;
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}*/

class RectangleFactory {
    public static Rectangle newRectangle(int width, int height) {
        return new Rectangle(width, height);
    }

    public static Rectangle newSquare(int side) {
        return new Rectangle(side, side);
    }

}

public class LiskovSubstitutionPrinciple {

    static void useIt(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println("Expected area of " + (width * 10) + ", got " + r.getArea());
    }

    public static void main(String[] args) {
        Rectangle rc = new Rectangle(2,3);
        useIt(rc);

        //Giving misleading information
/*        Rectangle sq = new Square();
        sq.setWidth(5);
        useIt(sq);*/

    }
}

