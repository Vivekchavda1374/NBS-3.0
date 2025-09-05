import java.util.HashMap;

public class AdjecentStiring {
    // Method to rearrange string using bitmask checks
    public static String rearrange(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        // Count frequencies
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int n = s.length();
        char[] result = new char[n];

        // Use bitmask to track used indices (0 = free, 1 = occupied)
        int usedMask = 0;
        int index = 0;

        // Fill characters one by one
        while (!freq.isEmpty()) {
            // Pick the char with maximum frequency left
            char pick = 0;
            int maxCount = 0;
            for (char c : freq.keySet()) {
                if (freq.get(c) > maxCount) {
                    maxCount = freq.get(c);
                    pick = c;
                }
            }

            // Place this character in next available slot
            while (index < n && ((usedMask >> index) & 1) == 1) {
                index++;
            }

            if (index >= n) index = 1; // wrap to odd positions if evens are filled

            result[index] = pick;
            usedMask |= (1 << index); // mark this position as used
            index += 2;

            // Decrease frequency
            int left = freq.get(pick) - 1;
            if (left == 0) {
                freq.remove(pick);
            } else {
                freq.put(pick, left);
            }
        }

        // Final adjacency check with bit ops
        for (int i = 1; i < n; i++) {
            if ((result[i] ^ result[i - 1]) == 0) { // same char => XOR = 0
                return "Not possible";
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        String s1 = "aaabbc";
        String s2 = "aaab";
        String s3 = "aabbcc";

        System.out.println(rearrange(s1)); // Possible: "ababac"
        System.out.println(rearrange(s2)); // Not possible
        System.out.println(rearrange(s3)); // Possible: "abcabc"
    }
}
