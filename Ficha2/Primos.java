import java.util.Scanner;


public class Primos {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int min=scanner.nextInt();
        int max=scanner.nextInt();
        scanner.close();

        boolean[] isPrime=new boolean[max+1];
        for(int i=2;i<=max;i++){
            isPrime[i]=true;
        }
        
        for(int p=2;p*p<=max;p++){
            if(isPrime[p]){
                for(int i=p*p;i<=max;i+=p){
                    isPrime[i]= false;
                }
            }
        }
        int contagem=0;
        for(int i=min;i<=max;i++){
            if(isPrime[i]){
                contagem++;
            }
        }
        System.out.print(contagem);
    }
}
