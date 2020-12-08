package Model.Game;

import static java.lang.Math.random;

public class Turn{
    private Player player;

    /**
     * <b>Constructor:</b> creates a new instance of Turn and initializes the player randomly
     * <b>Postcondition:</b> the player has been initialized
     * @param P1
     * @param P2
     * @param P3
     * @param P4
     */
    public Turn(Player P1, Player P2, Player P3, Player P4){
        int num = (int)(random() * 4) + 1;
        System.out.println(num);
        if(num == 1) this.player = P1;
        else if(num == 2) this.player = P2;
        else if(num == 3) this.player = P3;
        else this.player = P4;
    }

    /**
     * <b>Transformer:</b> change the player that has the turn to the next one
     * <b>Postcondition:</b> the next player now has the turn
     * @param P1
     * @param P2
     * @param P3
     * @param P4
     */
    public void endTurn(Player P1, Player P2, Player P3, Player P4){
        if(this.player == P1) player = P2;
        else if(player == P2) player = P3;
        else if(player == P3) player = P4;
        else if(player == P4) player = P1;
    }

    /**
     * <b>Accessor:</b> returns the player that currently has the turn
     * <b>Postcondition:</b> the player has been returned
     * @return Player player
     */
    public Player getPlayer() { return player; }
}
