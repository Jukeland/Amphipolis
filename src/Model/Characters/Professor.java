package Model.Characters;

import Model.Game.Player;

public class Professor extends Character {

    /**
     * <b>Constructor:</b> creates a new professor
     * <b>Postcondition:</b> a new professor has been created
     * @param isUsed
     */
    public Professor(boolean isUsed){
        super(isUsed);
    }

    /**
     * returns the string representation of the character
     * <b>Postcondition:</b> the string representation of the character has been returned
     * @return the string representation of the character
     */
    @Override
    public String toString(){ return "Professor " + getIsUsed(); }
}
