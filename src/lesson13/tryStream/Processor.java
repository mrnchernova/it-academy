package lesson13.tryStream;

public class Processor {
    private String title;
    private double cpu;

    @Override
    public String toString() {
        return "Title: " + title + " | cpu: " + cpu;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public Processor(String title, double cpu) {
        this.title = title;
        this.cpu = cpu;
    }

    public Processor() {
    }
}
