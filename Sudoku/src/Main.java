import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BlocoMaior blocoMaior = new BlocoMaior();
        blocoMaior.addNumber(1, 0, 0); // Número 1 na linha 0, coluna 0
        blocoMaior.addNumber(2, 0, 1); // Número 2 na linha 0, coluna 1
        blocoMaior.addNumber(3, 0, 2); // Número 3 na linha 0, coluna 2
        blocoMaior.addNumber(4, 1, 0); // Número 4 na linha 1, coluna 0
        blocoMaior.addNumber(5, 1, 1); // Número 5 na linha 1, coluna 1
        blocoMaior.addNumber(6, 1, 2); // Número 6 na linha 1, coluna 2
        blocoMaior.addNumber(7, 2, 0); // Número 7 na linha 2, coluna 0
        blocoMaior.addNumber(8, 2, 1); // Número 8 na linha 2, coluna 1
        blocoMaior.addNumber(9, 2, 2); // Número 9 na linha 2, coluna 2
        blocoMaior.addNumber(1, 3, 3); // Número 1 na linha 3, coluna 3
        blocoMaior.addNumber(2, 3, 4); // Número 2 na linha 3, coluna 4
        blocoMaior.addNumber(3, 3, 5); // Número 3 na linha 3, coluna 5

        blocoMaior.addNumber(2, 0, 0); // test check remove - passed
        blocoMaior.addNumber(3, 0, 7); // test check row - passed
        blocoMaior.removeNumber(1, 1);// test remove - passed

        blocoMaior.addNumber(1, 3, 0); // test column - passed
        blocoMaior.addNumber(3, 1, 1); // test square - no passed - to revise
    }
}
