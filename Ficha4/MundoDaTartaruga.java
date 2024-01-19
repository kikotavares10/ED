import java.util.Scanner;

class Turtle{
    final int MAX_ROWS =100;
    final int MAX_COLS=100;
    int rows,cols;
    char[][] grid=new char[MAX_ROWS][MAX_COLS];
    int x,y;
    boolean PenDown;
    char direction;

    Turtle(int rows,int cols){
        x=0;
        y=0;
        PenDown=false;
        direction='E';
    }
    void move(int steps){
        int dx=0,dy=0;
        if(direction=='N') dy=-1;
        else if(direction=='S') dy=1;
        else if(direction=='W') dx=-1;
        else if(direction=='E')dx=1;

        while(steps>0){
            if(PenDown){
                grid[y][x]='*';
            }

            x+=dx;
            y+=dy;

            if(x<0) x=0;
            if(x>=cols) x=cols-1;
            if(y<0) y=0;
            if(y>=rows) y=rows-1;
            steps--;
        }
    }

    void Esq(){
        if(direction=='N') direction='W';
        else if(direction=='S') direction='E';
        else if(direction=='W') direction ='S';
        else if(direction =='E') direction='N';
    }
    void Dir(){
        if(direction=='N') direction='E';
        else if(direction=='S') direction='W';
        else if(direction == 'W') direction='N';
        else if(direction == 'E') direction = 'S';
    }
    void Pen(){
        PenDown=!PenDown;
    }

    void DisplayGrid(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}

public class MundoDaTartaruga{
    public static void main(String[] args){
        Scanner stdin=new Scanner(System.in);
        int flag=stdin.nextInt();
        int rows=stdin.nextInt();
        int cols=stdin.nextInt();
        Turtle turtle=new Turtle(rows,cols);

        while(true){
            String command = stdin.next();

            if(command.equals("end")){
                break;
            }
            if(command.equals("U")){
                turtle.Pen();
            }
            else if(command.equals("D")){
                turtle.Pen();
            }
            else if(command.equals("L")){
                turtle.Esq();
            }
            else if(command.equals("R")){
                turtle.Dir();
            }
            else if(command.charAt(0)=='F'){
                int steps=Integer.parseInt(command.substring(2));
                turtle.move(steps);
            }
        }

        if(flag==0){
            turtle.DisplayGrid();
        }
        else if(flag==1){
            int marked=0;
            int unmarked=0;
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(turtle.grid[i][j]=='*'){
                        marked++;
                    }
                    else{
                        unmarked++;
                    }
                }
            }
            int total=marked+unmarked;
            System.out.println((100.0*marked/total)+" "+unmarked+" "+ marked);
        }
        else if(flag==2){
            int padraoRows=stdin.nextInt();
            int padraoCols=stdin.nextInt();
            char[][] padrao = new char[padraoRows][padraoCols];
            for(int i=0;i<padraoRows;i++){
                String line=stdin.next();
                padrao[i]=line.toCharArray();            }


            boolean found=false;
            for(int i=0;i<=rows-padraoRows;i++){
                for(int j=0;j<=cols-padraoCols;j++){
                    boolean match=true;
                    for(int k=0;k<padraoRows;k++){
                        for(int l=0;l<padraoCols;l++){
                            if(padrao[k][l]=='*' && turtle.grid[i+k][j+l]!='*'){
                                match=false;
                                break;
                            }
                        }
                        if(!match){
                        break;
                        }
                    }
                    if(match){
                        found=true;
                        break;
                    }
                }
                if(found){
                    break;
                }
            }
            if(found){
                System.out.println("Sim");
            }
            else{
                System.out.println("Nao");
            }
        }
    }
}