package Model.Characters;

public class Archaeologist extends Character {

    /**
     * <b>Constructor:</b> creates a new archaeologist
     * <b>Postcondition:</b> a new archaeologist has been created
     * @param isUsed
     */
    public Archaeologist(boolean isUsed){
        super(isUsed);
    }


    /**
     * returns the string representation of the character
     * <b>Postcondition:</b> the string representation of the character has been returned
     * @return the string representation of the character
     */
    @Override
    public String toString(){ return "Archaeologist " + getIsUsed(); }
}
