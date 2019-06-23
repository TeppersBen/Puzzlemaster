package components;

public class TileLevel {

    private int id;
    private int rows;
    private int columns;
    private int[] activeTiles;

    public TileLevel(int id, int rows, int columns, int... activeTiles) {
        setId(id);
        setRows(rows);
        setColumns(columns);
        setActiveTiles(activeTiles);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int[] getActiveTiles() {
        return activeTiles;
    }

    public void setActiveTiles(int[] activeTiles) {
        this.activeTiles = activeTiles;
    }

    private String getTilesStringFormat() {
        String result = "";
        for (int tile : getActiveTiles()) {
           result += tile + "-";
        }
        return result.substring(0, result.length()-1);
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %s | Rows: %s | Columns: %s | ActiveTiles: %s",
                getId(), getRows(), getColumns(), getTilesStringFormat()
        );
    }
}
