import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
  // Approach 1: Sorting
  // n: number of strings
  // m : maximum length of a string
  // Time complexity: O(n * m log m)
  // Space complexity: O(n * m)
  public List<List<String>> groupAnagramsUsingSorting(String[] strs) {
    HashMap<String, List<String>> groups = new HashMap<>();

    for (String str : strs) {
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String sortedString = new String(charArray);
      if (groups.containsKey(sortedString)) {
        groups.get(sortedString).add(str);
      } else {
        List<String> group = new ArrayList<>();
        group.add(str);
        groups.put(sortedString, group);
      }
    }

    List<List<String>> groupsList = new ArrayList<>();
    for (String key : groups.keySet()) {
      groupsList.add(groups.get(key));
    }

    return groupsList;
  }

  // Approach 2: Hash Table
  // n: number of strings
  // m : maximum length of a string
  // Time complexity: O(n * m)
  // Space complexity: O(n)
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<List<Integer>, List<String>> groups = new HashMap<>();

    for (String str : strs) {
      List<Integer> count = new ArrayList<>(26);
      for (int i = 0; i < 26; i++) {
        count.add(0);
      }
      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        count.set(c - 'a', count.get(c - 'a') + 1);
      }

      if (groups.containsKey(count)) {
        groups.get(count).add(str);
      } else {
        List<String> strList = new ArrayList<>();
        strList.add(str);
        groups.put(count, strList);
      }
    }

    return new ArrayList<>(groups.values());
  }

  public static void main(String[] args) {
    String[] strs = new String[1];
    strs[0] = "";
    GroupAnagrams ga = new GroupAnagrams();
    System.out.println(ga.groupAnagrams(strs));
  }
}
