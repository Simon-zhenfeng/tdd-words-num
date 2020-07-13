package com.word;

import java.util.*;

/**
 * @author Simon
 * @date 2020/7/12 22:29
 */
public class Words {
    public static String caculator(String words) {
        if (words.isEmpty()) {
            return "";
        }
        String[] splitWords = split(words);
        Map<String, Integer> frequency = frequency(splitWords);
        List<Map.Entry<String, Integer>> sorted = sort(frequency);
        return formatPrint(sorted);
    }

    private static List<Map.Entry<String, Integer>> sort(Map<String, Integer> frequency) {
        List<Map.Entry<String, Integer>> result = new ArrayList<>(frequency.entrySet());
        result.sort((o1, o2) -> o2.getValue() - o1.getValue());
        return result;
    }

    private static String[] split(String words) {
        return words.split("\\s+");
    }

    private static String formatPrint(List<Map.Entry<String, Integer>> frequency) {
        StringBuilder sb = new StringBuilder();
        frequency.forEach(entry -> sb.append(entry.getKey()).append(" ").append(entry.getValue()).append(" "));
        return sb.substring(0, sb.length() - 1);
    }

    private static Map<String, Integer> frequency(String[] splitWords) {
        Map<String, Integer> result = new HashMap<>();
        for (String splitWord : splitWords) {
            if (result.containsKey(splitWord)) {
                result.put(splitWord, result.get(splitWord) + 1);
            } else {
                result.put(splitWord, 1);
            }
        }
        return result;
    }
}
