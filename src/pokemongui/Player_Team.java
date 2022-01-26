//Dimitri Papadedes
//Dec 16th 2019
//player Team class for pokemon
package pokemongui;

import javax.swing.JOptionPane;

/**
 *
 * @author dipap8722
 */
public class Player_Team extends Team{

    //constructor
    public Player_Team() {
        super();
    }

    //constructor
    public Player_Team(Pokemon p, Pokemon p2, Pokemon p3, Pokemon p4, Pokemon p5, Pokemon p6) {
        super(p, p2, p3, p4, p5, p6);
    }
    
    
    public void Switch(){
        int poke = Integer.parseInt(JOptionPane.showInputDialog("What Pokemon would you like to swap with"));
       
        
            super.Switch(poke);
    }
    
    
    
    
    
}
