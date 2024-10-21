import java.util.HashSet;
import java.util.Set;

public class CicloNaoDirigido {

    private Set<String> conjArestas;
    private Set<String> marked;
    private boolean temCiclo;

    public CicloNaoDirigido(Graph g) {
        conjArestas = new HashSet<>();
        marked = new HashSet<>();
        temCiclo = false;
        for (String v : g.getVerts()) {
            if (!marked.contains(v))
                dfs(g, v);
        }
    }

    public boolean temCiclo() {
        return temCiclo;
    }

    private void dfs(Graph g, String v) {

    }
}
