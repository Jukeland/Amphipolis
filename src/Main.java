import View.GUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{
    public static void main(String[] args){

        Object[] options = {"One Player", "Four Players", "Cancel"};
        int n = JOptionPane.showOptionDialog(null,
                "How many players would you like to play with?",
                "Choose Players",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[2]);
        GUI g = new GUI();

    }
}
