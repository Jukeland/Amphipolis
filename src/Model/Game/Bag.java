package Model.Game;

import Model.Tiles.AmphoraTile;
import Model.Tiles.AmphoraTileColor;
import Model.Tiles.LandslideTile;
import Model.Tiles.MosaicTile;
import Model.Tiles.MosaicTileColor;
import Model.Tiles.SkeletonTile;
import Model.Tiles.StatueTile;
import Model.Tiles.Tile;

import java.util.ArrayList;
import java.util.Collections;

public class Bag{
    private ArrayList<Tile> tiles;

    /**Constructor.
     * <b>Postcondition:</b> Creates a new Bag with a new ArrayList.
     */
    public Bag(){ tiles = new ArrayList<>(); }

    /**
     * <b>Transformer:</b> Initializes and shuffles all the tiles.
     * <b>Postcondition:</b> All the tiles have been initialized and shuffled.
     */
    public void init_tiles(){
        for(int i = 0; i < 24; i++){                                    //initializes landslide tiles
            tiles.add(new LandslideTile());
        }
        for(AmphoraTileColor col: AmphoraTileColor.values()){           //initializes amphora tiles
            for(int i = 0; i < 5; i++){
                tiles.add(new AmphoraTile(col));
            }
        }
        for(MosaicTileColor col: MosaicTileColor.values()){             //initializes mosaic tiles
            for(int i = 0; i < 9; i++){
                tiles.add(new MosaicTile(col));
            }
        }
        for(int i = 0; i < 12; i++){                                    //initializes statue tiles
            tiles.add(new StatueTile("Caryatid"));
            tiles.add(new StatueTile("Sphinx"));
        }
        for(int i = 0; i < 10; i++){                                    //initializes skeleton tiles
            tiles.add(new SkeletonTile("Adult", "Upper"));
            tiles.add(new SkeletonTile("Adult", "Lower"));
            if(i < 5){
                tiles.add(new SkeletonTile("Kid", "Upper"));
                tiles.add(new SkeletonTile("Kid", "Lower"));
            }
        }

        Collections.shuffle(tiles);
        Collections.shuffle(tiles);
        Collections.shuffle(tiles);
        Collections.shuffle(tiles);
    }

    /**
     * <b>Accessor:</b> returns the tiles of the bag
     * <b>Postcondition:</b> the tiles of the bag has been returned
     * @return ArrayList tiles
     */
    public ArrayList<Tile> getTiles(){ return tiles; }

    /**
     * <b>Accessor:</b> returns the array list's size
     * <b>Postcondition:</b> the array list's size has been returned
     * @return int size
     */
    public int getSize(){ return tiles.size(); }

    /**
     * <b>Transformer:</b> adds a tile to the array list
     * <b>Postcondition:</b> the tile has been added
     * @param e
     */
    public void addTile(Tile e){
        this.tiles.add(e);
    }

    /**
     * <b>Transformer:</b> removes a tile from the array list
     * <b>Postcondition:</b> the tile has been removed
     * @param e
     */
    public void removeTile(Tile e){ this.tiles.remove(e); }

    /**
     * <b>Accessor:</b> returns the tile on the i position
     * <b>Postcondition:</b> the i tile has been returned
     * @param i
     * @return Tile
     */
    public Tile getTile(int i){ return this.tiles.get(i); }

    /**
     * <b>Transformer:</b> removes all objects from the array list
     * <b>Postcondition:</b> all the tiles have been removed
     */
    public void clearAll(){
        tiles.clear();
    }

    /**
     * Returns the string representation of all the tiles.
     * <b>Postcondition:</b> The string representation of all the tiles is returned
     * @return The string representation of all the tiles
     */
    @Override
    public String toString(){
        return tiles.toString();
    }
}
