public class Driver
{
    public static void main(String[] args)
    {
        //creates a K5,5 graph: 10 nodes and 20 edges
        int v = 10;
        Graph graph = new Graph(v);
        for(int i = 0; i < v/2; i++)
        {
            for(int j = v/2; j < v; j++)
            {
                graph.addEdge(i, j);
            }
        }
        System.out.println("The adjacency list for the given graph:");
        graph.showAdjList(graph);

        System.out.println("Depth First Traversal for given graph, starting at node 0:");
        graph.BFSearch(0);

        System.out.println("\nBreadth First Traversal for given graph, starting at node 0:");
        graph.DFSearch(0);
    }
}
