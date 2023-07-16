package homework06.ships;

import java.util.Random;

public class OneDeckShip extends Ship {
    private static Random random = new Random();

    @Override
    public void chargeShip() {
        System.out.println("Загрузка " + 1 + "-палубного корабля контейнерами");
        Container[] arrayContainer = new Container[4];
        Container container = new Container();
        int i = 0;
        int bigContainer = 0;
        int smallContainer = 0;

        while (i < arrayContainer.length) {
            arrayContainer[i] = container.getContainer();
            if (arrayContainer[i].bigContainer) {

                if ((smallContainer == 3) || (bigContainer == 1 && smallContainer == 1)) {
                    // больше больших контейнеров уже не впихнуть
                    // ничего не происходит. ждем когда выпадет маленький контейнер
                    continue;
                } else {
                    bigContainer++;
                    i++;
                }
            } else {
                smallContainer++;
                i++;
            }

            // при этом условии никакие контейнеры больше не поместятся. Выход из цикла. Завершение заполнения корабля
            if ((bigContainer == 1 && smallContainer == 2) || (bigContainer == 2)) {
                break;
            }
        }

        System.out.println("Больших контейнеров:   " + bigContainer);
        System.out.println("Маленьких контейнеров: " + smallContainer);

        for (Container x : arrayContainer) {
            System.out.println(x);
//            container.getContainerWeight(x);
        }
        System.out.println("---");
    }

    @Override
    public void getShip() {
    }
}
