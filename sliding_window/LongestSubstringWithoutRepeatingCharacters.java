import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
  // Approach 1: Brute Force - O(n²)
  public int lengthOfLongestSubstringBruteForce(String s) {
    int max_len = 0;
    for (int i = 0; i < s.length(); i++) {
      HashSet<Character> seen = new HashSet<>();
      for (int j = i; j < s.length(); j++) {
        if (seen.contains(s.charAt(j))) {
          break;
        }
        seen.add(s.charAt(j));
        max_len = Math.max(max_len, seen.size());
      }
    }

    return max_len;
  }

  // Approach 2: Sliding Window + HashMap - O(n)
  public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> hm = new HashMap<>();
    int left = 0;
    int max_len = 0;
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      if (hm.containsKey(c) && !(left > hm.get(c))) {
        left = hm.get(c) + 1;
      }

      hm.put(c, right);
      max_len = Math.max(max_len, right - left + 1);
    }

    return max_len;
  }
}
