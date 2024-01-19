package Ficha5;

public class ArrayListIntSet implements IntSet {
   private int size;   // Numero de elementos do conjunto
   private int elem[]; // Array que contem os elementos em si 
   
   ArrayListIntSet(int maxSize){
      elem=new int[maxSize];
      size=0;
   }

   public int size(){
      return size;
   }

   public void clear(){
      size=0;
   }

   public boolean contains(int x){
      for(int i=0;i<size;i++){
         if(elem[i]==x) return true;
      }
      return false;
   }

   public boolean add(int x){
      if(!contains(x)){
         elem[size]=x;
         size++;
         return true;
      }
      return false;
   }

   public boolean remove(int x){
      if(contains(x)){
         int pos=0;
         while(elem[pos]!=x) pos++;
         elem[pos]=elem[size];
         return true;
      }
      return false;
   }

   public String toString(){
      String res="{";
      for(int i=0;i<size;i++){
         if(i>0) res+=",";
         res+=elem[i];
      }
      res+="}";
      return res;
 
   }

   public boolean equals(IntSet s){
      if(s.size()==size){
         for(int i=0;i<size;i++){
            if(!s.contains(elem[i])){
               return false;
            }
         }
         return true;
      }
      return false;
   }

   public IntSet intersection(IntSet s){
      IntSet n= new ArrayListIntSet(100);
      for(int i=0;i<size;i++){
         if(s.contains(elem[i])){
            n.add(elem[i]);
         }
      }
      return n;
   }
}

