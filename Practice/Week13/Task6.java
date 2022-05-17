package Practice.Week13;

public class Task6 {
    public static int calculate(String s){
        // ^ : high
        // % / * : middle
        // + - : low

        // ( 1 ( 2 ( 3 ) )    ( 2 ) )

        return -1;
    }

    public static void main(String[] args) {
        String s = "(5 * 2 ^ 3 + 2 * 3 % 2) * 4";
        System.out.println(calculate(s));
    }
}
