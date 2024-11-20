import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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

        // System.out.println(edges);
        Collections.shuffle(edges);
        //System.out.println(edges);

        for (int[] edge : edges) {
            int cell1 = edge[0];
            int cell2 = edge[1];

            if (uf.find(cell1) != uf.find(cell2)) {
                uf.union(cell1, cell2);
                mazeEdges.add(edge);
            }
        }
        return mazeEdges;
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





/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazeGenerator {
    private int rows;
    private int cols;
    private boolean[][] horizontalWalls;
    private boolean[][] verticalWalls;

    public MazeGenerator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        horizontalWalls = new boolean[rows + 1][cols];
        verticalWalls = new boolean[rows][cols + 1];

        // Initialize all walls as present
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                horizontalWalls[i][j] = true;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols; j++) {
                verticalWalls[i][j] = true;
            }
        }
    }

    public void generateMaze() {
        int totalCells = rows * cols;
        UnionFind uf = new UnionFind(totalCells);

        // Generate all possible edges
        List<int[]> edges = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int cell = r * cols + c;

                // Add edge to the right
                if (c < cols - 1) {
                    edges.add(new int[]{cell, cell + 1});
                }

                // Add edge below
                if (r < rows - 1) {
                    edges.add(new int[]{cell, cell + cols});
                }
            }
        }

        // Shuffle edges randomly
        Collections.shuffle(edges);

        // Process edges
        for (int[] edge : edges) {
            int cell1 = edge[0];
            int cell2 = edge[1];

            if (!uf.connected(cell1, cell2)) {
                uf.union(cell1, cell2);

                // Remove the wall between cell1 and cell2
                int r1 = cell1 / cols, c1 = cell1 % cols;
                int r2 = cell2 / cols, c2 = cell2 % cols;

                if (r1 == r2) {
                    verticalWalls[r1][Math.min(c1, c2) + 1] = false;
                } else {
                    horizontalWalls[Math.min(r1, r2) + 1][c1] = false;
                }
            }
        }
    }

    public void printMaze() {
        // Print the top border
        for (int c = 0; c < cols; c++) {
            System.out.print("+---");
        }
        System.out.println("+");

        for (int r = 0; r < rows; r++) {
            // Print vertical walls and cells
            for (int c = 0; c < cols; c++) {
                System.out.print(verticalWalls[r][c] ? "|   " : "    ");
            }
            System.out.println("|");

            // Print horizontal walls
            for (int c = 0; c < cols; c++) {
                System.out.print(horizontalWalls[r + 1][c] ? "+---" : "+   ");
            }
            System.out.println("+");
        }
    }
}

 */