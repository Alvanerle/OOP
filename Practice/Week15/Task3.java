package Practice.Week15;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        FibonacciIterator fibonacciIterator = new FibonacciIterator(100000);
        fibonacciIterator.print();
    }
}

class FibonacciIterator {
    List<Integer> list = new ArrayList<>();
    int limit;

    FibonacciIterator(int limit){
        this.limit = limit;

        list.add(0);
        list.add(1);

        int prev = 0;
        int cur = 1;

        while(prev + cur <= limit){
            list.add(prev + cur);
            prev = cur;
            cur = list.get(list.size() - 1);
        }
    }

    public void print(){
        for(int x: list){
            System.out.print(x + " ");
        }
    }
}
