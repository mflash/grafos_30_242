public class AppBFS {

    public static void main(String[] args) {
        Graph g = new Graph("exemplos/tinyG.txt");
        BFS bfs = new BFS(g, "0");

        for (String v : g.getVerts()) {
            System.out.print(v + ": ");
            if (!bfs.hasPathTo(v))
                System.out.println("SEM CAMINHO");
            else {
                for (String w : bfs.pathTo(v))
                    System.out.print(w + " (" + bfs.distTo(w) + ") ");
                System.out.println();
            }
        }
    }

}
