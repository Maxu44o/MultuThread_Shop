public class Manager {
    private Dealer dealer;
    private final int OFFLOADTIME = 500;

    public Manager(Dealer dealer) {
        this.dealer = dealer;
    }

    public synchronized void sellCar(String model) {
        try {
            while (!dealer.hasCar(model)) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dealer.shipCar(model);
    }

    public synchronized void recieveCar(String model, int quantity) {
        dealer.recieveCars(model, quantity);
        try {
            Thread.sleep(OFFLOADTIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Автомобили " + model + " "+ quantity + " выставили на продажу\n");
        notifyAll();
    }
}
