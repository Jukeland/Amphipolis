package Model.Tiles;

public class StatueTile extends FindingTile{
    private String StatueType;

    /**Constructor.
     * <b>Postcondition</b>Creates a new statue tile.
     */
    public StatueTile(String StatueType){
        super(TileType.STATUE);
        setStatueType(StatueType);
        if(StatueType.equals("Caryatid"))
            setImage("src\\resources\\caryatid.png");
        else
            setImage("src\\resources\\sphinx.png");
    }

    /**
     * <b>Transformer:</b> sets the statue's type.
     * <b>Postcondition:</b> statue's type has been set.
     * @param StatueType
     */
    public void setStatueType(String StatueType) { this.StatueType = StatueType; }

    /**
     * <b>Accessor:</b> returns the statue's type.
     * <b>Postcondition:</b> statue's type has been returned.
     * @return String StatueType.
     */
    public String getStatueType(){ return StatueType; }

    /**
     * Returns the string representation of a tile.
     * <b>Postcondition:</b> The string representation of a tile is returned
     * @return The string representation of a tile
     */
    @Override
    public String toString(){ return "Statue(" + StatueType + ")"; }
}
