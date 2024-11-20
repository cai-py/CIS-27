import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MazeGenerator {
    private int size;
    private List<int[]> edges;

    public MazeGenerator(int size) {
        this.size = size;
        edges = new ArrayList<>();

        // Initialize all possible edges in the grid
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int cell = row * size + col;

                // Add edge to the right neighbor
                if (col < size - 1) {
                    edges.add(new int[]{cell, cell + 1});
                }

                // Add edge to the bottom neighbor
                if (row < size - 1) {
                    edges.add(new int[]{cell, cell + size});
                }
            }
        }
    }

    public List<int[]> generateMaze() {
        UnionFind uf = new UnionFind(size * size);
        List<int[]> mazeEdges = new ArrayList<>();

        // Shuffle the edges to introduce randomness
        shuffleEdges();

        for (int[] edge : edges) {
            int cell1 = edge[0];
            int cell2 = edge[1];

            if (uf.find(cell1) != uf.find(cell2)) {
                uf.union(cell1, cell2);
                mazeEdges.add(edge); // Add edge to the maze
            }
        }

        return mazeEdges;
    }

    private void shuffleEdges() {
        Random rand = new Random();

        for (int i = edges.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            // Swap edges[i] with edges[j]
            int[] temp = edges.get(i);
            edges.set(i, edges.get(j));
            edges.set(j, temp);
        }
    }

    public void printMaze(List<int[]> mazeEdges) {
        boolean[][] horizontalWalls = new boolean[size + 1][size];
        boolean[][] verticalWalls = new boolean[size][size + 1];

        for (int i = 0; i <= size; i++) {
            for (int j = 0; j < size; j++) {
                horizontalWalls[i][j] = true;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size; j++) {
                verticalWalls[i][j] = true;
            }
        }

        for (int[] edge : mazeEdges) {
            int cell1 = edge[0];
            int cell2 = edge[1];

            int row1 = cell1 / size, col1 = cell1 % size;
            int row2 = cell2 / size, col2 = cell2 % size;

            if (row1 == row2) { // Horizontal edge
                verticalWalls[row1][Math.min(col1, col2) + 1] = false;
            } else { // Vertical edge
                horizontalWalls[Math.min(row1, row2) + 1][col1] = false;
            }
        }

        // Remove the first wall (top-left cell) for start
        horizontalWalls[0][0] = false;

        // Remove the last wall (bottom-right cell) for finish
        horizontalWalls[size][size - 1] = false;

        // Print the maze
        for (int c = 0; c < size; c++) {
            if (c == 0) {
                System.out.print("    "); // Start gap
            } else {
                System.out.print("+---");
            }
        }
        System.out.println("+");

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(verticalWalls[r][c] ? "|   " : "    ");
            }
            System.out.println("|");

            for (int c = 0; c < size; c++) {
                if (r == size - 1 && c == size - 1) {
                    System.out.print("    "); // Finish gap
                } else {
                    System.out.print(horizontalWalls[r + 1][c] ? "+---" : "+   ");
                }
            }
            System.out.println("+");
        }
    }
}
