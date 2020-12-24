package View;

import Controller.Controller;
import Model.Game.Bag;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame{
    private Controller game = new Controller();
    private JButton DrawTiles, EndTurn;
    private JButton archaeologist, assistant, digger, professor;
    private JPanel playersTilesField;
    private JPanel amphoraArea, mosaicArea, skeletonArea, statueArea, landslideArea;
    private JLayeredPane boardGraphics;
    private ArrayList<JButton> amphoraButtons, mosaicButtons, skeletonButtons, statueButtons;
    private String previousChoice = "Nothing";
    private int numOfTilesTaken = 0, maxNumOfTilesToTake = 2;
    private JLabel playerName;
    private ArrayList<JLabel> playersTiles = new ArrayList<>();

    /**
     * <b>Constructor:</b> Creates a new Window and initializes some buttons and panels <br />
     * <b>Postcondition:</b> Creates a new Window and initializes some buttons and panels
     * starting a new game.
     */
    public GUI(){
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
    }

    /**
     * <b>Transformer:</b> initializes some buttons and labels.
     * <b>Postcondition:</b> the buttons and labels have been initialized.
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
        DrawListener drawListener = new DrawListener();
        DrawTiles.addActionListener(drawListener);
        EndTurn.addActionListener(drawListener);
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
     * Bag is a custom class which is basically an array list of tiles. tiles are created through other custom classes
     * b.getTile(i) returns the tile in the i position
     * getIsDisplayed() is a method that returns true if the current tile is being already displayed or false if not
     * playersTilesField is an array list with the tiles that are in the player's inventory
     * getImage() returns a String of the tile's image path (e.x "src\\resources\\landslide"
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
     * <b>Transformer:</b> initializes some buttons and labels for a new game.
     * <b>Postcondition:</b> the buttons and labels have been initialized.
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
     * a class to listen to the draw button
     */
    private class DrawListener implements ActionListener {

        /**
         * <b>Transformer:</b> -> when the DrawTiles button is pressed and if the game has not finished, the last 4 tiles
         *                          from the bag are removed and placed into the designated areas of the board
         *
         *                     -> when the EndTurn button is pressed and if the game has not finished, the player changes
         *                          to the next one and the player's inventory and all of the characters change with them
         * <b>Postcondition:</b>
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == DrawTiles){
                if(!game.gameFinished()){
                    game.drawTilesFromBag(game.getBag(), game.getTurn().getPlayer().getPlayersTiles());
                    game.getBoard().addToAreas(game.getTurn().getPlayer().getPlayersTiles());
                    displayTiles();
                }else JOptionPane.showMessageDialog(null, game.gameWinner());
            }else if(e.getSource() == EndTurn){
                if(!game.gameFinished()){
                    previousChoice = "Nothing";
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
                }else JOptionPane.showMessageDialog(null, game.gameWinner());
            }
        }
    }

    /**
     * a class to listen to one of the characters buttons
     */
    private class CharacterListener implements ActionListener{

        /**
         * <b>Transformer:</b> doing the character's move when they have been pressed
         * <b>Postcondition:</b> the character's move has been done
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e){
            if(!game.getTurn().getPlayer().getHasUsedCharacter()) {
                if(e.getSource() == archaeologist){
                    numOfTilesTaken = 0;
                    maxNumOfTilesToTake = 2;
                    game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(0).setIsUsed(true);
                    archaeologist.setVisible(false);
                    game.getTurn().getPlayer().setHasUsedCharacter(true);
                }else if (e.getSource() == assistant){
                    numOfTilesTaken = 0;
                    maxNumOfTilesToTake = 1;
                    previousChoice = "Nothing";
                    game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(1).setIsUsed(true);
                    assistant.setVisible(false);
                    game.getTurn().getPlayer().setHasUsedCharacter(true);
                }else if (e.getSource() == digger){
                    numOfTilesTaken = 0;
                    maxNumOfTilesToTake = 2;
                    game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(2).setIsUsed(true);
                    digger.setVisible(false);
                    game.getTurn().getPlayer().setHasUsedCharacter(true);
                }else if (e.getSource() == professor){
                    numOfTilesTaken = 0;
                    maxNumOfTilesToTake = 1;
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
         * <b>Transformer:</b> doing some action after a tile button is pressed
         * <b>Postcondition:</b> the action is done
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e){
            if(numOfTilesTaken < maxNumOfTilesToTake){
                if(game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(0).getIsUsed()){
                    if(previousChoice.equals("Amphora")){
                        previousChoice = "Nothing";

                    }
                }else if(game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(3).getIsUsed()){

                }else{
                    if(previousChoice.equals("Amphora") || previousChoice.equals("Nothing")){
                        for(int i = 0; i < game.getBoard().getAmphoraArea().getSize(); i++){
                            if(e.getSource() == amphoraButtons.get(i)){
                                previousChoice = "Amphora";
                                game.getTurn().getPlayer().getPlayersTiles().addTile(game.getBoard().getAmphoraArea().getTile(i));
                                displayInventory(game.getTurn().getPlayer().getPlayersTiles());
                                amphoraButtons.get(i).setVisible(false);
                                numOfTilesTaken++;
                            }
                        }
                    }
                    if(previousChoice.equals("Mosaic") || previousChoice.equals("Nothing")){
                        for(int i = 0; i < game.getBoard().getMosaicArea().getSize(); i++){
                            if(e.getSource() == mosaicButtons.get(i)){
                                previousChoice = "Mosaic";
                                game.getTurn().getPlayer().getPlayersTiles().addTile(game.getBoard().getMosaicArea().getTile(i));
                                displayInventory(game.getTurn().getPlayer().getPlayersTiles());
                                mosaicButtons.get(i).setVisible(false);
                                numOfTilesTaken++;
                            }
                        }
                    }
                    if(previousChoice.equals("Skeleton") || previousChoice.equals("Nothing")){
                        for(int i = 0; i < game.getBoard().getSkeletonArea().getSize(); i++){
                            if(e.getSource() == skeletonButtons.get(i)){
                                previousChoice = "Skeleton";
                                game.getTurn().getPlayer().getPlayersTiles().addTile(game.getBoard().getSkeletonArea().getTile(i));
                                displayInventory(game.getTurn().getPlayer().getPlayersTiles());
                                skeletonButtons.get(i).setVisible(false);
                                numOfTilesTaken++;
                            }
                        }
                    }
                    if(previousChoice.equals("Statue") || previousChoice.equals("Nothing")){
                        for(int i = 0; i < game.getBoard().getStatueArea().getSize(); i++){
                            if(e.getSource() == statueButtons.get(i)){
                                previousChoice = "Statue";
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
    
}
