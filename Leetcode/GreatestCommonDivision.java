package Leetcode;

// TC - O(min(m+n)(m+n))
// SC - O(min(m,n))
public class GreatestCommonDivision {
    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        for (int i = Math.min(m, n); i > 0; i--) {
            /*
             * now we find the substring and check if it part of both the strings and if it is we return 
             * the substring where it is a part 
             */

             if (valid(str1, str2, i)){
                /*
                 * Now we need to vaidate the method and check if fulfills all the conditions for the gcd 
                 */
                return str1.substring(0, i);
             }        
        }
        return "";
    }

    private boolean valid(String str1, String str2, int i) {
        int m = str1.length(), n = str2.length();
        if (!(m % i == 0) && !(n % i == 0)){
            return false;
        }

        String gcd = str1.substring(0, i);
        return str1.replace(gcd, "").isEmpty() && str2.replace(gcd, "").isEmpty();
    }
    
}
