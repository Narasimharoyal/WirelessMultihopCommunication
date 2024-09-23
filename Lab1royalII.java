import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab1royalII {
    public static void main(String[] args) {
        List<int[]> hikers = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("hikernet2.txt"))) {
            int N = scanner.nextInt();

            for (int i = 0; i < N; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                hikers.add(new int[]{x, y});
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + e.getMessage());
            return;
        }

        int minPower = findMinimumPower(hikers, hikers.size());

        try (PrintWriter writer = new PrintWriter("hikernet2out.txt")) {
            writer.println(minPower);
        } catch (FileNotFoundException e) {
            System.err.println("Error writing output file: " + e.getMessage());
        }
    }

    private static int findMinimumPower(List<int[]> hikers, int N) {
        int low = 0, high = 625000000; // max distance^2

        while (low < high) {
            int mid = (low + high) / 2;
            if (canCommunicate(hikers, N, mid)) {
                high = mid; // try smaller power
            } else {
                low = mid + 1; // need more power
            }
        }

        return low;
    }

    private static boolean canCommunicate(List<int[]> hikers, int N, int power) {
        boolean[] visited = new boolean[N];
        dfs(0, hikers, visited, power);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private static void dfs(int index, List<int[]> hikers, boolean[] visited, int power) {
        visited[index] = true;
        int[] current = hikers.get(index);

        for (int i = 0; i < hikers.size(); i++) {
            if (!visited[i]) {
                int[] neighbor = hikers.get(i);
                int distanceSquared = (current[0] - neighbor[0]) * (current[0] - neighbor[0]) + (current[1] - neighbor[1]) * (current[1] - neighbor[1]);
                if (distanceSquared <= power) {
                    dfs(i, hikers, visited, power);
                }
            }
        }
    }
}
