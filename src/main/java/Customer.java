public class Customer extends Thread {
    String model;
    Dealer dealer;
    String name;

    private final int TIMEBETWEENCUSTOMERS = 400;

    public Customer(Dealer dealer, String model, String name) {
        this.model = model;
        this.name = name;
        this.dealer = dealer;
    }

    @Override
    public void run() {
        synchronized (dealer) {
            System.out.println(name + " хочет купить автомобиль " + model);
            if (!dealer.hasCar(model)) System.out.println("автомобиля " + model + " нет в наличии\n");
            try {
                sleep(TIMEBETWEENCUSTOMERS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (model.equals("Corolla")) dealer.corollaManager.sellCar(model);
        if (model.equals("Camry")) dealer.camryManager.sellCar(model);
        if (model.equals("Prado")) dealer.pradoManager.sellCar(model);
        if (model.equals("LC300")) dealer.LC3000Manager.sellCar(model);

        System.out.println(name + " приобрел автомобиль " + model);

    }
}
