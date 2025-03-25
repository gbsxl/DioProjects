import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Data
public class BlocoMaior {
    final int ROW = 9;
    final int COLUMN = 9;
    List<int[]> square = new ArrayList<int[]>();

    Bloquinho[][] blocoMaior = new Bloquinho[ROW][COLUMN];

    public BlocoMaior() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                blocoMaior[i][j] = new Bloquinho();
            }
        }
        square.add(new int[]{0, 0, 2, 2});
        square.add(new int[]{0, 3, 2, 5});
        square.add(new int[]{0, 6, 2, 8});

        square.add(new int[]{3, 0, 5, 2});
        square.add(new int[]{3, 3, 5, 5});
        square.add(new int[]{3, 6, 5, 8});

        square.add(new int[]{6, 0, 8, 2});
        square.add(new int[]{6, 3, 8, 5});
        square.add(new int[]{6, 6, 8, 8});
    }

    void addNumber(int number, int row, int column){
        if(blocoMaior[row][column].getNumber() == 0 || checkColumn(number, column) ||
                checkRow(number, row) || checkSquare(number, row, column)){
            blocoMaior[row][column].setNumber(number);
        }
        else {
            System.out.println("LOG: Primeiro remova um número para adicionar outro no lugar");
        }
    }
    private boolean checkColumn(int number,int column){// retorna true se o NUMBER puder ser utilizado
        List<Integer> colunaSelecionada = Stream.of(blocoMaior)
                .map(linha -> linha[column])
                .map(Bloquinho::getNumber)
                .toList();
        return !(colunaSelecionada.contains(number));
    }
    private boolean checkRow(int number, int row){
        List<Integer> colunaSelecionada = Stream.of(blocoMaior[row])
                .map(Bloquinho::getNumber)
                .toList();
        return !(colunaSelecionada.contains(number));
    }
    private boolean checkSquare(int number, int row, int column){ //retorna true se o Number puder ser colocado
        //        square.add(new int[]{3, 3, 5, 5});
        int squareIndex = (row / 3) * 3 + (column/3);
        int[] squareSelect = square.get(squareIndex);
        for (int i = squareSelect[0]; i <squareSelect[3] ; i++) {
            for (int j = squareSelect[1]; j < squareSelect[2]; j++) {
                if(blocoMaior[i][j].getNumber() == number){
                    return false;
                }
            }
        }
        return true;
    }
    void removeNumber(){

    }
    void viewBoard(){
        //square.add(new int[]{3, 0  //   5, 2});
        //
    for (int k = 0; k < ROW ; k++) {
        int[] squareSelect = square.get(k);
        for (int i = squareSelect[0]; i <squareSelect[3] ; i++) {
            for (int j = squareSelect[1]; j < squareSelect[2]; j++) {
                System.out.println();
                }
            }
         }
    }
}
