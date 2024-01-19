package Ficha5;

public class BooleanArrayIntSet implements IntSet {
    private boolean[] elem;
    private int size;
    private final int max_size;

    public BooleanArrayIntSet(int max_size){
        elem=new boolean[max_size+1];
        size=0;
        this.max_size=max_size;
    }

    public boolean contains(int x){
        return elem[x];
    }

    public int size(){
        return size;
    }

    public void clear(){
        for(int i=0;i<max_size;i++){
            elem=new boolean[max_size];
            size=0;
        }
    }

    public boolean add(int x){
        if(!contains(x)){
            elem[x]=true;
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(int x){
        if(contains(x)){
            elem[x]=false;
            size--;
            return true;
        }
        return false;
    }

    public boolean equals(IntSet s){
        if(s.size()==size){
            for(int i=0;i<max_size;i++){
                if(contains(i)&&!(s.contains(i))){
                    return false;
                }
                if(!contains(i) && (s.contains(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public IntSet intersection(IntSet s){
        IntSet n=new BooleanArrayIntSet(max_size);
        
        for(int i=0;i<max_size;i++){
            if(contains(i) && s.contains(i)){
                n.add(i);
            }
        }
        return n;
    }
}


