//Dimtiri Papadedes, and Seb Latka
//oct 25th 2019
//Move object
package pokemongui;

import javax.swing.JOptionPane;

/**
 *
 * @author Dimitri
 */
public class Move {

    private int pp,ppMax, damage, accuracy;
    private String physical_special;
    private static String types[] = new String[]{"Normal", "Fire", "Fighting", "Water", "Flying", "Grass", "Poison", "Electric", "Ground", "Psychic", "Rock", "Ice", "Bug", "Dragon", "Ghost", "Dark", "Steel", "Fairy"};
    private String type, name;

    //constructor
    public Move() {
        pp = 0;
        damage = 0;
        accuracy = 0;
        type = "";
        name = "";
        physical_special = "";
    }

    //contructor linked to the first
    public Move(String name, int p, int d, int a, String t, String ps) {
        this();
        pp = p;
        ppMax = p;
        damage = d;
        accuracy = a;
        type = t;
        this.name = name;
        physical_special = ps;
    }

    //setters
    //set the type
    public void setType(String type) {
        this.type = type;
    }

    //set if its physical or specail
    public void setPhysical_special(String ps) {
        this.physical_special = ps;
    }

    //set the damage
    public void setDamage(int damage) {
        this.damage = damage;
    }

    //set the pp
    public void setPp(int pp) {
        this.pp = pp;
    }

    //set the accuracy
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    //set pp max
    public void setPpMax(int ppMax) {
        this.ppMax = ppMax;
    }

    

    
    
    
    //getters
    //get name
    public String getName() {
        return name;
    }

    //get physical special
    public String getPs() {
        return physical_special;
    }

    //get the type
    public String getType() {
        return type;
    }

    //get the pp
    public int getPp() {
        return pp;
    }

    //get the damage
    public int getDamage() {
        return damage;
    }

    //get the Accuracy
    public int getAccuracy() {
        return accuracy;
    }

    //set name
    public void setName(String name) {
        this.name = name;
    }
    
    //get the max pp
    public int getPpMax() {
        return ppMax;
    }

    //get the type of move
    public String getPhysical_special() {
        return physical_special;
    }
    
    //lose one pp
    public boolean use(String t,String t2,Pokemon user) {
        boolean hit = true;
        int num;

        
        //check for immunites
        //ground and flying
        if(type.equals("Ground") && t.equals("Flying") || getType().equals("Ground") && t2.equals("Flying")){
            hit = false;
            Pokemon.txtBattleLog.setText(Pokemon.txtBattleLog.getText() + user.getName() + " used " + name + " but the opponent was immune!");
            
        //Ghost and normal
        }else if(type.equals("Ghost") && t.equals("Normal") || type.equals("Ghost") && t2.equals("Normal")){
            hit = false;
            Pokemon.txtBattleLog.setText(Pokemon.txtBattleLog.getText() + user.getName() + " used " + name + " but the opponent was immune!");
        
        //normal and ghost
        }else if(type.equals("Normal") && t.equals("Ghost") || type.equals("Normal") && t2.equals("Ghost")){
            hit = false;
            Pokemon.txtBattleLog.setText(Pokemon.txtBattleLog.getText() + user.getName() + " used " + name + " but the opponent was immune!");
            
        //fighting and ghost
        }else if(type.equals("Fighting") && t.equals("Ghost") || type.equals("Fighting") && t2.equals("Ghost")){
            hit = false;
            Pokemon.txtBattleLog.setText(Pokemon.txtBattleLog.getText() + user.getName() + " used " + name + " but the opponent was immune!");
        }
        
        
        
        //only do this if hit is true
        if(hit == true){
            
            
        //check the accuracy
        num = (int) (Math.random() * 100 + 1);

        if (num > accuracy) {
            hit = false;
        } else {
            hit = true;
        }


        //check if they have enough pp
        if (pp > 0 && hit == false) {
            Pokemon.txtBattleLog.setText(Pokemon.txtBattleLog.getText() + user.getName() + " used " + name + " but it missed!");
            pp--;
        } else if (pp > 0 && hit == true) {
            pp--;
            
            //code for swords dance 
            //check if the users move is swords dance
         if(name.equals("Swords Dance")){ 
             
             //set the hit to false because it used on itself and should not activate other text output
             hit = false;
             
             //write to the log
             Pokemon.txtBattleLog.setText(Pokemon.txtBattleLog.getText() + user.getName() + " used " + name);
             
             //double the attack stat
             user.setAttack(user.getAttack() + 200);
             
             //if its over 1000 times 
             if(user.getAttack() >= 1000){
                 user.setAttack(1000);
                 //add to log because it is capped
                 Pokemon.txtBattleLog.setText(Pokemon.txtBattleLog.getText() + " but it had no effect!\n");
             }
         }
         
         //code for explosion 
         if(name.equals("Explosion")){
             //kill it 
             user.setHp(0);
             user.setAlive(false);
         }
            
        } else {
            Pokemon.txtBattleLog.setText(Pokemon.txtBattleLog.getText() + user.getName() + " used "+ name + " but it has no PP left\n");
            hit = false;
        }
        
        }

        
        return hit;
    }

    //clone move
    public Move clone() {
        Move m = new Move(name, pp, damage, accuracy, type, physical_special);

        return m;
    }

    //static method
    //return the list of moves
    public static String[] getTypes() {
        return types;
    }

    //to string 
    public String toString() {
        return "\nName: " + name + "\nType: " + type + "\nDamage: " + damage + "\nAccuracy: " + accuracy + "\nPower Points: " + pp;
    }

}
