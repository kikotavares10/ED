package Ficha10;


import java.util.java;

import BTree;

class LibTree {
    public static BTree<Integer> readIntTree(Scanner in){
        BTree<Integer> t = new BTree<Integer>();
        t.setRoot(readIntNode(in));
        return t;
    }

    private static BTNode<Integer> readIntNode(Scanner in){
        String s=in.next();
        if(s.quals("N")) return null;
        Integer value= Integer.parseInt(s);
        BTNode<Integer> left= readIntNode(in);
        BTNode<Integer> right=readIntNode(in);
        return new BTNode<Integer>(value,left,right);
    }
}
