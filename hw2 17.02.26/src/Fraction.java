import java.util.Objects;

public class Fraction extends Number {
    private int nominator;
    private int denominator;
    public Fraction(int nominator, int denominator) {
        this.nominator = nominator;
        if (denominator != 0) {
            this.denominator = denominator;
            if ((denominator < 0 && nominator > 0) || (denominator < 0 && nominator < 0)) {
                this.nominator = -nominator;
                this.denominator = -denominator;
            }
            reduce();
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int intValue() {
        return nominator / denominator;
    }

     @Override
    public double doubleValue() {
        return (double) nominator / denominator;
    }

    @Override
    public long longValue() {
        return (long) nominator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) nominator / denominator;
    }

    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private void reduce() {
        int nod = gcd(nominator, denominator);
        nominator /= nod;
        denominator /= nod;
    }

    @Override
    public String toString() {
        return nominator + " / " + denominator;
    }

    public Fraction negate() {
        return new Fraction(-this.nominator, this.denominator);
    }

    public boolean isProper() {
        return Math.abs(nominator) < Math.abs(denominator);
    }

    public int getNominator() {
        return nominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction add(Fraction other) {
        nominator = nominator * other.getDenominator() + other.getNominator() * denominator;
        denominator = denominator * other.getDenominator();
        return new Fraction(nominator, denominator);
    }

    public Fraction subtract(Fraction other) {
        nominator = nominator * other.getDenominator() - other.getNominator() * denominator;
        denominator = denominator * other.getDenominator();
        return new Fraction(nominator, denominator);
    }

    public Fraction multiply(Fraction other) {
        nominator = nominator * other.getNominator();
        denominator = denominator * other.getDenominator();
        return new Fraction(nominator, denominator);
    }

    public Fraction divide(Fraction other) {
        nominator = nominator * other.getDenominator();
        denominator = denominator * other.getNominator();
        return new Fraction(nominator, denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return nominator == fraction.nominator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nominator, denominator);
    }
}   
