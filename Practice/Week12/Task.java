package Practice.Week12;

public class Task {
    public static void main(String[] args) {
        Pair<Integer, String> test1 = new Pair<>(10, "test");
        Pair<Character, Double> test2 = new Pair<>('d', 13.13d);
    }
}

class Pair<T, V> {
    public T first;
    public V second;

    Pair(T first, V second){
        this.first = first;
        this.second = second;
    }
}

class Tuple<T, V, K extends Comparable<K>> {
    public T first;
    public V second;
    public K third;

    Tuple(T first, V second, K third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
