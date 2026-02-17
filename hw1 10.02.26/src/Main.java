public class Main {
    public static void main(String[] args) {
        ItemStorage<Integer> prov1 = new ItemStorage<>(100);
        prov1.compareWith(100);
        // сравнение выдаёт True, т.к 100 входит в диапазон кэширования (-128 < 100 < 127), соотв мы не создаём новый объект а берём кэшированный

        ItemStorage<Integer> prov2 = new ItemStorage<>(200);
        prov2.compareWith(200);
        // сравнение выдаёт False, т.к 200 не входит в диапазон кэширования (-128 < 100 < 127), соотв мы создаём новый объект

        ItemStorage<Fraction> prov3 = new ItemStorage<>(new Fraction(1, 2));
        Fraction frac = new Fraction(1, 2);
        System.out.println((frac.equals(prov3.getValue())));
        // Сравнение выдаёт True, т.к в Fraction переопределён метод equals, соотв мы сравниваем не ссылки на объекты, а их содержимое
    }
    
}