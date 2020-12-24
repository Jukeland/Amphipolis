package Model.Characters;

public class Digger extends Character {

    /**
     * <b>Constructor:</b> creates a new digger
     * <b>Postcondition:</b> a new digger has been created
     * @param isUsed
     */
    public Digger(boolean isUsed) {
        super(isUsed);
    }

    /**
     * returns the string representation of the character
     * <b>Postcondition:</b> the string representation of the character has been returned
     * @return the string representation of the character
     */
    @Override
    public String toString(){ return "Digger " + getIsUsed(); }
}
