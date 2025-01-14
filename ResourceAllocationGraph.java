import java.util.*;

public class ResourceAllocationGraph_237 {
    private final Map<Character, List<Character>> graph = new HashMap<>();

    public void addEdge(char from, char to) {
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
    }

    public boolean hasCycle() {
        Set<Character> visited = new HashSet<>();
        Set<Character> recursionStack = new HashSet<>();

        for (char node : graph.keySet()) {
            if (detectCycle(node, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean detectCycle(char node, Set<Character> visited, Set<Character> recursionStack) {
        if (recursionStack.contains(node)) {
            return true;
        }
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        recursionStack.add(node);

        List<Character> neighbors = graph.get(node);
        if (neighbors != null) {
            for (char neighbor : neighbors) {
                if (detectCycle(neighbor, visited, recursionStack)) {
                    return true;
                }
            }
        }

        recursionStack.remove(node);
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResourceAllocationGraph rag = new ResourceAllocationGraph();

        System.out.print("Enter number of nodes: ");
        int nodes = scanner.nextInt();
        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter edges (from to):");
        for (int i = 0; i < edges; i++) {
            char from = scanner.next().charAt(0);
            char to = scanner.next().charAt(0);
            rag.addEdge(from, to);
        }

        if (rag.hasCycle()) {
            System.out.println("Deadlock: Yes");
        } else {
            System.out.println("Deadlock: No");
        }
        scanner.close();
    }
}
