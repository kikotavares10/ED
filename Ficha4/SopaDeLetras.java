import java.util.Scanner;

public class SopaDeLetras{
    public static void searchWord(char[][] matrix, String word){
        int rows=matrix.length;
        int cols=matrix[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(matrix[r][c]==word.charAt(0)){
                    for(int direction=0;direction<4;direction++){
                        int dr,dc;
                        if(direction==1){
                            dr=-1;
                            dc=0;
                        }
                        else if(direction==2){
                            dr=0;
                            dc=-1;
                        }
                        else if(direction==3){
                            dr=1;
                            dc=0;
                        }
                        else{
                            dr=0;
                            dc=1;
                        }

                        boolean found=true;
                        for(int i=1;i<word.length();i++){
                            int nr=r+i*dr;
                            int nc=c+i * dc;
                            if(nr<0 || nr>=rows ||nc<0 || nc>=cols || matrix[nr][nc] != word.charAt(i)){
                                found=false;
                                break;
                            }
                        }
                        if(found){
                            for(int i=0;i<word.length();i++){
                                int nr=r+i*dr;
                                int nc=c+i*dc;
                                matrix[nr][nc]=word.charAt(i);
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner stdin=new Scanner(System.in);
        int caseNumber=1;

        while(true){
            int lines=stdin.nextInt();
            int cols=stdin.nextInt();
            
            if(lines==0 && cols==0){
                break;
            }

            char[][] matrix=new char[lines][cols];

            for(int i=0;i<lines;i++){
                String row=stdin.next();
                matrix[i]=row.toCharArray();
            }

            int n=stdin.nextInt();
            stdin.nextLine();
            String[] words = new String[n];

            for(int i=0;i<n;i++){
                words[i]=stdin.nextLine();
            }

            System.out.println("Input #" + caseNumber);
            caseNumber++;

            for(String word : words){
                searchWord(matrix, word);
            }

            for(int i=0;i<lines;i++){
                for(int j=0;j<cols;j++){
                    if(matrix[i][j]=='.'){
                        System.out.print(matrix[i][j]);
                    }
                    else{
                        System.out.print(matrix[i][j]);
                    }
                }
                System.out.println();
            }
        }
        stdin.close();
    }
}
