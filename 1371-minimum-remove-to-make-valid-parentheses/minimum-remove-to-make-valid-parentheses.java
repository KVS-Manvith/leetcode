class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;

        // Step 1: Remove invalid ')'
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                sb.append(c);
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                    sb.append(c);
                }
            } else {
                sb.append(c); // letters
            }
        }

        // Step 2: Remove extra '('
        StringBuilder result = new StringBuilder();
        int extraOpen = open;

        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '(' && extraOpen > 0) {
                extraOpen--;
                continue; // skip it
            }
            result.append(c);
        }

        return result.reverse().toString();
    }
}