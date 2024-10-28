public class AppKruskal {

    public static void main(String[] args) {
        EdgeWeightedGraph g = new EdgeWeightedGraph("exemplos/tinyEWG.txt");

        // System.out.println(g.toDot());

        Kruskal k = new Kruskal(g);
        System.out.println(g.toDot());
    }
}
