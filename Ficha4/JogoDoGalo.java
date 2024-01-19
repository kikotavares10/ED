import java.util.Scanner;

public class JogoDoGalo{
    public static void main(String[] args){
        Scanner stdin=new Scanner(System.in);
        int n = stdin.nextInt();
        stdin.nextLine();

        char[][] tabuleiro = new char[n][n];
        for(int i=0; i<n;i++){
            String linha=stdin.nextLine();
            for(int j=0;j<n;j++){
                tabuleiro[i][j]=linha.charAt(j);
            }
        }
        String resultado = analisarTabuleiro(tabuleiro);
        System.out.println(resultado);

        stdin.close();
    }
    public static String analisarTabuleiro(char[][] tabuleiro){
        int n=tabuleiro.length;

        for(int i=0;i<n;i++){
            boolean linhaX=true;
            boolean colunaX=true;
            boolean linhaO=true;
            boolean colunaO=true;
            
            for(int j=0;j<n;j++){
                if(tabuleiro[i][j]!='X'){
                    linhaX=false;
                }
                if(tabuleiro[i][j]!='O'){
                    linhaO=false;
                }
                if(tabuleiro[j][i]!='X'){
                    colunaX=false;
                }
                if(tabuleiro[j][i]!='O'){
                    colunaO=false;
                }
            }
            if (linhaX || colunaX){
                return "Ganhou o X";
            }
            if(linhaO || colunaO){
                return "Ganhou o O";
            }
        }

        boolean diagonalPrincipalX=true;
        boolean diagonalPrincipalO=true;
        boolean diagonalSecundariaX=true;
        boolean diagonalSecundariaO=true;
        for(int i=0;i<n;i++){
            if(tabuleiro[i][i] != 'X'){
                diagonalPrincipalX=false;
            }
            if(tabuleiro[i][i]!='O'){
                diagonalPrincipalO=false;
            }
            if(tabuleiro[i][n-1-i]!='X'){
                diagonalSecundariaX=false;
            }
            if(tabuleiro[i][n-1-i]!='O'){
                diagonalSecundariaO=false;
            }
        }
        if(diagonalPrincipalX || diagonalSecundariaX){
            return "Ganhou o X";
        }
        if(diagonalPrincipalO || diagonalSecundariaO){
            return "Ganhou o O";
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(tabuleiro[i][j]=='.'){
                    return "Jogo incompleto";
                }
            }
        }
        return "Empate";
    }
}