import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppMapaMST {

    private class Ponto implements Comparable<Ponto> {
        public int pos;
        public double x, y, dist;

        public Ponto(int pos, double x, double y, double dist) {
            this.pos = pos;
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(AppMapaMST.Ponto o) {
            if (this.dist > o.dist)
                return 1;
            else if (this.dist < o.dist)
                return -1;
            return 0;
        }
    }

    public AppMapaMST(String nomeArq) {
        In arq = new In(nomeArq);
        List<Ponto> pontos = new ArrayList<>();
        int totalPontos = 0;
        while (arq.hasNextLine()) {
            String linha = arq.readLine();
            String[] dados = linha.split(";");
            double y = Double.parseDouble(dados[0]);
            double x = Double.parseDouble(dados[1]);
            pontos.add(new Ponto(totalPontos++, x, y, 0));
        }

        EdgeWeightedGraph g = new EdgeWeightedGraph();

        for (int pos1 = 0; pos1 < pontos.size(); pos1++) {
            double x1 = pontos.get(pos1).x;
            double y1 = pontos.get(pos1).y;
            List<Ponto> pontosAux = new ArrayList<>(pontos);
            for (int pos2 = 0; pos2 < pontos.size(); pos2++) {
                if (pos1 != pos2) {
                    double x2 = pontos.get(pos2).x;
                    double y2 = pontos.get(pos2).y;
                    double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
                    Ponto p = pontosAux.get(pos2);
                    p.dist = dist;
                }
            }
            Collections.sort(pontosAux);
            // for (Ponto p : pontosAux) {
            // System.out.println(p.pos + " - " + p.dist);
            // }
            Ponto inicial = pontos.get(pos1);
            for (int i = 1; i <= 5; i++) {
                Ponto fim = pontosAux.get(i);
                g.addEdge(inicial.pos + "", fim.pos + "", fim.dist);
            }
        }

        Kruskal k = new Kruskal(g);

        Out saida = new Out("exemplos/saida.txt");
        for (Edge e : g.getEdges()) {
            int dentro = 0;
            if (e.getColor() != "")
                dentro = 1;
            saida.println(e.getV() + " " + e.getW() + " " + dentro);
        }
        saida.close();
    }

    public static void main(String[] args) {
        AppMapaMST app = new AppMapaMST("exemplos/dados.csv");
    }
}
