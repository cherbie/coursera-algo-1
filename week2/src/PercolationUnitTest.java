public class PercolationUnitTest {
    public static void main(String[] args) {
        System.out.println("--- START: PercolationUnitTest ---");
        try {
            System.out.println("[ ] testNoOpenSites");
            testNoOpenSites();
            System.out.println("[ ] testNaivePercolatingSystem");
            testNiavePercolatingSystem();
            System.out.println("[ ] testNonPercolatingSystem");
            testNonPercolatingSystem();
        } catch (AssertionError e) {
            System.err.println("--- FAILED TEST ---");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Done");
    }

    public static void testNoOpenSites() {
        Percolation system = new Percolation(10);
        assert system.numberOfOpenSites() == 0;
        assert !system.isFull(0, 0);
        assert !system.percolates();
    }

    public static void testNiavePercolatingSystem() {
        Percolation system = new Percolation(10);
        for (int i = 0; i < 10; i++) {
            // niavely open all in the first column
            system.open(i, 0);
            assert system.isFull(i, 0);
            assert !system.isFull(i, 1);
        }
        assert system.numberOfOpenSites() == 10;
        assert system.percolates();
    }

    public static void testNonPercolatingSystem() {
        Percolation system = new Percolation(10);
        // attach on diagonals
        for (int i = 0; i < 10; i++) {
            system.open(i, i);
            if (i != 0)
                assert !system.isFull(i, i) : "System incorrectly full";
        }
        assert system.numberOfOpenSites() == 10 : "Incorrect number of open sites";
        assert !system.percolates() : "System should not percolate";
    }
}
