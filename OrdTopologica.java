import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrdTopologica {
    private Set<String> marked;
    private List<String> ordemTopo;

    public OrdTopologica(Digraph g) {
        marked = new HashSet<>();
        ordemTopo = new LinkedList<>();
        for (String v : g.getVerts())
            if (!marked.contains(v)) {
                System.out.println("Iniciando em " + v);
                dfs(g, v);
            }
    }

    public Iterable<String> ordemTopologica() {
        return ordemTopo;
    }

    public void dfs(Graph g, String v) {
        // System.out.println("Pré-ordem: " + v);
        marked.add(v);
        for (String w : g.getAdj(v)) {
            if (!marked.contains(w)) {
                dfs(g, w);
            }
        }
        System.out.println("Pós-ordem: " + v);
        // Adiciona no início da lista (inverte)
        ordemTopo.add(0, v);
    }
}