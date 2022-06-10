package edu.escuelaing.arsw.labs.calc;

import java.util.Collection;

public class Stats {
    public static double mean(Collection<? extends Number> list) {
        double mean = 0;
        for (Number n : list) {
            mean += n.doubleValue();
        }
        return mean / list.size();
    }

    public static double stdDev(Collection<? extends Number> list) {
        double mean = mean(list);
        double std_dev = 0;
        for (Number n : list) {
            std_dev += Math.pow(n.doubleValue() - mean, 2);
        }
        std_dev = std_dev / (list.size() - 1);
        return Math.sqrt(std_dev);
    }
}
