package Practice.Week2;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getterA(){
        return a;
    }

    public double getterB(){
        return b;
    }

    public double getterC(){
        return c;
    }

    public double getDiscriminant(){
        return b * b - 4 * a * c;
    }

    public double getRoot1(){
        if(getDiscriminant() >= 0) return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
        else return 0;
    }

    public double getRoot2(){
        if(getDiscriminant() >= 0) return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
        else return 0;
    }

    public static void main(String[] args){
        QuadraticEquation obj1 = new QuadraticEquation(4, 1, 3);

        System.out.println("The discriminant is " + obj1.getDiscriminant());
        System.out.println("First root " + (obj1.getRoot1() == 0 ? "doesn't exist" : "is " + obj1.getRoot1()));
        System.out.println("Second root " + (obj1.getRoot2() == 0 ? "doesn't exist" : "is " + obj1.getRoot2()));
    }
}
