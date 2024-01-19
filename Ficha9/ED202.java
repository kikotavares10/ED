package Ficha9;


import java.util.Scanner;

public class ED202 {
    static double menor=Double.MAX_VALUE;
    static void permutations(String[] locais, double[][] distancias){
        int n=locais.length;
        int[] v=new int[n];
        for(int m=0;m<n;m++){
            v[m]=m;
        }
        boolean used[] = new boolean[v.length]; // $i$ esta na permutacao?
        int perm[] = new int[v.length];         // permutacao actual
        goPerm(0, v, used, perm, locais, distancias); // chamar funcao recursiva
    }

    static void goPerm(int cur, int v[], boolean used[], int perm[], String locais[], double[][] distancias) {
        if (cur == v.length) {  // Caso base: terminamos a permutacao
            double atual=calcularSoma(perm,locais,distancias);
            if(atual<menor){
                menor=atual;
            }
        } else { // Se nao terminamos, continuar a gerar
            for (int i=0; i<v.length; i++){ // Tentar todos os elementos
                if (!used[i]) { 
                    used[i] = true; 
                    perm[cur] = i;
                    goPerm(cur+1, v, used, perm, locais, distancias);
                    used[i] = false;
                }
            }
        }
    }
    static double calcularSoma(int[] permutacao,String[] locais, double[][] distancias){
        double comprimento=0;
        for (int i=0;i<permutacao.length-1;i++){
            int origem=permutacao[i];
            int destino=permutacao[i+1];
            comprimento+=distancias[origem][destino];
        }
        comprimento+=distancias[permutacao[permutacao.length-1]][permutacao[0]]; //nao perceni assim muito bem esta operacao
        return comprimento;
        
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();

        String[] locais=new String[n];
        for(int i=0;i<n;i++){
            locais[i]=in.next();
        }

        double[][] distancias= new double[n][n];
        for (int j=0;j<n;j++){
            for(int k=0;k<n;k++){
                distancias[j][k]=in.nextDouble();
            }
        }
        
        permutations(locais,distancias);
        System.out.printf("%.2f\n", menor);
    }
}
