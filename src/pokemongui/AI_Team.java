//Dimitri Papadedes
//Dec 16th 2019
//AI Team class for pokemon
package pokemongui;

/**
 *
 * @author dipap8722
 */
public class AI_Team extends Team {

    //constructor
    public AI_Team() {
        super();
    }

    //constructor
    public AI_Team(Pokemon p, Pokemon p2, Pokemon p3, Pokemon p4, Pokemon p5, Pokemon p6) {
        super(p, p2, p3, p4, p5, p6);
    }
    
    //switch pokemon
    public String Switch(int p){
        
        
        //check what pokemon is alive and switch
        if(poke[0].getAlive() == true){
            p = 0;
        }else if(poke[1].getAlive() == true){
            p = 1;
        }else if(poke[2].getAlive() == true){
            p = 2;
        }else if(poke[3].getAlive() == true){
            p = 3;
        }else if(poke[4].getAlive() == true){
            p = 4;
        }else if(poke[5].getAlive() == true){
            p = 5;
        }
        
        
        
        return "The opponent swapped " + super.Switch(p);
    }
    
    
    //pick a move to use as the ai
    public int movePick(Pokemon defender){
        //create a base move
        int move = (int)(Math.random() * 4) + 1;
        
        //run this loop 5 times to try and get a good move (there is still a random element to it so they are unpredictable)
        for (int i = 0; i < 4; i++) {
            //check if the move is super effective
            if(Pokemon.damageMulti(battling.getMove(move), defender.getType1(), defender.getType2()) == 4 ||Pokemon.damageMulti(battling.getMove(move), defender.getType1(), defender.getType2()) == 2){
                
                
                
            }else if(Pokemon.damageMulti(battling.getMove(move), defender.getType1(), defender.getType2()) <= 1){
                move = (int)(Math.random() * 4) + 1;
            }
        }
        
        
        
        
        
        
        return move;
    }
    
    
    
    
    
    
    
}
