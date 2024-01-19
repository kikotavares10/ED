package Ficha3;
import java.util.Scanner;

class Game {
    final char DEAD = '.';
    final char ALIVE = 'O';
    private int rows,cols;
    private char m[][];

    Game(int r,int c){
        rows=r;
        cols=c;
        m=new char[r][c];
    }

    public void read(Scanner in){
        for(int i=0;i<rows;i++)
            m[i]=in.next().toCharArray();
    }

    public void write(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.println(m[i][j]);
            }
            System.out.println();
        }
    }

    private int countAlive(int y, int x){
        int count=0;
        for(int i=y-1;i<=y+1;i++){
            for(int j=x-1;j<=x+1;j++){
                if(i>=0 && i<rows && j>=0 && j<cols){
                    if(m[i][j]==ALIVE){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void iterate(){
        char m2[][]=new char[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(m[i][j]==ALIVE){
                    if(countAlive(i,j)<2){
                        m2[i][j]=DEAD;
                    }
                    else if(countAlive(i,j)>=4){
                        m2[i][j]=DEAD;
                    }
                    else if(countAlive(i,j)==2 || countAlive(i,j)==3){
                        m2[i][j]=ALIVE;
                    }
                    else{
                        if(countAlive(i,j)==3){
                            m2[i][j]=ALIVE;
                        }
                        else{
                            m2[i][j]=DEAD;
                        }                        
                        
                    }
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                m[i][j]=m2[i][j];
            }
        }
    }
}
public class ED088 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int rows=in.nextInt();
        int cols = in.nextInt();
        int n=in.nextInt();

        Game g = new Game(rows, cols);
        g.read(in);
        for(int i=0;i<n;i++){
            g.iterate();
        }
        g.write();
    }
}
