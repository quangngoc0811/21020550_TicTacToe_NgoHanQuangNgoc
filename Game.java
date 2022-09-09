import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe");
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        Board board = new Board(CellStatus.EMPTY);
        while (true) {
            CellStatus status;
            if (count%2 == 0) {
                status = CellStatus.X;
            } else status = CellStatus.O;
            System.out.print(status.toString());
            System.out.println("'s turn! Xin moi nhap toa do!");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            if (x==10) {
                break;
            }
            if(board.choose(x,y)) board.check(x,y,status);
            else { 
                System.out.println("Invalid move! Move again!");
                continue;
            }
            // System.out.println(board.choose(1,1));
            board.printBoard();
            if (board.checkWin()) {
                System.out.print(status.toString() + " won the game!");
                break;
            }
            count++;
            if (board.checkDraw(count)) {
                System.out.print("DRAWWWWWWWW!");
                break;
            }
        }
    }
}