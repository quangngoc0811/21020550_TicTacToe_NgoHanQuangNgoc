public class Cell {
    private CellStatus status = CellStatus.EMPTY;
    
    public void setStatus(CellStatus status1) {
        this.status  = status1;
    }
    public CellStatus getStatus() {
        return this.status;
    }
}