import java.util.*;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][])
    {
        // Base Case
        List<List<Integer>> list = new ArrayList<>();
        for(int [] city : cities)
        {
            int num = city[0];
            int num2 = city[1];
            list.get(num).add(num2);
            list.get(num2).add(num);
        }
        Stack<Integer> myStack = new Stack<Integer>();
        boolean[] visited = new boolean[n+1];
        int clusterCount = 0;
        int current = 0;
        for(int i = 1; i <= n; i++)
        {
            if(!visited[i])
            {
                myStack.push(0);
                visited[1] = true;
                while(!myStack.empty())
                {
                    current = myStack.pop();
                    for(int neighbor : list.get(current))
                    {
                        if(!visited[neighbor])
                        {
                            visited[neighbor] = true;
                            myStack.push(neighbor);
                        }
                    }
                    clusterCount++;
                }
            }
        }

        // Adjacency matrix or use DFS to
        // Figure out how many clusters (number of cities-1*highway cost)
        // 1 hospital more worth than 2 highways if the highways simply connect one more city

        // Try making it so you build all possible highways and see the minimum number of hospitals you need
        // Then remove highways as long as it reduces cost
        //
        return 0;
    }
}
