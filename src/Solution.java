import java.util.HashSet;

public class Solution {
    public int solution(int[] A, int[] B)
    {
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
            HashSet<Integer> set = new HashSet<>();
            checkElement = aux[i];
            set.add(i);
            aux[i] = 0;
            for(int j = i+1; j < aux.length; j++)
            {
                if(aux[j] == checkElement)
                {
                    if(!set.contains((j % A.length))) {
                        set.add(j);
                    }
                    aux[j] = 0;
                }
            }
            if(set.size() > maxFrequency)
            {
                maxFrequency = set.size();
            }
        }
        return maxFrequency;
    }
}
