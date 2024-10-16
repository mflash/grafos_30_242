import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BFS {
    private Set<String> marked;
    private Map<String, String> edgeTo;
    private Map<String, Integer> distTo;
    private String start;

    public BFS(Graph g, String start) {
        this.start = start;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        edgeTo.put(start, null);
        distTo.put(start, 0);
        bfs(g, start);
    }

    public boolean hasPathTo(String v) {
        return edgeTo.containsKey(v);
        // return marked.contains(v);
    }

    public Iterable<String> pathTo(String v) {
        LinkedList<String> path = new LinkedList<>();
        while (v != null) {
            path.add(0, v);
            v = edgeTo.get(v);
        }
        return path;
    }

    public int distTo(String v) {
        return distTo.get(v);
    }

    private void bfs(Graph g, String s) {
        List<String> fila = new LinkedList<>();
        fila.add(s);
        marked.add(s);
        while (!fila.isEmpty()) {
            String v = fila.removeFirst();
            // System.out.println("Visitando: " + v);
            for (String w : g.getAdj(v)) {
                if (!marked.contains(w)) {
                    marked.add(w);
                    edgeTo.put(w, v);
                    distTo.put(w, distTo.get(v) + 1);
                    fila.add(w);
                }
            }
        }
    }
}