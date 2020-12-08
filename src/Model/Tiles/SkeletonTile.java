package Model.Tiles;

public class SkeletonTile extends FindingTile{
    private String age;
    private String half;

    /**Constructor.
     * <b>Postcondition:</b> Creates a new skeleton tile with "age" age and "half" half
     * @param age
     * @param half
     */
    public SkeletonTile(String age, String half){
        super(TileType.SKELETON);
        setAge(age);
        setHalf(half);
    }

    /**
     * <b>Transformer:</b> sets the skeleton's age.
     * <b>Postcondition:</b> skeleton's age has been set.
     * @param age
     */
    public void setAge(String age){ this.age = age; }

    /**
     * <b>Accessor:</b> returns the skeleton's age.
     * <b>Postcondition:</b> the skeleton's age has been returned.
     * @return String age
     */
    public String getAge(){ return age; }

    /**
     * <b>Transformer:</b> sets the skeleton's half.
     * <b>Postcondition:</b> the skeleton's half has been set.
     * @param half
     */
    public void setHalf(String half) { this.half = half; }

    /**
     * <b>Accessor:</b> returns the skeleton's half.
     * <b>Postcondition:</b> the skeleton's half has been returned.
     * @return String half
     */
    public String getHalf() { return half; }

    /**
     * Returns the string representation of a tile.
     * <b>Postcondition:</b> The string representation of a tile is returned
     * @return The string representation of a tile
     */
    @Override
    public String toString(){ return "Skeleton " + this.age + " " + this.half; }
}
