public class QuickFind {
    private int[] nodes; // nodes with their component ids assigned
    private int nComponents;

    public QuickFind(int size)
    {
        nodes = new int[size];
        nComponents = size;
        for (int i = 0; i < size; i++)
        {
            // node is it's own component
            nodes[i] = i;
        }
    }

    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == pid) {
                nodes[i] = qid;
                nComponents -= 1;
            }
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return nodes[p];
    }

    /**
     * Number of components
     */
    public int count() {
        return nComponents;
    }
}
