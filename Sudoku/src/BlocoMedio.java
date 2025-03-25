import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BlocoMedio{
    final int ROW = 3;
    final int COLUMN = 3;
    Bloquinho[][] blocoMedio = new Bloquinho[ROW][COLUMN];


    void setValue(int number, int row, int column){
        if (blocoMedio[row][column].getNumber() == 0){
            blocoMedio[row][column].setNumber(number);
        }
    }
    int getValue(int row, int column){
        return this.blocoMedio[row][column].getNumber();
    }

    public BlocoMedio() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                blocoMedio[i][j] = new Bloquinho();
            }
        }
    }
}

