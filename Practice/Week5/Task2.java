package Practice.Week5;

public class Task2 {
    public static void main(String[] args) {
        Shape shape1 = new Shape("black", true);
        System.out.println(shape1.toString());
    }
}

class Shape{
    private String color;
    private boolean filled;

    public Shape(){
        this.color = "red";
        this.filled = true;
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
