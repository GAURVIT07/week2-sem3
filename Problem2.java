public class Problem2 {

    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        // Split paragraph into individual words by single spaces
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            // Reverse current word using StringBuilder
            StringBuilder wordSb = new StringBuilder(words[i]);
            result.append(wordSb.reverse().toString());
            
            // Add space between words
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "hello club";
        System.out.println(reverseEachWord(input)); // Output: olleh bulc
    }
}