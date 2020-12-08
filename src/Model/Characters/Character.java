package Model.Characters;

public class Character {
    private boolean isUsed;

    /**
     * <b>Constructor:</b> is used to make a new character by the other classes
     * <b>Postcondition:</b> a new character is created
     * @param isUsed
     */
    public Character(boolean isUsed){ this.isUsed = isUsed; }

    /**
     * <b>Transformer:</b> sets if the character is used or not.
     * <b>Postcondition:</b> if the character is used or not has been returned.
     *
     * @param isUsed
     */
    public void setIsUsed(boolean isUsed){ this.isUsed = isUsed; }

    /**
     * <b>Accessor:</b> returns if the character is used or not.
     * <b>Postcondition:</b> if the character is used or not has been returned.
     *
     * @return boolean isUsed.
     */
    public boolean getIsUsed(){ return isUsed; }

}