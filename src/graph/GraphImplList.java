package graph;

import java.util.LinkedList;

public class GraphImplList {

    private LinkedList<Integer>[] adj;

    private int V;
    private int E;

    public GraphImplList(int nodes) {
        this.V = nodes;
        this.E = 0;
        adj = new LinkedList[nodes];
        for(int i = 0; i < nodes; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdges(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " Edges " + "\n" );
        for(int v = 0; v < V; v++) {
            sb.append(v + " : ");
            for(int i : adj[v]) {
                sb.append(i + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GraphImplList graph = new GraphImplList(4);
        graph.addEdges(0,1);
        graph.addEdges(1,2);
        graph.addEdges(2,3);
        graph.addEdges(3,0);

        System.out.println(graph);
    }
}
