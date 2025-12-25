/** Checks if a given string is a palindrome. */
public class Palindrome {

	public static void main(String[]args) {
    	System.out.println(isPalindrome(args[0]));
    }
	
	/** Checks if the given string is a palindrome. */
	public static boolean isPalindrome(String s) {
		int sLength = s.length();
		if (sLength <= 1) return true;
		if ((s.charAt(0) == s.charAt(sLength - 1))) {
			return isPalindrome(s.substring(1, sLength - 1));
		}	
		return false;
    }
}

