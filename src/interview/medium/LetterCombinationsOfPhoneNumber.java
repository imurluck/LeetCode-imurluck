package interview.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        for (char c : getDigitChars(digits.charAt(0))) {
            find(c, 0, digits,  list, "");
        }
        return list;
    }

    private void find(char currentC, int index, String digits, List<String> result, String currentStr) {
        if (index == digits.length() - 1) {
            currentStr += currentC;
            result.add(currentStr);
            return;
        } else {
            currentStr += currentC;
            index++;
            for (char c : getDigitChars(digits.charAt(index))) {
                currentC = c;
                find(currentC, index, digits, result, currentStr);
            }
        }
    }

    private char[] getDigitChars(char digit) {
        switch (digit) {
            case '2': return new char[] {'a', 'b', 'c'};
            case '3': return new char[] {'d', 'e', 'f'};
            case '4': return new char[] {'g', 'h', 'i'};
            case '5': return new char[] {'j', 'k', 'l'};
            case '6': return new char[] {'m', 'n', 'o'};
            case '7': return new char[] {'p', 'q', 'r', 's'};
            case '8': return new char[] {'t', 'u', 'v'};
            case '9': return new char[] {'w', 'x', 'y', 'z'};
        }
        return null;
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();
        System.out.println(solution.letterCombinations("234"));
    }
}
