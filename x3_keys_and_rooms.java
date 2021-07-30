import java.util.*;

//841
public class x3_keys_and_rooms extends helperM {
 public static void main(String[] args) {
  Graph G = new Graph(4);
  // G.addEdge_Directed(0, 1);
  // G.addEdge_Directed(0, 3);
  // G.addEdge_Directed(1, 0);
  // G.addEdge_Directed(1, 3);
  // G.addEdge_Directed(1, 1);
  // G.addEdge_Directed(2, 2);
  // G.addEdge_Directed(3, 0);

  G.addEdge_Directed(0, 1);
  G.addEdge_Directed(1, 2);
  G.addEdge_Directed(2, 3);

  System.out.println(canVisitAllRooms(G.adj));
 }

 public static boolean canVisitAllRooms(ArrayList<ArrayList<Integer>> rooms) {
  int size = rooms.size();
  boolean visited[] = new boolean[size];
  bfs(0, visited, rooms);
  for (int i = 0; i < size; i++) {
   if (visited[i] == false) {
    return false;
   }
  }
  return true;
 }

 private static void bfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> rooms) {
  visited[i] = true;

  int parent;
  Queue<Integer> Q = new LinkedList<>();
  Q.add(i);

  while (!Q.isEmpty()) {
   int u = Q.poll();
   parent = u;

   for (int j : rooms.get(u)) {
    if (j != parent && visited[j] == false) {
     visited[j] = true;
     Q.add(j);
    }
   }
  }
 }
}
