package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reorganize-string/description/
 * DS: HashMap and MaxHeap
 * Time: O(A + NlogA) where A is the size of the alphabet
 * Space: O(A)
 * Approach: start with most frequent character, hold it and find
 * the next frequent character expect the "previous" one.
 */
public class ReOrganizeString {
    public static String reorganizeString(String s) {
        if (s.isEmpty()) return "";
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }

        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> previous = null;
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            result.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);

            if (previous != null && previous.getValue() > 0 && previous.getKey() != entry.getKey()) {
                maxHeap.add(previous);
            }
            previous = entry;
        }
        return s.length() == result.length() ? result.toString() : "";

    }

    public static void main(String[] args) {

        System.out.println(reorganizeString("aab").equalsIgnoreCase("aba"));
        System.out.println(reorganizeString("aaab").equalsIgnoreCase(""));
    }
}
