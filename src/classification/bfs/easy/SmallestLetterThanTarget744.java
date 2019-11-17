package classification.bfs.easy;

public class SmallestLetterThanTarget744 {

    public static char nextGreatestLetter(char[] letters, char target) {
        int[] indexArray = new int[26];
        for (char c : letters) {
            indexArray[c - 'a']++;
        }
        int targetIndex = target - 'a';
        int result = targetIndex + 1;
        while (result != targetIndex) {
            result = result % 26;
            if (indexArray[result] > 0) {
                break;
            }
            result++;
        }
        return (char) (result + 'a');
    }

    public static void main(String[] args) {
        char[] chars = new char[] {'c', 'e', 'f'};
        System.out.println(SmallestLetterThanTarget744.nextGreatestLetter(chars, 'a'));
    }
}
