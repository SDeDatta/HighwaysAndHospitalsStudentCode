import java.util.*;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Surya De Datta
 *
 */

public class HighwaysAndHospitals
{
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][])
    {
        // Base Case
        if(highwayCost > hospitalCost)
        {
            return (long) n*hospitalCost;
        }
        // Array to represent all the cities and what weights they hold/cities that are roots of them
        long[] nodes = new long[n+1];
        for(int i = 1; i < nodes.length;i++)
        {
            // Sets every city to have a weight of -1;
            nodes[i] = -1;
        }
        // Runs the union function for every possible city connection
        for(int edge[] : cities) {
            union(edge[0], edge[1], nodes);
        }
        long total = 0;
        long discComponents = 0;
       // Counts the number of disconnected components/clusters
        for(int i = 1; i < nodes.length; i++)
        {
            if(nodes[i] < 0)
            {
                discComponents++;
            }
        }
        // Computes the total based on number of clusters
        total = discComponents*hospitalCost + (nodes.length - discComponents - 1)*highwayCost;
        return total;
    }
    static void union(int rootA, int rootB, long[] arr)
    {
        // Finds the ultimate root for each city in a proposed connection
        rootA = find(rootA, arr);
        rootB = find(rootB, arr);
        // Doesn't change array if the two cities have the same root
        if(rootA != rootB)
        {
            // Ensures rootA has a higher order
            // Otherwise swaps them
            if(arr[rootA] > arr[rootB])
            {
                int temp = rootA;
                rootA = rootB;
                rootB = temp;
            }
            // Combines size of two chains
            arr[rootA] += arr[rootB];
            // Makes larger chain the root of smaller one
            arr[rootB] = rootA;
        }
    }
    static int find(int x, long[] arr)
    {
        int root = x;

        // Finds the root of x
        while (arr[root] >= 0) {
            root = (int) arr[root];
        }

        // Path compression (follows up the chain)
        while (x != root) {
            int parent = (int) arr[x];
            // Make x point directly to root
            arr[x] = root;
            x = parent;
        }

        return root;
    }

}
