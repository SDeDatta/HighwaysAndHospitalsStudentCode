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
        long[] arr = new long[n+1];
        for(int i = 1; i < arr.length;i++)
        {
            // Sets every city to have a weight of -1;
            arr[i] = -1;
        }
        // Runs the union function for every possible city connection
        for(int edge[] : cities) {
            union(edge[0], edge[1], arr);
        }
        // Calculate the total cost
        long total = 0;
        for(int i = 1; i < arr.length;i++)
        {
            if(arr[i] < 0)
            {
               long size = -arr[i];
               total+= hospitalCost + (size - 1) * highwayCost;
            }
        }
        return total;
    }
    static void union(int a, int b, long[] arr)
    {
        a = find(a, arr);
        b = find(b, arr);
        if(a != b)
        {
            if(arr[a] > arr[b])
            {
                int temp = a;
                a = b;
                b = temp;
            }
            arr[a] += arr[b];
            arr[b] = a;
        }
    }
    static int find(int x, long[] arr)
    {
        int root = x;

        // Step 1: Find the root of x
        while (arr[root] >= 0) {
            root = (int) arr[root];
        }

        // Step 2: Path compression
        while (x != root) {
            int parent = (int) arr[x];
            arr[x] = root; // make x point directly to root
            x = parent;
        }

        return root;
    }

}
