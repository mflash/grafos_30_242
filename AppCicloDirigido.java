public class AppCicloDirigido {

    public static void main(String[] args) {
        // Graph g = new Graph("exemplos/tinyG.txt");
        Graph g = new Digraph();
        g.addEdge("A", "B");
        g.addEdge("A", "D");
        g.addEdge("B", "C");
        g.addEdge("C", "D");
        g.addEdge("C", "E");

        System.out.println(g.toDot());

        // CicloDirigido detecta = new CicloDirigido(g);
        // if (detecta.temCiclo())
        // System.out.println("Tem ciclo!");
        // else
        // System.out.println("Não tem ciclo...");
    }
}
