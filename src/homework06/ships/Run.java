package homework06.ships;

import java.text.DecimalFormat;
import java.util.Random;

public class Run {
    public static DecimalFormat decimalFormat = new DecimalFormat("#.###");
    public static Random random = new Random();


    public void start() {
        OneDeckShip ods = new OneDeckShip();
        TwoDeckShip tds = new TwoDeckShip();
        double allWaterWeight = 0;

        Port port = new Port();
        int n = port.maxShips;
        System.out.println("В порту " + n + " кораблей");

        for (int i = 0; i < n; i++) {
            // в зависимости от того, что выпадет 1 или 2, будут создаваться разные корабли и заполняться контейнерами
            int random = (int) (Math.random() * (1 + 1)) + 1;
            if (random == 1) {
                allWaterWeight += ods.chargeShip();
            } else {
                allWaterWeight += tds.chargeShip();
            }
        }
        System.out.println("Масса воды на всех кораблях = " + decimalFormat.format(allWaterWeight));
    }

}
