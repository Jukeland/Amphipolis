package Model.Game;

import Model.Tiles.Tile;
import Model.Tiles.TileType;

public class Board{
    private Bag AmphoraArea;
    private Bag MosaicArea;
    private Bag SkeletonArea;
    private Bag StatueArea;
    private Bag LandslideArea;

    /**
     * <b>Constructor:</b> creates a new instance of Board
     * <b>Postcondition:</b> a new Board is created
     */
    public Board(){
        AmphoraArea = new Bag();
        MosaicArea = new Bag();
        SkeletonArea = new Bag();
        StatueArea = new Bag();
        LandslideArea = new Bag();
    }

    /**
     * <b>Transformer:</b> adds the tiles to the designated areas and removes it from the player's inventory
     * <b>Postcondition:</b> the tiles have been added to the designated areas and removed from the player's inventory
     * @param b
     */
    public void addToAreas(Bag b){
        for(int i = b.getSize()-4; i < b.getSize(); i++){
            if(b.getTile(i).getType() == TileType.AMPHORA){
                AmphoraArea.addTile(b.getTile(i));
            }else if(b.getTile(i).getType() == TileType.MOSAIC){
                MosaicArea.addTile(b.getTile(i));
            }else if(b.getTile(i).getType() == TileType.SKELETON){
                SkeletonArea.addTile(b.getTile(i));
            }else if(b.getTile(i).getType() == TileType.STATUE){
                StatueArea.addTile(b.getTile(i));
            }else if(b.getTile(i).getType() == TileType.LANDSLIDE){
                LandslideArea.addTile(b.getTile(i));
            }
        }
        for(int i = 4; i > 0; i--){
            b.removeTile(b.getTile(b.getSize() - i));
        }
    }

    /**
     * <b>Transformer:</b> removes all tiles from all areas for a new game to begin
     * <b>Postcondition:</b> all the tiles from all areas have been removed
     */
    public void init_board(){
        AmphoraArea.clearAll();
        MosaicArea.clearAll();
        SkeletonArea.clearAll();
        StatueArea.clearAll();
        LandslideArea.clearAll();
    }

    /**
     * <b>Transformer:</b> removes a given tile from its area
     * <b>Postcondition:</b> the tile has been removed from its area
     * @param e
     */
    public void removeTileFromArea(Tile e){  }

    /**
     * <b>Accessor:</b> returns the tiles in the amphora area
     * <b>Postcondition:</b> the tiles in the amphora area have been returned
     * @return Bag AmphoraArea
     */
    public Bag getAmphoraArea(){ return AmphoraArea; }

    /**
     * <b>Accessor:</b> returns the tiles in the mosaic area
     * <b>Postcondition:</b> the tiles in the mosaic area have been returned
     * @return Bag MosaicArea
     */
    public Bag getMosaicArea(){ return MosaicArea; }

    /**
     * <b>Accessor:</b> returns the tiles in the skeleton area
     * <b>Postcondition:</b> the tiles in the skeleton area have been returned
     * @return Bag SkeletonArea
     */
    public Bag getSkeletonArea(){ return SkeletonArea; }

    /**
     * <b>Accessor:</b> returns the tiles in the statue area
     * <b>Postcondition:</b> the tiles in the statue area have been returned
     * @return Bag StatueArea
     */
    public Bag getStatueArea(){ return StatueArea; }

    /**
     * <b>Accessor:</b> returns the tiles in the landslide area
     * <b>Postcondition:</b> the tiles in the landslide area have been returned
     * @return Bag LandslideArea
     */
    public Bag getLandslideArea(){ return LandslideArea; }

    /**
     * a string representation of the board areas
     * <b>Postcondition:</b> a string representation of the board areas has been returned
     * @return a string representation of the board areas
     */
    public String toString(){ return AmphoraArea + " " + MosaicArea + " " + SkeletonArea + " " + StatueArea + " " + LandslideArea; }
}
