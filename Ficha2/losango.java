import java.util.Scanner;

public class losango {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        for(int i=1;i<=n;i+=2){
            int pontos =(n-i) / 2;
            int cardinais = n-pontos * 2;

            for(int j=0; j< pontos ;j++){
                System.out.print(".");
            }
            for(int j=0;j<cardinais;j++){
                System.out.print("#");
            }
            for(int j=0;j<pontos;j++){
                System.out.print(".");
            }
            System.out.println();
        }
        for(int i=n-2;i>=1;i-=2){
            int pontos=(n-i) / 2;
            int cardinais = n - pontos*2;

            for(int j=0;j<pontos;j++){
                System.out.print(".");
            }
            for(int j=0;j<cardinais;j++){
                System.out.print("#");
            }
            for(int j=0;j<pontos;j++){
                System.out.print(".");
            }
            System.out.println();
        }          
    }
}
