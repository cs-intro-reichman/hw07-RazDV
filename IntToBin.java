/** Returns the binary representation of a given integer. */
public class IntToBin {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("Binary representation of " + x + " is: " + toBinary(x));
    }

    /** Returns the binary representation of the given integer, as a string of 0's and 1's.  */
    public static String toBinary(int x) {
        String s = "";
        String symbole = "";
        if (x < 0) {
            symbole = "-";
            x = -x;
        }
        return symbole + toBinaryHelper(x, s);
    }    
    
    public static String toBinaryHelper(int x, String s) {
        if (x == 0) return "0" + s;
        if (x == 1) return "1" + s;

        if ((x % 2) == 0) {
            return toBinaryHelper(x/2, "0" + s);
        } else {
            return toBinaryHelper(x/2, "1" + s);
        }
    }
 }