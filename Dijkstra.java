import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Dijkstra {
    private Map<String, Edge> edgeTo;
    private Map<String, Double> distTo;
    private IndexMinHeap<String, Double> pq;

    public Dijkstra(EdgeWeightedDigraph g, String s) {
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        pq = new IndexMinHeap<>();
        for (String v : g.getVerts()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(s, 0.0);

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            String v = pq.delMin();
            System.out.println("Processando " + v);
            for (Edge e : g.getAdj(v)) {
                relax(e);
            }
        }
    }

    public double getDist(String v) {
        return distTo.get(v);
    }

    public boolean hasPathTo(String v) {
        return edgeTo.containsKey(v);
    }

    public Iterable<String> pathTo(String v) {
        LinkedList<String> path = new LinkedList<>();
        while (v != null) {
            path.add(0, v);
            // System.out.println("Get edgeTo: " + v);
            Edge e = edgeTo.get(v);
            if (e == null)
                v = null;
            else
                v = e.getV();
        }
        return path;
    }

    private void relax(Edge e) {
        String v = e.getV();
        String w = e.getW();
        // System.out.println("Relax: " + v + " -> " + w);
        Double newWeight = distTo.get(v) + e.getWeight();
        if (distTo.get(w) > newWeight) {
            distTo.put(w, newWeight);
            edgeTo.put(w, e);
            if (pq.contains(w)) {
                pq.decreaseValue(w, newWeight);
            } else {
                pq.insert(w, newWeight);
            }
        }
    }
}