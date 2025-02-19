// class including both methods
public class CompressDecompress {

    // static method to compress string
    public static String compressString(String inputString) {
        // create StringBuilder object to generate output string
        StringBuilder compressedString = new StringBuilder();
        // initialize character count variable
        int count = 1;
        // loop through input string to check if next char same as previous
        // and not end of string
        for (int i = 0; i < inputString.length(); i++) {
            if (i + 1 < inputString.length() && inputString.charAt(i) == inputString.charAt(i + 1)) {
                // increase count by 1 if next char same as previous
                count++;
            } else {
                // add the latest letter of same kind and the number of its
                // instances to string; reassign count to 1 for next set of
                // letter characters
                compressedString.append(inputString.charAt(i));
                compressedString.append(count);
                count = 1;
            }

        }
        // output compressed string
        return compressedString.toString();
    }

    // static method to decompress string using recursive method
    public static String decompressString(String inputString) {
        return decompressRecursive(inputString, 0, new StringBuilder());
    }

    // private recursive decompression method to account for several digit
    // numbers in input string
    private static String decompressRecursive(String inputString, int index,
                                              StringBuilder decompressedString) {
        // return output string once char index reaches input string end
        if (index >= inputString.length()) {
            return decompressedString.toString();
        }
        // capture letter character, increase index to next
        char c = inputString.charAt(index++);
        // create StringBuilder object to capture digits if more than one
        StringBuilder number = new StringBuilder();
        // as long as next character is a digit, append it to number string
        // object and then increase index to next
        while (index < inputString.length() && Character.isDigit(inputString.charAt(index))) {
            number.append(inputString.charAt(index++));
        }
        // parse the number string object to an integer
        int count = Integer.parseInt(number.toString());
        // append the character 'count' times to the output string
        for (int i = 0; i < count; i++) {
            decompressedString.append(c);
        }
        // recursively process the rest of the string with index and
        // decompressedString variables updated to capture next letter-digit
        // set in input string
        return decompressRecursive(inputString, index, decompressedString);
    }

    public static void main(String[] args) {
        System.out.println(compressString("aaaaaaaaaaaaaaaaaaaaababccc"));
        System.out.println(decompressString("a1b11c1"));

    }
}
