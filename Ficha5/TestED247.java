package Ficha5;

public class TestED247{
    public static void main(String[] args){
        IntSet s1= new BooleanArrayIntSet(100);
        IntSet s2 = new BooleanArrayIntSet(100);
        IntSet s4 = new BooleanArrayIntSet(100);
    

        for(int i=1;i<=5;i++)
            s1.add(i);
        System.out.println("s1= "+ s1 + " | tamanho= " + s2.size());

        for(int i=3;i<=7;i++)
            s2.add(i);
        System.out.println("s2 = " + s2 + " | tamanho " + s2.size());

        System.out.println("s1.equals(s2) = " + s1.equals(s2));

        System.out.println(s4=s1.intersection(s2));

        System.out.println(s1.contains(2));
        System.out.println(s4.contains(2));

    }
}