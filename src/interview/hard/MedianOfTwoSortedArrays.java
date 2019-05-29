package interview.hard;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] shortArray;
        int[] longArray;
        if (nums1.length < nums2.length) {
            shortArray = nums1;
            longArray = nums2;
        } else {
            shortArray = nums2;
            longArray = nums1;
        }
        //m < n
        int m = shortArray.length;
        int n = longArray.length;
        int totalSize = m + n;
        int maxCut;
        //边界控制，很重要
        int left = 0, right = m;
        int minCut = (left + right) / 2;
        while (minCut <= m) {
            minCut = (left + right) / 2;
            maxCut = (totalSize / 2) - minCut;
            double minL = (minCut <= 0) ? Integer.MIN_VALUE : shortArray[minCut - 1];
            double minR = (minCut >= m) ? Integer.MAX_VALUE : shortArray[minCut];
            double maxL = (maxCut <= 0) ? Integer.MIN_VALUE : longArray[maxCut - 1];
            double maxR = (maxCut >= n) ? Integer.MAX_VALUE : longArray[maxCut];
            if (minL <= maxR && maxL <= minR) {
                if (totalSize % 2 != 0) {
                    if (minCut + maxCut > totalSize / 2) {
                        return Math.max(minL, maxL);
                    } else {
                        return Math.min(minR, maxR);
                    }
                } else {
                    return (Math.max(minL, maxL) + Math.min(minR, maxR)) / 2;
                }
            } else if (minL > maxR) {
                right = minCut - 1;
            } else if (minR < maxL) {
                left = minCut + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        System.out.println(solution.findMedianSortedArrays(new int[] {1, 2},
                new int[] {3, 4}));
    }
}
