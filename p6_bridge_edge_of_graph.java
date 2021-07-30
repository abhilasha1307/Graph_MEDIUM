import java.util.ArrayList;

//check wehether the graph is already disconnected (perform DFS)

public class p6_bridge_edge_of_graph extends helperM {
  public static void main(String[] args) {
    Graph G = new Graph(5);
    G.addEdge_UnDirected(1, 0);
    G.addEdge_UnDirected(0, 2);
    G.addEdge_UnDirected(1, 2);
    G.addEdge_UnDirected(0, 3);
    G.addEdge_UnDirected(3, 4);

    int c = 0;
    int d = 2;
    System.out.println(isBridge(G.V, G.adj, c, d));
  }

  static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
    if (isConnected(adj, V, c, d) == false) {
      return 0;
    }
    adj.get(c).remove(Integer.valueOf(d));
    adj.get(d).remove(Integer.valueOf(c));

    if (isConnected(adj, V, c, d))
      return 0;
    else
      return 1;

  }

  public static boolean isConnected(ArrayList<ArrayList<Integer>> adj, int V, int one, int two) {
    boolean[] visited = new boolean[V];

    DFS(one, visited, adj);
    if (!visited[two]) {
      return false;
    }
    return true;
  }

  static void DFS(int V, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
    visited[V] = true;
    ArrayList<Integer> temp = adj.get(V);
    int k = 0;
    while (k < temp.size()) {
      int n = temp.get(k);
      if (!visited[n]) {
        DFS(n, visited, adj);
      }
      k++;
    }
  }
}
