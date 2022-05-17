package Projects.Project2;

import java.util.List;
import java.util.Random;

public class MyPlayer implements Player {
    private Position position;
    private Map map;
    private int score;
    private int dir = 1; // r, l, u, d = 1, -1, 2, -2

    public void increaseScore(int x, int y){
        score += map.points.get(new Point(x, y));
        map.points.remove(new Point(x, y));
    }

    public void updateMap(int x1, int y1, int x2, int y2){
        map.setValueAt(x1, y1, '0');
        map.setValueAt(x2, y2, 'X');
    }

    @Override
    public void moveTraps(){
        List<Point> traps = map.traps.keys();
        for(int i = 0; i < traps.size(); i++){
            int x = traps.get(i).x;
            int y = traps.get(i).y;
            if(x == map.getSize() - 1){
                map.setValueAt(x, y, '0');
                map.traps.remove(traps.get(i));
            }
            else{
                map.setValueAt(x, y, '0');
                if(map.points.get(new Point(x + 1, y)) != null){
                    map.points.remove(new Point(x + 1, y));
                }
                map.setValueAt(x + 1, y, '#');
                traps.set(i, new Point(x + 1, y));
            }
        }
    }

    @Override
    public void moveRight() {
        int x1 = position.getX();
        int y1 = position.getY() + 1;

        int check = check(x1, y1);
        int checkForTrap = check(position.getX(), position.getY());
        if(check == 0 || checkForTrap == -1){
            System.out.println("Game Over!");
            System.exit(0);
        }
        else if(check == 1 || check == 2) {
            if(check == 2) increaseScore(x1, y1);

            updateMap(x1, y1 - 1, x1, y1);
            position.setY(y1);
        }
    }

    @Override
    public void moveLeft() {
        int x1 = position.getX();
        int y1 = position.getY() - 1;

        int check = check(x1, y1);
        int checkForTrap = check(position.getX(), position.getY());
        if(check == 0 || checkForTrap == -1){
            System.out.println("Game Over!");
            System.exit(0);
        }
        else if(check == 1 || check == 2){
            if(check == 2) increaseScore(x1, y1);

            updateMap(x1, y1 + 1, x1, y1);
            position.setY(y1);
        }
    }

    @Override
    public void moveUp() {
        int x1 = position.getX() - 1;
        int y1 = position.getY();

        int check = check(x1, y1);
        int checkForTrap = check(position.getX(), position.getY());
        if(check == 0 || checkForTrap == -1){
            System.out.println("Game Over!");
            System.exit(0);
        }
        else if(check == 1 || check == 2){
            if(check == 2) increaseScore(x1, y1);

            updateMap(x1 + 1, y1, x1, y1);
            position.setX(x1);
        }
    }

    @Override
    public void moveDown() {
        int x1 = position.getX() + 1;
        int y1 = position.getY();

        int check = check(x1, y1);
        int checkForTrap = check(position.getX(), position.getY());
        if(check == 0 || checkForTrap == -1){
            System.out.println("Game Over!");
            System.exit(0);
        }
        else if(check == 1 || check == 2){
            if(check == 2) increaseScore(x1, y1);

            updateMap(x1 - 1, y1, x1, y1);
            position.setX(x1);
        }
    }


    @Override
    public void right() {
        dir = 1;
    }

    @Override
    public void left() {
        dir = -1;
    }

    @Override
    public void up() {
        dir = 2;
    }

    @Override
    public void down() {
        dir = -2;
    }

    @Override
    public void updateMap(){
        if(dir == 1){
            moveRight();
        }
        else if(dir == -1){
            moveLeft();
        }
        else if(dir == 2){
            moveUp();
        }
        else if(dir == -2){
            moveDown();
        }

        updatePoints();
        updateTraps();
        moveTraps();
    }

    public void updatePoints(){
        while(map.points.size() < map.getSize()){
            Random random = new Random();
            int x = random.nextInt(map.getSize());
            int y = random.nextInt(map.getSize());

            if(map.getValueAt(x, y) == '0'){
                int point = random.nextInt(9) + 1;
                map.setValueAt(x, y, (char)(point + '0'));
                map.points.put(new Point(x, y), point);
            }
        }
    }

    public void updateTraps(){
        while(map.traps.size() < map.getSize() / 5){
            Random random = new Random();
            int x = 0;
            int y = random.nextInt(map.getSize());

            if(map.getValueAt(x, y) == '0'){
                map.setValueAt(x, y, '#');
                map.traps.put(new Point(x, y), -1);
            }
            else if(map.getValueAt(x, y) >= '1' && map.getValueAt(x, y) <= '9'){
                map.points.remove(new Point(x, y));
                map.setValueAt(x, y, '#');
                map.traps.put(new Point(x, y), -1);
            }
        }
    }

    @Override
    public void setMap(Map map){
        this.map = map;
        for(int i = 0; i < map.getSize(); i++){
            for(int j = 0; j < map.getSize(); j++){
                if(map.getValueAt(i, j) == 'X'){
                    position = new Position(i, j);
                    return;
                }
            }
        }
    }

    @Override
    public Position getPosition() {
        return position;
    }

    // -1 - trap
    //  0 - boundaries
    //  1 - everything okay
    //  2 - you got point
    public int check(int x, int y){
        if(x < 0 || x >= map.getSize() || y < 0 || y >= map.getSize()){
            return 0;
        }
        else if(map.getValueAt(x, y) == '#'){
            return -1;
        }
        else if(map.getValueAt(x, y) >= '1' && map.getValueAt(x, y) <= '9'){
            return 2;
        }
        else if(map.getValueAt(x, y) == '0'){
            return 1;
        }

        return 0;
    }

    @Override
    public int getScore(){
        return score;
    }
}