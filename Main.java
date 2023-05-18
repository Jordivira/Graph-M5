import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Una clase para representar un objeto graph
class Graph {
    // Una lista de listas para representar una lista de adyacencia
    List<List<Integer>> adjList = null;

    // Constructor
    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // agrega bordes al grafo no dirigido
        for (Edge edge : edges) {
            int src = edge.source;
            int dest = edge.dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}

public class Main {
    // Realiza DFS en el graph y devuelve verdadero si hay back-edge
    // se encuentra en el grafo
    public static boolean DFS(Graph graph, int v, boolean[] discovered, int parent) {
        // marca el nodo actual como descubierto
        discovered[v] = true;

        // hacer para cada borde (v, w)
        for (int w : graph.adjList.get(v)) {
            // si `w` no se descubre
            if (!discovered[w]) {
                if (!DFS(graph, w, discovered, v)) {
                    return false;
                }
            }

            // si se descubre `w` y `w` no es un padre
            else if (w != parent) {
                // encontramos un back-edge (ciclo)
                return false;
            }
        }

        // no se encontraron bordes posteriores en el graph
        return true;
    }

    // Comprobar si el graph no dirigido dado es un árbol
    public static boolean isTree(Graph graph, int n) {
        // para realizar un seguimiento de si se descubre un vértice o no
        boolean[] discovered = new boolean[n];

        // Realizar recorrido DFS desde el primer vértice
        boolean isTree = DFS(graph, 0, discovered, -1);

        for (int i = 0; isTree && i < n; i++) {
            // cualquier vértice no descubierto significa que el graph está desconectado
            if (!discovered[i]) {
                isTree = false;
            }
        }

        return isTree;
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 2), new Edge(1, 3), new Edge(1, 4),
                new Edge(2, 5)
        );

        // número de nodos en el grafo
        final int N = 6;

        // construir un grafo no dirigido
        Graph graph = new Graph(edges, N);

        // comprueba si el grafo no dirigido dado es un árbol
        boolean isTree = isTree(graph, N);
        if (isTree) {
            System.out.println(true);

        } else {
            System.out.println(false);
        }
    }
}

