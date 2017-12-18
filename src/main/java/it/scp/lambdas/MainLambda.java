package it.scp.lambdas;

public class MainLambda {


    public static void main (String...args) {
        Thread t = new Thread(() -> System.out.print("Ciaociao"));
        t.start();
    }

    FuncInterface pieceOfCode = (int a, int b) -> (a + b);

}
