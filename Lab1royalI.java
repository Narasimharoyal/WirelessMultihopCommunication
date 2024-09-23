import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Hiker {
    int x, y, power;

    Hiker(int x, int y, int power) {
        this.x = x;
        this.y = y;
        this.power = power;
    }

    boolean canReach(Hiker other) {
        int distanceSquared = (this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y);
        return distanceSquared <= power * power;
    }
}

public class Lab1royalI {
    public static void main(String[] args) {
        List<Hiker> hikers = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("hikernet1.txt"))) {
            int N = scanner.nextInt();

            for (int i = 0; i < N; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int power = scanner.nextInt();
                hikers.add(new Hiker(x, y, power));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + e.getMessage());
            return;
        }

        int maxReachable = 0;

        for (Hiker hiker : hikers) {
            boolean[] visited = new boolean[hikers.size()];
            maxReachable = Math.max(maxReachable, dfs(hikers, hiker, visited));
        }

        try (PrintWriter writer = new PrintWriter("hikernet1out.txt")) {
            writer.println(maxReachable);
        } catch (FileNotFoundException e) {
            System.err.println("Error writing output file: " + e.getMessage());
        }
    }

    private static int dfs(List<Hiker> hikers, Hiker current, boolean[] visited) {
        int count = 1;
        visited[hikers.indexOf(current)] = true;

        for (Hiker neighbor : hikers) {
            if (!visited[hikers.indexOf(neighbor)] && current.canReach(neighbor)) {
                count += dfs(hikers, neighbor, visited);
            }
        }

        return count;
    }
}
