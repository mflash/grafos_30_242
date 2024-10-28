import java.util.LinkedList;
import java.util.List;

public class Kruskal {
    protected static final String NEWLINE = System.getProperty("line.separator");

    private double totalWeight;
    private List<Edge> edges;

    public Kruskal(EdgeWeightedGraph g) {

        MinHeap<Edge> pq = new MinHeap<Edge>();
        edges = new LinkedList<>();
        UnionFind uf = new UnionFind(g);
        totalWeight = 0;

        // Insere todas as arestas do grafo original no minheap
        // (fila de prioridade de mínimo)
        for (Edge e : g.getEdges()) {
            pq.put(e);
        }

        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            // System.out.println(e);
            String v = uf.find(e.getV());
            String w = uf.find(e.getW());
            // Se o conjunto de v for diferente do
            // conjunto de w, v e w não vão formar
            // ciclo!
            if (!v.equals(w)) {
                // Neste caso, une os dois conjuntos
                // E adiciona a aresta à MST
                uf.union(e.getV(), e.getW());
                edges.add(e);
                e.setColor("color=\"red\" penwidth=3");
                totalWeight += e.getWeight();
            }
        }
    }

    public Iterable<Edge> getEdges() {
        return edges;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public String toDot() {
        StringBuilder sb = new StringBuilder();
        sb.append("graph {" + NEWLINE);
        sb.append("rankdir = LR;" + NEWLINE);
        sb.append("node [shape = circle];" + NEWLINE);
        for (Edge e : getEdges())
            sb.append(String.format("%s -- %s [label=\"%.3f\"]", e.getV(), e.getW(), e.getWeight()) + NEWLINE);
        sb.append("}" + NEWLINE);
        return sb.toString();
    }

    public static void main(String[] args) {
        EdgeWeightedGraph g = new EdgeWeightedGraph("tinyEWG.txt");
        Kruskal k = new Kruskal(g);

        System.out.println("Peso total: " + k.getTotalWeight());
        for (Edge e : k.getEdges()) {
            System.out.println(e);
        }

        System.out.println();
        System.out.println(k.toDot());
    }
}