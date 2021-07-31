public class PercolationStatsUnitTest {
    public static void main(String[] args) {
        System.out.println("-- START: PercolationStatsUnitTest ---");
        try {
            runVisualTest();
        } catch (AssertionError e) {
            System.err.println("--- FAILED TEST ---");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Done");
    }

    public static void runVisualTest() {
        PercolationStats experiment = new PercolationStats(100, 30);
        System.out.println("MEAN = " + experiment.mean());
        System.out.println("STDDEV = " + experiment.stddev());
        System.out.println("CONFIDENCE INTERVAL = "
            + experiment.confidenceLo() + " - "
            + experiment.confidenceHi());
    }
}
