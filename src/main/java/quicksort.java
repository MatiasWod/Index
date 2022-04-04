public class quicksort {
	int Max;
	int Min;
	int[] unsorted;
	public void quicksort(int[] unsorted) {
		this.unsorted=unsorted;
		quicksort (unsorted, unsorted.length-1);
	}
	
	
	public void quicksort(int[] unsorted, int cantElements) {
		quicksortHelper (unsorted, 0, cantElements);
	}

	int[] range(int leftKey, int rightKey, boolean leftIncluded, boolean rightIncluded){
		
	}

	public int getMin(){

	}

	public int getMax(){

	}

	public void sortedPrint(){
		quicksort(unsorted);
		for (int i : unsorted) {
			System.out.print(i + " ");
		}
	}

	private static void quicksortHelper (int[] unsorted, int leftPos, int rightPos) {
		if (rightPos <= leftPos )
			return; 
		
		// tomamos como pivot el primero. Podria ser otro elemento
		int pivotValue= unsorted[leftPos];
		
		// excluimos el pivot del cjto.
		swap(unsorted, leftPos, rightPos);

		// particionar el cjto sin el pivot
		int pivotPosCalculated= partition(unsorted, leftPos, rightPos-1, pivotValue);
		
		
		// el pivot en el lugar correcto
		swap(unsorted, pivotPosCalculated, rightPos);
		
		
		// salvo unsorted[middle] todo puede estar mal
		// pero cada particion es autonoma
		quicksortHelper(unsorted, leftPos, pivotPosCalculated - 1);
		quicksortHelper(unsorted, pivotPosCalculated + 1, rightPos );

	}
	


	static private int partition(int[] unsorted, int leftPos, int rightPos, int pivotValue) {
		while (leftPos<=rightPos){
			while (leftPos<=rightPos && unsorted[leftPos]<pivotValue)
				leftPos++;
			while (leftPos<=rightPos && unsorted[rightPos]>pivotValue)
				rightPos--;
			if(leftPos<=rightPos)
				swap(unsorted,leftPos++,rightPos--);
		}
		return leftPos;
	}
	
	static private void swap(int[] unsorted, int pos1, int pos2) {
		int auxi= unsorted[pos1];
		unsorted[pos1]= unsorted[pos2];
		unsorted[pos2]= auxi;
	}
	
	

}
