package homework06.ships;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;

/**
 * Построить иерархию.
 * 0.   Обязательные сущности (порт, корабль, палуба, контейнер)
 * 1. Порт - 10 кораблей.
 * 2. В порт приплывают корабли (однопалубные и двухпалубные), на одну палубу помещается или два больших контейнера или 4 маленьких.
 * 3. Контейнеры могут быть разной формы (цилиндрические, квадратные, конусом).
 * контейнеры наполнены водой(с плотностью 1000 и 2000 единиц, т.е можно наливать разную воду. Плотность константа);
 * 4. Нужно чтобы мы могли в порт пригонять разные корабли: с разными контейнерами, разной водой, с разной высотой контейнеров (не более 100 единиц и не меньше 10).
 * 5. Основание конуса и цилиндра - диагональ (диаметр) 20 у большого и 10 у маленького. И у квадратного с диагональю 20 у большого и 10 у маленького квадрата.
 * 6. Программа должна выводить общую массу воды которую привозят все корабли.
 * Дополнительные рекомендации:
 * Не забываем про пакеты с маленькой буквы. Объекты одного типа в один пакет.
 * Не все делаем public. Нужно использовать массивы. Желательно чтобы в каждом классе были методы put (или add) и remove (или delete).
 * Для определения размера контейнера использовать флаг или писать сущности . У корабля должно быть имя. Удаление по имени.
 */
public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        OneDeckShip sop = new OneDeckShip();
        sop.chargeShip();
        Container c = new Container();

        c.getContainerWeight("square", "big", 40, 2000);

        System.out.println();

        int randomShape = random.nextInt(c.shape.length);
        int randomSize = random.nextInt(c.size.length);
        int randomDensity = random.nextInt(c.density.length);
        c.getContainerWeight(c.shape[randomShape], c.size[randomSize], (int) (Math.random() * 91) + 10, c.density[randomDensity]);
        c.getContainerWeight(c.shape[randomShape], c.size[randomSize], (int) (Math.random() * 91) + 10, c.density[randomDensity]);
        c.getContainerWeight(c.shape[randomShape], c.size[randomSize], (int) (Math.random() * 91) + 10, c.density[randomDensity]);
        c.getContainerWeight(c.shape[randomShape], c.size[randomSize], (int) (Math.random() * 91) + 10, c.density[randomDensity]);

//     for (int i=0; i<50;i++)
//        System.out.println((int) (Math.random() * 91) + 10);
    }
}
