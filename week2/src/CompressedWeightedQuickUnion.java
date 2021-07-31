import java.util.Arrays;

public class CompressedWeightedQuickUnion {
    private int[] nodes; // nodes with their component ids assigned
    private int[] weights; // relative weight of tree node
    private int nComponents;

    public CompressedWeightedQuickUnion(int size) {
        nodes = new int[size];
        weights = new int[size];
        Arrays.fill(weights, 1);
        nComponents = size;
        for (int i = 0; i < size; i++) {
            // root node is yourself
            nodes[i] = i;
        }
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
        else if (weights[i] < weights[j]) {
            nodes[i] = j;
            weights[j] = weights[j] + weights[i];
            nComponents -= 1;
        } else {
            nodes[j] = i;
            weights[i] = weights[i] + weights[j];
            nComponents -= 1;
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public int root(int p) {
        while (p != nodes[p]) {
            int pid = nodes[p]; // parent node id
            nodes[p] = nodes[pid]; // set to grandparent id
            p = nodes[p];
        }
        return p;
    }

    /**
     * Number of components
     */
    public int count() {
        return nComponents;
    }
}
