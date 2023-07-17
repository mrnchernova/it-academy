package homework06.ships;

public class TwoDeckShip extends Ship {
    @Override
    public double chargeShip() {
        System.out.println("Загрузка " + 2 + "-палубного корабля контейнерами");
        int bigContainer2Deck = 0;
        int smallContainer2Deck = 0;
        double commonWeight = 0;

        for (int deck = 1; deck <= 2; deck++) {
            if (deck == 1) {
                System.out.println("Загрузка первой палубы:");
            } else {
                System.out.println("Загрузка второй палубы:");
            }

            Container[] arrayContainer = new Container[4];
            Container container = new Container();
            int i = 0;
            int bigContainer = 0;
            int smallContainer = 0;
            while (i < arrayContainer.length) {
                arrayContainer[i] = container.getContainer();
                if (arrayContainer[i].isBigContainer()) {

                    if ((smallContainer == 3) || (bigContainer == 1 && smallContainer == 1)) {
                        // больше больших контейнеров уже не впихнуть
                        // ничего не происходит. ждем когда выпадет маленький контейнер
                        continue;
                    } else {
                        commonWeight += container.getContainerWeight(arrayContainer[i].getDiagonal(), arrayContainer[i].getDensity(),
                                arrayContainer[i].getHeight(), arrayContainer[i].getShape());
                        bigContainer++;
                        i++;
                    }
                } else {
                    commonWeight += container.getContainerWeight(arrayContainer[i].getDiagonal(), arrayContainer[i].getDensity(),
                            arrayContainer[i].getHeight(), arrayContainer[i].getShape());
                    smallContainer++;
                    i++;
                }
                // при этом условии никакие контейнеры больше не поместятся. Выход из цикла. Завершение заполнения корабля
                if ((bigContainer == 1 && smallContainer == 2) || (bigContainer == 2)) {
                    break;
                }
            }
            bigContainer2Deck += bigContainer;
            smallContainer2Deck += smallContainer;

            getShips(arrayContainer);
        }
        System.out.println("Больших контейнеров:   " + bigContainer2Deck);
        System.out.println("Маленьких контейнеров: " + smallContainer2Deck);
        System.out.println("Масса воды на корабле: " + Run.decimalFormat.format(commonWeight));

        System.out.println("-----------------------------------------");
        return commonWeight;
    }


}
