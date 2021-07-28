import java.util.HashSet;

/*
The class Solution which is commented below, has complexity O(N^2) which is bad! However, this new
class Solution has the same complexity as sorting algorithm which is O(NlogN) in this case, which
is far better than before!
*/
public class Solution {
    public int solution(int[] A, int[] B)
    {
        //Creates one array (named aux) out of A and B in a row
        int[] aux = new int[A.length+B.length];
        int auxCounter = 0;
        for(int i = 0; i < A.length; i++)
        {
            aux[auxCounter] = A[i];
            auxCounter++;
        }
        for(int i = 0; i < B.length; i++)
        {
            if(B[i] != A[i]) {
                aux[auxCounter] = B[i];
            }
            auxCounter++;
        }
        //This works for rectangles with two-digit dimensions
        int[] frequency = new int[100];
        for(int i = 0; i < aux.length; i++)
        {
            if(aux[i] != 0) {
                frequency[aux[i]]++;
            }
        }
        //Now, it is enough that the array frequency is sorted and the maximum is returned as the answer
        /*Sorting sort = new Sorting();
        frequency = sort.sort(frequency, 0, frequency.length-1);*/
        //Another sort
        QuickSort qs = new QuickSort();
        frequency = qs.sort(frequency, 0, frequency.length-1);

        return frequency[frequency.length-1];
    }
}

/*public class Solution {
    public int solution(int[] A, int[] B)
    {
        //Creates one array (named aux) out of A and B in a row
        int[] aux = new int[A.length+B.length];
        int auxCounter = 0;
        for(int i = 0; i < A.length; i++)
        {
            aux[auxCounter] = A[i];
            auxCounter++;
        }
        for(int i = 0; i < B.length; i++)
        {
            aux[auxCounter] = B[i];
            auxCounter++;
        }
        int checkElement;
        int maxFrequency = 0;
        for(int i = 0; i < aux.length-1; i++)
        {
            if(aux[i] == 0)
            {
                continue;
            }
            //A set to store the indices of repeated element of checkElement
            HashSet<Integer> set = new HashSet<>();
            checkElement = aux[i];
            set.add(i);
            aux[i] = 0;
            for(int j = i+1; j < aux.length; j++)
            {
                //If there is the same value as in checkElement, that must be set to zero in order to
                //avoid counting more than necessary
                if(aux[j] == checkElement)
                {
                    //If the index of repeated values in A and B is the same, that shouldn't be added to the set
                    if(!set.contains((j % A.length))) {
                        set.add(j);
                    }
                    aux[j] = 0;
                }
            }
            //The maxFrequency is set through the size of the set
            if(set.size() > maxFrequency)
            {
                maxFrequency = set.size();
            }
        }
        //This is the answer
        return maxFrequency;
    }
}*/
