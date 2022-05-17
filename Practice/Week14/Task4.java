package Practice.Week14;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<Integer, Integer> m = new HashMap<>();

        // number -> cnt
        int mx = 0;
        while(input.hasNext()){
            int x = input.nextInt();
            if(x == 0) break;

            m.put(x, m.getOrDefault(x, 0) + 1);
            mx = Math.max(mx, m.get(x));
        }

        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> pair: m.entrySet()) {
            if(pair.getValue() == mx) res.add(pair.getKey());
        }

        System.out.println("Max occurrences: " + mx);
        for(int x: res){
            System.out.println(x);
        }
    }
}
