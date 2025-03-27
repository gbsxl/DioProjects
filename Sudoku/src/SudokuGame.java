import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SudokuGame {
    private BigSquare boardGame;
    private Scanner scanner;

    public static void main(String[] args) {
        SudokuGame game = new SudokuGame();
        game.start();
    }

    public SudokuGame() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            displayMainMenu();
            int choice = getValidatedInput(1, 5);

            switch (choice) {
                case 1:
                    startNewGame();
                    break;
                case 2:
                    if (boardGame != null) {
                        playGame();
                    } else {
                        System.out.println("Please start a new game first.");
                    }
                    break;
                case 3:
                    showAvailableNumbers();
                    break;
                case 4:
                    removeNumber();
                    break;
                case 5:
                    System.out.println("Thanks for playing! Goodbye.");
                    return;
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n==== SUDOKU GAME ====");
        System.out.println("1. Start New Game");
        System.out.println("2. Play Game");
        System.out.println("3. Show Available Numbers");
        System.out.println("4. Remove Number");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private void startNewGame() {
        System.out.println("\nSelect Difficulty:");
        System.out.println("1. Empty");
        System.out.println("2. Easy");
        System.out.println("3. Mid Level");
        System.out.println("4. Hard");
        System.out.println("5. Impossible");

        int difficultyChoice = getValidatedInput(1, 5);
        GameLevel selectedLevel;

        switch (difficultyChoice) {
            case 1: selectedLevel = GameLevel.EMPTY; break;
            case 2: selectedLevel = GameLevel.EASY; break;
            case 3: selectedLevel = GameLevel.MIDLEVEL; break;
            case 4: selectedLevel = GameLevel.HARD; break;
            case 5: selectedLevel = GameLevel.IMPOSSIBLE; break;
            default: selectedLevel = GameLevel.EASY;
        }

        boardGame = generateGame(selectedLevel);
        System.out.println("New game started with " + selectedLevel + " difficulty!");
    }

    private void playGame() {
        while (true) {
            viewBoard();
            System.out.println("\nEnter move (row column number) or '0 0 0' to return to main menu:");

            try {
                int row = scanner.nextInt() - 1;
                int column = scanner.nextInt() - 1;
                int number = scanner.nextInt();

                if (row == -1 && column == -1 && number == 0) {
                    break;
                }

                if (row < 0 || row >= 9 || column < 0 || column >= 9) {
                    System.out.println("Invalid row or column. Must be between 1-9.");
                    continue;
                }

                if (addNumber(number, row, column)) {
                    System.out.println("Number added successfully!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter three integers.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private void showAvailableNumbers() {
        if (boardGame == null) {
            System.out.println("Start a game first!");
            return;
        }

        System.out.println("Enter row and column to check available numbers:");
        int row = scanner.nextInt() - 1;
        int column = scanner.nextInt() - 1;

        if (row < 0 || row >= 9 || column < 0 || column >= 9) {
            System.out.println("Invalid row or column. Must be between 1-9.");
            return;
        }

        List<Integer> availableNumbers = numbersAvailable(row, column);
        System.out.println("Available numbers for this cell: " + availableNumbers);
    }

    private void removeNumber() {
        if (boardGame == null) {
            System.out.println("Start a game first!");
            return;
        }

        System.out.println("Enter row and column to remove number:");
        int row = scanner.nextInt() - 1;
        int column = scanner.nextInt() - 1;

        if (row < 0 || row >= 9 || column < 0 || column >= 9) {
            System.out.println("Invalid row or column. Must be between 1-9.");
            return;
        }

        removeNumber(row, column);
        System.out.println("Number removed successfully!");
    }

    private int getValidatedInput(int min, int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.print("Invalid input. Please enter a number between " + min + " and " + max + ": ");
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    public SudokuGame(GameLevel gameLevel) {
        this.boardGame = generateGame(gameLevel);
    }

    public boolean addNumber(int number, int row, int column) {
        if (!(boardGame.bigSquare[row][column].getNumber() == 0)) {
            System.out.println("First remove the number " + boardGame.bigSquare[row][column].getNumber() + " to add another in its place");
            return false;
        } else if (!(checkColumn(number, column))) {
            System.out.println("There's the same number in the column that you tried to add " + number);
            return false;
        } else if (!(checkRow(number, row))) {
            System.out.println("There's the same number in the row that you tried to add " + number);
            return false;
        } else if (!(checkSquare(number, row, column))) {
            System.out.println("There's the same number in the square that you tried to add " + number);
            return false;
        } else if (number >= 1 && number <= 9) {
            boardGame.bigSquare[row][column].setNumber(number);
            return true;
        }
        return false;
    }

    private boolean checkColumn(int number, int column) {
        List<Integer> selectedColumn = Stream.of(boardGame.bigSquare)
                .map(row -> row[column])
                .map(miniSquare::getNumber)
                .collect(Collectors.toList());
        return !selectedColumn.contains(number);
    }

    private boolean checkRow(int number, int row) {
        List<Integer> selectedRow = Stream.of(boardGame.bigSquare[row])
                .map(miniSquare::getNumber)
                .collect(Collectors.toList());
        return !selectedRow.contains(number);
    }

    private boolean checkSquare(int number, int row, int column) {
        int squareIndex = ((row / 3) * 3 + (column / 3));
        int[] squareSelect = boardGame.square.get(squareIndex);
        for (int i = squareSelect[0]; i <= squareSelect[3]; i++) {
            for (int j = squareSelect[1]; j <= squareSelect[2]; j++) {
                if (boardGame.bigSquare[i][j].getNumber() == number) {
                    return false;
                }
            }
        }
        return true;
    }

    public void removeNumber(int row, int column) {
        if (boardGame.bigSquare[row][column].getNumber() == 0) {
            System.out.println("This cell is already empty");
        } else {
            boardGame.bigSquare[row][column].setNumber(0);
        }
    }

    public void viewBoard() {
        System.out.println("\n  1 2 3 | 4 5 6 | 7 8 9");
        System.out.println(" -------------------------");

        for (int i = 0; i < boardGame.ROW; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < boardGame.COLUMN; j++) {
                int value = boardGame.bigSquare[i][j].getNumber();
                // Print 0 as empty space, colored differently for better visibility
                System.out.print(value == 0 ? ". " : value + " ");

                // Add vertical separators every 3 columns
                if ((j + 1) % 3 == 0 && j < 8) {
                    System.out.print("| ");
                }
            }
            System.out.println();

            // Add horizontal separators every 3 rows
            if ((i + 1) % 3 == 0 && i < 8) {
                System.out.println(" -------------------------");
            }
        }
    }

    public BigSquare generateGame(GameLevel gameLevel) {
        BigSquare newBoard = new BigSquare();

        if (gameLevel == GameLevel.EMPTY) {
            return newBoard;
        }

        Random random = new Random();
        int attempts = 0;
        int valuesToGenerate = gameLevel.getValuesToGenerate();

        while (attempts < valuesToGenerate) {
            int row = random.nextInt(9);
            int column = random.nextInt(9);
            int number = random.nextInt(1, 10);

            if (newBoard.bigSquare[row][column].getNumber() == 0 &&
                    checkColumn(number, column) &&
                    checkRow(number, row) &&
                    checkSquare(number, row, column)) {

                newBoard.bigSquare[row][column].setNumber(number);
                attempts++;
            }
        }

        return newBoard;
    }

    public List<Integer> numbersAvailable(int row, int column) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (checkColumn(i, column) && checkRow(i, row) && checkSquare(i, row, column)) {
                numbers.add(i);
            }
        }
        return numbers;
    }

    public enum GameLevel {
        EMPTY(0), EASY(40), MIDLEVEL(35), HARD(30), IMPOSSIBLE(20);

        private final int valuesToGenerate;

        GameLevel(int valuesToGenerate) {
            this.valuesToGenerate = valuesToGenerate;
        }

        public int getValuesToGenerate() {
            return valuesToGenerate;
        }
    }

    public static class BigSquare {
        final int ROW = 9;
        final int COLUMN = 9;
        List<int[]> square = new ArrayList<>();
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

    public static class miniSquare {
        private int number = 0;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return number + ", ";
        }
    }
}