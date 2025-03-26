import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BigSquare {
    final int ROW = 9;
    final int COLUMN = 9;
    List<int[]> square = new ArrayList<int[]>();
    miniSquare[][] bigSquare = new miniSquare[ROW][COLUMN];

    public BigSquare() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                bigSquare[i][j] = new miniSquare();
            }
        }
        square.add(new int[]{0, 0, 2, 2}); //0
        square.add(new int[]{0, 3, 2, 5});
        square.add(new int[]{0, 6, 2, 8});

        square.add(new int[]{3, 0, 5, 2});
        square.add(new int[]{3, 3, 5, 5});
        square.add(new int[]{3, 6, 5, 8});

        square.add(new int[]{6, 0, 8, 2});
        square.add(new int[]{6, 3, 8, 5});
        square.add(new int[]{6, 6, 8, 8}); // 8
    }
}
