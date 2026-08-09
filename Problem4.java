public class Problem4 {

    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        
        // Trim leading and trailing spaces
        String trimmed = raw.trim();

        // Convert only the first 3 characters to uppercase if available
        if (trimmed.length() >= 3) {
            return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
        }
        return trimmed;
    }

    public static String validateAndFormat(String code) {
        // Validate total length of 13 characters
        if (code == null || code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Validate that first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Validate that remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Extract components
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        // Format string using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode)
          .append("] YEAR: ").append(year)
          .append(" | CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test Case 1: Valid input needing normalization
        String normalized1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(normalized1)); 
        // Output: [PEN] YEAR: 2026 | CATALOG: 004251

        // Test Case 2: Invalid publisher code
        String normalized2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(normalized2)); 
        // Output: Invalid: publisher code must be 3 letters
    }
}