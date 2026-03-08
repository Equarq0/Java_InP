import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArray = new MyArrayList<>();
        myArray.add(5);
        myArray.add(6);
        myArray.add(7);
        myArray.add(8);
        myArray.add(9);
        myArray.add(11);
        myArray.add(12);
        myArray.add(13);
        myArray.add(14);
        myArray.add(5, 10);
        myArray.remove(9);
        for (int i = 0; i < myArray.size(); i++) {
            System.out.println(i + ") " + myArray.get(i));
        }

    }
}