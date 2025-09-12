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
        if(highwayCost > hospitalCost)
        {
            return n*hospitalCost;
        }

        // 1 hospital more worth than 2 highways if the highways simply connect one more city

        // Try making it so you build all possible highways and see the minimum number of hospitals you need
        // Then remove highways as long as it reduces cost
        //
        return 0;
    }
}
