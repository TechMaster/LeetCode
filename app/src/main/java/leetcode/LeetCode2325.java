package leetcode;

import java.util.HashMap;

public class LeetCode2325 {
    public String decodeMessage(String key, String message) {
        HashMap<String, String> mapencode = new HashMap<String, String>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        mapencode.put(" ", " ");
        int count = 0;
        int i = 0;
        while (count < 26) { //Số lượng key trong hashmap phải ánh xạ đủ 26 ký tự trong bảng chữ cái A-Z
            String keyChar = key.substring(i, i + 1);
            //keychar phải khác space và chưa có trong HashMap
            if (!keyChar.equals(" ") &&  mapencode.get(keyChar) == null) { 
                mapencode.put(keyChar, alphabet.substring(count, count + 1));
                count++;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < message.length(); j++) {
            sb.append(mapencode.get(message.substring(j, j + 1)));
        }
        return sb.toString();
    }
}
