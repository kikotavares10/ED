package Ficha9;

import java.util.Scanner;

class ED200 {
    static int rows;
    static int cols;
    static char m[][];
    static boolean visited[][];
    public static int t(int y, int x){
        if(y<0 || y>=rows || x<0 || x>=cols) return 0;
        if (visited[y][x]) return 0;
        if(m[y][x]=='.') return 0;
        int count=1;
        visited[y][x]=true;
        count += t(y-1,x);
        count += t(y+1,x);
        count += t(y,x-1);
        count += t(y,x+1);
        count += t(y+1,x+1);
        count += t(y+1,x-1);
        count += t(y-1,x-1);
        count += t(y-1,x+1);
        return count;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n= in.nextInt();
        in.nextLine();
        
        for(int k=0;k<n;k++){
            rows=in.nextInt();
            cols=in.nextInt();
            int max_bacterias=0;
            m=new char[rows][cols];
            visited=new boolean[rows][cols];

            for (int p=0;p<rows;p++){
                m[p]=in.next().toCharArray();
            }
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    int bacterias=t(i,j);
                    max_bacterias=Math.max(max_bacterias,bacterias);
                }
            }
            System.out.println(max_bacterias);
        }
        in.close();
    }
    
}
