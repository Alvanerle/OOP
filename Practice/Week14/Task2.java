package Practice.Week14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Task2 {
    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();

        try {
            File file = new File("C:\\Users\\Imangaly\\IdeaProjects\\OOP\\src\\Practice\\Week14\\input2.txt");
            Scanner input = new Scanner(file);
            while(input.hasNextLine()) {
                String data = input.nextLine();
                s.add(data);
            }
            input.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Something wrong with file");
        }

        for(String str: s){
            System.out.println(str);
        }
    }
}
