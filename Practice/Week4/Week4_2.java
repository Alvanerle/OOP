package Practice.Week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Week4_2 {
    public static void main(String[] args){
        Stack<Integer> st = SecondTask.primeFactorization(120);
        while(!st.empty()){
            System.out.println(st.pop());
        }
        System.out.println("---------------");

        List<Integer> a = SecondTask.primeNumbers(120);
        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
    }
}

class SecondTask {
    public static Stack<Integer> primeFactorization(int x){
        Stack<Integer> st = new Stack<Integer>();

        for(int i = 2; i <= x; i++){
            if(x % i == 0){
                while(x % i == 0){
                    st.push(i);
                    x /= i;
                }
            }
        }

        return st;
    }

    static boolean isPrime(int x){
        for(long i = 2; i * i <= x; i++){
            if(x % i == 0){
                return false;
            }
        }

        return true;
    }

    public static List<Integer> primeNumbers(int n){
        List<Integer> a = new ArrayList<Integer>();
        for(int i = 2; i <= n; i++){
            if(isPrime(i)){
                a.add(i);
            }
        }

        return a;
    }
}