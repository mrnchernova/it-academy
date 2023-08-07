package streams;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Processor)) return false;
        Processor processor = (Processor) o;
        return Double.compare(processor.cpu, cpu) == 0 && Objects.equals(title, processor.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, cpu);
    }
}
