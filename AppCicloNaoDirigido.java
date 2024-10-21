public class AppCicloNaoDirigido {

    public static void main(String[] args) {
        Graph g = new Graph("exemplos/tinyG.txt");
        /*
         * Graph g = new Graph();
         * g.addEdge("A", "B");
         * g.addEdge("D", "A");
         * g.addEdge("B", "C");
         * g.addEdge("C", "D");
         * g.addEdge("C", "E");
         */
        System.out.println(g.toDot());

        CicloNaoDirigido detecta = new CicloNaoDirigido(g);
        if (detecta.temCiclo())
            System.out.println("Tem ciclo!");
        else
            System.out.println("Não tem ciclo...");
    }
}
