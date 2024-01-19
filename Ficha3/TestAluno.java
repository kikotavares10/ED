 // Uma classe simples para representar um aluno
class Aluno {
   // Atributos da classe (variáveis para conter informação)
   String nome;
   int numero;
   int ano() {
   return numero / 100000;
    }

   // Construtor "padrão"
   Aluno() {
      nome   = "indefinido";
      numero = -1;
   }
   Aluno(String n, int mec) {
   nome = n;
   numero = mec;
    }
}

// Classe principal contendo o main para testar a classe Aluno
public class TestAluno {
   public static void main(String[] args) {
        Aluno a = new Aluno();
      
        System.out.println("a.nome = " + a.nome);
        System.out.println("a.numero = " + a.numero);
        System.out.println("a = " + a);

        Aluno g = new Aluno("Ana", 201408762);
        Aluno h = new Aluno("Bruno", 201508145);
        System.out.println(g.ano() + " " + h.ano());
   }
}
