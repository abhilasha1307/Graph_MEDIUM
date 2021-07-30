import java.util.*;

/*
PROBLEM:)
Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
class Node {
    public int val;
    public List<Node> neighbors;
}
*/

//clone undirected graph
//clone directed acyclic graph
/*
APPROACH:)

*/

public class x1_clone_graph {
    static class Node {
        public int val;
        public ArrayList<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        ArrayList<Node> list = new ArrayList<>();
        list.add(node2);
        list.add(node4);
        node1.neighbors = list;

        list = new ArrayList<>();
        list.add(node1);
        list.add(node3);
        node2.neighbors = list;

        list = new ArrayList<>();
        list.add(node2);
        list.add(node4);
        node3.neighbors = list;

        list = new ArrayList<>();
        list.add(node1);
        list.add(node3);
        node4.neighbors = list;

        x1_clone_graph obj = new x1_clone_graph();
        Node res = obj.cloneGraph(node1);
        boolean visited[] = new boolean[100];
        obj.printGraph(res, visited);
    }

    // DFS

    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node root = new Node(node.val);
        map.put(node, root);

        for (Node neighbour : node.neighbors) {
            root.neighbors.add(cloneGraph(neighbour));
        }

        return root;
    }

    // BFS

    // will print lists for 1, 2, 4, 3
    public void printGraph(Node node, boolean[] visited) {
        if (node == null) {
            return;
        }
        Queue<Node> Q = new LinkedList<>();
        Q.add(node);

        while (!Q.isEmpty()) {
            Node curr = Q.poll();
            if (visited[curr.val] == false) {
                visited[curr.val] = true;
                for (Node neighbour : curr.neighbors) {
                    System.out.print(neighbour.val + " ");
                    Q.add(neighbour);
                }
                System.out.println();
            }
        }
    }
}