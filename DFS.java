import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DFS {
    private Set<String> marked;
    private Map<String, String> edgeTo;
    private String start;

    public DFS(Graph g, String start) {
        this.start = start;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        edgeTo.put(start, null);
        dfs(g, start);
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

    public void dfs(Graph g, String v) {
        System.out.println("Visitando: " + v);
        marked.add(v);
        for (String w : g.getAdj(v)) {
            if (!marked.contains(w)) {
                edgeTo.put(w, v);
                dfs(g, w);
            }
        }
    }
}