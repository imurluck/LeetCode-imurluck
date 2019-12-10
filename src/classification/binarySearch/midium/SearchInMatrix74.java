package classification.binarySearch.midium;

public class SearchInMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int low = 0;
        int high = matrix.length - 1;

        while (low < high) {
            int mid = (low + high + 1) >>> 1;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        int[] array = matrix[high];
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        SearchInMatrix74 searchInMatrix74 = new SearchInMatrix74();
        System.out.println(searchInMatrix74.searchMatrix(new int[][]{{1}}, 1));
    }
}
