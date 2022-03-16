package Chapter30_CoreJava1;

public class a_PalindromeReverseString {

    static void isPalindrome(String theWord) {
        theWord = theWord.toLowerCase();
        System.out.printf("Original word is: %s", theWord).println();
        String theWordReversed = "";

        for (int i = theWord.length() - 1; i >= 0; i -= 1) {
            //theWordReversed = theWordReversed.concat(String.valueOf(theWord.charAt(i)));
            /**
             * Metodą concat da się do stringa dodać tylko innego stringa, przy char wywala błąd.
             * Trzeba char skonwertować do string i dopiero wtedy można użyć concat.
             * Przy użyciu '+' nie ma już tego problemu - można dodawać char do string bez konwersji.
             */
            theWordReversed = theWordReversed + theWord.charAt(i);
        }
        System.out.printf("Reversed word is: %s", theWordReversed).println();

        if (theWord.equals(theWordReversed)) {
            System.out.println("Words are equal. This word is a palindrome.");
        } else {
            System.out.println("Words are not equal. This word is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        isPalindrome("Marek");
    }
}
