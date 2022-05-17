package Projects.Project2;

import java.util.Scanner;

public class Map {
    private char[][] c;
    private int size;
    MyMap<Point, Integer> points = new MyMap<>();
    MyMap<Point, Integer> traps = new MyMap<>();

    public Map(Scanner input) throws InvalidMapException {
        size = input.nextInt();
        c = new char[size][size];

        if(size == 0){
            throw new InvalidMapException("Map size can not be zero");
        }

        boolean ok = false;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(input.hasNext()){
                    c[i][j] = input.next().charAt(0);
                    if(c[i][j] >= '1' && c[i][j] <= '9'){
                        points.put(new Point(i, j), c[i][j] - '0');
                    }
                    if(c[i][j] == '#'){
                        traps.put(new Point(i, j), 0);
                    }
                    if(c[i][j] == 'X') ok = true;
                    if(!(c[i][j] == '0' || c[i][j] == '#' || c[i][j] == 'X' || (c[i][j] >= '1' && c[i][j] <= '9'))){
                        throw new InvalidMapException("Invalid map element");
                    }
                }
                else{
                    throw new InvalidMapException("Not enough map elements");
                }
            }
        }

        if(!ok) throw new InvalidMapException("Player does not exist");
    }

    public int getSize(){
        return size;
    }

    public char getValueAt(int i, int j){
        return c[i][j];
    }

    public void setValueAt(int i, int j, char ch){
        c[i][j] = ch;
    }

    public void print(){
        for(int i = 0; i < c.length; i++){
            System.out.print("  ");
            for(int j = 0; j < c[i].length; j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}