import java.util.*;

public class Problem5 {

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.isEmpty()) {
            return;
        }

        // Set of stop words to filter out
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        // Normalize text: convert to lowercase and remove punctuation (periods and commas)
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");

        // Split into words using whitespace pattern
        String[] words = cleaned.split("\\s+");

        // Map to count word frequencies
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            // Skip empty strings and stop words
            if (word.isEmpty() || stopWords.contains(word)) {
                continue;
            }
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Convert map entries to list for sorting
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freqMap.entrySet());

        // Sort entries by count in descending order
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Print each word with its frequency count
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String input = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(input);
    }
}