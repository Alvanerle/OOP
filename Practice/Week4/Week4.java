package Practice.Week4;

public class Week4 {
    public static void main(String[] args){
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(10, 35);

        System.out.println(p1.distance(p2));
        System.out.println(MyPoint.distance(p1.getterX(), p1.getterY(), p2.getterX(), p2.getterY()));
        System.out.println(MyPoint.distance(p1, p2));
    }
}

class MyPoint {
    private int x;
    private int y;

    MyPoint(){
        x = 0;
        y = 0;
    }

    MyPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getterX(){
        return x;
    }

    public int getterY(){
        return y;
    }

    public double distance(MyPoint p2){
        return Math.sqrt((p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y));
    }

    public static double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public static double distance(MyPoint p1, MyPoint p2){
        return distance(p1.x, p1.y, p2.x, p2.y);
    }
}
