package Ficha7;
import java.util.Scanner;

import LinkedListQueue;
import MyQueue;

public class ED196 {
    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b){

        String t,nome="";
        for(int i=0;i<q.size();){
            t=q.dequeue();
            nome=q.dequeue();
            if(!t.equals("A") && !t.equals("B")&& !t.equals("X")) nome=t;

            else if(t.equals("A"))
                a.enqueue(nome);
            else if(t.equals("B"))
                b.enqueue(nome);
            else if(t.equals("X")){
                if(a.size()!=b.size()){
                    if(a.size()<b.size())
                        a.enqueue(nome);
                    else if(b.size()<a.size())
                        b.enqueue(nome);
                }
            }

        }
    }
    public static void main(String[] args){
        MyQueue<String> q = new LinkedListQueue<>();
        MyQueue<String> a = new LinkedListQueue<>();
        MyQueue<String> b = new LinkedListQueue<>();
        Scanner in= new Scanner(System.in);
        int N=in.nextInt();
        for(int i=0;i<N;i++){
            String nome=in.next();
            String lista=in.next();
            q.enqueue(nome);
            q.enqueue(lista);
        }

        process(q,a,b);
        System.out.println("q"+q);
        System.out.println("a"+a);
        System.out.println("b"+b);

        in.close();
    }
}
