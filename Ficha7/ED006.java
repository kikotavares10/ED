package Ficha7;

import java.util.Scanner;

public class ED006 {
    Scanner in=new Scanner(System.in);
    int N=in.nextInt();
    int n;
    in.nextLine();

    CircularLinkedList<String> nomes= new CircularLinkedList<>();

    for(int i=0;i<N;i++){
        int count=0;
        while(in.next()!=null){
            count++;
        }
        in.nextLine();
        n=in.nextInt();
        for(int j=0;j<n;j++){
            nomes.addLast(in.next());
        }

        while (nomes.size()!=1){
            for(k=0;k<count;k++){
                nomes.rotate();
            }
        }
        if(nomes.getFirst().equals("Carlos"))
    }

}
