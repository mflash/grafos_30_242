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
        // Para cada vértice ainda não marcado...
        // (isto é, não visitado na chamada anterior)
        for (String v : g.getVerts()) {
            if (!marked.contains(v)) {
                System.out.println("Chamada dfs: " + v);
                temCiclo = dfs(g, v);
                if (temCiclo)
                    break;
            }
        }
    }

    public boolean temCiclo() {
        return temCiclo;
    }

    private boolean dfs(Graph g, String v) {
        System.out.println("Visitando: " + v);
        marked.add(v);
        for (String u : g.getAdj(v)) {
            if (!marked.contains(u)) {
                String e = v + "-" + u;
                System.out.println("Aresta: " + e);
                conjArestas.add(e);
                boolean res = dfs(g, u);
                if (res)
                    return res;
            } else {
                String e = u + "-" + v;
                System.out.println("Aresta: " + e);
                if (!conjArestas.contains(e)) {
                    return true;
                }
            }
        }
        return false;
    }
}
