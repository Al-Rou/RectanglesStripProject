//Another sort
public class QuickSort {
    public int[] sort(int[] input, int lo, int hi)
    {
        if(lo >= hi)
        {
            return input;
        }
        int lt = lo;
        int gt = hi;
        int v = input[lo];
        int i = lo+1;
        while (i <= gt)
        {
            if (input[i] < v)
            {
                int temp = input[lt];
                input[lt] = input[i];
                input[i] = temp;
                i++;
                lt++;
            }
            else if (input[i] > v)
            {
                int temp = input[i];
                input[i] = input[gt];
                input[gt] = temp;
                gt--;
            }
            else
            {
                i++;
            }
        }
        sort(input, lo, lt-1);
        sort(input, gt+1, hi);
        return input;
    }
}
