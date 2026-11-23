import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

  public void countChar(Map<Character, Integer> m, char c) {
    if (m.containsKey(c)) {
      int count = m.get(c);
      m.put(c, count + 1);
    } else {
      m.put(c, 1);
    }
  }

  // Approach 2: Sorting
  public boolean isAnagramUsingSorting(String s, String t) {
    if (s.length() != t.length()) return false;
    char[] sAry = s.toCharArray();
    char[] tAry = t.toCharArray();

    Arrays.sort(sAry);
    Arrays.sort(tAry);

    return Arrays.equals(sAry, tAry);
  }


  // Approach 1: HashMap
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    Map<Character, Integer> sCharCount = new HashMap<>();
    Map<Character, Integer> tCharCount = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      countChar(sCharCount, s.charAt(i));
      countChar(tCharCount, t.charAt(i));
    }

    for (char c : sCharCount.keySet()) {
      if (!sCharCount.get(c).equals(tCharCount.get(c))) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String s = "racecar";
    String t = "carrace";
    ValidAnagram va = new ValidAnagram();
    System.out.println(va.isAnagram(s, t));
  }
}
