package leetcode.twopointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "...";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            Character start = s.charAt(left);
            Character end = s.charAt(right);

            if (!Character.isLetterOrDigit(start)) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(end)) {
                right--;
                continue;
            }

            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    }
