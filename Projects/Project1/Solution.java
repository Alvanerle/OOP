package Projects.Project1;/*
Enter your code here.
Create all the necessary classes and methods as per the requirements.
*/
// START of your code

import java.util.Scanner;

interface Player{
    public void moveRight();
    public void moveLeft();
    public void moveUp();
    public void moveDown();
    public void setMap(Map map);
    public Position getPosition();
}

class MyPlayer implements Player{
    private Position position;
    private Map map;

    @Override
    public void moveRight() {
        int x1 = position.getX();
        int y1 = position.getY() + 1;
        if(check(x1, y1)){
            position.setY(y1);
        }
    }

    @Override
    public void moveLeft() {
        int x1 = position.getX();
        int y1 = position.getY() - 1;
        if(check(x1, y1)){
            position.setY(y1);
        }
    }

    @Override
    public void moveUp() {
        int x1 = position.getX() - 1;
        int y1 = position.getY();
        if(check(x1, y1)){
            position.setX(x1);
        }
    }

    @Override
    public void moveDown() {
        int x1 = position.getX() + 1;
        int y1 = position.getY();
        if(check(x1, y1)){
            position.setX(x1);
        }
    }

    @Override
    public void setMap(Map map){
        this.map = map;
        for(int i = 0; i < map.getSize(); i++){
            for(int j = 0; j < map.getSize(); j++){
                if(map.getValueAt(i, j) == 'P'){
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

    public boolean check(int x, int y){
        if(x < 0 || x >= map.getSize() || y < 0 || y >= map.getSize() || map.getValueAt(x, y) == '1'){
            return false;
        }

        return true;
    }
}

class InvalidMapException extends Exception{
    private String message;

    InvalidMapException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}

class Map {
    private char[][] c;
    private int size;

    public Map(Scanner input) throws InvalidMapException {
        size = input.nextInt();
        c = new char[size][size];

        if(size == 0){
            throw new InvalidMapException("Map size can not be zero");
        }

        boolean ok = true;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(input.hasNext()){
                    c[i][j] = input.next().charAt(0);
                }
                else {
                    ok = false;
                }
            }
        }

        if(!ok) throw new InvalidMapException("Not enough map elements");
    }

    public int getSize(){
        return size;
    }

    public char getValueAt(int i, int j){
        return c[i][j];
    }

    public void print(){
        for(int i = 0; i < c.length; i++){
            for(int j = 0; j < c[i].length; j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Position {
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

class Game{
    private Map map;

    public Game(Map map){
        this.map = map;
    }

    public void setMap(Map map){
        this.map = map;
    }

    public void addPlayer(Player player){
        player.setMap(map);
    }
}



// END of your code.

/*
DO NOT MODIFY THIS PART!!!
Input and Output has been done for you.
Various conditions are meant to check individual classes separately.
You still need to implement completely all the necessary classes with their corresponding methods,
but the correctness for each class is checked individually.
In other words, you already get some partial points for implementing some classes completely and correctly,
even if other classes are complete but still may not work properly.
*/

public class Solution{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String className = input.nextLine();

        // Checking the implementation of the Position class
        if(className.equals("Position")){
            Position p1 = new Position(input.nextInt(), input.nextInt());
            System.out.println(p1);
            p1.setX(5);
            System.out.println(p1.getX());

            Position p2 = new Position(5, 10);
            System.out.println(p1.equals(p2));
        }

        // Checking the implementation of the Map class
        else if(className.equals("Map")){
            try{
                Map map = new Map(input);
                map.print();
                int size = map.getSize();
                System.out.println(size);
                System.out.println(map.getValueAt(size/2, size/2));
            }
            catch(Exception e){}
        }

        // Checking the Player interface and the MyPlayer class
        else if(className.equals("Player")){
            Player player = new MyPlayer();
            System.out.println(Player.class.isInterface());
            System.out.println(player instanceof Player);
            System.out.println(player instanceof MyPlayer);
        }

        // Checking the InvalidMapException class
        else if(className.equals("Exception")){
            try{
                throw new InvalidMapException("Some message");
            }
            catch(InvalidMapException e){
                System.out.println(e.getMessage());
            }
        }

        // Checking the Game class and all of its components
        else if(className.equals("Game")){

            // Initialize player, map, and the game
            Player player = new MyPlayer();
            Game game = null;

            try{
                game = new Game(new Map(input));
            }
            catch(InvalidMapException e){ // custom exception
                System.out.println(e.getMessage());
                System.exit(0);
            }

            game.addPlayer(player);

            // Make the player move based on the commands given in the input
            String moves = input.next();
            char move;
            for(int i=0; i<moves.length(); i++){
                move = moves.charAt(i);
                switch(move){
                    case 'R':
                        player.moveRight();
                        break;
                    case 'L':
                        player.moveLeft();
                        break;
                    case 'U':
                        player.moveUp();
                        break;
                    case 'D':
                        player.moveDown();
                        break;
                }
            }

            // Determine the final position of the player after completing all the moves above
            Position playerPosition = player.getPosition();
            System.out.println("Player final position");
            System.out.println("Row: " + playerPosition.getX());
            System.out.println("Col: " + playerPosition.getY());
        }
    }
}
    

    