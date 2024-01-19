import java.util.Scanner;

public class Pizza {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            int k=scanner.nextInt();
            a[i]=k;
        }

        int p=scanner.nextInt();
        int contagem=0;

        for(int i=0;i<p;i++){
            int ing=scanner.nextInt();
            int v=0;
            for(int j=0;j<ing;j++){
                int f=scanner.nextInt();
                for(int c=0;c<n;c++){
                    if(f==a[c]){
                        v=1;
                        break;
                    }
                }
            }
            if(v==1)
                contagem++;
        }
        scanner.close();
        System.out.print(contagem);
    }
}
