package homework03.calculator;

public class Calculator {


    public double sum(double a, double b) {
        return a + b;
    }

    public double minus(double a, double b) {
        return a - b;
    }

    public double mult(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        return a / b;
    }

    public double mod(double a, double b) {
        return a % b;
    }

    public double percent(double a, double b) {
        return (a * b) / 100;
    }
    
    public void fromDecToBin(double a){
        System.out.println(Integer.toBinaryString((int) a));
    }

    public void fromBinToDec(double a){
        System.out.println(Integer.parseInt(String.valueOf((int) a), 2));
    }


}
