package edu.upenn.cit594project.common.metric;

/**
 * Calculation of weighted Jaro-Winkler distance
 */
public class JaroWinkler implements IDistance<String, String> {
    /**
     * @param obj1 the first string obj1
     * @param obj2 the second string obj2
     * @return the Jaro-Winkler distance between obj1 and obj2
     */
    @Override
    public double getDistance(String obj1, String obj2) {
        return 1.0 - this.similarity(obj1, obj2);
    }


    /**
     * @param obj1 the first string obj1
     * @param obj2 the second string obj2
     * @return the Jaro-Winkler similarity between obj1 and obj2
     */
    public double similarity(String obj1,String obj2){
        if(obj1 == obj2) return 1.0;
        int len1 = obj1.length(),
                len2 = obj2.length();

        // Maximum distance upto which matching
        // is allowed
        int max_dist = (int) (Math.floor(Math.max(len1, len2) / 2) - 1);

        // Count of matches
        int match = 0;

        // Hash for matches
        int hash_s1[] = new int[obj1.length()];
        int hash_s2[] = new int[obj2.length()];

        // Traverse through the first String
        for (int i = 0; i < len1; i++)
        {

            // Check if there is any matches
            for (int j = Math.max(0, i - max_dist);
                 j < Math.min(len2, i + max_dist + 1); j++)

                // If there is a match
                if (obj1.charAt(i) == obj2.charAt(j) && hash_s2[j] == 0)
                {
                    hash_s1[i] = 1;
                    hash_s2[j] = 1;
                    match++;
                    break;
                }
        }

        // If there is no match
        if (match == 0)
            return 0.0;

        // Number of transpositions
        double t = 0;

        int point = 0;

        // Count number of occurrences
        // where two characters match but
        // there is a third matched character
        // in between the indices
        for (int i = 0; i < len1; i++)
            if (hash_s1[i] == 1)
            {

                // Find the next matched character
                // in second String
                while (hash_s2[point] == 0)
                    point++;

                if (obj1.charAt(i) != obj2.charAt(point++) )
                    t++;
            }

        t /= 2;

        // Return the Jaro Similarity
        return (((double)match) / ((double)len1)
                + ((double)match) / ((double)len2)
                + ((double)match - t) / ((double)match))
                / 3.0;
    }

}
