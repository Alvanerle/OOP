package Practice.Week13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Task3 {
    public static void main(String[] args) {

        String s = "";
        try{
            File input = new File("C:\\Users\\Imangaly\\IdeaProjects\\OOP\\src\\Practice\\Week13\\input2.txt");
            Scanner scanner = new Scanner(input);
            s = scanner.nextLine();
            scanner.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Problems with file");
        }

        Map<Character, Character> m = new HashMap<>();
        m.put('(', ')');
        m.put('{', '}');
        m.put('[', ']');

        Stack<Character> st = new Stack<>();
        boolean ok = true;
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                st.push(m.get(c));
            }
            else{
                if(st.empty() || st.pop() != c){
                    ok = false;
                }
            }
        }
        ok &= st.empty();

        System.out.println(ok ? "Valid" : "Invalid");
    }
}
