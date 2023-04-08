package leetcode.practice;

public class SubStringMatch {
    public class SubStringSearch {
        public int match(String str, String substr) {
            for (int i = 0; i < str.length(); ) {
                for (int j = i; j < substr.length(); j++) {
                    if (str.charAt(j) != substr.charAt(j)) {
                        i++;
                        break;
                    }
                    if (j >= substr.length() - 1) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }
}
