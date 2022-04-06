import java.util.ArrayList;
import java.util.List;

public class IndexWithDuplicates implements IndexService{
    private int size=0,index=0,chunksize=10;
    private int[] array=new int[chunksize];

    @Override
    public void initialize(int[] elements) {
        for (int e:elements) {
            insert(e);
        }
    }

    @Override
    public void insert(int key) {
        if (key!=(int) key)
            throw new IllegalArgumentException();
        if(size!=0)
            index=binarySearch(key,0,size);
        add(index,key);
    }

    @Override
    public boolean search(int key) {
        if (size!=0) {
            index = binarySearch(key, 0, size);
            if (get(index) == key)
                return true;
        }
        return false;
    }


    @Override
    public void delete(int key) {
        if(size!=0) {
            index=binarySearch(key,0,size);
            remove(index);
        }
    }

    @Override
    public int occurrences(int key) {
        int resp=0,aux;
        if(size!=0) {
            index = binarySearch(key, 0, size);
            aux = index;
            while (aux > 0 && key == get(aux - 1)) {
                aux--;
                resp++;
            }
            while (get(index) == key) {
                index++;
                resp++;
            }
        }
        return resp;
    }

    private void checkChunk(){
        if (size==chunksize){
            int[]temp=new int[size+chunksize];
            System.arraycopy(array,0,temp,0,size+chunksize);
            array=temp;
        }
    }

    private int binarySearch(int key,int izq,int der){
        if(izq > der)
            return size-1;
        int mid=(der + izq)/2;
        if(key == get(mid))
            return mid;
        if(key < get(mid)) {
            der = mid -1;
            return binarySearch(key, izq, der);
        }
        izq = mid + 1;
        return binarySearch(key,izq,der);
    }

    private void add(int idx, int elem){
        checkChunk();
        if (idx==size){
            array[idx]=elem;
        }
        else{
            for (int i=size;i>idx;i--){
                array[i]=array[i-1];
            }
            array[idx]=elem;
        }
        size++;
    }

    private int get(int idx){
        return array[idx];
    }

    private void remove(int idx){
        while(idx<size){
            array[idx]=array[idx+1];
            idx++;
        }
        size--;
    }
}
