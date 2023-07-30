package homework06.ships;

public abstract class Ship {
    public abstract double chargeShip();

    public void getShips(Container[] arrayContainer) {
        for (Container x : arrayContainer) {
            if (x != null) {
                System.out.println(x);
            }
        }
    }
}
