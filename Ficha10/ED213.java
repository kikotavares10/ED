package Ficha10;


import java.util.Scanner;

public class ED213{

    static String s="";
    static int max=0;
    public static String maxSum(BTree<Integer> t){
        s="";
        max=0;
        return maxSum(t.getRoot(), "");
    }

    public static String maxSum(BTNode<Integer> n, String s){
        if(n==null) return 0;
        int leftSum=maxSum(n.getLeft(), s + "E");
        int rightSum=maxSum(n.getRight(), s + "D");

        int cur=Math.max(leftSum+n.getValue(),rightSum+n.getValue());
        if(cur>max){
            if(cur==leftSum+n.getValue()){
                s=s+"E";
            }
            else{
                s=s+"D";
            }
        }
        return cur;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        BTree<Integer> t = LibBTree.readIntTree(in);

        System.out.println(maxSum(t));
    }
}