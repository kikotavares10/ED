package Ficha6;

public class SinglyLinkedList<T> {
    private Node <T> first;
    private int size;

    SinglyLinkedList(){
        first=null;
        size=0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return(size==0);
    }

    public void addFirst(T v){
        Node <T> newNode = new Node<T>(v,first);
        first=newNode;
        size++;
    }

    public void addLast(T v){
        Node <T> newNode=new Node<T>(v, null);
        if(isEmpty()){
            first=newNode;
        }else{
            Node <T> cur=first;
            while(cur.getNext()!=null){
                cur=cur.getNext();
            }
            cur.setNext(newNode);
        }
        size++;
    }

    public T getFirst(){
        if(isEmpty()) return null;
        return first.getValue();
    }

    public T getLast(){
        if(isEmpty()) return null;
        Node<T> cur=first;
        while(cur.getNext()!=null)
            cur=cur.getNext();
        return cur.getValue();
    }

    public void removeFirst(){
        if(isEmpty()) return;
        first=first.getNext();
        size--;
    }

    public void removeLast(){
        if(isEmpty()) return;
        if(size==1) first=null;
        else{
            Node<T> cur=first;
            for(int i=0;i<size-2;i++) cur=cur.getNext();
            cur.setNext(cur.getNext().getNext()); //ou simplesmente cur.setNext(null)
        }
    }

    public String toString(){
        String str="{";
        Node <T> cur=first;
        while(cur!=null){
            str+=cur.getValue();
            cur=cur.getNext();
            if(cur!=null) str+=",";
        }
        str+="}";
        return str;
    }

    public T get(int pos){
        Node <T> cur=first;
        for(int i=0;i<pos;i++){
            cur=cur.getNext();
        }
        if(cur.getValue()!=null){
            return cur.getValue();
        }
        return null;
    }

    public T remove(int pos){
        Node<T> cur=first;
        if(isEmpty() || pos>=size) return null;
        size--;
        if(pos==0){
            T valor = cur.getValue();
            first=cur.getNext();
            return valor;
        }
        else{
            for(int i=0;i<pos-1;i++){
                cur=cur.getNext();
            }
            T valor=cur.getNext() .getValue();           
            cur.setNext(cur.getNext().getNext());
            return valor;
        }

    }

    public SinglyLinkedList<T> copy(){
        SinglyLinkedList<T> lista=new SinglyLinkedList<>();
        if(size==0)return null;
        for(int i=0;i<size;i++){
            lista.addLast(this.get(i));
        }
        return lista;
    }

    public void duplicate(){
        Node<T> cur=first;
        while(cur!=null){
            Node<T> new_node=new Node<>(cur.getValue(),cur.getNext());
            cur.setNext(new_node);
            size++;
            cur=cur.getNext();
        }
    }

    public int count(T value){
        Node<T> cur=first;
        int count=0;
        while(cur.getValue()!=null){
            if(cur.getValue().equals(value)) count++;
            cur=cur.getNext();
        }
        return count;
    }

    public void removeAll(T value){
        Node<T> cur=first;
        while(cur.getValue()!=null){
            if(cur.getValue().equals(value)){
                cur=cur.getNext();
            }
        }
    }

}

