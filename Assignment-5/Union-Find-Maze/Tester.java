import java.util.List;

public class Tester {
    public static void main(String[] args) {
        int size = 5; // Maze dimension
        MazeGenerator generator = new MazeGenerator(size);

        List<int[]> mazeEdges = generator.generateMaze();
        generator.printMaze(mazeEdges);
    }
}
