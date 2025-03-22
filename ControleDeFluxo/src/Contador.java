import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) throws ParametrosInvalidosException {
        //rodar programa
        contar();
    }
    public static void contar() throws ParametrosInvalidosException {
        Scanner getData = new Scanner(System.in);
        System.out.println(
                "Digite dois parâmetros, a subtração do primeiro elemento e " +
                "do segundo resultará no número de prints....teste");
        try {
            //primeiro número
            System.out.print("Número 1 = ");
            int first = getData.nextInt();
            getData.nextLine();

            //segundo número
            System.out.print("Número 2 = ");
            int second = getData.nextInt();
            getData.nextLine();

            if (first < second) {
                throw new ParametrosInvalidosException(first, second);
            }
            int count = first - second;
            for (int i = 0; i < count; i++) {
                System.out.println("Imprimindo número " + (i + 1));
            }

        } catch (InputMismatchException e) {
            System.out.println("Digite um número INTEIRO");
        }
    }
}