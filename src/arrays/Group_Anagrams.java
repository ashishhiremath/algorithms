package arrays;

import java.util.*;

public class Group_Anagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{}));
        System.out.println(groupAnagrams(new String[]{"a"}));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        if (strs.length == 0) result.add(new ArrayList<>());
        for (String word : strs) {
            char[] arr = new char[26];
            for (int j = 0; j < word.length(); j++) {
                arr[word.charAt(j) - 'a']++;
            }
            String key = String.valueOf(arr);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(word);
        }
        //return new ArrayList<>(map.values());
        map.forEach((key, value) -> result.add(value));
        return result;
    }
}
