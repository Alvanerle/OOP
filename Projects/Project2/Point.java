package Projects.Project2;

public class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode(){
        return x * 31 + y;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;

        if(obj instanceof Point){
            return ((Point)obj).x == this.x && ((Point)obj).y == this.y;
        }

        return false;
    }
}