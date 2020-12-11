package Model.Tiles;

public class FindingTile implements Tile{
    private TileType type;
    private String image;

    /**Constructor.
     * <b>Postcondition:</b> creates a new Finding tile.
     * @param type
     */
    public FindingTile(TileType type){
        setType(type);
    }

    /**
     * <b>Transformer:</b> sets the tile type.
     * <b>Postcondition:</b> the tile type has been set.
     * @param type
     */
    public void setType(TileType type){ this.type = type; }

    /**
     * <b>Accessor:</b> returns the amphora color
     * <b>Postcondition:</b> the amphora color has been returned
     * @return the amphora color
     */
    @Override
    public AmphoraTileColor getAmphoraColor(){ return null; }

    /**
     * <b>Accessor:</b> returns the mosaic color
     * <b>Postcondition:</b> the mosaic color has been returned
     * @return the mosaic color
     */
    @Override
    public MosaicTileColor getMosaicColor(){ return null; }

    /**
     * <b>Accessor:</b> returns the statue type
     * <b>Postcondition:</b> the statue type has been returned
     * @return the statue type
     */
    @Override
    public String getStatueType() { return null; }

    /**
     * <b>Accessor:</b> returns the skeleton's age
     * <b>Postcondition:</b> the skeleton's age has been returned
     * @return the skeleton's age
     */
    @Override
    public String getAge(){ return null; }

    /**
     * <b>Accessor:</b> returns the skeleton's half
     * <b>Postcondition:</b> the skeleton's half has been returned
     * @return the skeleton's half
     */
    @Override
    public String getHalf(){ return null; }

    /**
     * <b>Accessor:</b> returns the path of the image of the tile as a string
     * <b>Postcondition:</b> the path of the image has been returned
     * @return the path of the image as a string
     */

    /**
     * <b>Accessor:</b> returns the path of the image of the tile as a string
     * <b>Postcondition:</b> the path of the image has been returned
     * @return the path of the image as a string
     */
    @Override
    public String getImage(){ return image; }

    /**
     * <b>Transformer:</b> sets the image of the tile
     * <b>Postcondition:</b> the image of the tile has been set
     * @param image
     */
    public void setImage(String image){ this.image = image; }

    /**
     * <b>Accessor:</b> returns the tile type.
     * <b>Postcondition:</b> the tile type has been returned.
     * @return TileType type
     */
    public TileType getType() { return type; }
}