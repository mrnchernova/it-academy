package homework06.ships;

import java.text.DecimalFormat;
import java.util.Random;

public class Container {
    private static Random random = new Random();
    private int diagonal;
    public int density;
    private int height;
    public String shape;
    public boolean bigContainer;

    public Container getContainer() {
        String[] shapeOfContainer = new String[]{"square", "cylinder", "cone"};
        int[] densityOfWater = new int[]{1000, 2000};
        Container container = new Container();
        int randomShape = random.nextInt(shapeOfContainer.length);
        int randomDensity = random.nextInt(densityOfWater.length);

        container.shape = shapeOfContainer[randomShape];
        container.bigContainer = random.nextBoolean();
        container.height = (int) (Math.random() * 91) + 10;
        container.density = densityOfWater[randomDensity];

        if (container.bigContainer == true) {
            container.diagonal = 20;
        } else {
            container.diagonal = 10;
        }
        return container;
    }

    public void getContainerWeight(int diagonal,int p, int height,String shape) {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        double V;
        double m;

        switch (shape) {
            case "square":

                System.out.println("Плотность воды: " + p);
                System.out.println("Высота контейнера: " + height);
                System.out.println(bigContainer);

                double c;
                c = Math.sqrt(Math.pow(diagonal / 2, 2) + Math.pow(diagonal / 2, 2));
                V = c * c * height;
                System.out.println("V = " + decimalFormat.format(V));
                m = V * p;
                System.out.println("Weight of " + bigContainer + " " + shape + " container = " + decimalFormat.format(m) + " ed\n");
                break;

            case "cylinder":

                System.out.println("Плотность воды: " + p);
                System.out.println("Высота контейнера: " + height);
                System.out.println(bigContainer);

                V = Math.PI * (Math.pow(diagonal, 2) / 4) * height;
                System.out.println("V = " + decimalFormat.format(V));
                m = V * p;
                System.out.println("Weight of " + bigContainer + " " + shape + " container = " + decimalFormat.format(m) + " ed\n");
                break;

            case "cone":

                System.out.println("Плотность воды: " + p);
                System.out.println("Высота контейнера: " + height);
                System.out.println(bigContainer);

                V = (Math.PI * Math.pow(diagonal / 2, 2) * height) / 3;
                System.out.println("V = " + decimalFormat.format(V));
                m = V * p;
                System.out.println("Weight of " + bigContainer + " " + shape + " container = " + decimalFormat.format(m) + " ed\n");
                break;
        }
    }

    public Container() {
    }

    public static Random getRandom() {
        return random;
    }

    public static void setRandom(Random random) {
        Container.random = random;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public int getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public boolean isBigContainer() {
        return bigContainer;
    }

    public void setBigContainer(boolean bigContainer) {
        this.bigContainer = bigContainer;
    }

    @Override
    public String toString() {
        return "Контейнер{" +
                "основание контейнера=" + diagonal +
                ", плотность воды=" + density +
                ", высота контейнера=" + height +
                ", форма контейнера='" + shape + '\'' +
                '}';
    }
}
