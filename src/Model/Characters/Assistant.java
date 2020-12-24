package Model.Characters;

public class Assistant extends Character {

    /**
     * <b>Constructor:</b> creates a new assistant
     * <b>Postcondition:</b> a new assistant has been created
     * @param isUsed
     */
    public Assistant(boolean isUsed){
        super(isUsed);
    }

    /**
     * returns the string representation of the character
     * <b>Postcondition:</b> the string representation of the character has been returned
     * @return the string representation of the character
     */
    @Override
    public String toString(){ return "Assistant " + getIsUsed();}
}
