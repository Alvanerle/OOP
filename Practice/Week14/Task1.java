package Practice.Week14;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        Set<String> s1 = new LinkedHashSet<>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
        Set<String> s2 = new LinkedHashSet<>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));

        Set<String> un = new LinkedHashSet<>(s1);
        un.addAll(s2);

        Set<String> dif = new LinkedHashSet<>(s1);
        dif.removeAll(s2);

        Set<String> inter = new LinkedHashSet<>(s1);
        inter.retainAll(s2);

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        System.out.println("Union: " + un);
        System.out.println("Difference: " + dif);
        System.out.println("Intersection: " + inter);
    }
}
