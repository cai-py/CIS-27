public class UnionFind {
    int[] parent;
    int[] size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        int root = x;

        while (root != parent[x]) {
            root = parent[x];
        }

        while (parent[x] != root) {
            int next = parent[x];
            parent[x] = root;
            x = next;
        }

        return root;
    }

    public void union (int x, int y) {
        int root_x = parent[x];
        int root_y = parent[y];
        // check if they are in the same set
        if (root_x != root_y) {
            // compare size of sets
            if (size[root_x] < size[root_y]) {
                parent[root_x] = root_y;
                size[root_y] += size[root_x];
            }else {
                parent[root_y] = root_x;
                size[root_x] += size[root_y];
            }
        }
    }
}


