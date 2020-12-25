package Model.Characters;

import java.util.ArrayList;

public class CharacterBundle{
    private ArrayList<Character> characters;

    /**
     * <b>Constructor:</b> creates a new array list of characters
     * <b>Postcondition:</b> a new array list of characters has been created
     */
    public CharacterBundle(){
        this.characters = new ArrayList<>();
        characters.add(new Archaeologist(false));
        characters.add(new Assistant(false));
        characters.add(new Digger(false));
        characters.add(new Professor(false));
    }

    /**
     * <b>Transformer:</b> initializes the character bundle
     * <b>Postcondition:</b> the character bundle has been initialized
     */
    public void init_characters(){
        characters.get(0).setIsUsed(false);
        characters.get(1).setIsUsed(false);
        characters.get(2).setIsUsed(false);
        characters.get(3).setIsUsed(false);
    }

    /**
     * <b>Accessor:</b> returns the characters on the array list
     * <b>Postcondition:</b> the characters on the array list have been returned
     * @return ArrayList characters
     */
    public ArrayList<Character> getCharacters(){ return characters; }

    /**
     * returns the string representation of the bundle
     * <b>Postcondition:</b> the string representation of the bundle has been returned
     * @return the string representation of the bundle
     */
    @Override
    public String toString(){ return characters.toString(); }
}
