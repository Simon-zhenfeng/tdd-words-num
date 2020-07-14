package com.word;

import java.util.*;

/**
 * @author Simon
 * @date 2020/7/13 09:31
 */
public class Words {
    private static final String ENTER = "\r\n";
    private final String wordsString;

    public Words(String wordsString) {
        this.wordsString = wordsString.trim();
    }

    public String caculate() {
        if (wordsString.isEmpty()) {
            return "";
        }
        String[] wordArray = wordsString.split("\\s+");
        List<Map.Entry<String, Integer>> group = group(wordArray);
        sort(group);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> word : group) {
            sb.append(format(word)).append(ENTER);
        }
        return sb.substring(0, sb.length() - ENTER.length());
    }

    private void sort(List<Map.Entry<String, Integer>> group) {
        group.sort((a, b) -> b.getValue() - a.getValue());
    }

    private List<Map.Entry<String, Integer>> group(String[] wordArray) {
        Map<String, Integer> pool = new HashMap<>(wordArray.length);
        for (String word : wordArray) {
            if (pool.containsKey(word)) {
                pool.put(word, pool.get(word) + 1);
            } else {
                pool.put(word, 1);
            }
        }
        return new ArrayList<>(pool.entrySet());
    }

    private String format(Map.Entry<String, Integer> entry) {
        return entry.getKey() + " " + entry.getValue();
    }
}
