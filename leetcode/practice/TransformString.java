package leetcode.practice;

public class TransformString {

    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        int N = start.length();
        char[] s = start.toCharArray(), e = end.toCharArray();
        int i = 0, j = 0;
        while (i < N && j < N) {
            while (i < N && s[i] == 'X')
                i++; // L or R
            while (j < N && e[j] == 'X')
                j++; // L or R
            if ((i < N) ^ (j < N)) {
                return false;
            }
            // start => RXXLRXRXL i-> R,L,R,R,L
            // end => XRLXXRRLX j -> R,L,R,R,L
            // LX => XL, XR => RX
            if (i < N && ((s[i] != e[j]) || // if not same
                    (s[i] == 'L' && i < j) ||
                    (s[i] == 'R' && i > j))) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

}
