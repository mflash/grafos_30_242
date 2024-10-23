public class AppOrdTopologicaES {

    public static void main(String[] args) {
        // Graph g = new Graph("exemplos/tinyG.txt");
        Digraph g = new Digraph();
        In arq = new In("exemplos/es.txt");

        while (arq.hasNextLine()) {
            String line = arq.readLine();
            String[] dados = line.split("/");
            // System.out.println(dados[0]);
            for (int i = 1; i < dados.length; i++) {
                g.addEdge(dados[0], dados[i]);
            }
        }

        System.out.println(g.toDot());

        OrdTopologica ot = new OrdTopologica(g);

        System.out.println();
        System.out.println("Ordem topológica:");
        for (String v : ot.ordemTopologica())
            System.out.println(v);
    }
}
