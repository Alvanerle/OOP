package Projects.Project2;

import java.util.ArrayList;
import java.util.List;

public class MyMap<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    // 1 3 4 5
    // 4 2 1 1

    public MyMap(){
    }

    public int find(K key){
        for(int i = 0; i < keys.size(); i++){
            if(keys.get(i).equals(key)){
                return i;
            }
        }

        return -1;
    }

    public void put(K key, V value){
        int ind = find(key);

        if(ind == -1){
            keys.add(key);
            values.add(value);
        }
        else{
            values.set(ind, value);
        }
    }

    public void remove(K key){
        int ind = find(key);

        if(ind != -1) {
            keys.remove(ind);
            values.remove(ind);
        }
    }


    public V get(K key){
        int ind = find(key);
        if(ind == -1) return null;

        return values.get(ind);
    }

    public int size(){
        return keys.size();
    }

    public List<K> keys() {
        return keys;
    }

    public List<V> values(){
        return values;
    }
}