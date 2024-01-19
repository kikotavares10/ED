import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        Game g = new Game(n);
        g.read(in);
        g.check();
    }
}

class Game{
    private int n;
    private char m[][];

    Game(int size){
        n=size;
        m=new char[n][n];
    }

    void read(Scanner in){
        for(int i=0;i<n;i++){
            String buf=in.next();
            for(int j=0;j<n;j++)
                m[i][j]=buf.charAt(j);
        }
    }

    void verify(int y, int x, int incy, int incx){
        if(m[y][x]=='.') return;
        for(int i=0,yy=y, xx=x; i<n;i++, yy+=incy, xx+=incx)
            if(m[y][x] != m[yy][xx]) return;
        win(m[y][x]);
    }

    void win(char player){
        System.out.println("Ganhou o "+ player);
        System.exit(0);
    }

    void check(){
        for(int i=0;i<n;i++) verify(i,0,0,1);
        for(int j=0;j<n;j++) verify(0,j,1,0);

        verify(0,0,1,1);
        verify(0,n-1,1,-1);

        if(!finished()) System.out.println("Jogo incomleto");
        else System.out.println("Empate");
    }

    boolean finished(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(m[i][j]=='.') return false;
            }
        }
        return true;
    }
}
