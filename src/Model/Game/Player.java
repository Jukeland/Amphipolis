package Model.Game;

import Model.Characters.CharacterBundle;
import Model.Tiles.AmphoraTileColor;
import Model.Tiles.MosaicTileColor;
import Model.Tiles.TileType;
import java.util.ArrayList;
import java.util.Collections;

public class Player{
    private String name;
    private Bag playersTiles;
    private CharacterBundle characterBundle = new CharacterBundle();
    private boolean hasUsedCharacter;
    private int points;
    private int caryatid = 0;
    private int sphinx = 0;

    /**Constructor.
     *<b>Postcondition:</b> creates a new Player with "color" color and "name" name.
     * @param name
     */
    public Player(String name){
        this.name = name;
        this.playersTiles = new Bag();
        this.hasUsedCharacter = false;
        this.points = 0;
    }

    /**
     * <b>Accessor:</b> returns the player's points from the mosaic tiles.
     * <b>Postcondition:</b> the player's mosaic points have been returned.
     * @return int p
     */
    public int getMosaicPoints(){       //done
        int[] mosaics = {0, 0, 0};
        int points = 0;
        for(int i = 0; i < playersTiles.getSize(); i++) {
            if (playersTiles.getTile(i).getType() == TileType.MOSAIC) {
                if (playersTiles.getTile(i).getMosaicColor() == MosaicTileColor.GREEN) {
                    mosaics[0]++;
                } else if (playersTiles.getTile(i).getMosaicColor() == MosaicTileColor.RED) {
                    mosaics[1]++;
                } else if (playersTiles.getTile(i).getMosaicColor() == MosaicTileColor.YELLOW) {
                    mosaics[2]++;
                }
            }
        }
        for(int i = 0; i < 3; i++){
            points += 4*(mosaics[i]/4);
            mosaics[i] = mosaics[i]%4;
        }
        points += 2*((mosaics[0] + mosaics[1] + mosaics[2])/4);
        return points;
    }

    /**
     * <b>Accessor:</b> returns the player's points from the skeleton tiles.
     * <b>Postcondition:</b> the player's skeleton points have been returned.
     * @return int p
     */
    public int getSkeletonPoints(){     //done
        int sumOfSkeletonsAdultUpper = 0, sumOfSkeletonsAdultLower = 0, sumOfSkeletonsKidUpper = 0, sumOfSkeletonsKidLower = 0;
        int sumOfSkeletonsAdult, sumOfSkeletonsKid, points = 0;
        for(int i = 0; i < playersTiles.getSize(); i++){
            if(playersTiles.getTile(i).getType() == TileType.SKELETON){
                if(playersTiles.getTile(i).getAge().equals("Adult")){
                    if(playersTiles.getTile(i).getHalf().equals("Upper")){
                        sumOfSkeletonsAdultUpper++;
                    }else sumOfSkeletonsAdultLower++;
                }else{
                    if(playersTiles.getTile(i).getHalf().equals("Upper")){
                        sumOfSkeletonsKidUpper++;
                    }else sumOfSkeletonsKidLower++;
                }
            }
        }
        if(sumOfSkeletonsAdultUpper==sumOfSkeletonsAdultLower){
            sumOfSkeletonsAdult = sumOfSkeletonsAdultUpper;
        }else{
            int min = sumOfSkeletonsAdultLower;
            if(sumOfSkeletonsAdultUpper < min){ min = sumOfSkeletonsAdultUpper; }
            sumOfSkeletonsAdult = min%(sumOfSkeletonsAdultLower+sumOfSkeletonsAdultUpper-min);
        }
        if(sumOfSkeletonsKidUpper == sumOfSkeletonsKidLower){
            sumOfSkeletonsKid = sumOfSkeletonsKidUpper;
        }else{
            int min = sumOfSkeletonsKidLower;
            if(sumOfSkeletonsKidUpper < min){ min = sumOfSkeletonsKidUpper; }
            sumOfSkeletonsKid = min%(sumOfSkeletonsKidLower+sumOfSkeletonsKidUpper-min);
        }
        while(sumOfSkeletonsAdult!=0 || sumOfSkeletonsKid!=0){
            if(sumOfSkeletonsAdult<2 || sumOfSkeletonsKid==0){
                points += sumOfSkeletonsAdult + sumOfSkeletonsKid;
                sumOfSkeletonsAdult = 0;
                sumOfSkeletonsKid = 0;
            }else{
                points += 6;
                sumOfSkeletonsAdult -= 2;
                sumOfSkeletonsKid -= 1;
            }
        }
        return points;
    }

    /**
     * <b>Accessor:</b> returns the player's points from the amphora tiles.
     * <b>Postcondition:</b> the player's amphora points have been returned.
     * @return int p
     */
    public int getAmphoraPoints(){      //done
        int blue = 0, brown = 0, red = 0, green = 0, yellow = 0, purple = 0, amphoraPoints = 0, num = 0;
        for(int i = 0; i < playersTiles.getSize(); i++){
            if(playersTiles.getTile(i).getType() == TileType.AMPHORA) {
                if (playersTiles.getTile(i).getAmphoraColor() == AmphoraTileColor.BLUE) blue++;
                else if (playersTiles.getTile(i).getAmphoraColor() == AmphoraTileColor.BROWN) brown++;
                else if (playersTiles.getTile(i).getAmphoraColor() == AmphoraTileColor.RED) red++;
                else if (playersTiles.getTile(i).getAmphoraColor() == AmphoraTileColor.GREEN) green++;
                else if (playersTiles.getTile(i).getAmphoraColor() == AmphoraTileColor.YELLOW) yellow++;
                else if (playersTiles.getTile(i).getAmphoraColor() == AmphoraTileColor.PURPLE) purple++;
            }
        }

        ArrayList<Integer> counter = new ArrayList<>();
        counter.add(blue);
        counter.add(brown);
        counter.add(red);
        counter.add(green);
        counter.add(yellow);
        counter.add(purple);
        Collections.sort(counter);
        for (Integer value : counter) {
            if (value == 0) num++;
        }
        while(counter.get(3) != 0){
            if(num == 0){
                amphoraPoints += 6*counter.get(0);
                for(int i = counter.size() - 1; i >= 0; i--){
                    counter.set(i, counter.get(i) - counter.get(0));
                }
            }else if(num == 1){
                amphoraPoints += 4*counter.get(1);
                for(int i = counter.size() - 1; i >= 1; i--){
                    counter.set(i, counter.get(i) - counter.get(1));
                }
            }else if(num == 2){
                amphoraPoints += 2*counter.get(2);
                for(int i = counter.size() - 1; i >= 2; i--){
                    counter.set(i, counter.get(i) - counter.get(2));
                }
            }else if(num == 3){
                amphoraPoints += counter.get(3);
                for(int i = counter.size() - 1; i >= 3 ; i--){
                    counter.set(i, counter.get(i) - counter.get(3));
                }
            }
            num = 0;
            for (Integer integer : counter) {
                if (integer == 0) num++;

            }
        }
        return amphoraPoints;
    }

    /**
     * <b>Accessor:</b> initializes the number of caryatid tiles the player has.
     * <b>Postcondition:</b> the number of the player's caryatid tiles has been initialized
     */
    public void initCaryatid(){          //done
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
    public void initSphinx(){           //done
        for(int i = 0; i < playersTiles.getSize(); i++){
            if(playersTiles.getTile(i).getType() == TileType.STATUE){
                if(playersTiles.getTile(i).getStatueType().equals("Sphinx")){
                    sphinx++;
                }
            }
        }
    }

    /**
     * <b>Transformer:</b> sets the player's points using the methods above
     * <b>Postcondition</b> the player's points have been set
     */
    public void playersPoints(){
        points = getAmphoraPoints() + getMosaicPoints() + getSkeletonPoints();
    }

    /**
     * <b>Transformer:</b> initializes the player for a new game.
     * <b>Postcondiion:</b> the player has been initialized.
     */
    public void init_Player(){
        characterBundle.init_characters();
        this.hasUsedCharacter = false;
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

    //there is no need for a method to set the player's name

    /**
     * <b>Accessor:</b> returns the player's name.
     * <b>Postcondition:</b> the player's name has been returned.
     * @return String name.
     */
    public String getName(){ return name; }

    //there is no need for a method to set the player's tiles

    /**
     * <b>Accessor:</b> returns the player's tiles.
     * <b>Postcondition:</b> the player's tiles has been returned.
     * @return Bag tiles.
     */
    public Bag getPlayersTiles(){ return playersTiles; }

    //there is no need for a method to set the character bundle

    /**
     * <b>Accessor:</b> returns the player's characters.
     * <b>Postcondition:</b> the player's characters have been returned.
     * @return Character characters
     */
    public CharacterBundle getCharacterBundle(){ return characterBundle; }

    /**
     * <b>Transformer:</b> sets if the player has used a character this turn or not
     * <b>Postcondition:</b> if the player has used a character this turn or not has been set
     * @param bool
     */
    public void setHasUsedCharacter(boolean bool){ hasUsedCharacter = bool; }

    /**
     * <b>Accessor:</b> returns true if the player has used a character this turn or false otherwise
     * <b>Postcondition:</b> if the player has used a character this turn has been returned
     * @return boolean hasUsedCharacter
     */
    public boolean getHasUsedCharacter(){ return hasUsedCharacter; }

    /**
     * Returns the string representation of the player
     * <b>Postcondition:</b> the string representation of the player has been returned
     * @return the string representation of the player
     */
    @Override
    public String toString(){ return "Name: " + name +  ", Characters: " + characterBundle.toString() + ", Tiles: " + playersTiles.toString() + ", Points: " + points; }
}
