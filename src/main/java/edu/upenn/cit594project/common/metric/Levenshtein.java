package edu.upenn.cit594project.common.metric;

import java.util.Locale;

/**
 * Calculation of weighted Levenshtein edit distance
 */
public class Levenshtein implements IDistance<String, String> {
    ILevenshteinWeight weight;
    double decayFactor;
    double swapFactor;
    double deleteFactor;

    public Levenshtein() {
        this.weight = (c1, c2) -> 1;
        this.decayFactor = 0;
        this.swapFactor = 1;
        this.deleteFactor = 1;
    }

    public Levenshtein(ILevenshteinWeight weight, double decayFactor, double swapFactor, double deleteFactor) {
        this.weight = weight;
        this.decayFactor = decayFactor;
        this.swapFactor = swapFactor;
        this.deleteFactor = deleteFactor;
    }

    /**
     * @param obj1 the first string obj1
     * @param obj2 the second string obj2
     * @return the weighted Levenshtein distance between obj1 and obj2
     */
    @Override
    public double getDistance(String obj1, String obj2) {
        obj1 = obj1.toLowerCase(Locale.ROOT);
        obj2 = obj2.toLowerCase(Locale.ROOT);
        int m = obj1.length();
        int n = obj2.length();
        double[][] dp = new double[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    double c = 0.0;
                    double cost = weight.getWeight(obj1.charAt(i - 1), obj2.charAt(j - 1));
                    double invPen = Math.exp(decayFactor * (i + j));
                    if (obj1.charAt(i - 1) != obj2.charAt(j - 1)) {
                        c = cost * swapFactor / invPen;
                    }
                    // Wagner–Fischer Algorithm
                    dp[i][j] = Math.min(
                            c + dp[i - 1][j - 1],
                            Math.min(
                                    deleteFactor / invPen + dp[i - 1][j],
                                    deleteFactor / invPen + dp[i][j - 1]
                            ));
                }
            }
        }

        return dp[m][n];
    }
}
