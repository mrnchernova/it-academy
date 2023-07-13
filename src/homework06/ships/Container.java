package homework06.ships;

import java.util.Arrays;

public class Container {
    private int[] diagonal = new int[]{10, 20};
    private int[] density = new int[]{1000, 2000}; //plotnost'
    private int height; //[10..100]
    private String[] shape = new String[]{"square", "cylinder", "cone"};
    private String[] size = new String[]{"big", "small"};


    public void getContainerWeight(String shape, String size, int height, int p) {
        double m;
        int diagonal;
        if (size.equals("big")) {
            diagonal = 20;
        } else {
            diagonal = 10;
        }

        switch (shape) {
            case "square":
                break;
            case "cylinder": //https://www.stresscalc.ru/volume/v1.php
                double V = Math.PI * (Math.pow(diagonal, 2) / 4) * height;  //V=(π*d2/4)h
                System.out.println("V = " + V);
                m = V * p/(Math.pow(1000,3));
                System.out.println("Weight of " + size + " " + shape + " container = " + m + " kg");
                break;
            case "cone":
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
