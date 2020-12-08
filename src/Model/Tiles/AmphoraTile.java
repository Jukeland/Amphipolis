package Model.Tiles;

public class AmphoraTile extends FindingTile{
    private AmphoraTileColor color;

    /**Constructor.
     * <b>Postcondition:</b> creates a new Amphora tile.
     * @param col
     */
    public AmphoraTile(AmphoraTileColor col){
        super(TileType.AMPHORA);
        setColor(col);
    }

    /**
     * <b>Transformer:</b> sets the amphora's color.
     * <b>Postcondition:</b> the amphora's color has been set.
     * @param color
     */
    public void setColor(AmphoraTileColor color){ this.color = color; }

    /**
     * <b>Accessor:</b> returns the amphora's color.
     * <b>Postcondition:</b> the amphora's color has been returned.
     * @return AmphoraTileColor color
     */
    public AmphoraTileColor getAmphoraColor(){ return color; }

    /**
     * Returns the string representation of a tile.
     * <b>Postcondition:</b> The string representation of a tile is returned
     * @return The string representation of a tile
     */
    @Override
    public String toString(){ return "Amphora " + color.toString(); }
}