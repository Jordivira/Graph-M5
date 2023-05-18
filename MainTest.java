import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testIsTree() {
	  List<Edge> edges = Arrays.asList(
	    new Edge(0, 1), new Edge(0, 2), new Edge(1, 3), new Edge(1, 4),
	    new Edge(2, 5)
	  );
	  final int N = 6;
	  Graph graph = new Graph(edges, N);

	  // comprueba si el grafo no dirigido dado es un árbol	
	  boolean isTree = Main.isTree(graph, N);

	  // assert si el resultat es veritat
	  assertTrue(isTree);
	}
	
	@Test
	void testIsNotTree() {
	  List<Edge> edges = Arrays.asList(
	    new Edge(0, 1), new Edge(0, 2), new Edge(1, 3), new Edge(1, 4),
	    new Edge(2, 5), new Edge(3, 5)
	  );
	  final int N = 6;
	  Graph graph = new Graph(edges, N);

	  // comprueba si el grafo no dirigido dado es un árbol	
	  boolean isTree = Main.isTree(graph, N);

	  // assert si el resultat es veritat
	  assertFalse(isTree);
	}
	
	@Test
	void testIsDisconnected() {
	  List<Edge> edges = Arrays.asList(
	    new Edge(0, 1), new Edge(0, 2), new Edge(3, 4), new Edge(4, 5)
	  );
	  final int N = 6;
	  Graph graph = new Graph(edges, N);

	  // comprueba si el grafo no dirigido dado es un árbol	
	  boolean isTree = Main.isTree(graph, N);

	 // assert si el resultat es fals
	  assertFalse(isTree);
	}
	
	@Test
	void testIsSingleNode() {
	  List<Edge> edges = Arrays.asList();
	  final int N = 1;
	  Graph graph = new Graph(edges, N);

	  // comprueba si el grafo no dirigido dado es un árbol	
	  boolean isTree = Main.isTree(graph, N);

	  // assert si el resultat es true
	  assertTrue(isTree);
	}
	
	@Test
	void testIsComplete() {
	  List<Edge> edges = Arrays.asList(
	    new Edge(0, 1), new Edge(0, 2), new Edge(0, 3), new Edge(1, 2),
	    new Edge(1, 3), new Edge(2, 3)
	  );
	  final int N = 4;
	  Graph graph = new Graph(edges, N);

	  // comprueba si el grafo no dirigido dado es un árbol
	  boolean isTree = Main.isTree(graph, N);

	  // assert si el resultat es fals
	  assertFalse(isTree);
	}
	@Test
	void testIsStar() {
	  List<Edge> edges = Arrays.asList(
	    new Edge(0, 1), new Edge(0, 2), new Edge(0, 3), new Edge(0, 4)
	  );
	  final int N = 5;
	  Graph graph = new Graph(edges, N);

	  // comprueba si el grafo no dirigido dado es un árbol
	  boolean isTree = Main.isTree(graph, N);

	  // assert si el resultat es true
	  assertTrue(isTree);
	}
	
	@Test
	void testIsLine() {
	  List<Edge> edges = Arrays.asList(
	    new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(3, 4)
	  );
	  final int N = 5;
	  Graph graph = new Graph(edges, N);

	  // comprueba si el grafo no dirigido dado es un árbol
	  boolean isTree = Main.isTree(graph, N);

	  // assert si el resultat es true
	  assertTrue(isTree);
	}
	
	@Test
	void testIsWheel() {
	  List<Edge> edges = Arrays.asList(
	    new Edge(0, 1), new Edge(0, 2), new Edge(0, 3), new Edge(0, 4), new Edge(0, 5),
	    new Edge(1, 2), new Edge(2, 3), new Edge(3, 4), new Edge(4, 5), new Edge(5, 1)
	  );
	  final int N = 6;
	  Graph graph = new Graph(edges, N);

	  // comprueba si el grafo no dirigido dado es un árbol
	  boolean isTree = Main.isTree(graph, N);

	  // assert si el resultat es fals
	  assertFalse(isTree);
	}
	@Test
	void testIsBipartite() {
	  List<Edge> edges = Arrays.asList(
	    new Edge(0, 1), new Edge(0, 3), new Edge(1, 4), new Edge(2, 4), new Edge(3, 5)
	  );
	  final int N = 6;
	  Graph graph = new Graph(edges, N);

	  // comprueba si el grafo no dirigido dado es un árbol
	  boolean isTree = Main.isTree(graph, N);

	  // assert si el resultat es fals
	  assertFalse(isTree);
	}

}
