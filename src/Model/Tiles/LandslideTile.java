package Model.Tiles;

public class LandslideTile implements Tile{
    private TileType type;
    private String image;

    /**Constructor.
     * <b>Postcondition:</b> creates a new LandSlide tile.
     */
    public LandslideTile(){
        type = TileType.LANDSLIDE;
        image = "src\\resources\\landslide.png";
    }

    /**
     * Returns the string representation of a tile
     * <p><b>Postcondition:</b> The string representation of a tile is returned</p>
     * @return The string representation of a tile
     */
    @Override
    public String toString(){ return "Landslide"; }

    //there is no need to set the image because it's not gonna change

    //there is no need to set the type because it's not gonna change

    /**
     * <b>Accessor:</b> returns the type of the tile
     * <b>Postcondition:</b> the type of the tile has been returned
     * @return the type of the tile
     */
    @Override
    public TileType getType() { return type; }

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
    public String getStatueType(){ return null; }

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
    @Override
    public String getImage(){ return image; }
}
