import java.util.Iterator;
import java.util.Vector;

import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats implements IPercolationStats {
    private class TrialResult {
        double threshold;
        double size;

        public double mean() {
            return threshold / size;
        }
    }
    private Vector<TrialResult> results;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        for (int i = 0; i < trials; i++) {
            results.add(runTrial(n));
        }
    }

    private TrialResult runTrial(int n) {
        TrialResult result = new TrialResult();
        result.size = n * n;
        Percolation system = new Percolation(n);
        while (!system.percolates()) {
            int row = StdRandom.uniform(0, n);
            int col = StdRandom.uniform(0, n);
            if (system.isOpen(row, col))
                continue;
            system.open(row, col);
        }
        result.threshold = system.numberOfOpenSites();
        return result;
    }

    // sample mean of percolation threshold
    public double mean() {
        Iterator<TrialResult> it = results.iterator();
        double sum = 0;
        while (it.hasNext()) {
            TrialResult result = it.next();
            sum += result.mean();
        }
        return sum / results.size();
    }

    public double variance() {
        Iterator<TrialResult> it = results.iterator();
        double sampleMean = mean();
        double s = 0;
        while (it.hasNext()) {
            TrialResult result = it.next();
            s += Math.pow(result.mean() - sampleMean, 2);
        }
        s /= results.size() - 1;
        return s;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        double var = variance();
        return Math.sqrt(var);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        double mean = mean();
        double s = stddev();
        return mean - (1.96 * s / Math.sqrt(results.size()));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        double mean = mean();
        double s = stddev();
        return mean - (1.96 * s / Math.sqrt(results.size()));
    }
}
