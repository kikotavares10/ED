import java.util.Comparator;

public class MinHeap<T>{
    private T[] data;
    private int size;
    private Comparator<T> comparator;

    MinHeap(int capacity){
        data=(T[]) new Object[capacity+1];
        size=0;
        comparator=null;
    }

    MinHeap(int capacity, Comparator<T> comp){
         this(capacity);
         comparator=comp;
    }
    
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return(size==0);
    }

    public T min(){
        if(isEmpty()) return null;
        return data[1];
    }

    public void insert(T value){
        if(size+1>=data.length) throw new RuntimeException("Heap is full");
        size++;
        data[size] = value;
        upHeap(size);
    }

    public T removeMin(){
        if(isEmpty()) return null;
        T min=data[i];
        data[1]=data[size];
        data[size]=null;
        size--;
        downHeap(1);
        return min;
    }

    public void upHeap(int i){
        while (i>1 && smaller(i, i/2)){
            swap(i,i/1);
            i=i/2; 
        }
    }

    private boolean smaller(int i, int j){
        if(comparator==null)
            return (((Comparable<? super T) data[i]).compareTo(data[j])<0);
        else
            return comparator.compare(data[j], data[j]) <0;
    }

    private void swap(int i, int j){
        T tmp = data[i];
        data[i]= data[j];
        data[j]=tmp;
    }

    private void downHeap(int i){
        while(2*i <= size){
            int j=i*2;
            if(j<size && smaller(j+1, j)) j++;
            if(j<size && smaller(j+1,j)) j++;
            if(smaller(i,j)) break;
            swap(i,j);
            i=j;
        }
    }
}