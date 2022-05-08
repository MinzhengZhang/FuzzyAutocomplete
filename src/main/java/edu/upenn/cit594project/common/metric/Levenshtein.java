package edu.upenn.cit594project.common.metric;

/**
 * Calculation of weighted Levenshtein edit distance
 */
public class Levenshtein implements IDistance<String, String> {
    ILevenshteinWeight weight;

    public Levenshtein() {
        this.weight = (c1, c2) -> 1;
    }

    public Levenshtein(ILevenshteinWeight weight) {
        this.weight = weight;
    }

    /**
     * @param obj1 the first string obj1
     * @param obj2 the second string obj2
     * @return the weighted Levenshtein distance between obj1 and obj2
     */
    @Override
    public double getDistance(String obj1, String obj2) {
        int m = obj1.length();
        int n = obj2.length();
        double[][] dp = new double[m+1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <dp[0].length; j++){
                if(i == 0){
                    dp[i][j] = j;
                }
                else if (j == 0){
                    dp[i][j] = i;
                }
                else {
                    double c = 0.0;
                    double cost = weight.getWeight(obj1.charAt(i-1),obj2.charAt(j-1));
                    if (obj1.charAt(i-1) != obj2.charAt(j-1)) {
                        c = cost;
                    }
//Wagner–Fischer Algorithm
                    dp[i][j] = Math.min(c + dp[i - 1][j - 1], Math.min( 1 + dp[i - 1][j], 1 + dp[i][j - 1]));
                }
            }
        }

        return dp[m][n];
    }
}
