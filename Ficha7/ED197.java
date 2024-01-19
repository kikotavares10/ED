package Ficha7;
import java.util.Scanner;

import LinkedListQueue;
import MyQueue;

public class ED197 {
    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b){
        MyQueue<Integer> m= new LinkedListQueue<>();
        while(a.first()!=null || b.first()!=null){

            if(a.first()==null){
                m.enqueue(b.dequeue());
            }else if(b.first()==null){
                m.enqueue(a.dequeue());
            }else if(a.first()>b.first()){
                m.enqueue(b.dequeue());
            }else{
                m.enqueue(a.dequeue());
            }
        }

        return m;
    }

    public static void main(String[] args){
        MyQueue<Integer> a = new LinkedListQueue<>();
        MyQueue<Integer> b= new LinkedListQueue<>();

        Scanner in= new Scanner(System.in);
        int n1=in.nextInt();
        in.nextLine();
        for(int i=0;i<n1;i++){
            a.enqueue(in.nextInt());
        }
        in.nextLine();
        int n2=in.nextInt();
        in.nextLine();
        for(int j=0;j<n2;j++){
            b.enqueue(in.nextInt());
        }

        MyQueue<Integer> m=merge(a,b);
        System.out.println(m);
        //System.out.print("a:"+a);
        //System.out.print("b:"+b);

        in.close();
    }
}
