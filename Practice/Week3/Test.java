package Practice.Week3;

public class Test {
    static void test(int a[]){
        a[3] = 102;
        a[1]++;
    }

    public static void main(String[] args){
        int a[] = {1, 2, 3, 4, 5};

        test(a);

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}
