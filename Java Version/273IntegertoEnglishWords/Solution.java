class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                int group = num % 1000;
                String groupWord = helper(group); // e.g., 123 -> "One Hundred Twenty Three"

                String unit = THOUSANDS[i];       // e.g., i = 1 -> "Thousand"
                if (!unit.isEmpty()) {
                    groupWord = groupWord + " " + unit;  // add "Thousand", "Million", etc.
                }

                sb.insert(0, groupWord + " "); // insert at the beginning
            }
            num /= 1000;
            i++;
        }

        return sb.toString().trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num];
        } else if (num < 100) {
            return TENS[num / 10] + (num % 10 != 0 ? " " + helper(num % 10) : "");
        } else {
            return LESS_THAN_20[num / 100] + " Hundred" + (num % 100 != 0 ? " " + helper(num % 100) : "");
        }
    }
}
