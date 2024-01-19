import java.util.Scanner;

public class Matrix {
    int data[][]; // os elementos da matriz em si
    int rows;     // numero de linhas
    int cols;     // numero de colunas

    // construtor padrao de matriz
    Matrix(int r, int c) {
        data = new int[r][c];
        rows = r;
        cols = c;
    }

    // Ler os rows x cols elementos da matriz
    public void read(Scanner in) {
        for (int i=0; i<rows; i++)
            for (int j=0; j<cols; j++)
                data[i][j] = in.nextInt();
    }

    // Representacao em String da matriz
    public String toString() {
        String ans = "";
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++)
                ans += data[i][j] + " ";
            ans += "\n";
        }
        return ans;
    }
    
    public static Matrix identity(int n){
        Matrix identity= new Matrix(n,n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==i){
                    identity.data[i][j]=1;
                }
                else{
                    identity.data[i][j]=0;
                }
            }
        }
        return identity;
    }

    public Matrix transpose(){
        Matrix transpose=new Matrix(cols,rows);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                transpose.data[j][i]=data[i][j];
            }
        }
        return transpose;
    }

    public Matrix sum(Matrix m){
        Matrix matrixsum=new Matrix(rows,cols);
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++){
                matrixsum.data[i][j]=data[i][j]+m.data[i][j];
            }
        return matrixsum;         
    }

    public Matrix multiply(Matrix m){
        Matrix multiply=new Matrix(rows,m.cols);
        for(int i=0;i<rows;i++){
            for(int j=0;j<m.cols;j++){
                for(int k=0;k<cols;k++){
                    multiply.data[i][j] += data[i][k] * m.data[k][j];
                }
            }
        }
        return multiply;
    }
}
