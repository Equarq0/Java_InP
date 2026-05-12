public class Task2 {
//    public static void transfer(Account from, Account to, int amount) {
//        synchronized (from) {
//            System.out.println(Thread.currentThread().getName() + " locked " + from.id);
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {}
//
//            synchronized (to) {
//                from.withdraw(amount);
//                to.deposit(amount);
//            }
//        }
//    }

    public static void transfer(Account from, Account to, int amount) {
        Account first = from.id < to.id ? from : to;
        Account second = from.id < to.id ? to : from;

        synchronized (first) {
            synchronized (second) {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("Transfer done from " + from.id + " to " + to.id);
            }
        }
    }

    public static void main(String[] args) {
        Account accA = new Account(1, 1000);
        Account accB = new Account(2, 1000);

        Thread t1 = new Thread(() -> transfer(accA, accB, 100), "Thread-1");
        Thread t2 = new Thread(() -> transfer(accB, accA, 200), "Thread-2");

        t1.start();
        t2.start();
    }
}