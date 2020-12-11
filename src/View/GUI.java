package View;

import Controller.Controller;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class GUI extends JFrame{
    private Controller game = new Controller();
    private JButton DrawTiles, EndTurn;
    private JButton archaeologist, assistant, digger, professor;
    //private JButton archaeologistP2, assistantP2, diggerP2, professorP2;
    //private JButton archaeologistP3, assistantP3, diggerP3, professorP3;
    //private JButton archaeologistP4, assistantP4, diggerP4, professorP4;
    private JDesktopPane playersTilesField;
    private JLayeredPane boardGraphics;
    private URL imageURL;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private String previousChoice;
    private JLabel label;
    JButton b1 = new JButton();
    JButton b2 = new JButton();

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
        boardGraphics.setBounds(0,0,500,500);
        boardGraphics.setVisible(true);

        buttons.add(b1);
        buttons.add(b2);
        TileListener me = new TileListener();
        b1.setIcon(new ImageIcon("src\\resources\\mosaic_green.png"));
        b1.setBounds(14, 14, 32, 32);
        b1.addActionListener(me);
        b2.setIcon(new ImageIcon("src\\resources\\mosaic_yellow.png"));
        b2.setBounds(46,14,32,32);
        b2.addActionListener(me);

        JLabel lbl = new JLabel("", new ImageIcon("src\\resources\\background.png"), JLabel.CENTER);
        lbl.setBounds(0, 0, 500, 500);

        boardGraphics.add(lbl);
        boardGraphics.add(b1);
        boardGraphics.add(b2);

        JPanel playerPanel = new JPanel();
        playerPanel.setBounds(501, 0, 320, 25);
        label = new JLabel(game.getTurn().getPlayer().getName());
        playerPanel.add(label);

        CharacterListener characterListener = new CharacterListener();
        JPanel characterPanel = new JPanel();
        characterPanel.setBounds(501, 25, 320, 425);
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
        drawEndPanel.setBounds(501, 450, 320, 50);
        DrawListener drawListener = new DrawListener();
        DrawTiles.addActionListener(drawListener);
        EndTurn.addActionListener(drawListener);
        drawEndPanel.add(DrawTiles);
        drawEndPanel.add(EndTurn);

        playersTilesField = new JDesktopPane();
        playersTilesField.setBounds(0, 500, 850, 150);
        JInternalFrame JIF = new JInternalFrame();
        playersTilesField.add(JIF);

        setTitle("Amphipolis");
        setVisible(true);
        setSize(850,650);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(boardGraphics);
        add(playerPanel);
        add(characterPanel);
        add(drawEndPanel);
        add(playersTilesField);

        validate();
    }

    public JButton getDrawTiles(){ return DrawTiles; }

    /**
     * <b>Transformer:</b> initializes some buttons and labels.
     * <b>Postcondition:</b> the buttons and labels have been initialized.
     */
    public void setUpGUI(){

    }

    /**
     * <b>Transformer   :</b> initializes some buttons and labels for a new game.]
     * <b>Postcondition:</b> the buttons and labels have been initialized.
     */
    public void initButtons(){

    }

    /**
     * <b>Transformer:</b> play a sound
     * <b>Postcondition:</b> play a sound
     * @param soundName
     */
    public void playSound(String soundName){

    }

    /**
     * <b>Accessor:</b> returns the controller field named game from the GUI class to be used by the ActionListener classes
     * <b>Postcondition:</b> the controller field named game has been returned
     * @return Controller game
     */
    public Controller getGame(){ return game; }

    /**
     * a class to listen to the draw button
     */
    private class DrawListener implements ActionListener {

        /**
         * <b>Transformer:</b> doing some action when the Draw Tiles button or the End Turn button is pushed
         * <b>Postcondition:</b> the action is done
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == DrawTiles){
                if(!game.gameFinished()){
                    game.drawTilesFromBag(game.getBag(), game.getTurn().getPlayer().getPlayersTiles());
                    game.getBoard().addToAreas(game.getTurn().getPlayer().getPlayersTiles());
                    System.out.println(game.getBoard());
                }else JOptionPane.showMessageDialog(null, "The game has finished.");
            }else if (e.getSource() == EndTurn){
                game.getTurn().endTurn(game.getP1(), game.getP2(), game.getP3(), game.getP4());
                label.setText(game.getTurn().getPlayer().getName());
                archaeologist.setVisible(!game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(0).getIsUsed());
                assistant.setVisible(!game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(1).getIsUsed());
                digger.setVisible(!game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(2).getIsUsed());
                professor.setVisible(!game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(3).getIsUsed());
                System.out.println(game.getTurn().getPlayer());
            }
        }
    }

    /**
     * a class to listen to one of the characters buttons
     */
    private class CharacterListener implements ActionListener{

        /**
         * <b>Transformer:</b> doing an action when a character button is pressed
         * <b>Postcondition:</b> the action is done
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == archaeologist){
                JOptionPane.showMessageDialog(null, "Archaeologist has been pressed.");
                game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(0).setIsUsed(true);
            }else if(e.getSource() == assistant){
                System.out.println("Assistant has been pressed.");
                game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(1).setIsUsed(true);
            }else if(e.getSource() == digger){
                System.out.println("Digger has been pressed.");
                game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(2).setIsUsed(true);
            }else if(e.getSource() == professor){
                System.out.println("Professor has been pressed.");
                game.getTurn().getPlayer().getCharacterBundle().getCharacters().get(3).setIsUsed(true);
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
        public void actionPerformed(ActionEvent e){}

    }
    
}
