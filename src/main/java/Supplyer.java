public class Supplyer extends Thread {

    String model;
    int quantity;
    Dealer dealer;

    public Supplyer(Dealer dealer, String model, int quantity) {
        this.model = model;
        this.quantity = quantity;
        this.dealer = dealer;
    }

    @Override
    public void run() {
        System.out.println("\n Привезли " + quantity + " шт " + model);

        if (model.equals("Corolla")) dealer.corollaManager.recieveCar(model, quantity);
        if (model.equals("Camry")) dealer.camryManager.recieveCar(model, quantity);
        if (model.equals("Prado")) dealer.pradoManager.recieveCar(model, quantity);
        if (model.equals("LC300")) dealer.LC3000Manager.recieveCar(model, quantity);

    }
}
