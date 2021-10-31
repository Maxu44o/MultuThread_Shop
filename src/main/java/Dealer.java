import java.util.HashMap;
import java.util.Map;

public class Dealer {
    Manager corollaManager = new Manager(this);
    Manager camryManager = new Manager(this);
    Manager pradoManager = new Manager(this);
    Manager LC3000Manager = new Manager(this);

    public Map<String, Integer> depot = new HashMap<>();

    public boolean hasCar(String model) {
        if (depot.get(model) != null && depot.get(model) > 0) {
            return true;
        } else return false;
    }

    public void shipCar(String model) {
        if (depot.get(model) != null && depot.get(model) > 0) {
            int tmp = depot.get(model);
            depot.put(model, tmp - 1);
        }
    }

    public Map<String, Integer> recieveCars(String model, int quantity) {
        if (depot.get(model) == null) depot.put(model, quantity);
        else {
            Integer tmp = depot.get(model);
            depot.put(model, tmp + quantity);
        }
        return depot;
    }

}
