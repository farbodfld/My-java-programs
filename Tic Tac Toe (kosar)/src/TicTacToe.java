import javax.xml.xpath.XPath;
import java.util.Scanner;

class IllegalPosException extends Exception {
    public IllegalPosException(String massage) {
        System.out.println(massage);
    }
}

class FullSpaceException extends Exception {
    public FullSpaceException(String massage) {
        System.out.println(massage);
    }
}

class StupidPlayerException extends Exception {
    public StupidPlayerException(String massage) {
        System.out.println(massage);
    }
}

public class TicTacToe {
    static char[][] table = new char[3][3];
    boolean X_player = true;
    int counter = 0;

    public static void drawtable() {
        System.out.println("-------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j] = '.');
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    public void playGame() throws IllegalPosException, FullSpaceException {
        Scanner scan = new Scanner(System.in);

        int row = scan.nextInt();
        int col = scan.nextInt();

        if ((row >= 3 || row < 0 || col < 0 || col >= 3)) {
            throw new IllegalPosException("invalid index...try again");
        } else if ((table[row][col] == 'X' && X_player) || (table[row][col] == 'O' && X_player)
                || (table[row][col] == 'X' && !X_player) || (table[row][col] == 'O' && !X_player)) {
            throw new FullSpaceException("FullSpaceException...try again");
        } else {
            if (counter < 3) {
                if (X_player) {
                    table[row][col] = 'X';
                    X_player = false;
                } else {
                    table[row][col] = 'O';
                    X_player = true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }

    }

    public static boolean WinX() {
        int countX = 0;
        int j;
        for (int i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (table[i][j] == 'X') {
                    countX++;
                    if (countX == 3) {
                        return true;
                    }
                }
            }
            countX = 0;
            j = 0;
        }
        if (table[0][0] == 'X' && table[1][0] == 'X' && table[2][0] == 'X') {
            return true;
        }
        if (table[0][1] == 'X' && table[1][1] == 'X' && table[2][1] == 'X') {
            return true;
        }
        if (table[0][2] == 'X' && table[1][2] == 'X' && table[2][2] == 'X') {
            return true;
        }
        if (table[0][0] == 'X' && table[1][1] == 'X' && table[2][2] == 'X') {
            return true;
        }
        if (table[0][2] == 'X' && table[1][1] == 'X' && table[2][0] == 'X') {
            return true;
        }
        return false;
    }

    public static boolean WinO() {
        int countO = 0;
        int j;
        for (int i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (table[i][j] == 'O') {
                    countO++;
                    if (countO == 3) {
                        return true;
                    }
                }
            }
            countO = 0;
            j = 0;
        }
        if (table[0][0] == 'O' && table[1][0] == 'O' && table[2][0] == 'O') {
            return true;
        }
        if (table[0][1] == 'O' && table[1][1] == 'O' && table[2][1] == 'O') {
            return true;
        }
        if (table[0][2] == 'O' && table[1][2] == 'O' && table[2][2] == 'O') {
            return true;
        }
        if (table[0][0] == 'O' && table[1][1] == 'O' && table[2][2] == 'O') {
            return true;
        }
        if (table[0][2] == 'O' && table[1][1] == 'O' && table[2][0] == 'O') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        game.drawtable();

        while (true) {
            try {
                game.playGame();
            } catch (IllegalPosException e) {
                game.counter++;
                try {
                    if (game.counter >= 3) {
                        throw new StupidPlayerException("StupidPlayerException...");
                    }
                } catch (StupidPlayerException s) {
                    if (game.X_player) {
                        System.out.println("X player won the game.");
                        return;
                    } else {
                        System.out.println("O player won the game.");
                        return;
                    }
                }
            } catch (FullSpaceException e) {
                System.out.println(e);
            }
        }
    }
}
