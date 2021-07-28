public class Sorting {
    public int partition(int[] input, int lo, int hi)
    {
        int i = lo + 1;
        int j = hi;
        while (true)
        {
            while (input[i] < input[lo])
            {
                if(i == hi)
                {
                    break;
                }
                i++;
            }
            while (input[j] > input[lo])
            {
                if(j == lo)
                {
                    break;
                }
                j--;
            }
            if(i >= j)
            {
                break;
            }
            else {
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
            }
        }
        int temp = input[lo];
        input[lo] = input[j];
        input[j] = temp;
        return j;
    }
    public int[] sort(int[] input, int lo, int hi)
    {
        int j;
        if(lo >= hi)
        {
            return input;
        }
        else
        {
            j = partition(input, lo, hi);
            sort(input, lo, j-1);
            sort(input, j+1, hi);
        }
        return input;
    }
}
