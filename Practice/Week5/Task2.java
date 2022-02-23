package Practice.Week5;

public class Task2 {
    public static void main(String[] args) {
        Shape shape1 = new Shape("black", true);
        System.out.println(shape1.toString());

        Circle circle1 = new Circle(1337.228, "yellow", true);
        System.out.println(circle1.toString());

        Rectangle rect1 = new Rectangle(12, 16, "blue", true);
        System.out.println(rect1.toString());

        Square sq1 = new Square(14, "green", false);
        System.out.println(sq1.toString());
    }
}

class Shape{
    private String color = "red";
    private boolean filled = true;

    public Shape(){
    }

    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public boolean isFilled(){
        return this.filled;
    }

    public void setFilled(boolean filled){
        this.filled = filled;
    }

    public String toString(){
        return String.format("Shape[color = %s, filled = %s]", this.color, this.filled);
    }
}

class Circle extends Shape{
    private double radius = 1.0d;

    public Circle(){

    }

    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double gerArea(){
        return Math.PI * this.radius * this.radius;
    }

    public double getPerimeter(){
        return 2 * Math.PI * this.radius;
    }

    public String toString(){
        return String.format("Circle[%s, radius = %s]", super.toString(), this.radius);
    }
}

class Rectangle extends Shape{
    private double width = 1.0d;
    private double length = 1.0d;

    public Rectangle(){

    }

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth(){
        return this.width;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public double getLength(){
        return this.length;
    }

    public void setLength(double length){
        this.length = length;
    }

    public double getArea(){
        return this.width * this.length;
    }

    public double getPerimeter(){
        return 2 * (this.width + this.length);
    }

    public String toString(){
        return String.format("Rectangle[%s, width = %s, length = %s]", super.toString(), this.width, this.length);
    }
}

class Square extends Rectangle{
    public Square(){

    }

    public Square(double side){
        super(side, side);
    }

    public Square(double side, String color, boolean filled){
        super(side, side, color, filled);
    }

    public double getSide(){
        return this.getWidth();
    }

    public void setSide(double side){
        this.setWidth(side);
        this.setLength(side);
    }

    public void setWidth(double side){
        super.setWidth(side);
        super.setLength(side);
    }

    public void setLength(double side){
        super.setWidth(side);
        super.setLength(side);
    }

    public String toString(){
        return String.format("Square[%s]", super.toString());
    }
}

