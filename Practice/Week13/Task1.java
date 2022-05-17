package Practice.Week13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        try{
            File input = new File("C:\\Users\\Imangaly\\IdeaProjects\\OOP\\src\\Practice\\Week13\\input.txt");
            Scanner scanner = new Scanner(input);
            while(scanner.hasNext()){
                words.add(scanner.next());
            }
            scanner.close();
        }
        catch(FileNotFoundException fnf) {
            System.out.println("Problems with file");
        }

        Collections.sort(words);
        for(String word: words) {
            System.out.println(word);
        }
    }
}
