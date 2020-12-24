package Model.Tiles;

public class MosaicTile extends FindingTile{
    private MosaicTileColor color;

    /**Constructor.
     * <b>Postcondition:</b> creates a new Mosaic tile.
     * @param col
     */
    public MosaicTile(MosaicTileColor col){
        super(TileType.MOSAIC);
        setColor(col);
        if(color == MosaicTileColor.GREEN)
            setImage("src\\resources\\mosaic_green.png");
        else if(color == MosaicTileColor.RED)
            setImage("src\\resources\\mosaic_red.png");
        else
            setImage("src\\resources\\mosaic_yellow.png");
    }

    /**
     * <b>Transformer:</b> sets the mosaic's color.
     * <b>Postcondition:</b> the mosaic's color has been set.
     * @param color
     */
    public void setColor(MosaicTileColor color){ this.color = color; }

    /**
     * <b>Accessor:</b> returns the mosaic's color.
     * <b>Postcondition:</b> the mosaic's color has been set.
     * @return MosaicTileColor color
     */
    public MosaicTileColor getMosaicColor(){ return color; }

    /**
     * Returns the string representation of a tile.
     * <b>Postcondition:</b> The string representation of a tile is returned
     * @return The string representation of a tile
     */
    @Override
    public String toString(){ return "Mosaic " + color.toString(); }
}
