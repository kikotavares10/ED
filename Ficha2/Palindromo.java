import java.util.Scanner;

public class Palindromo {
   public static void main(String[] args) {
	
      Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
      stdin.nextLine();

      // Ciclo para iterar sobre todas as linhas do input
      for(int i=0;i<=n;i++){
         String linha = stdin.nextLine();
         String linhaconvertida = converter(linha);

         if (isPalindromo(linhaconvertida)){
            System.out.println("sim");
         }
         else{
            System.out.print("nao");
         }
         stdin.close();
      }
   }
   public static String converter(String str){
      StringBuilder s = new StringBuilder();
      for(int i=0;i<str.length();i++){
         char c=str.charAt(i);

         if(Character.isLetter(c)){
            c=Character.toLowerCase(c);
            s.append(c);
         }
      }
      return s.toString();
   }

   public static boolean isPalindromo(String str){
      int j=str.length();

      for(int i=0;i<j/2;i++){
         if(str.charAt(i)!=str.charAt(j-1))
            return false;
      }
      return true;
   }
}
