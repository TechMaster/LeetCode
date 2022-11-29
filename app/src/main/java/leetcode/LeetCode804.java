package leetcode;

import java.util.HashSet;

public class LeetCode804 {
  public int uniqueMorseRepresentations(String[] words) {
    final String morsecode[] = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
        ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

    HashSet<String> unique_morse = new HashSet<>();

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < word.length(); j++) {
        sb.append(morsecode[word.charAt(j) - 97]);
      }
      unique_morse.add(sb.toString());
    }
    return words.length - unique_morse.size();
  }
}
