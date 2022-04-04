public class quicksort {
	int Max;
	int Min;
	int[] unsorted;

	public void initialize(int[] unsorted) {
		initialize(unsorted, unsorted.length-1);
	}
	

	public void initialize(int[] unsorted, int cantElements) {
		this.unsorted=unsorted;
		quicksortHelper (this.unsorted, 0, cantElements);
	}

	int[] range(int leftKey, int rightKey, boolean leftIncluded, boolean rightIncluded){
		int i=indexOf(leftKey,0,unsorted.length-1);
		leftKey=leftIncluded?i:(i+1);
		rightKey=rightIncluded?rightKey:(rightKey-1);

		int []range=new int[rightKey-leftKey];
		for (int i=unsorted[leftKey],j=0;i<rightKey;i++,j++)
			range[j]=unsorted[i];
		return range;
	}

	public int getMin(){
		return unsorted[0];
	}

	public int getMax(){
		return unsorted[unsorted.length-1];
	}

	public void sortedPrint(){
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

	private int indexOf(int key,int index,int max){
		if (index>max)
			return max;
		int mid=(index+(max))/2;
		if (key==unsorted[mid]) {
			return mid;
		}
		if (key<unsorted[mid]) {
			if(mid==0)
				return mid;
			return indexOf(key,max,mid - 1);
		}
		return indexOf(key,mid+1,max);
	}
	
	

}
