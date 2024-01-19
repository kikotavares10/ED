package Ficha4;
import java.util.Scanner;

class Game{
    private int n;
    private char[][] m;

    Game(int n){
        this.n = n;
        m= new char[n][n];
    }

    void read(Scanner in){
        for(int i=0; i<n; i++){
            String buf = in.next();
            for(int j=0; j<n; i++){
                m[i][j] = buf.charAt(j);
            }
        }
    }

    void show(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }

    void verify(int y, int x, int incy, int incx){
        if(m[y][x] == '.') return;
        for(int i=0, yy=y, xx=x; i<n; i++, yy+= incy, xx+=incx ){
            if (m[y][x] != m[yy][xx]) return;
        }
        win(m[y][x]);
    }

    void win(char player){
        System.out.println("Ganhou o" + player);
        System.exit(0);
    }

    void check(){
        for(int i=0; i<n; i++) verify(i, 0, 0, 1); //linhas
        for(int j=0;j<n;j++) verify(0, j, 1, 0); //colunas
        verify(0,0,1,1); //Diagonal1
        verify(n-1, 0,-1,1); //Diagonal2

        if (finished()) System.out.println("Empate");
        else System.out.println("Jogo incompleto");
    }

    boolean finished(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(m[i][j]=='.')
                    return false;
            }
        }
        return true;
    }
}

public class ED004 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Game g = new Game(n);
        g.read(in);
        //g.show();
        g.check();
    }
}
