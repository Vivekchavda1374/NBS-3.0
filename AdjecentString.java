import java.util.HashMap;

public class AdjecentStiring {
    public static String rearrange(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int n = s.length();
        char[] result = new char[n];
        int usedMask = 0;
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
            while (index < n && ((usedMask >> index) & 1) == 1) {
                index++;
            }

            if (index >= n) index = 1;
            result[index] = pick;
            usedMask |= (1 << index);
            index += 2;
            int left = freq.get(pick) - 1;
            if (left == 0) {
                freq.remove(pick);
            } else {
                freq.put(pick, left);
            }
        }
        for (int i = 1; i < n; i++) {
            if ((result[i] ^ result[i - 1]) == 0) {
                return "Not possible";
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        String s1 = "aaabbc";
        String s2 = "aaab";
        String s3 = "aabbcc";
    }
}

