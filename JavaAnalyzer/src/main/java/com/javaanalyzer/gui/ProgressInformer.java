package com.javaanalyzer.gui;

import java.util.function.Consumer;

public class ProgressInformer {

    private Consumer<Double> consumer;
    private int total, current;

    public ProgressInformer(Consumer<Double> consumer) {
        this.consumer = consumer;
        this.total = 0;
        this.current = 0;
    }

    public void init(int total) {
        this.total = total;
    }

    public void add() {
        this.current++;
        this.consumer.accept(getPercentage());
    }

    public double getPercentage() {
        if (total == 0)
            return 100.0d;
        return (double) 100 * current / total;
    }

}
