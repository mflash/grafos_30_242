import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CicloDirigido {

    private enum Cores {
        WHITE, GREY, BLACK
    }

    private Map<String, Cores> marked;
    private boolean temCiclo;

    public CicloDirigido(Graph g) {
        marked = new HashMap<>();
        temCiclo = false;
        for (String v : g.getVerts())
            marked.put(v, Cores.WHITE);
        // Para cada vértice marcado como WHITE...
        // (isto é, não visitado na chamada anterior)
        for (String v : g.getVerts()) {
            if (marked.get(v) == Cores.WHITE) {
                System.out.println("Chamada dfs: " + v);
                temCiclo = visit(g, v);
                if (temCiclo)
                    break;
            } else
                System.out.println(v + " já foi visitado...");
        }
    }

    public boolean temCiclo() {
        return temCiclo;
    }

    private boolean visit(Graph g, String v) {
        System.out.println("Visitando: " + v);
        marked.put(v, Cores.GREY);
        for (String u : g.getAdj(v)) {
            if (marked.get(u) == Cores.GREY)
                return true;
            else if (marked.get(u) == Cores.WHITE) {
                boolean res = visit(g, u);
                if (res)
                    return res;
            }
        }
        marked.put(v, Cores.BLACK);
        return false;
    }
}
