package homework06.ships;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Container {
    private int[] diagonal = new int[]{10, 20};
    public int[] density = new int[]{1000, 2000}; //plotnost'
    private int height; //[10..100]
    public String[] shape = new String[]{"square", "cylinder", "cone"};
    public String[] size = new String[]{"big", "small"};


    public void getContainerWeight(String shape, String size, int height, int p) {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        double V;
        double m;
        int diagonal;

        if (size.equals("big")) {
            diagonal = 20;
        } else {
            diagonal = 10;
        }

        switch (shape) {
            case "square":

                System.out.println("plotn " + p);
                System.out.println("height " + height);
                
                double c;
                c = Math.sqrt(Math.pow(diagonal / 2, 2) + Math.pow(diagonal / 2, 2));
                V = c * c * height;
                System.out.println("V = " + decimalFormat.format(V));
                m = V * p;
                System.out.println("Weight of " + size + " " + shape + " container = " + decimalFormat.format(m) + " ed\n");
                break;

            case "cylinder":

                System.out.println("plotn " + p);
                System.out.println("height " + height);
                
                V = Math.PI * (Math.pow(diagonal, 2) / 4) * height;
                System.out.println("V = " + decimalFormat.format(V));
                m = V * p;
                System.out.println("Weight of " + size + " " + shape + " container = " + decimalFormat.format(m) + " ed\n");
                break;

            case "cone":

                System.out.println("water density " + p);
                System.out.println("container height " + height);
                
                V = (Math.PI * Math.pow(diagonal / 2, 2) * height) / 3;
                System.out.println("V = " + decimalFormat.format(V));
                m = V * p;
                System.out.println("Weight of " + size + " " + shape + " container = " + decimalFormat.format(m) + " ed\n");
                break;
        }
    }


    public Container() {
    }

    public Container(int[] diagonal, int height, String[] shape, String[] size) {
        this.diagonal = diagonal;
        this.height = height;
        this.shape = shape;
        this.size = size;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[] getDiagonal() {
        return diagonal;
    }

    public int getHeight() {
        return height;
    }

    public String[] getShape() {
        return shape;
    }

    public String[] getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Container{" +
                "diagonal=" + Arrays.toString(diagonal) +
                ", height=" + height +
                ", shape=" + Arrays.toString(shape) +
                ", size=" + Arrays.toString(size) +
                '}';
    }
}
