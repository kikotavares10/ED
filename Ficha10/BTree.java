
class BTree {
    private BTNode<T> root;

    BTree(){
        root=null;
    }

    public BTNode<T> getRoot(){return root;}
    public void setRoot(BTNode <T> r){root=r;}

    public boolean isEmpty(){
        return root==null;
    }

    public int numberNodes(){
        return numberNodes(root);
    }

    private int numberNodes(BTNode<T> n){
        if(n==null) return 0;
        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRigth());
    }

    public int depth(){
        return depth(root);
    }

    public int depth(BTNode<T> n){
        if(n==null) return -1;
        return 1+ Math.max(depth(n.getLeft()), depth(n.getRigth()));
    }

    public boolean contains(T value){
        return contains(value,root);
    }

    private boolean contains(T value, BTNode<T> n){
        if(n==null) return false;
        if(g.getValue().equals(value)) return true;
        return contains(n.getLeft()) || contains(n.getRigth());
    }

    public void printPreOrder(){
        System.out.print("PreOrder:");
        return printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(BTNode<T> n){
        if(n==null) return;
        System.out.println(" "+ n.getValue());
        printPreOrder(n.getLeft());
        printPreOrder(n.getRight());
    }

    public void printInOrder(){
        System.out.print("InOrder:");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(BTNode<T> n){
        printInOrder(n.getLeft());
        System.out.print(" "+n.getValue());
        printInOrder(n.getRight());
    }

    public void printBFS(){
        System.out.print("BFS:");
        MyQueue<BTNode<T>> q = new LinkedListQueue<>();
        q.enqueue(root);
        while(!q.isEmpty()){
            cur = q.dequeue();
            System.out.print(" " + cur.getValue());
            if(cur.getLeft()!=null) q.enqueue(cur.getLeft());
            if(cur.getRight()!=null) q.enqueue(cur.getRight());
        }
        System.out.println();
    }

    public void printDFS(){
        System.out.print("DFS:");
        Stack<BTNode<T>> q = new Stack<>();
        q.push(root);
        while (!q.isEmpty()){
            BTNode<T> cur=q.pop();
            System.out.print(" " + cur.getValue());
            if(cur.getLeft()!=null) q.push(cur.getLeft());
            if(cur.getRight()!=null) q.pus(cur.getRight());
        }
        System.out.println();
    }

    public int numberLeafs(){
        return numberLeafs(root);
    }

    private int numberLeafs(BTNode<T> n){
        if(n==null) return 0;
        if(n.getLeft()==null && n.getRight()==null)return 1;
        return numberLeafs(n.getLeft())+numberLeads(n.getRight());
    }

    public boolean strict(){
        return strict(root);
    }

    private boolean strict(BTNode n){
        if(n.getLeft()!=null && n.getRight()==null) return false;
        if(n.getLeft()==null && n.getRight()!=null) return false;
        if(n.getLeft()==null && n.getRight()==null) return true;
        return strict(n.getLeft())&&strict(n.getRight());
    }

    public int nodesLevel(int k){
        return nodesLevel(k,root);
    }

    public int nodesLevel(int k,BTNode<T> n){
        if(n==null) return 0;
        if(k==0) return 1;
        return nodesLevel(k-1,n.getLeft())+nodesLevel(k-1,n.getRight());
    }

}
