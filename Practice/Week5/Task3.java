package Practice.Week5;

public class Task3 {
    public static void main(String[] args){
        Point p1 = new Point(13.4f, -12.45f);
        System.out.println(p1.toString());

        MovablePoint mp1 = new MovablePoint(-12.34f, 15.413f, 2f, 10f);
        System.out.println(mp1.toString());

        MovablePoint mp2 = mp1.move();
        System.out.println(mp2.toString());
    }
}

class Point{
    private float x = 0.0f;
    private float y = 0.0f;

    public Point(){

    }

    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX(){
        return this.x;
    }

    public void setX(float x){
        this.x = x;
    }

    public float getY(){
        return this.y;
    }

    public void setY(float y){
        this.y = y;
    }

    public void setXY(float x, float y){
        this.setX(x);
        this.setY(y);
    }

    public float[] getXY(){
        return new float[] {this.x, this.y};
    }

    public String toString(){
        return String.format("(%s, %s)", this.x, this.y);
    }
}

class MovablePoint extends Point{
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint(float x, float y, float xSpeed, float ySpeed){
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(){

    }

    public float getXSpeed() {
        return this.xSpeed;
    }

    public void setXSpeed(float xSpeed){
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return this.ySpeed;
    }

    public void setYSpeed(float ySpeed){
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        this.setXSpeed(xSpeed);
        this.setYSpeed(ySpeed);
    }

    public float[] getSpeed(){
        return new float[] {this.xSpeed, this.ySpeed};
    }

    public String toString(){
        return String.format("%s, speed = (%s, %s)", super.toString(), this.xSpeed, this.ySpeed);
    }

    public MovablePoint move(){
        this.setX(this.getX() + this.xSpeed);
        this.setY(this.getY() + this.ySpeed);

        return this;
    }
}