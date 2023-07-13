package homework06.ships;

public abstract class Ship {
    private String name;
    
    public void chargeShip(){
        System.out.println("Common method for charging ship");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ship(String name) {
        this.name = name;
    }

    public Ship() {
    }

    @Override
    public String toString() {
        return "Ship{" + name + '}';
    }
}
