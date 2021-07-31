public class QuickUnion {
    private int[] nodes; // nodes with their component ids assigned
    private int nComponents;

    public QuickUnion(int size)
    {
        nodes = new int[size];
        nComponents = size;

        for (int i = 0; i < size; i++)
        {
            // root node is yourself
            nodes[i] = i;
        }
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
        // set the root of p to the root of q
        nodes[i] = j;
        nComponents -= 1;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int p) {
        return nodes[p];
    }

    /**
     * Number of components
     */
    public int count() {
        return nComponents;
    }
}
