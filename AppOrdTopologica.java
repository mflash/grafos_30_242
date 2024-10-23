public class AppOrdTopologica {

    public static void main(String[] args) {
        // Digraph g = new Graph("exemplos/tinyDAG.txt");
        Digraph g = new Digraph();
        g.addEdge("0", "1");
        g.addEdge("0", "5");
        g.addEdge("0", "2");
        g.addEdge("1", "4");
        g.addEdge("1", "4");
        g.addEdge("3", "2");
        g.addEdge("3", "4");
        g.addEdge("3", "5");
        g.addEdge("3", "6");
        g.addEdge("5", "2");
        g.addEdge("6", "0");
        g.addEdge("6", "4");

        System.out.println(g.toDot());

        OrdTopologica ot = new OrdTopologica(g);

        System.out.println("Ordem topológica:");
        for (String v : ot.ordemTopologica())
            System.out.print(v + " ");
        System.out.println();
    }
}
