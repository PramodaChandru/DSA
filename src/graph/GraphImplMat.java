package graph;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GraphImplMat {
    private int V;
    private int E;

    private int[][] adjMatrix;


    public GraphImplMat(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdges(int u, int v) {
        this.adjMatrix[u][v] = 1;
        this.adjMatrix[v][u] = 1;
        E++;
    }

    public void printMatrix() {
        IntStream.range(0, this.V).forEach(i -> {
            Arrays.stream(this.adjMatrix[i]).
                    forEach(System.out::print);
            System.out.println();
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " Vertices, " + E + " Edges" + "\n");
        for(int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for(int i : adjMatrix[v]) {
                sb.append(i + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GraphImplMat graph = new GraphImplMat(4);
        graph.addEdges(0,1);
        graph.addEdges(1,2);
        graph.addEdges(2,3);
        graph.addEdges(3,0);
        graph.addEdges(3,4);

        graph.printMatrix();

        System.out.println(graph);
    }
}
