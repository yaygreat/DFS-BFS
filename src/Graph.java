import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph
{
    int n;
    LinkedList<Integer> adjListArr[];
    public Graph(int n)
    {
        this.n = n;
        adjListArr = new LinkedList[n];
        for(int i = 0; i < n; i++)
        {
            adjListArr[i] = new LinkedList<>();
        }
    }

    public void addEdge(int beg, int end)
    {
        adjListArr[beg].add(end);
        adjListArr[end].add(beg);
    }

    public void showAdjList(Graph graph)
    {
        for(int n = 0; n < graph.n; n++)
        {
            System.out.print("Node " + n + ": ");
            for (int i = 0; i < graph.adjListArr[n].size(); i++)
            {
                System.out.print(graph.adjListArr[n].get(i));
                if(i < (graph.adjListArr[n].size()-1))
                    System.out.print("-->");
            }
            System.out.println("");
        }
    }

    public void DFSearch(int v)
    {
        boolean[] boolVisitedArr = new boolean[n];
        DFSearching(v, boolVisitedArr);
    }

    public void DFSearching(int v, boolean[] visited)
    {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adjListArr[v].listIterator();
        int w = -1;
        while (i.hasNext())
        {
            w = i.next();
            if(!visited[w])
                DFSearching(w, visited);
        }

        /*for (int i = 0; i < adjListArr[v].size(); i++)
        {
            if(!visited[i])
                DFSearching(i, visited);
        }*/
    }

    public void BFSearch(int v)
    {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList <>();
        visited[v] = true;
        queue.add(v);

        while(!queue.isEmpty())
        {
            v = queue.poll();
            System.out.print(v + " ");
            Iterator<Integer> i = adjListArr[v].listIterator();
            int w = -1;
            while (i.hasNext())
            {
                w = i.next();
                if(!visited[w])
                {
                    queue.add(w);
                    visited[w] = true;
                }
            }

        }
    }
}
