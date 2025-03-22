public class ParametrosInvalidosException extends Exception {
    private final int firstInt;
    private final int secondInt;

    public ParametrosInvalidosException(int firstInt, int secondInt) {
        this.firstInt = firstInt;
        this.secondInt = secondInt;
    }

    @Override
    public String toString() {
        return "Resultado de " + firstInt + " é menor que " + secondInt + ", o primeiro parâmetro DEVE ser maior que o segundo";
    }
}
