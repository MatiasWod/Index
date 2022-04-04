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
            index=indexOf(key,index,size);
        add(index,key);
    }

    @Override
    public boolean search(int key) {
        index=indexOf(key,index,size);
        if (get(index)==key)
                return true;
        return false;
    }


    @Override
    public void delete(int key) {
        if(size!=0) {
            index = indexOf(key, index, size);
            remove(index);
        }
    }

    @Override
    public int occurrences(int key) {
        int resp=0,aux;
        index=indexOf(key,index,size);
        aux=index;
        while (aux>0 && key ==get(aux - 1)) {
            aux--;
            resp++;
        }
        while (get(index)==key){
                index++;
                resp++;
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

    private int indexOf(int key,int index,int max){
        if (index>max)
            return max;
        int mid=(index+(size-1))/2;
        if (key==get(mid)) {
            return mid;
        }
        if (key<get(mid) ) {
            if(mid==0)
                return mid;
            return indexOf(key,max,mid - 1);
        }
        return indexOf(key,mid+1,max);
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
