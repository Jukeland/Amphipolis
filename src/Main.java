import View.GUI;
import javax.swing.*;

public class Main{
    public static void main(String[] args){
        int input;
        try{
            input = Integer.parseInt(JOptionPane.showInputDialog("Give me the number of players (1 or 4)"));
            while (input != 1 && input != 4) {
                input = Integer.parseInt(JOptionPane.showInputDialog("Give me the number of players (1 or 4)"));
            }
        }catch(Exception e){
            input = 0;
        }
        GUI g = new GUI(input);

    }
}
