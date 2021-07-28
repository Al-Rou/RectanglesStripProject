import java.util.HashSet;

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
}
