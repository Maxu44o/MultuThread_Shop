public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int TIMEBETWEENDELIVERY = 2000;
        Dealer dealer = new Dealer();

        new Customer(dealer, "Corolla", "Джун1").start();
        new Customer(dealer, "Corolla", "Джун2").start();
        new Customer(dealer, "Corolla", "Джун3").start();
        new Customer(dealer, "Corolla", "Джун4").start();
        new Customer(dealer, "Camry", "Мидл1").start();
        new Customer(dealer, "Camry", "Мидл2").start();
        new Customer(dealer, "Camry", "Мидл3").start();
        new Customer(dealer, "Prado", "Синьор1").start();
        new Customer(dealer, "Prado", "Синьор2").start();
        new Customer(dealer, "Prado", "Синьор3").start();
        new Customer(dealer, "LC300", "Лид1").start();
        new Customer(dealer, "LC300", "Лид2").start();

       // Thread.sleep(1000);

        for (int i = 0; i < 3; i++) {
            new Supplyer(dealer, "Corolla", 3).start();
            Thread.sleep(TIMEBETWEENDELIVERY);
            new Supplyer(dealer, "Camry", 2).start();
            Thread.sleep(2000);
            new Supplyer(dealer, "Prado", 2).start();
            Thread.sleep(2000);
            new Supplyer(dealer, "LC300", 1).start();
            Thread.sleep(2000);
        }
    }
}
