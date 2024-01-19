package Ficha10;



public class BTNode <T> {
    private T value;
    private BTNode <T> left;
    private BTNode <T> rigth;

    BTNode(T value, BTNode <T> left, BTNode <T> rigth){
        this.value=value;
        this.left=left;
        this.rigth=rigth;
    }

    public T getValue() {return value;}
    public BTNode<T> getLeft(){return left;}
    public BTNode<T> getRigth(){return rigth;}
    public void setValue(T value){this.value=value;}
    public void setLeft(BTNode<T> left){this.left=left;}
    public void setRigth(BTNode<T> right){this.rigth=right;}
}
