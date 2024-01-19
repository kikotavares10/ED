import java.util.Scanner;

public class ReadNumbers {

    // Escrever os numeros guardados num array no stdout
    static void writeArray(int v[]) {
        for (int i=0; i<v.length; i++)          
        System.out.println("v[" + i + "] = " + v[i]);      
    }

    public static void main(String[] args) {
        
        Scanner stdin = new Scanner(System.in);
  
        int v[] = new int[1000];             
        int n = stdin.nextInt();   // Ler a quantidade de numeros que se seguem
        
        for (int i=0; i<n; i++)    // Ler os numeros a partir do stdin
            v[i] = stdin.nextInt();
        
        int maior=v[0], menor=v[0];
        for(int i=1;i<n;i++)
            if(v[i]>maior) maior=v[i];
            else if(v[i]<menor) menor=v[i];
        int amplitude=maior-menor;

        float soma=0;
        for(int i=0;i<n;i++)
            soma=soma + v[i];
        float media=soma/n;
        System.out.printf("%.2f\n", media);
        System.out.printf("%d\n", amplitude);
    }
}
