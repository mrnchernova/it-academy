package homework06.ships;

public class Container {
    private int diagonal;
    private int density;
    private int height;
    private String shape;
    private boolean bigContainer;

    public Container getContainer() {
        String[] shapeOfContainer = new String[]{"прямоугольник", "цилиндр", "конус"};
        int[] densityOfWater = new int[]{1000, 2000};
        Container container = new Container();
        int randomShape = Run.random.nextInt(shapeOfContainer.length);
        int randomDensity = Run.random.nextInt(densityOfWater.length);

        container.shape = shapeOfContainer[randomShape];
        container.bigContainer = Run.random.nextBoolean();
        container.height = (int) (Math.random() * 91) + 10;
        container.density = densityOfWater[randomDensity];

        if (container.bigContainer) {
            container.diagonal = 20;
        } else {
            container.diagonal = 10;
        }
        return container;
    }

    public double getContainerWeight(int diagonal, int density, int height, String shape) {
        double volume;
        double weight = 0;

        switch (shape) {
            case "прямоугольник":
                double c;
                c = Math.sqrt(Math.pow(diagonal / 2, 2) + Math.pow(diagonal / 2, 2));
                volume = c * c * height;
                weight = volume / 1000 * density;
                break;
            case "цилиндр":
                volume = Math.PI * (Math.pow(diagonal, 2) / 4) * height;
                weight = volume / 1000 * density;
                break;
            case "конус":
                volume = (Math.PI * Math.pow(diagonal / 2, 2) * height) / 3;
                weight = volume / 1000 * density;
                break;
        }
        return weight;
    }

    public Container() {
    }

    public int getDiagonal() {
        return diagonal;
    }

    public int getDensity() {
        return density;
    }

    public int getHeight() {
        return height;
    }

    public String getShape() {
        return shape;
    }

    public boolean isBigContainer() {
        return bigContainer;
    }

    @Override
    public String toString() {
        return "Контейнер[" +
                "основание контейнера: " + diagonal +
                ", плотность воды: " + density +
                ", высота контейнера: " + height +
                ", форма контейнера: " + shape + ']';
    }
}
