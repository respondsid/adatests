// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    //Codility Array shift can be imporoved by testiung for -iver shift and 0 returning same array for 0 shift.
    public int[] solution(int[] A, int K) {
        if(A==null){
            return null;
        }
        int arrayLen=A.length;
        if(arrayLen==1){
            return A;
        }
        int shift=K;
        if(K>arrayLen){
            shift=K/arrayLen;
        }
        int result[] =new int[arrayLen];
        int j=0+shift;
        for(int i=0;i<arrayLen;i++){
            if(j==arrayLen){
                j=0;
            }
            
            result[j]=A[i];
            j++;
        }
        return result;
    }
    
    
}
