package View;

import Controller.Controller;
import Model.Game.Bag;
import Model.Tiles.TileType;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame{
    private Controller game;
    private JButton DrawTiles, EndTurn;
    private JButton archaeologist, assistant, digger, professor;
    private JPanel playersTilesField;
    private JPanel amphoraArea, mosaicArea, skeletonArea, statueArea, landslideArea;
    private JLayeredPane boardGraphics;
    private ArrayList<JButton> amphoraButtons, mosaicButtons, skeletonButtons, statueButtons;
    private JLabel playerName;
    private String previousChoice = "Nothing", nextChoice = "Nothing";
    private int numOfTilesTaken = 0, maxNumOfTilesToTake = 2, numOfDraw = 0, numOfPlayers;
    private boolean drewLandslideTile = false;


    /**
     * <b>Constructor:</b> Creates a new Window and initializes some buttons and panels <br />
     * <b>Postcondition:</b> Creates a new Window and initializes some buttons and panels
     * starting a new game.
     */
    public GUI(int numOfPlayers){
        if(numOfPlayers == 0)
            System.exit(-1);
        this.numOfPlayers = numOfPlayers;
        game = new Controller(numOfPlayers);
        archaeologist = new JButton();
        assistant = new JButton();
        digger = new JButton();
        professor = new JButton();
        DrawTiles = new JButton("Draw Tiles");
        EndTurn = new JButton("End Turn");
        boardGraphics = new JLayeredPane();
        amphoraArea = new JPanel();
        mosaicArea = new JPanel();
        skeletonArea = new JPanel();
        statueArea = new JPanel();
        landslideArea = new JPanel();
        amphoraButtons = new ArrayList<>();
        mosaicButtons = new ArrayList<>();
        skeletonButtons = new ArrayList<>();
        statueButtons = new ArrayList<>();
        setUpGUI();
        displayTiles();
    }

    /**
     * <b>Transformer:</b> initializes the board graphics, the character buttons, the name of the current player, the DrawTiles,
     *                          EndTurn buttons and the playerInventory panel
     * <b>Postcondition:</b> the buttons, labels and panels have been initiated
     */
    public void setUpGUI(){

        boardGraphics.setBounds(0,0,650,650);
        boardGraphics.setVisible(true);

        JLabel lbl = new JLabel("", new ImageIcon("src\\resources\\background.png"), JLabel.CENTER);
        lbl.setBounds(0, 0, 650, 650);
        boardGraphics.add(lbl);

        mosaicArea.setBounds(19, 18, 189, 189);
        statueArea.setBounds(442, 17, 189, 189);
        amphoraArea.setBounds(19, 440, 189, 189);
        skeletonArea.setBounds(441, 441, 189, 189);
        landslideArea.setBounds(232, 284, 189, 189);
        boardGraphics.add(mosaicArea);
        boardGraphics.add(statueArea);
        boardGraphics.add(amphoraArea);
        boardGraphics.add(skeletonArea);
        boardGraphics.add(landslideArea);

        JPanel playerPanel = new JPanel();
        playerPanel.setBounds(650, 0, 320, 25);
        playerName = new JLabel(game.getTurn().getPlayer().getName());
        playerPanel.add(playerName);

        CharacterListener characterListener = new CharacterListener();
        JPanel characterPanel = new JPanel();
        characterPanel.setBounds(650, 50, 320, 450);
        archaeologist.setIcon(new ImageIcon("src\\resources\\archaeologist.png"));
        archaeologist.setSize(120, 195);
        archaeologist.addActionListener(characterListener);
        assistant.setIcon(new ImageIcon("src\\resources\\assistant.png"));
        assistant.setSize(120, 195);
        assistant.addActionListener(characterListener);
        digger.setIcon(new ImageIcon("src\\resources\\digger.png"));
        digger.setSize(120, 195);
        digger.addActionListener(characterListener);
        professor.setIcon(new ImageIcon("src\\resources\\professor.png"));
        professor.setSize(120, 195);
        professor.addActionListener(characterListener);
        characterPanel.add(archaeologist);
        characterPanel.add(assistant);
        characterPanel.add(digger);
        characterPanel.add(professor);

        JPanel drawEndPanel = new JPanel();
        drawEndPanel.setBounds(650, 500, 320, 150);
        DrawEndListener drawEndListener = new DrawEndListener();
        DrawTiles.addActionListener(drawEndListener);
        EndTurn.addActionListener(drawEndListener);
        drawEndPanel.add(DrawTiles);
        drawEndPanel.add(EndTurn);

        playersTilesField = new JPanel();
        playersTilesField.setBounds(0, 650, 970, 150);
        JInternalFrame JIF = new JInternalFrame();
        playersTilesField.add(JIF);

        setTitle("Amphipolis");
        setVisible(true);
        setSize(985,800);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        boardGraphics.moveToBack(lbl);
        add(boardGraphics);
        add(playerPanel);
        add(characterPanel);
        add(drawEndPanel);
        add(playersTilesField);

        validate();
    }

    /**
     * <b>Transformer:</b> displays the player's tiles as labels in the playerTilesField panel
     * <b>Postcondition:</b> the player's tiles have been displayed
     * @param b
     */
    public void displayInventory(Bag b){
        playersTilesField.removeAll();
        playersTilesField.revalidate();
        playersTilesField.repaint();
        for(int i = 0; i < b.getSize(); i++){
            playersTilesField.add(new JLabel("", new ImageIcon(b.getTile(i).getImage()), JLabel.CENTER));
        }
    }

    /**
     * <b>Transformer:</b> displays all the tiles from the designated areas of the board as buttons or labels if the tiles is landslide
     * <b>Postcondition:</b> the tiles have been displayed
     */
    public void displayTiles(){
        amphoraArea.removeAll();
        amphoraArea.revalidate();
        amphoraArea.repaint();
        mosaicArea.removeAll();
        mosaicArea.revalidate();
        mosaicArea.repaint();
        skeletonArea.removeAll();
        skeletonArea.revalidate();
        skeletonArea.repaint();
        statueArea.removeAll();
        statueArea.revalidate();
        statueArea.repaint();
        landslideArea.removeAll();
        landslideArea.revalidate();
        landslideArea.repaint();
        amphoraButtons.clear();
        mosaicButtons.clear();
        skeletonButtons.clear();
        statueButtons.clear();
        TileListener tileListener = new TileListener();
        for(int i = 0; i < game.getBoard().getAmphoraArea().getSize(); i++){
            amphoraButtons.add(new JButton(new ImageIcon(game.getBoard().getAmphoraArea().getTile(i).getImage())));
            amphoraArea.add(amphoraButtons.get(i));
            amphoraButtons.get(i).addActionListener(tileListener);
        }
        for(int i = 0; i < game.getBoard().getMosaicArea().getSize(); i++){
            mosaicButtons.add(new JButton(new ImageIcon(game.getBoard().getMosaicArea().getTile(i).getImage())));
            mosaicArea.add(mosaicButtons.get(i));
            mosaicButtons.get(i).addActionListener(tileListener);
        }
        for(int i = 0; i < game.getBoard().getSkeletonArea().getSize(); i++){
            skeletonButtons.add(new JButton(new ImageIcon(game.getBoard().getSkeletonArea().getTile(i).getImage())));
            skeletonArea.add(skeletonButtons.get(i));
            skeletonButtons.get(i).addActionListener(tileListener);
        }
        for(int i = 0; i < game.getBoard().getStatueArea().getSize(); i++){
            statueButtons.add(new JButton(new ImageIcon(game.getBoard().getStatueArea().getTile(i).getImage())));
            statueArea.add(statueButtons.get(i));
            statueButtons.get(i).addActionListener(tileListener);
        }
        for(int i = 0; i < game.getBoard().getLandslideArea().getSize(); i++){
            if(i == 16) break;
            landslideArea.add(new JLabel(new ImageIcon("src\\resources\\landslide.png")));
        }
    }

    /**
     * a class to listen to the draw tiles button and the end turn button
     */
    private class DrawEndListener implements ActionListener {

        /**
         * <b>Transformer:</b> -> when the DrawTiles button is pressed and if the game has not finished, the last 4 tiles
         *                          from the bag are removed and placed into the designated areas of the board
         *
         *                     -> when the EndTurn button is pressed and if the game has not finished, the player changes
         *                          to the next one and the player's inventory and all of the characters change with them
         *
         *                     -> if the game has finished a window pops up and informs the user about the game winner
         *                          and the points of the players
         * <b>Postcondition:</b>
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == DrawTiles){
                if(numOfPlayers == 4){
                    if(!game.gameFinished() && numOfDraw == 0){
                        numOfDraw++;
                        game.drawTilesFromBag(game.getBag(), game.getTurn().getPlayer().getPlayersTiles());
                        game.getBoard().addToAreas(game.getTurn().getPlayer().getPlayersTiles());
                        displayTiles();
                    }else if(game.gameFinished()){
                        JOptionPane.showMessageDialog(null, game.gameWinner());
                        game.newGame();
                        displayTiles();
                        displayInventory(game.getTurn().getPlayer().getPlayersTiles());
                        archaeologist.setVisible(true);
                        assistant.setVisible(true);
                        digger.setVisible(true);
                        professor.setVisible(true);
                        numOfDraw = 0;
                    }
                }else{
                    if(!game.gameFinished() && numOfDraw == 0){
                        numOfDraw++;
                        game.drawTilesFromBag(game.getBag(), game.getTurn().getPlayer().getPlayersTiles());
                        for(int i = game.getP1().getPlayersTiles().getSize() - 4; i < game.getP1().getPlayersTiles().getSize(); i++){
                            if(game.getP1().getPlayersTiles().getTile(i).getType() == TileType.LANDSLIDE)
                                drewLandslideTile = true;
                        }
                        game.getBoard().addToAreas(game.getTurn().getPlayer().getPlayersTiles());
                        displayTiles();
                    }else if(game.gameFinished()){
                        JOptionPane.showMessageDialog(null, game.gameWinner());
                        game.newGame();
                        displayTiles();
                        displayInventory(game.getTurn().getPlayer().getPlayersTiles());
                        archaeologist.setVisible(true);
                        assistant.setVisible(true);
                        digger.setVisible(true);
                        professor.setVisible(true);
                        numOfDraw = 0;
                    }
                }
            }else if(e.getSource() == EndTurn){
                if(numOfPlayers == 4){
                    if(!game.gameFinished()){
                        numOfDraw = 0;
                        previousChoice = "Nothing";
                        nextChoice = "Nothing";
                        game.getTurn().getPlayer().setHasUsedCharacter(false);
                        numOfTilesTaken = 0;
                        maxNumOfTilesToTake = 2;
                        game.getTurn().endTurn(game.getP1(), game.getP2(), game.getP3(), game.getP4());
                        playerName.setText(game.getTurn().getPlayer().getName());
                        archaeologist.setVisible(!game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(0).getIsUsed());
                        assistant.setVisible(!game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(1).getIsUsed());
                        digger.setVisible(!game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(2).getIsUsed());
                        professor.setVisible(!game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(3).getIsUsed());
                        displayInventory(game.getTurn().getPlayer().getPlayersTiles());
                    }else{
                        JOptionPane.showMessageDialog(null, game.gameWinner());
                        game.newGame();
                        displayTiles();
                        displayInventory(game.getTurn().getPlayer().getPlayersTiles());
                        archaeologist.setVisible(true);
                        assistant.setVisible(true);
                        digger.setVisible(true);
                        professor.setVisible(true);
                        numOfDraw = 0;
                    }
                }else{
                    if(!game.gameFinished()){
                        numOfDraw = 0;
                        previousChoice = "Nothing";
                        nextChoice = "Nothing";
                        game.getTurn().getPlayer().setHasUsedCharacter(false);
                        numOfTilesTaken = 0;
                        maxNumOfTilesToTake = 2;
                        for(int i = 0; i < game.getBoard().getAmphoraArea().getSize(); i++){
                            game.getP2().getPlayersTiles().addTile(game.getBoard().getAmphoraArea().getTile(i));
                            game.getBoard().getAmphoraArea().clearAll();
                        }
                        for(int i = 0; i < game.getBoard().getMosaicArea().getSize(); i++){
                            game.getP2().getPlayersTiles().addTile(game.getBoard().getMosaicArea().getTile(i));
                            game.getBoard().getMosaicArea().clearAll();
                        }
                        for(int i = 0; i < game.getBoard().getSkeletonArea().getSize(); i++){
                            game.getP2().getPlayersTiles().addTile(game.getBoard().getSkeletonArea().getTile(i));
                            game.getBoard().getSkeletonArea().clearAll();
                        }
                        for(int i = 0; i < game.getBoard().getStatueArea().getSize(); i++){
                            game.getP2().getPlayersTiles().addTile(game.getBoard().getStatueArea().getTile(i));
                            game.getBoard().getStatueArea().clearAll();
                        }
                        displayTiles();
                        drewLandslideTile = false;
                    }else{
                        JOptionPane.showMessageDialog(null, game.gameWinner());
                        game.newGame();
                        displayTiles();
                        displayInventory(game.getTurn().getPlayer().getPlayersTiles());
                        archaeologist.setVisible(true);
                        assistant.setVisible(true);
                        digger.setVisible(true);
                        professor.setVisible(true);
                        System.out.println(game.getBoard().getLandslideArea());
                    }
                }
            }
        }
    }

    /**
     * a class to listen to one of the characters buttons
     */
    private class CharacterListener implements ActionListener{

        /**
         * <b>Transformer:</b> when a character button is pressed it resets the number of tiles taken and sets the max number
         *                          of tiles the player can take based on the rules. when the assistant is pressed the
         *                          previous choice is set to "Nothing" so that the player can take one tile from anywhere
         * <b>Postcondition:</b> the character's move has been done
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e){
            if(!game.getTurn().getPlayer().getHasUsedCharacter()) {
                if(e.getSource() == archaeologist && !drewLandslideTile){
                    numOfTilesTaken = 0;
                    maxNumOfTilesToTake = 2;
                    game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(0).setIsUsed(true);
                    archaeologist.setVisible(false);
                    game.getTurn().getPlayer().setHasUsedCharacter(true);
                    if(previousChoice.equals("Amphora"))
                        nextChoice = "notAmphora";
                    else if(previousChoice.equals("Mosaic"))
                        nextChoice = "notMosaic";
                    else if(previousChoice.equals("Skeleton"))
                        nextChoice = "notSkeleton";
                    else if(previousChoice.equals("Statue"))
                        nextChoice = "notStatue";
                    previousChoice = "Something";
                }else if (e.getSource() == assistant && !drewLandslideTile){
                    numOfTilesTaken = 0;
                    maxNumOfTilesToTake = 1;
                    previousChoice = "Nothing";
                    game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(1).setIsUsed(true);
                    assistant.setVisible(false);
                    game.getTurn().getPlayer().setHasUsedCharacter(true);
                }else if (e.getSource() == digger && !drewLandslideTile){
                    numOfTilesTaken = 0;
                    maxNumOfTilesToTake = 2;
                    game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(2).setIsUsed(true);
                    digger.setVisible(false);
                    game.getTurn().getPlayer().setHasUsedCharacter(true);
                }else if (e.getSource() == professor && !drewLandslideTile){
                    numOfTilesTaken = 0;
                    maxNumOfTilesToTake = 3;
                    game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(3).setIsUsed(true);
                    professor.setVisible(false);
                    game.getTurn().getPlayer().setHasUsedCharacter(true);

                }
            }
        }

    }

    /**
     * a class to listen to the tile buttons
     */
    private class TileListener implements ActionListener{

        /**
         * <b>Transformer:</b> when a tile is pressed it disappears from the board and it's being displayed in the player's inventory
         *                          also it sets the previousChoice to that tile type and increment by one the counter
         *                          of how many tile the player has taken this turn so that he can't play off the rules
         * <b>Postcondition:</b> the action is done
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e){
            if(numOfTilesTaken < maxNumOfTilesToTake){
                if((previousChoice.equals("Amphora") || previousChoice.equals("Nothing") || (!nextChoice.equals("notAmphora") && !nextChoice.equals("Nothing"))) && !drewLandslideTile){
                    for(int i = 0; i < game.getBoard().getAmphoraArea().getSize(); i++){
                        if(e.getSource() == amphoraButtons.get(i)){
                            previousChoice = "Amphora";
                            nextChoice = "Nothing";
                            game.getTurn().getPlayer().getPlayersTiles().addTile(game.getBoard().getAmphoraArea().getTile(i));
                            displayInventory(game.getTurn().getPlayer().getPlayersTiles());
                            amphoraButtons.get(i).setVisible(false);
                            numOfTilesTaken++;
                        }
                    }
                }
                if((previousChoice.equals("Mosaic") || previousChoice.equals("Nothing") || (!nextChoice.equals("notMosaic") && !nextChoice.equals("Nothing"))) && !drewLandslideTile){
                    for(int i = 0; i < game.getBoard().getMosaicArea().getSize(); i++){
                        if(e.getSource() == mosaicButtons.get(i)){
                            previousChoice = "Mosaic";
                            nextChoice = "Nothing";
                            game.getTurn().getPlayer().getPlayersTiles().addTile(game.getBoard().getMosaicArea().getTile(i));
                            displayInventory(game.getTurn().getPlayer().getPlayersTiles());
                            mosaicButtons.get(i).setVisible(false);
                            numOfTilesTaken++;
                        }
                    }
                }
                if((previousChoice.equals("Skeleton") || previousChoice.equals("Nothing") || (!nextChoice.equals("notSkeleton") && !nextChoice.equals("Nothing"))) && !drewLandslideTile){
                    for(int i = 0; i < game.getBoard().getSkeletonArea().getSize(); i++){
                        if(e.getSource() == skeletonButtons.get(i)){
                            previousChoice = "Skeleton";
                            nextChoice = "Nothing";
                            game.getTurn().getPlayer().getPlayersTiles().addTile(game.getBoard().getSkeletonArea().getTile(i));
                            displayInventory(game.getTurn().getPlayer().getPlayersTiles());
                            skeletonButtons.get(i).setVisible(false);
                            numOfTilesTaken++;
                        }
                    }
                }
                if((previousChoice.equals("Statue") || previousChoice.equals("Nothing") || (!nextChoice.equals("notStatue") && !nextChoice.equals("Nothing"))) && !drewLandslideTile){
                    for(int i = 0; i < game.getBoard().getStatueArea().getSize(); i++){
                        if(e.getSource() == statueButtons.get(i)){
                            previousChoice = "Statue";
                            nextChoice = "Nothing";
                            game.getTurn().getPlayer().getPlayersTiles().addTile(game.getBoard().getStatueArea().getTile(i));
                            displayInventory(game.getTurn().getPlayer().getPlayersTiles());
                            statueButtons.get(i).setVisible(false);
                            numOfTilesTaken++;
                        }
                    }
                }
            }
        }

    }
    
}
