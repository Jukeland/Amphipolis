package Controller;

import Model.Characters.CharacterBundle;
import Model.Game.*;

import java.util.ArrayList;

public class Controller{
    private Player P1, P2, P3, P4;
    private ArrayList<Player> players = new ArrayList<>();
    private Bag bag = new Bag();
    private Turn turn;
    private Board board = new Board();

    /**
     * <b>Constructor:</b>  creates a new instance of Controller and initializes some things
     * <b>Postcondition:</b> a new instance of Controller had been created and all initializations have been done
     */
    public Controller(){
        P1 = new Player(PlayerColor.BLACK, "Player1");
        P1.initPlayer();
        P2 = new Player(PlayerColor.BLUE, "Player2");
        P2.initPlayer();
        P3 = new Player(PlayerColor.RED, "Player3");
        P3.initPlayer();
        P4 = new Player(PlayerColor.YELLOW, "Player4");
        P4.initPlayer();
        players.add(P1);
        players.add(P2);
        players.add(P3);
        players.add(P4);
        bag.init_tiles();
        turn = new Turn(P1, P2, P3, P4);
        board.init_board();
    }

    /**
     * Checks if the game has finished (if the landslide area has 16 tiles in it)
     * <b>Postcondition:</b> if the game has finished or not has been returned
     * @return boolean isFinished
     */
    public boolean gameFinished(){
        boolean isFinished = false;
        if(board.getLandslideArea().getSize() == 16) isFinished = true;
        return isFinished;
    }

    /**
     * <b>Accessor:</b> returns the player or players who won
     * <b>Postcondition:</b> the player or players who won have been returned
     * @return the player or players who won
     */
    public String gameWinner(){
        if(gameFinished()){
            P1.playersPoints();
            P2.playersPoints();
            P3.playersPoints();
            P4.playersPoints();
            assignCaryatidPoints();
            assignSphinxPoints();
            int max = P1.getPoints();
            String str = "";
            if (P2.getPoints() > max) max = P2.getPoints();
            if (P3.getPoints() > max) max = P3.getPoints();
            if (P4.getPoints() > max) max = P4.getPoints();
            if (max == P1.getPoints()) str += "Player 1, ";
            if (max == P2.getPoints()) str += "Player 2, ";
            if (max == P3.getPoints()) str += "Player 3, ";
            if (max == P4.getPoints()) str += "Player 4, ";
            return "The winner(s) is/are " + str + "and their points were " + max;
        }else return "Game has not finished yet";
    }

    /**
     * <b>Transformer:</b> draw 4 tiles from the bag (remove 4 tile from the bag)
     * <b>Postcondition:</b> the 4 tiles have been drawn (removed)
     * @param gameBag, playerBag
     */
    public void drawTilesFromBag(Bag gameBag, Bag playerBag){
        for(int i = 0; i < 4; i++){
            playerBag.addTile(gameBag.getTile(gameBag.getSize()-1));
            gameBag.removeTile(gameBag.getTile(gameBag.getSize()-1));
            gameBag.getTiles().trimToSize();
        }
    }

    /**
     * <b>Transformer:</b> draw some tiles from the board following the rules of the game
     * <b>Postcondition:</b> the tiles have been drawn
     */
    public void drawTilesFromBoard(Board board){

    }

    /**
     * <b>Transformer:</b> use a character's move and set that character's isUsed to true
     * <b>Postcondition:</b> the character's move has been used and it's isUsed has been set to true
     */
    public void useCharacter(CharacterBundle bundle){

    }

    /**
     * <b>Transformer:</b> computes and assigns the points earned from caryatids by each player
     * <b>Postcondition:</b> the points have been updated
     */
    public void assignCaryatidPoints(){
        if(P1.getCaryatid() != 0 || P2.getCaryatid() != 0 || P3.getCaryatid() != 0 || P4.getCaryatid() != 0){
            int max = P1.getCaryatid();
            if (P2.getCaryatid() > max) max = P2.getCaryatid();
            if (P3.getCaryatid() > max) max = P3.getCaryatid();
            if (P4.getCaryatid() > max) max = P4.getCaryatid();

            int min = P1.getCaryatid();
            if (P2.getCaryatid() < min) min = P2.getCaryatid();
            if (P3.getCaryatid() < min) min = P3.getCaryatid();
            if (P4.getCaryatid() < min) min = P4.getCaryatid();

            if (max == P1.getCaryatid()) P1.setPoints(P1.getPoints() + 6);
            if (max == P2.getCaryatid()) P2.setPoints(P2.getPoints() + 6);
            if (max == P3.getCaryatid()) P3.setPoints(P3.getPoints() + 6);
            if (max == P4.getCaryatid()) P4.setPoints(P3.getPoints() + 6);

            if (P1.getCaryatid() != max && P1.getCaryatid() != min) P1.setPoints(P1.getPoints() + 3);
            if (P2.getCaryatid() != max && P2.getCaryatid() != min) P2.setPoints(P2.getPoints() + 3);
            if (P3.getCaryatid() != max && P3.getCaryatid() != min) P3.setPoints(P3.getPoints() + 3);
            if (P4.getCaryatid() != max && P4.getCaryatid() != min) P4.setPoints(P4.getPoints() + 3);
        }
    }

    /**
     * <b>Transformer:</b> computes and assigns the points from sphinxes from each player
     * <b>Postcondition:</b> the points have been updates
     */
    public void assignSphinxPoints(){
        if(P1.getSphinx() != 0 || P2.getSphinx() != 0 || P3.getSphinx() != 0 || P4.getSphinx() != 0){
            int max = P1.getSphinx();
            if (P2.getSphinx() > max) max = P2.getSphinx();
            if (P3.getSphinx() > max) max = P3.getSphinx();
            if (P4.getSphinx() > max) max = P4.getSphinx();

            int min = P1.getSphinx();
            if (P2.getSphinx() < min) min = P2.getSphinx();
            if (P3.getSphinx() < min) min = P3.getSphinx();
            if (P4.getSphinx() < min) min = P4.getSphinx();

            if (max == P1.getSphinx()) P1.setPoints(P1.getPoints() + 6);
            if (max == P2.getSphinx()) P2.setPoints(P2.getPoints() + 6);
            if (max == P3.getSphinx()) P3.setPoints(P3.getPoints() + 6);
            if (max == P4.getSphinx()) P4.setPoints(P3.getPoints() + 6);

            if (P1.getSphinx() != max && P1.getSphinx() != min) P1.setPoints(P1.getPoints() + 3);
            if (P2.getSphinx() != max && P2.getSphinx() != min) P2.setPoints(P2.getPoints() + 3);
            if (P3.getSphinx() != max && P3.getSphinx() != min) P3.setPoints(P3.getPoints() + 3);
            if (P4.getSphinx() != max && P4.getSphinx() != min) P4.setPoints(P4.getPoints() + 3);
        }
    }

    /**
     * <b>Accessor:</b> returns the board
     * <b>Postcondition:</b> the board has been returned
     * @return Board board
     */
    public Board getBoard(){ return board; }

    /**
     * <b>Accessor:</b> returns player 1
     * <b>Postcondition:</b> player 1 has been returned
     * @return Player P1
     */
    public Player getP1(){ return P1; }

    /**
     * <b>Accessor:</b> returns player 2
     * <b>Postcondition:</b> player 2 has been returned
     * @return Player P2
     */
    public Player getP2(){ return P2; }

    /**
     * <b>Accessor:</b> returns player 3
     * <b>Postcondition:</b> player 3 has been returned
     * @return Player P3
     */
    public Player getP3(){ return P3; }

    /**
     * <b>Accessor:</b> returns player 4
     * <b>Postcondition:</b> player 4 has been returned
     * @return Player P4
     */
    public Player getP4(){ return P4; }

    /**
     * <b>Accessor:</b> returns the turn
     * <b>Postcondition:</b> the turn has been returned
     * @return turn
     */
    public Turn getTurn(){ return turn; }

    /**
     * <b>Accessor:</b> returns the bag of the game
     * <b>Postcondition:</b> the bag of the game has been returned
     * @return Bag bag
     */
    public Bag getBag(){ return bag; }
}
