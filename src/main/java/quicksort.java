public class quicksort {
	int Max;
	int Min;
	int[] unsorted;
	int chunksize=10;

	public void initialize(int[] unsorted) {
		initialize(unsorted, unsorted.length-1);
	}


	public void initialize(int[] unsorted, int cantElements) {
		this.unsorted=unsorted;
		quicksortHelper (this.unsorted, 0, cantElements);
	}

	int[] range(int leftKey, int rightKey, boolean leftIncluded, boolean rightIncluded){
		int i=binarySearch(leftKey,0,unsorted.length-1);
		int []range=new int[chunksize];
		int e=0;
		if(leftIncluded){
			int j=i;
			while (j>=0 && unsorted[j]==leftKey){
					checkChunk(range,e+1);
					range[e++]=unsorted[j--];
			}
		}
		else{
			while(i<unsorted.length && unsorted[i]==leftKey){
				i++;
			}
		}
		while(i<unsorted.length && unsorted[i]!=rightKey){
			checkChunk(range,e+1);
			range[e++]=unsorted[i++];
		}
		if (rightIncluded){
			while ( i<unsorted.length && unsorted[i]==rightKey){
				checkChunk(range,e+1);
				range[e++]=unsorted[i++];
			}
		}
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

	private int binarySearch(int key,int izq,int der){
		if(izq > der)
			return unsorted.length-1;
		int mid=(der + izq)/2;
		if(key == unsorted[mid])
			return mid;
		if(key < unsorted[mid]) {
			der = mid -1;
			return binarySearch(key, izq, der);
		}
		izq = mid + 1;
		return binarySearch(key,izq,der);
	}

	private void checkChunk(int []array,int size){
		if (size==chunksize){
			int[]temp=new int[size+chunksize];
			System.arraycopy(array,0,temp,0,size+chunksize);
			array=temp;
		}
	}
}
