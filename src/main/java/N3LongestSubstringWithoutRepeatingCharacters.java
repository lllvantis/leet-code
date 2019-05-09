import java.util.HashMap;

public class N3LongestSubstringWithoutRepeatingCharacters {

    // region 3. longest-substring-without-repeating-characters
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int from = 0;
        int result = 0;
        HashMap<Character, Integer> positionMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char pending = chars[i];
            if (positionMap.containsKey(pending)) {
                Integer position = positionMap.get(pending) + 1;
                if (position > from) from = position;
            }
            positionMap.put(pending, i);
            int pendingResult = i - from + 1;
            if (result < pendingResult) result = pendingResult;
        }
        return result;
    }
    // endregion

    public static void main(String[] args) {
        int result = new N3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba");
        System.out.println(result);
    }
}
