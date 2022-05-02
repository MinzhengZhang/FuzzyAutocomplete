package edu.upenn.cit594project.common.metric;

import org.apache.commons.codec.language.DoubleMetaphone;

/**
 * Calculation of the Levenshtein distance between the
 * Double-Metaphone-based phonetic representations of two strings
 */
public class DMetaphone implements IDistance<String, String> {
    DoubleMetaphone dm;
    Levenshtein l;

    public DMetaphone() {
        dm = new DoubleMetaphone();
        l = new Levenshtein();
    }

    @Override
    public double getDistance(String obj1, String obj2) {
        return l.getDistance(
                dm.doubleMetaphone(obj1),
                dm.doubleMetaphone(obj2)
        );
    }
}
