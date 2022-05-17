package Projects.Project2;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;

        if(obj instanceof Position){
            return this.x == ((Position)obj).x && this.y == ((Position)obj).y;
        }

        return false;
    }

    @Override
    public String toString(){
        return String.format("(%s,%s)", x, y);
    }
}