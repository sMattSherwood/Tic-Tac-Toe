package comp210.sherwood;

public class square {

    int col;
    int row;
    int reasourceId;

    // Square constructor for the rows and collumn
    public square(int col, int row) {
        this.col = col;
        this.row = row;
    }

    // setter for reasource id
    public void setReasourceId(int reasourceId) {
        this.reasourceId = reasourceId;
    }
}
