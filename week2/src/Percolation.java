import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Iterator;
import java.util.Vector;
import java.util.BitSet;

public class Percolation extends WeightedQuickUnionUF implements IPercolation {
    /** size of the square grid */
    private int size;
    /** cell index identifier for the top of the system */
    private int top;
    /** cell index indentifier for the bottom of the system */
    private int bottom;
    /** bit flags for closed and open cell state */
    private BitSet cellState;

    /**
     * Creates n-by-n grid, with all sites initially blocked
     */
    public Percolation(int n) {
        super(Percolation.getNumberOfCells(n));
        int numberOfCells = Percolation.getNumberOfCells(n);
        size = n;
        top = 0;
        bottom = numberOfCells - 1;
        cellState = new BitSet(numberOfCells);
        cellState.set(top);
        cellState.set(bottom);

        for (int i = 1; i <= n; i++) {
            // connect top row to top of the system
            union(top, top + i);
            // connect bottom row to bottom of the system
            union(bottom, bottom - i);
        }
    }

    private class Cell {
        public int row;
        public int col;
    }

    /**
     * Determine the number of cells used to represent the system
     * 
     * @param n
     * @return
     */
    private static int getNumberOfCells(int n) {
        return n * n + 2;
    }

    /**
     * Returns iterable list of open neighbours
     * 
     * @param row
     * @param col
     * @return Iterable list of open neighbour cells
     */
    private Vector<Cell> getOpenNeighbours(int row, int col) {
        Vector<Cell> neighbours = new Vector<Cell>();
        for (int i = 0; i < 4; i++) {
            Cell cell = new Cell();
            switch (i) {
                case 0: {
                    cell.row = row - 1;
                    cell.col = col;
                    break;
                }
                case 1: {
                    cell.row = row;
                    cell.col = col - 1;
                    break;
                }
                case 2: {
                    cell.row = row + 1;
                    cell.col = col;
                    break;
                }
                case 3: {
                    cell.row = row;
                    cell.col = col + 1;
                    break;
                }
            }
            try {
                if (isOpen(cell.row, cell.col))
                    neighbours.add(cell);
            } catch (IllegalArgumentException _e) {
                continue;
            }
        }
        return neighbours;
    }

    private int getCellIndex(int row, int col) {
        return row * size + col + 1;
    }

    private boolean isSystemCell(int index) {
        return index > top && index < bottom;
    }

    /**
     * Determines if two cell indexes are connected
     * 
     * @param siteA
     * @param siteB
     * @return
     */
    private boolean isConnected(int siteA, int siteB) {
        return find(siteA) == find(siteB);
    }

    /**
     * Opens the site (row, col) if it is not open already
     */
    public void open(int row, int col) {
        int siteIndex = getCellIndex(row, col);
        if (!isSystemCell(siteIndex)) {
            throw new IllegalArgumentException();
        }
        cellState.set(siteIndex);
        Iterator<Cell> it = getOpenNeighbours(row, col).iterator();
        while (it.hasNext()) {
            Cell cell = it.next();
            int neighbourIndex = getCellIndex(cell.row, cell.col);
            union(siteIndex, neighbourIndex);
        }
    }

    /**
     * Is the site (row, col) open?
     */
    public boolean isOpen(int row, int col) {
        int cellIndex = getCellIndex(row, col);
        if (!isSystemCell(cellIndex)) {
            throw new IllegalArgumentException();
        }
        return cellState.get(cellIndex);
    }

    /**
     * Is the site (row, col) full? i.e is the site connected to the top?
     */
    public boolean isFull(int row, int col) {
        int siteIndex = getCellIndex(row, col);
        if (!isSystemCell(siteIndex)) {
            throw new IllegalArgumentException();
        }
        return isOpen(row, col) && isConnected(top, siteIndex);
    }

    /**
     * Returns the number of open sites
     **/
    public int numberOfOpenSites() {
        return cellState.cardinality() - 2;
    }

    /**
     * Does the system percolate?
     **/
    public boolean percolates() {
        return isConnected(top, bottom);
    }
}
