public class Board {
    public Cell board[][]= new Cell[3][3];

    public Board(CellStatus status) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3;j++) {
                Cell c = new Cell();
                c.setStatus(status);
                this.board[i][j] = c;
            }
        }
    }

    public boolean choose(int row, int col) {
        if (this.board[row-1][col-1].getStatus() != CellStatus.EMPTY) {
            return false;
        }
        return true;
    }

    public boolean check(int row, int col, CellStatus status) {
        this.board[row-1][col-1].setStatus(status);
        return true;
    }

    public void printBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3;j++) {
                CellStatus c = this.board[i][j].getStatus();
                System.out.print("[");
                if(c != CellStatus.EMPTY) System.out.print(c);
                else System.out.print(" ");
                System.out.print("]");
            }
            System.out.print("\n");
        }
    }
    public boolean checkWin() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3;j++) {
                if (board[i][j].getStatus() != CellStatus.EMPTY) {
                    // if ( i>0 && j >0 ) continue;
                    // System.out.println(i + "______" + j + "____" + board[i][j].getStatus());
                    if (i == 0) {
                        if ((board[i][j].getStatus() == board[i + 1][j].getStatus() && board[i + 1][j].getStatus() == board[i + 2][j].getStatus()))
                        {
                            return true;
                        }
                    }
                    if (j==0) {
                        if ((board[i][j].getStatus() == board[i][j + 1].getStatus() && board[i][j + 1].getStatus() == board[i][j + 2].getStatus()))
                        {
                            return true;
                        }
                    }
                    if (i==0 && j == 0) {
                        if ((board[i][j].getStatus() == board[i + 1][j + 1].getStatus() && board[i + 1][j + 1].getStatus() == board[i + 2][j + 2].getStatus()))
                        {
                            return true;
                        }
                    }
                    if  ((i==0 && j==2)) {
                        if (board[i][j].getStatus() == board[i + 1][j - 1].getStatus() && board[i + 1][j - 1].getStatus() == board[i + 2][j - 2].getStatus()) {
                            return true;
                        }
                    }
                }
            }
            // System.out.print("\n");
        }
        return false;
    }
    public boolean checkDraw(int count) {
        if(count >=9) {
            return true;
        }
        return false;
    }
}