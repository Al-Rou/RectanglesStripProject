public class RectanglesStrip {
    public static void main(String[] args)
    {
        Solution s = new Solution();
        //int[] A = {2, 3, 2, 3, 5}; int[] B = {3, 4, 2, 4, 2};
        //int[] A = {2, 3, 1, 3}; int[] B = {2, 3, 1, 3};
        int[] A = {2, 10, 4, 1, 4}; int[] B = {4, 1, 2, 2, 5};

        //System.out.println(s.solution(A, B));

        QuickSort qs = new QuickSort();
        A = qs.sort(A, 0, 4);
        for(int i = 0; i < A.length; i++)
        {
            System.out.println(A[i]);
        }
    }
}
