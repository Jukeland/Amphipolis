package Model.Game;

import Model.Characters.CharacterBundle;
import Model.Tiles.AmphoraTileColor;
import Model.Tiles.MosaicTileColor;
import Model.Tiles.TileType;

import java.util.ArrayList;
import java.util.Collections;

public class Player{
    private PlayerColor color;
    private String name;
    private Bag playersTiles;
    private CharacterBundle characterBundle;
    private boolean hasTurn, finished;
    private int points;
    private int caryatid = 0;
    private int sphinx = 0;

    /**Constructor.
     *<b>Postcondition:</b> creates a new Player with "color" color and "name" name.
     * @param color
     */
    public Player(PlayerColor color, String name){
        this.color = color;
        this.name = name;
        this.playersTiles = new Bag();
        characterBundle = new CharacterBundle();
        this.hasTurn = false;
        this.finished = false;
        this.points = 0;
    }

    /**
     * <b>Accessor:</b> returns the player's points from the mosaic tiles.
     * <b>Postcondition:</b> the player's mosaic points have been returned.
     * @return int p
     */
    public int getMosaicPoints(){    //done
        int[] mos = {0, 0, 0};
        int p = 0;
        for(int i = 0; i < playersTiles.getSize(); i++) {
            if (playersTiles.getTile(i).getType() == TileType.MOSAIC) {
                if (playersTiles.getTile(i).getMosaicColor() == MosaicTileColor.GREEN) {
                    mos[0]++;
                } else if (playersTiles.getTile(i).getMosaicColor() == MosaicTileColor.RED) {
                    mos[1]++;
                } else if (playersTiles.getTile(i).getMosaicColor() == MosaicTileColor.YELLOW) {
                    mos[2]++;
                }
            }
        }
        for(int i = 0; i < 3; i++){
            p += 4*(mos[i]/4);
            mos[i] = mos[i]%4;
        }
        p += 2*((mos[0] + mos[1] + mos[2])/4);
        return p;
    }

    /**
     * <b>Accessor:</b> returns the player's points from the skeleton tiles.
     * <b>Postcondition:</b> the player's skeleton points have been returned.
     * @return int p
     */
    public int getSkeletonPoints(){     //done
        int skelAU = 0, skelAL = 0, skelKU = 0, skelKL = 0, skelA, skelK, p = 0;
        for(int i = 0; i < playersTiles.getSize(); i++){
            if(playersTiles.getTile(i).getType() == TileType.SKELETON){
                if(playersTiles.getTile(i).getAge().equals("Adult")){
                    if(playersTiles.getTile(i).getHalf().equals("Upper")){
                        skelAU++;
                    }else skelAL++;
                }else{
                    if(playersTiles.getTile(i).getHalf().equals("Upper")){
                        skelKU++;
                    }else skelKL++;
                }
            }
        }
        if(skelAU==skelAL){
            skelA = skelAU;
        }else{
            int min = skelAL;
            if(skelAU < min){ min = skelAU; }
            skelA = min%(skelAL+skelAU-min);
        }
        if(skelKU == skelKL){
            skelK = skelKU;
        }else{
            int min = skelKL;
            if(skelKU < min){ min = skelKU; }
            skelK = min%(skelKL+skelKU-min);
        }
        while(skelA!=0 || skelK!=0){
            if(skelA<2 || skelK==0){
                p += skelA + skelK;
                skelA = 0;
                skelK = 0;
            }else{
                p += 6;
                skelA -= 2;
                skelK -= 1;
            }
        }
        return p;
    }

    /**
     * <b>Accessor:</b> initializes the number of caryatid tiles the player has.
     * <b>Postcondition:</b> the number of the player's caryatid tiles has been initialized
     */
    public void initCaryatid(){      //done
        for(int i = 0; i < playersTiles.getSize(); i++){
            if(playersTiles.getTile(i).getType() == TileType.STATUE){
                if(playersTiles.getTile(i).getStatueType().equals("Caryatid")){
                    caryatid++;
                }
            }
        }
    }

    /**
     * <b>Accessor:</b> initializes the number of sphinx tiles the player has.
     * <b>Postcondition:</b> the number of the player's sphinx tiles has been initialized
     */
    public void initSphinx(){       //done
        for(int i = 0; i < playersTiles.getSize(); i++){
            if(playersTiles.getTile(i).getType() == TileType.STATUE){
                if(playersTiles.getTile(i).getStatueType().equals("Sphinx")){
                    sphinx++;
                }
            }
        }
    }

    /**
     * <b>Accessor:</b> returns the player's points from the amphora tiles.
     * <b>Postcondition:</b> the player's amphora points have been returned.
     * @return int p
     */
    public int getAmphoraPoints(){
        int blue = 0, brown = 0, red = 0, green = 0, yellow = 0, purple = 0, amphoraPoints = 0, m = 6, sum = 0;
        for(int i = 0; i < playersTiles.getSize(); i++) {
            if(playersTiles.getTile(i).getAmphoraColor() == AmphoraTileColor.BLUE) blue++;
            else if(playersTiles.getTile(i).getAmphoraColor() == AmphoraTileColor.BROWN) brown++;
            else if(playersTiles.getTile(i).getAmphoraColor() == AmphoraTileColor.RED) red++;
            else if(playersTiles.getTile(i).getAmphoraColor() == AmphoraTileColor.GREEN) green++;
            else if(playersTiles.getTile(i).getAmphoraColor() == AmphoraTileColor.YELLOW) yellow++;
            else if(playersTiles.getTile(i).getAmphoraColor() == AmphoraTileColor.PURPLE) purple++;
        }

        ArrayList<Integer> counter = new ArrayList<>();
        counter.add(blue);
        counter.add(brown);
        counter.add(red);
        counter.add(green);
        counter.add(yellow);
        counter.add(purple);
        Collections.sort(counter);
        System.out.println(counter);
        for(int i = 0; i < counter.size(); i++){
            if(counter.get(i) == 0) sum++;
        }
        /*
        for(int j = 0; j < 4; j++){
            if(sum == j){
                amphoraPoints += 6*counter.get(j);
                for(int i = j; i < counter.size(); i++){
                    counter.set(i, counter.get(i) - 1);
                }
            }
        }
        */

        if(sum == 0){
            amphoraPoints += 6*counter.get(0);
            for(int i = 0; i < counter.size(); i++){
                counter.set(i, counter.get(i) - 1);
            }
        }else if(sum == 1){
            amphoraPoints += 4*counter.get(1);
            for(int i = 1; i < counter.size(); i++){
                counter.set(i, counter.get(i) - 1);
            }
        }else if(sum == 2){
            amphoraPoints += 2*counter.get(2);
            for(int i = 2; i < counter.size(); i++){
                counter.set(i, counter.get(i) - 1);
            }
        }else if(sum == 3){
            amphoraPoints += counter.get(3);
            for(int i = 3; i < counter.size(); i++){
                counter.set(i, counter.get(i) - 1);
            }
        }
        System.out.println(counter);
        System.out.println(amphoraPoints);
        return amphoraPoints;
    }

    /**
     * <b>Transformer:</b> sets the player's points.
     * <b>Postcondition</b> the player's points have been set;
     */
    public void playersPoints(){
        points = getAmphoraPoints() + getMosaicPoints() + getSkeletonPoints();
    }

    /**
     * <b>Transformer:</b> initializes the player for a new game.
     * <b>Postcondiion:</b> the player has been initialized.
     */
    public void initPlayer(){
        characterBundle.init_characters();
        this.finished = false;
        this.hasTurn = false;
        this.playersTiles.clearAll();
        this.points = 0;
    }

    /**
     * <b>Accessor:</b> returns the number of sphinxes in the player's inventory
     * <b>Postcondition:</b> the number of sphinxes in the player's inventory has been returned
     * @return int caryatid
     */
    public int getCaryatid() { return caryatid; }


    /**
     * <b>Accessor:</b> returns the number of caryatids in the player's inventory
     * <b>Postcondition:</b> the number of caryatids in the player's inventory has been returned
     * @return int sphinx
     */
    public int getSphinx() { return sphinx; }

    /**
     * <b>Transformer:</b> sets the player's points
     * <b>Postcondition:</b> the player's points have been set
     * @param points
     */
    public void setPoints(int points){ this.points = points; }

    /**
     * <b>Accessor:</b> returns the player's points
     * <b>Postcondition:</b> the player's points have been returned
     */
    public int getPoints(){ return points; }

    /**
     * <b>Transformer:</b> sets the player's color.
     * <b>Postcondition:</b> the player's color has been set.
     * @param color
     */
    public void setColor(PlayerColor color){ this.color = color; }

    /**
     * <b>Accessor:</b> returns the player's color.
     * <b>Postcondition:</b> the player's color has been returned.
     * @return PlayerColor color.
     */
    public PlayerColor getColor(){ return color; }

    /**
     * <b>Transformer:</b> sets the player's name.
     * <b>Postcondition:</b> the player's name has been set.
     * @param name
     */
    public void setName(String name){ this.name = name; }

    /**
     * <b>Accessor:</b> returns the player's name.
     * <b>Postcondition:</b> the player's name has been returned.
     * @return String name.
     */
    public String getName(){ return name; }

    /**
     * <b>Transformer:</b> sets the player's tiles.
     * <b>Postcondition:</b> the player's tiles has been returned.
     * @param playersTiles
     */
    public void setPlayersTiles(Bag playersTiles){ this.playersTiles = playersTiles; }

    /**
     * <b>Accessor:</b> returns the player's tiles.
     * <b>Postcondition:</b> the player's tiles has been returned.
     * @return Bag tiles.
     */
    public Bag getPlayersTiles(){ return playersTiles; }

    /**
     * <b>Transformer:</b> sets the player's characters.
     * <b>Postcondition:</b> the player's characters has been set.
     * @param characterBundle
     */
    public void setCharacterBundle(CharacterBundle characterBundle){ this.characterBundle = characterBundle; }

    /**
     * <b>Accessor:</b> returns the player's characters.
     * <b>Postcondition:</b> the player's characters have been returned.
     * @return Character characters
     */
    public CharacterBundle getCharacterBundle(){ return characterBundle; }

    /**
     * <b>Transformer:</b> sets if the player has played.
     * <b>Postcondition:</b> if the player has played has been set.
     * @param hasTurn
     */
    public void setHasTurn(boolean hasTurn){ this.hasTurn = hasTurn; }

    /**
     * <b>Accessor:</b> returns if the player has played.
     * <b>Postcondition:</b> the player's color has been returned.
     * @return boolean hasPlayed.
     */
    public boolean getHasTurn(){ return hasTurn; }

    /**
     * <b>Transformer:</b> sets if the player is finished.
     * <b>Postcondition:</b> if the player is finished has been set.
     * @param finished
     */
    public void setFinished(boolean finished){ this.finished = finished; }

    /**
     * <b>Accessor:</b> returns if the players has finished or not
     * <b>Postcondition:</b> if the player has finished has been returned
     * @return boolean finished.
     */
    public boolean getFinished(){ return finished; }

    /**
     * Returns the string representation of the player
     * <b>Postcondition:</b> the string representation of the player has been returned
     * @return the string representation of the player
     */
    @Override
    public String toString(){ return "Name: " + name + ", Color: " + color + ", Characters: " + characterBundle.toString() + ", Tiles: " + playersTiles.toString() + ", Points: " + points; }
}
