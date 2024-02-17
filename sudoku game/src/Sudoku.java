import java.util.InputMismatchException;
import java.util.Scanner;

class Number_Exception extends Exception {
    public Number_Exception(String s) {
        super(s);
    }
}

class Row_Exception extends Exception {
    public Row_Exception(String s) {
        super(s);
    }
}

class Column_Exception extends Exception {
    public Column_Exception(String s) {
        super(s);
    }
}

class Square_Exception extends Exception {
    public Square_Exception(String s) {
        super(s);
    }
}

public class Sudoku {
    private int[][] chart = new int[9][9];
    private int[][] helpful_friend = new int[3][3];
    private int Win_Law = 0;
    public boolean playing = true;

    public int getWin_Law() {
        return Win_Law;
    }

    public void Show_chart() {
        for (int i = 0; i < chart.length; i++) {
            for (int j = 0; j < chart[i].length; j++) {
                System.out.print(chart[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean hasDuplicatesInColumn(int[][] inArray) {
        for (int row = 0; row < inArray.length; row++) {
            for (int col = 0; col < inArray[row].length; col++) {
                int num = inArray[row][col];
                for (int otherRow = row + 1; otherRow < inArray.length; otherRow++) {
                    if (num == inArray[otherRow][col] && num != 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasDuplicatesInRows(int[][] inArray) {
        for (int[] ints : inArray) {
            for (int col = 0; col < ints.length; col++) {
                int num = ints[col];
                for (int otherCol = col + 1; otherCol < inArray.length; otherCol++) {
                    if (num == ints[otherCol] && num != 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasDuplicatesInSquare(int[][] inArray) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int num = inArray[row][col];
                for (int k = 0; k < 3; k++) {
                    for (int i = 0; i < 3; i++) {
                        if (row == k && col == i) {
                            continue;
                        } else if (num == inArray[k][i] && num != 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void Game_Setup() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("enter your coordinate!");
            int x = input.nextInt();
            int y = input.nextInt();

            System.out.println("set your number between 1 to 9!");
            int answer = input.nextInt();

            if (answer > 9 || answer < 1) {
                throw new Number_Exception("number should be between 1 to 9!");
            }
            chart[x][y] = answer;

            if (hasDuplicatesInRows(chart)) {
                throw new Row_Exception("duplicated number detected in row!");
            } else if (hasDuplicatesInColumn(chart)) {
                throw new Column_Exception("duplicated number detected in column!");
            } else {
                Win_Law++;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            helpful_friend[k][l] = chart[(3 * i) + k][(3 * j) + l];
                        }
                    }
                    if (hasDuplicatesInSquare(helpful_friend)) {
                        throw new Square_Exception("duplicated number detected in square!");
                    } else {
                        Win_Law++;
                    }
                }
            }
            if (Win_Law == 81) {
                System.out.println("GAME FINISHED!");
                playing = false;
            }
            // Show_chart();

        } catch (ArrayIndexOutOfBoundsException | Column_Exception | Row_Exception | Square_Exception e) {
            System.out.println(e);
            System.out.println("try again!");
            Game_Setup();

        } catch (InputMismatchException | Number_Exception e) {
            System.out.println(e);
            Game_Setup();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        Scanner in = new Scanner(System.in);
        while (true) {
            if (s.playing) {
                System.out.println("1)START\n2)Show Chart\n3)END");
                int aw = in.nextInt();
                switch (aw) {
                    case 1:
                        // s.Show_chart();
                        s.Game_Setup();
                        break;
                    case 2:
                        s.Show_chart();
                        break;
                    case 3:
                        return;
                }
            }else {
                System.out.println("Game has already finished!");
                return;
            }
        }
    }
}