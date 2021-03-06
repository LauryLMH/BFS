// Java program to find out whether a given graph is Bipartite or not
import java.util.*;
import java.lang.*;
import java.io.*;
 
class Bipartite
{
    private int numberOfVertices;
    private Queue<Integer> queue;
 
    public BipartiteBfs(int numberOfVertices)
    {
        this.numberOfVertices = numberOfVertices;

        queue = new LinkedList<Integer>();
    }
 
    // This function returns true if graph G[V][V] is Bipartite, else false
   public boolean isBipartite(int adjacencyMatrix[][], int src)//adjacencyMatrix=int G[][V]
    {
        // Create a color array to store colors assigned to all veritces.
        // Vertex number is used as index in this array. The value '-1'
        // of  colorArr[i] is used to indicate that no color is assigned
        // to vertex 'i'.  The value 1 is used to indicate first color
        // is assigned and value 0 indicates second color is assigned.
        int colorArr[] = new int[V];
        for (int i=0; i<numberOfVertices; ++i)
            colorArr[i] = -1;
 
        // Assign first color to source
        colorArr[src] = 1;
 
        // Create a queue (FIFO) of vertex numbers and enqueue
        // source vertex for BFS traversal
        LinkedList<Integer>queue = new LinkedList<Integer>();//queue=q
        queue.add(src);
 
      /*  // Run while there are vertices in queue (Similar to BFS)
        while (queue.size() != 0)
        {
 
            // Dequeue a vertex from queue
            int u = queue.poll();
 
            // Find all non-colored adjacent vertices
            for (int v=0; v<V; ++v)
            {
                // An edge from u to v exists and destination v is
                // not colored
                if (G[u][v]==1 && colorArr[v]==-1)
                {
                    // Assign alternate color to this adjacent v of u
                    colorArr[v] = 1-colorArr[u];
                    q.add(v);
                }
 
                // An edge from u to v exists and destination v is
                // colored with same color as u
                else if (G[u][v]==1 && colorArr[v]==colorArr[u])
                    return false;
            }
        }
        // If we reach here, then all adjacent vertices can
        //  be colored with alternate color
        return true;
    }
 
    // Driver program to test above function
    public static void main (String[] args)
    {
        int G[][] = {{0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };
        Bipartite b = new Bipartite();
        if (b.isBipartite(G, 0))
           System.out.println("Yes");
        else
           System.out.println("No");
    }
}
 
*/
int element, neighbour;
        while (!queue.isEmpty())
        {
            element = queue.remove();
            neighbour = 1;
            while (neighbour <= numberOfVertices)
            { 
                if (adjacencyMatrix[element][neighbour] == 1 && colored[element]== colored[neighbour])
                {
                    return false;
                }
                if (adjacencyMatrix[element][neighbour] == 1 && colored[neighbour]== -1)
                {
                    colored[neighbour] = (1 - colored[element]);
                    queue.add(neighbour);
                }
                neighbour++;
            }
        }
        return true;
    }
 
    public static void main(String... arg)
    {
        int number_of_nodes, source;
        Scanner scanner = null;
        try 
        {
           System.out.println("Enter the number of nodes in the graph");
           scanner = new Scanner(System.in);
           number_of_nodes = scanner.nextInt();
 
           int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
           System.out.println("Enter the adjacency matrix");
           for (int i = 1; i <= number_of_nodes; i++)
           {
               for (int j = 1; j <= number_of_nodes; j++)
               {	
                   adjacency_matrix[i][j] = scanner.nextInt();
               }
           }
 
           for (int i = 1; i <= number_of_nodes; i++)
           {
               for (int j = 1; j <= number_of_nodes; j++)
               {	
                   if(adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0)
                   {
                       adjacency_matrix[j][i] = 1;
                   }
               }
           }
 
           System.out.println("Enter the source for the graph");
           source = scanner.nextInt();
 
           BipartiteBfs bipartiteBfs = new BipartiteBfs(number_of_nodes);
           if (bipartiteBfs.isBipartite(adjacency_matrix, source)) 
           {
               System.out.println("The given graph is bipartite");
           } else
           {
               System.out.println("The given graph is not bipartite");
           }
       } catch (InputMismatchException inputMismatch) 
       {
           System.out.println("Wrong Input format");
       }
       scanner.close();
    }
}