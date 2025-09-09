import java.util.*;
class OptimizedReArrangeStringHashMap {
   public static void ReArrangeString(String s) {
       int n = s.length();
       HashMap<Character, Integer> freq = new HashMap<>();
         for (char c : s.toCharArray()) {
              freq.put(c, freq.getOrDefault(c, 0) + 1);
         }
            char[] result = new char[n];
            int index = 0;
            while (!freq.isEmpty()) {
                char pick = 0;
                int maxCount = 0;
                for (char c : freq.keySet()) {
                    if (freq.get(c) > maxCount) {
                        maxCount = freq.get(c);
                        pick = c;
                    }

                }
                while (index < n && result[index] != '\u0000') {
                    index++;
                }
                if (index >= n) index = 1;
                result[index] = pick;
                index += 2;
                int left = freq.get(pick) - 1;

                if (left == 0) {
                    freq.remove(pick);
                } else {
                    freq.put(pick, left);
                }
                System.out.println(result);
            }
   }
    public static void main(String[] args) {
        String s1 = "aaabbc";
        String s2 = "aaab";
        String s3 = "aabbcc";
        ReArrangeString(s1);
        ReArrangeString(s2);
        ReArrangeString(s3);

    }
}