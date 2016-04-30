package Aula6;

public class UtilCompare {
	@SuppressWarnings("unchecked")
	public static <T> Comparable<T> findMax(Comparable<T>[] array){
        int maxIdx = 0;
        
        for(int i=1; i<array.length; i++ )
                if(array[i].compareTo((T)array[maxIdx]) > 0 )
                	maxIdx = i;
        
        return array[maxIdx];
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void sortArray(Comparable<T>[] array){
	        Comparable<T> temp;
	        
	        for(int i=0; i<array.length; i++)
	        	for(int j=i+1; j<array.length; j++)
	            	if (array[i].compareTo((T)array[j])>0){
	            		temp = array[j];
	                    array[j] = array[i];
	                    array[i] = temp;
	                }
        
	}
}
