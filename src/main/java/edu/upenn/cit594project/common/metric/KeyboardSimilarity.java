package edu.upenn.cit594project.common.metric;

import java.util.*;

/**
 * Calculation of the inverse of the Euclidean distance between two keys on a QWERTY keyboard
 */
public class KeyboardSimilarity implements ILevenshteinWeight {
    // position of letters in QWERTY keyboard, assuming letters are lower case
    private static final Map<Character, Map.Entry<Integer, Integer>> KEYBOARD_POSITION;
    private static final double SCALE_FACTOR = 0.40204048134548814;

    static {
        Map<Character, Map.Entry<Integer, Integer>> keyboard = new HashMap<>();
        keyboard.put('1', new AbstractMap.SimpleEntry<Integer, Integer>(0, 0));
        keyboard.put('2', new AbstractMap.SimpleEntry<Integer, Integer>(0, 1));
        keyboard.put('3', new AbstractMap.SimpleEntry<Integer, Integer>(0, 2));
        keyboard.put('4', new AbstractMap.SimpleEntry<Integer, Integer>(0, 3));
        keyboard.put('5', new AbstractMap.SimpleEntry<Integer, Integer>(0, 4));
        keyboard.put('6', new AbstractMap.SimpleEntry<Integer, Integer>(0, 5));
        keyboard.put('7', new AbstractMap.SimpleEntry<Integer, Integer>(0, 6));
        keyboard.put('8', new AbstractMap.SimpleEntry<Integer, Integer>(0, 7));
        keyboard.put('9', new AbstractMap.SimpleEntry<Integer, Integer>(0, 8));
        keyboard.put('0', new AbstractMap.SimpleEntry<Integer, Integer>(0, 9));
        keyboard.put('-', new AbstractMap.SimpleEntry<Integer, Integer>(0, 10));

        keyboard.put('q', new AbstractMap.SimpleEntry<Integer, Integer>(1, 0));
        keyboard.put('w', new AbstractMap.SimpleEntry<Integer, Integer>(1, 1));
        keyboard.put('e', new AbstractMap.SimpleEntry<Integer, Integer>(1, 2));
        keyboard.put('r', new AbstractMap.SimpleEntry<Integer, Integer>(1, 3));
        keyboard.put('t', new AbstractMap.SimpleEntry<Integer, Integer>(1, 4));
        keyboard.put('y', new AbstractMap.SimpleEntry<Integer, Integer>(1, 5));
        keyboard.put('u', new AbstractMap.SimpleEntry<Integer, Integer>(1, 6));
        keyboard.put('i', new AbstractMap.SimpleEntry<Integer, Integer>(1, 7));
        keyboard.put('o', new AbstractMap.SimpleEntry<Integer, Integer>(1, 8));
        keyboard.put('p', new AbstractMap.SimpleEntry<Integer, Integer>(1, 9));

        keyboard.put('a', new AbstractMap.SimpleEntry<Integer, Integer>(2, 0));
        keyboard.put('s', new AbstractMap.SimpleEntry<Integer, Integer>(2, 1));
        keyboard.put('d', new AbstractMap.SimpleEntry<Integer, Integer>(2, 2));
        keyboard.put('f', new AbstractMap.SimpleEntry<Integer, Integer>(2, 3));
        keyboard.put('g', new AbstractMap.SimpleEntry<Integer, Integer>(2, 4));
        keyboard.put('h', new AbstractMap.SimpleEntry<Integer, Integer>(2, 5));
        keyboard.put('j', new AbstractMap.SimpleEntry<Integer, Integer>(2, 6));
        keyboard.put('k', new AbstractMap.SimpleEntry<Integer, Integer>(2, 7));
        keyboard.put('l', new AbstractMap.SimpleEntry<Integer, Integer>(2, 8));
        keyboard.put('\'',new AbstractMap.SimpleEntry<Integer, Integer>(2, 10));

        keyboard.put('z', new AbstractMap.SimpleEntry<Integer, Integer>(3, 0));
        keyboard.put('x', new AbstractMap.SimpleEntry<Integer, Integer>(3, 1));
        keyboard.put('c', new AbstractMap.SimpleEntry<Integer, Integer>(3, 2));
        keyboard.put('v', new AbstractMap.SimpleEntry<Integer, Integer>(3, 3));
        keyboard.put('b', new AbstractMap.SimpleEntry<Integer, Integer>(3, 4));
        keyboard.put('n', new AbstractMap.SimpleEntry<Integer, Integer>(3, 5));
        keyboard.put('m', new AbstractMap.SimpleEntry<Integer, Integer>(3, 6));
        keyboard.put(',', new AbstractMap.SimpleEntry<Integer, Integer>(3, 7));
        keyboard.put('.', new AbstractMap.SimpleEntry<Integer, Integer>(3, 8));

        KEYBOARD_POSITION = Collections.unmodifiableMap(keyboard);

    }

    /**
     * Get the keyboard similarity score which is the inverse of
     * the Euclidean distance between two keys on a QWERTY keyboard
     *
     * @param obj1 the first character
     * @param obj2 the second character
     * @return the keyboard similarity score for the 2 characters
     */
    @Override
    public double getWeight(Character obj1, Character obj2) {
        if (obj1 == obj2) {
            return 0.0;
        }
        Map.Entry<Integer, Integer> entry1 = KEYBOARD_POSITION.get(obj1);
        Map.Entry<Integer, Integer> entry2 = KEYBOARD_POSITION.get(obj2);
        if(entry1 == null || entry2 == null){
            return SCALE_FACTOR;
        }
        int x1 = entry1.getKey();
        int y1 = entry1.getValue();
        int x2 = entry2.getKey();
        int y2 = entry2.getValue();
        double eucDistance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double weight = 1.0 / eucDistance;

        return weight / SCALE_FACTOR;
    }

}
