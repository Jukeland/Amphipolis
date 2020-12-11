package Model.Tiles;

public interface Tile{

    /**
     * <b>Accessor:</b> returns the type of the tile
     * <b>Postcondition:</b> the type of the tile has been returned
     * @return the type of the tile
     */
    TileType getType();

    /**
     * Returns the string representation of a tile
     * <p><b>Postcondition:</b> The string representation of a tile is returned</p>
     * @return The string representation of a tile
     */
    String toString();

    /**
     * <b>Accessor:</b> returns the amphora color
     * <b>Postcondition:</b> the amphora color has been returned
     * @return the amphora color
     */
    AmphoraTileColor getAmphoraColor();

    /**
     * <b>Accessor:</b> returns the mosaic color
     * <b>Postcondition:</b> the mosaic color has been returned
     * @return the mosaic color
     */
    MosaicTileColor getMosaicColor();

    /**
     * <b>Accessor:</b> returns the statue type
     * <b>Postcondition:</b> the statue type has been returned
     * @return the statue type
     */
    String getStatueType();

    /**
     * <b>Accessor:</b> returns the skeleton's age
     * <b>Postcondition:</b> the skeleton's age has been returned
     * @return the skeleton's age
     */
    String getAge();

    /**
     * <b>Accessor:</b> returns the skeleton's half
     * <b>Postcondition:</b> the skeleton's half has been returned
     * @return the skeleton's half
     */
    String getHalf();

    /**
     * <b>Accessor:</b> returns the path of the image of the tile as a string
     * <b>Postcondition:</b> the path of the image has been returned
     * @return the path of the image as a string
     */
    String getImage();
}
