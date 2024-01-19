package Ficha9;


import java.util.Scanner;

class ED201 {
    static void sets(int v[]) {
        // array de booleanos para representar o conjunto
        boolean used[] = new boolean[v.length];
        goSets(0, v, used); // chamar funcao recursiva
    }

    static int max=0;
    static int T;
  
     // Gera todos os subconjuntos a partir da posicao 'cur'
    static void goSets(int cur, int v[], boolean used[]) {
        int sum=0;
        if (cur == v.length) {  // Caso base: terminamos o conjunto
           // Escrever conjunto
           
            for (int i=0; i<v.length; i++) {
                if (used[i]){
                    sum+=v[i];
                }
            }
            if(sum<=T){
                max=Math.max(max,sum);
            }
            sum=0;
        } else {                  // Se nao terminamos, continuar a gerar
           used[cur] = true;      // Subconjuntos que incluem o elemento actual
           goSets(cur+1, v, used);// Chamada recursiva
           used[cur] = false;     // Subconjuntos que nao incluem o el. actual
           goSets(cur+1, v, used);// Chamada recursiva
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        T=in.nextInt();
        int n=in.nextInt();
        in.nextLine();
        int array[]=new int[n];
        for (int i=0;i<n;i++){
            array[i]=in.nextInt();
        }
        sets(array);
        System.out.println(max);
    }
}
