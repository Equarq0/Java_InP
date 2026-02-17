public class Main {
    public static void main(String[] args) {

        // Task 1
        Box<Integer> integerBox = new Box<>();
        Box<Double> doubleBox = new Box<>();
        System.out.println(integerBox.getClass() == doubleBox.getClass());

        // Task 2
        System.out.println(Calculator.add(5, 6));
        System.out.println(Calculator.add(new Fraction(1, 4), 5));

        System.out.println(Calculator.divide(1.5, 6));

    }
}
