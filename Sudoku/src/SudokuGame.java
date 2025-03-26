import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
public class SudokuGame {
    public SudokuGame(GameLevel gameLevel){
        this.boardGame = generateGame(gameLevel);
    }
    BigSquare boardGame = new BigSquare();
    boolean addNumber(int number, int row, int column){
        if (!(boardGame.bigSquare[row][column].getNumber() == 0)){
            System.out.println("First remove the number " + boardGame.bigSquare[row][column].getNumber() + " to add another in its place");
            return false;
        }else if (!(checkColumn(number, row))) {
            System.out.println("There's the same number on the column that you tried add " + number);
            return false;
        }else if (!(checkRow(number, row))) {
            System.out.println("There's the same number on the row that you tried add " + number);
            return false;
        }else if (!(checkSquare(number, row, column))) {
            System.out.println("There's the same number on the square that you tried add " + number);
            return false;
        }else if(boardGame.bigSquare[row][column].getNumber() == 0 && checkColumn(number, column) &&
                checkRow(number, row) && checkSquare(number, row, column)){
            boardGame.bigSquare[row][column].setNumber(number);
            return true;
        }
        return false;
    }
    private boolean checkColumn(int number, int column){// retorna true se o NUMBER puder ser utilizado
        List<Integer> colunaSelecionada = Stream.of(boardGame.bigSquare)
                .map(linha -> linha[column])
                .map(miniSquare::getNumber)
                .toList();
        return !(colunaSelecionada.contains(number));
    }
    private boolean checkRow(int number, int row){
        List<Integer> colunaSelecionada = Stream.of(boardGame.bigSquare[row])
                .map(miniSquare::getNumber)
                .toList();
        return !(colunaSelecionada.contains(number));
    }
    private boolean checkSquare(int number, int row, int column){ //retorna true se o Number puder ser colocado
        int squareIndex = ((row / 3) * 3 + (column/3));
        int[] squareSelect = boardGame.square.get(squareIndex);
        for (int i = squareSelect[0]; i <= squareSelect[3] ; i++) {
            for (int j = squareSelect[1]; j <= squareSelect[2]; j++) {
                if(boardGame.bigSquare[i][j].getNumber() == number){
                    return false;
                }
            }
        }
        return true;
    }
    void removeNumber(int row, int column){
        if(boardGame.bigSquare[row][column].getNumber() == 0){
            System.out.println("This number cannot be remove because there's no value on it");
        }
        else{
            boardGame.bigSquare[row][column].setNumber(0);
        }
    }
    void viewBoard(){
        for (int i = 0; i < boardGame.ROW; i++) {
            System.out.println("\n");
            for (int j = 0; j < boardGame.COLUMN; j++) {
                System.out.print(boardGame.bigSquare[i][j]);
            }
        }
    }
    BigSquare generateGame(GameLevel gameLevel){
        if (gameLevel == GameLevel.EMPTY){
            return boardGame;
        }
        Random random = new Random();
        for (int i = 0; i <= gameLevel.getValuesToGenerate(); i++) {
            int row = random.nextInt(0,9);
            int column = random.nextInt(0,9);
            int number = random.nextInt(1,9);
            boolean isValid = addNumber(number, row, column);
            if(!isValid){
                i--;
            }
        }
        return boardGame;
    }
    List<Integer> numbersAvaliable(int row, int column) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= boardGame.ROW; i++) {
            if (checkColumn(i, column) && checkRow(i, row) && checkSquare(i, row, column)) {
                numbers.add(i);
            }
        }
        System.out.println(numbers);
        return numbers;
    }
}
