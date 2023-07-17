package homework06.ships;

public abstract class Ship {
    private String name;

    public abstract double chargeShip();

    public void getShips(Container[] arrayContainer) {
        for (Container x : arrayContainer) {
            if (x != null) {
                System.out.println(x);
            }
        }
    }

    public Ship() {
    }

    public Ship(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ship{" + name + '}';
    }
}
