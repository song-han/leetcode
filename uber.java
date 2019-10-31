import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// elements = ['B', 'Ar', 'O']

// Bryan -> **B**ryan

// Aaron -> A**Ar**on   or  Aar**O**n  (but not A**Ar****O**n)

// Dave -> Dave

// Bob ->  **B**ob  or   B**O**b   or  Bo**B**

// Trie ara, ar

public class Solution {
    public static void main(String args[] ) throws Exception {
        String[] elements = {"B", "Ar", "O"}; // ar -> ["Ar", "ar"]
        String s = "Aaron";
        String result = replace(s, elements);
        System.out.println("result: " + result);
        s = "Bryan";
        result = replace(s, elements);
        System.out.println("result: " + result);
        s = "Dave";
        result = replace(s, elements);
        System.out.println("result: " + result);
        s = "Bob";
        result = replace(s, elements);
        System.out.println("result: " + result);
    }
    
    public static String replace(String s, String[] elements) {
        Map<String, String> map = new HashMap<>();
        for (String element: elements) {
            map.put(element.toLowerCase(), element);
        }
        List<String> list = new ArrayList<>();
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < s.length(); i++) {
                int end = i + len;
                if (end > s.length()) continue;
                String subStr = s.substring(i, end).toLowerCase();
                if (map.containsKey(subStr)) {
                    String value = map.get(subStr);
                    String first = s.substring(0, i) + "**" + value + "**";
                    if (end < s.length()) {
                        first += s.substring(end);
                    }
                    list.add(first);
                }
            }
        }
        if (list.size() == 0) {
            return s;
        }
        Random r = new Random();
        int idx = r.nextInt(list.size());
        for (String str: list) {
            System.out.print(str + " | ");
        }
        System.out.print("\n");
        return list.get(idx);
    }
}