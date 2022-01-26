//Dimitri Papadedes
//oct 25th 2019
//Pokemon Class
package pokemongui;

import javax.swing.JTextArea;

/**
 *
 * @author Dimitri
 */
public class Pokemon {
    public static JTextArea txtBattleLog;

    private int hp, defence, attack, spD, spA, speed, hpMax;
    private String name, type1, type2;
    private Move m1, m2, m3, m4;
    private Boolean alive = true;

    //constructor
    public Pokemon() {
        type1 = "";
        type2 = "";
        hp = 0;
        defence = 0;
        attack = 0;
        spD = 0;
        spA = 0;
        speed = 0;
        m1 = null;
        m2 = null;
        m3 = null;
        m4 = null;
        name = "";
        hpMax = 0;
    }

    //constructor linked to the first
    //with moves
    public Pokemon(String name, int hp, int defence, int attack, int spD, int spA, int speed, Move m1, Move m2, Move m3, Move m4, String t1, String t2) {
        this();
        type1 = t1;
        type2 = t2;
        this.hp = hp;
        this.defence = defence;
        this.attack = attack;
        this.spD = spD;
        this.spA = spA;
        this.speed = speed;
        this.m1 = m1.clone();
        this.m2 = m2.clone();
        this.m3 = m3.clone();
        this.m4 = m4.clone();
        this.name = name;
        hpMax = hp;
    }
    
    //constructor linked to the first
    //without moves
    public Pokemon(String name, int hp, int defence, int attack, int spD, int spA, int speed, String t1, String t2) {
        this();
        type1 = t1;
        type2 = t2;
        this.hp = hp;
        this.defence = defence;
        this.attack = attack;
        this.spD = spD;
        this.spA = spA;
        this.speed = speed;
        this.name = name;
        hpMax = hp;
    }

    //getters    
    //get the name
    public String getName() {
        return name;
    }

    //get type 1
    public String getType1() {
        return type1;
    }

    //get type 2
    public String getType2() {
        return type2;
    }

    //get the hp
    public int getHp() {
        return hp;
    }

    //get Attack
    public int getAttack() {
        return attack;
    }

    //get Defence
    public int getDefence() {
        return defence;
    }

    //get spA
    public int getSpA() {
        return spA;
    }

    //get spD
    public int getSpD() {
        return spD;
    }

    //get speed
    public int getSpeed() {
        return speed;
    }

    //get if its alive
    public Boolean getAlive() {
        return alive;
    }
    
    //get text area
    public static JTextArea getTxtBattleLog() {
        return txtBattleLog;
    }

    //get max hp
    public int getHpMax() {
        return hpMax;
    }
    
    
    //get m1
    public Move getMove(int m) {
        if (m == 1) {
            return m1;
        } else if (m == 2) {
            return m2;
        } else if (m == 3) {
            return m3;
        } else if (m == 4) {
            return m4;
        } else {
            return null;
        }
    }

    //setters
    //set the name
    public void setName(String name) {
        this.name = name;
    }

    //set if alive
    public void setAlive(Boolean alive) {
        this.alive = alive;
    }
    
    //set the hp
    public void setHp(int hp) {
        this.hp = hp;
    }

    //set type 1
    public void setType1(String type1) {
        this.type1 = type1;
    }

    //set type 2
    public void setType2(String type2) {
        this.type2 = type2;
    }

    //set Attack
    public void setAttack(int attack) {
        this.attack = attack;
    }

    //set Defense
    public void setDefence(int defence) {
        this.defence = defence;
    }

    //set spA
    public void setSpA(int spA) {
        this.spA = spA;
    }

    //set spD
    public void setSpD(int spD) {
        this.spD = spD;
    }

    //set speed
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    //set text area
    public static void setTxtBattleLog(JTextArea txtBattleLog) {
        Pokemon.txtBattleLog = txtBattleLog;
    }
    
    //set max hp
    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    //set m1
    public void setMove(Move m, int num) {
        if (num == 1) {
            m1 = m;
        } else if (num == 2) {
            m2 = m;
        } else if (num == 3) {
            m3 = m;
        } else if (num == 4) {
            m4 = m;
        }
    }

    //attack
    public boolean attack(int m,Pokemon p) {
        boolean hit = true;
        //check what move the use and take away a pp and return it 
        if (m == 1) {
            hit = m1.use(p.getType1(), p.getType2(),this);
            if (hit == true) {
                return true;
            } else {
                return false;
            }

        } else if (m == 2) {
            hit = m2.use(p.getType1(), p.getType2(),this);

            if (hit == true) {
                return true;
            } else {
                return false;
            }

        } else if (m == 3) {
            hit = m3.use(p.getType1(), p.getType2(),this);

            if (hit == true) {
                return true;
            } else {
                return false;
            }

        } else if (m == 4) {
            hit = m4.use(p.getType1(), p.getType2(),this);

            if (hit == true) {
                return true;
            } else {
                return false;
            }

        } else {
            return true;
        }

    }

    //take damage 
    public boolean damage(Pokemon attacker, int move) {
        //variables
        int damage = 0;
        boolean stab = false;
        double mod = 1;
        boolean crit = false;

        if(attacker.getMove(move).getDamage() != 0){
            
        

            //check if the move matches one of the types of the pokemon
            if (attacker.getType1().equals(getMove(move).getType()) || attacker.getType1().equals(getMove(move).getType())) {
                stab = true;
            }
        
            //add to mod
            if(stab == true){
                mod = mod + 0.5;
            }

        //check if it is a physical or special move
        if (attacker.getMove(move).getPs().equals("Physical")) {
            //physical damage calculation
            damage = (int) ((((((2 * 100 / 5) + 2) * attacker.getMove(move).getDamage() * attacker.getAttack() / getDefence()) / (45 + (int) ((Math.random() * 5 + 1))) + 2 ) * mod) * damageMulti(attacker.getMove(move),getType1(),getType2())); //* Modifier

        } else {
            //special damage calculation
            damage = (int) ((((((2 * 100 / 5) + 2) * attacker.getMove(move).getDamage() * attacker.getSpA() / getSpD()) / (45 + (int) ((Math.random() * 5 + 1))) + 2) * mod) * damageMulti(attacker.getMove(move),getType1(),getType2()));   //* Modifier
        }
        
        //calculate critical hits
        if((int)(Math.random() * 16) + 1 == 4){
            crit = true;
            damage = damage * 2;
            Pokemon.txtBattleLog.setText(txtBattleLog.getText() + attacker.getName() + " used " + attacker.getMove(move).getName() + ". It was a critical hit!");
        }
        
        //set the new hp
        setHp(hp - damage);

        
        //if its below 0 then set it to 0 and make them dead
        if (hp <= 0) {
            hp = 0;
            alive = false;
        }
        
        }
        return crit;
        
    }
    
    
    
    //Weaknesses
    public static double damageMulti(Move m,String type1,String type2){
        
        double multi = 1;
    
        //check weaknesses and resistances for Normal type
        if(type1.equals("Normal") || type2.equals("Normal")){
            
            //if the move is fighting type do more damage
            if(m.getType().equals("Fighting")){
                multi = multi * 2;
            }
            
            //if the move is Ghost type do no damage
            else if(m.getType().equals("Ghost")){
                multi = multi * 0;
            }
            
        
        
        }
        
        //check weaknesses and resistances for Fire type
        if(type1.equals("Fire") || type2.equals("Fire")){
             
             //if the move is fire do less damage
             if(m.getType().equals("Fire")){
                 multi = multi * 0.5;
             }
             
             //if the move is water do more damage
             else if(m.getType().equals("Water")){
                 multi = multi * 2;
             }
             
             //if the move is grass do less damage
             else if(m.getType().equals("Grass")){
                 multi = multi * 0.5;
             }
             
             //if the move is ice do less damage
             else if(m.getType().equals("Ice")){
                 multi = multi * 0.5;
             }
             
             //if the move is Ground do more damage
             else if(m.getType().equals("Ground")){
                 multi = multi * 2;
             }
             
             //if the move is grass do less damage
             else if(m.getType().equals("Grass")){
                 multi = multi * 0.5;
             }
             
             //if the move is bug do less damage
             if(m.getType().equals("Bug")){
                 multi = multi * 0.5;
             }
             
             //if the move is Rock do more damage
             else if(m.getType().equals("Rock")){
                 multi = multi * 2;
             }
             
             
             //check weaknesses and resistances for water type
         } if(type1.equals("Water") || type2.equals("Water")){
             
             //if the move is Fire do less damage
             if(m.getType().equals("Fire")){
                 multi = multi * 0.5;
             }
             
             //if the move is Water do less damage
             else if(m.getType().equals("Water")){
                 multi = multi * 0.5;
             }
             
             //if the move is Electric do more damage
             else if(m.getType().equals("Electric")){
                 multi = multi * 2;
             }
             
             //if the move is Grass do more damage
             else if(m.getType().equals("Grass")){
                 multi = multi * 2;
             }
             
             //if the move is Ice do less damage
             else if(m.getType().equals("Ice")){
                 multi = multi * 0.5;
             }
             
             
             
          //check weaknesses and resistances for Electric type   
         } if(type1.equals("Electric") || type2.equals("Electric")){
             
             //if the move is Electric do less damage
             if(m.getType().equals("Electric")){
                 multi = multi * 0.5;
             }
             
             //if the move is ground do more damage
             else if(m.getType().equals("Ground")){
                 multi = multi * 2;
             }
             
             //if the move is Flying do less damage
             else if(m.getType().equals("Flying")){
                 multi = multi * 0.5;
             }
             
             
           //check weaknesses and resistances for grass type
         } if(type1.equals("Grass") || type2.equals("Grass")){
          
             //if the move is Fire do more damage
             if(m.getType().equals("Fire")){
                 multi = multi * 2;
             }
             
             //if the move is Water do less damage
             else if(m.getType().equals("Water")){
                 multi = multi * 0.5;
             }
             
             //if the move is Electric do less damage
             else if(m.getType().equals("Electric")){
                 multi = multi * 0.5;
             }
             
             //if the move is grass do less damage
             else if(m.getType().equals("Grass")){
                 multi = multi * 0.5;
             }
             
             //if the move is ice do more damage
             else if(m.getType().equals("Ice")){
                 multi = multi * 2;
             }
             
             //if the move is Poison do more damage
             else if(m.getType().equals("Poison")){
                 multi = multi * 2;
             }
             
             //if the move is Ground do less damage
             else if(m.getType().equals("Ground")){
                 multi = multi * 0.5;
             }
             
             //if the move is Flying do more damage
             else if(m.getType().equals("Flying")){
                 multi = multi * 2;
             }
             
             //if the move is bug do more damage
             else if(m.getType().equals("Bug")){
                 multi = multi * 2;
             }
             
             
         //check weaknesses and resistances for Ice type
         } if(type1.equals("Ice") || type2.equals("Ice")){
             
             
             //if the move is Fire do more damage
             if(m.getType().equals("Fire")){
                 multi = multi * 2;
             }
             
             //if the move is Ice do less damage
             else if(m.getType().equals("Ice")){
                 multi = multi * 0.5;
             }
             
             
             //if the move is Fighting do more damage
             else if(m.getType().equals("Fighting")){
                 multi = multi * 2;
             }
             
             //if the move is rock do more damage
             else if(m.getType().equals("Rock")){
                 multi = multi * 2;
             }
             
             
             
             
         //check weaknesses and resistances for Fighting type
         } if(type1.equals("Fighting") || type2.equals("Fighting")){
             
             //if the move is Flying do more damage
             if(m.getType().equals("Flying")){
                 multi = multi * 2;
             } 
             
             //if the move is Psychic do more damage
             else if(m.getType().equals("Psychic")){
                 multi = multi * 2;
             }
             
             //if the move is bug do less damage
             else if(m.getType().equals("Bug")){
                 multi = multi * 0.5;
             }
             
             //if the move is rock do less damage
             else if(m.getType().equals("Rock")){
                 multi = multi * 0.5;
             }
             
         //check weaknesses and resistances for Poison type
         } if(type1.equals("Poison") || type2.equals("Poison")){
             
             //if the move is grass do less damage
             if(m.getType().equals("Grass")){
                 multi = multi * 0.5;
             } 
             
             
             //if the move is Fighting do less damage
             else if(m.getType().equals("Fighting")){
                 multi = multi * 0.5;
             }
             
             //if the move is Poison do less damage
             else if(m.getType().equals("Poison")){
                 multi = multi * 0.5;
             }
             
             //if the move is Ground do more damage
             else if(m.getType().equals("Ground")){
                 multi = multi * 2;
             }
             
             //if the move is Psychic do more damage
             else if(m.getType().equals("Psychic")){
                 multi = multi * 2;
             }
             
             //if the move is bug do less damage
             else if(m.getType().equals("Bug")){
                 multi = multi * 0.5;
             }
             
             
         //check weaknesses and resistances for Ground type
         } if(type1.equals("Ground") || type2.equals("Ground")){
             
             //if the move is Water do less damage
             if(m.getType().equals("Water")){
                 multi = multi * 2;
             }
             
             //if the move is grass do more damage
             else if(m.getType().equals("Grass")){
                 multi = multi * 2;
             }
             
             //if the move is Ice do more damage
             else if(m.getType().equals("Ice")){
                 multi = multi * 2;
             }
             
             //if the move is Poison do less damage
             else if(m.getType().equals("Poison")){
                 multi = multi * 0.5;
             }
             
             //if the move is Rock do less damage
             else if(m.getType().equals("Rock")){
                 multi = multi * 0.5;
             }
             
             
             
         //check weaknesses and resistances for Flying type
         } if(type1.equals("Flying") || type2.equals("Flying")){
             
             //if the move is Electric do more damage
             if(m.getType().equals("Electric")){
                 multi = multi * 2;
             }
             
             //if the move is Grass do less damage
             else if(m.getType().equals("Grass")){
                 multi = multi * 0.5;
             }
             
             //if the move is Ice do less damage
             else if(m.getType().equals("Ice")){
                 multi = multi * 2;
             }
             
             //if the move is Fighting do less damage
             else if(m.getType().equals("Fighting")){
                 multi = multi * 0.5;
             }
             
             //if the move is Bug do less damage
             else if(m.getType().equals("Bug")){
                 multi = multi * 0.5;
             }
             
             //if the move is Rock do more damage
             else if(m.getType().equals("Rock")){
                 multi = multi * 2;
             }
             
             //if the move is Ground type do no damage
             else if(m.getType().equals("Ground")){
                multi = multi * 0;
            }
             
             
             
             
          //check weaknesses and resistances for Psychic type
         } if(type1.equals("Psychic") || type2.equals("Psychic")){
             
             //if the move is fighting do less damage
             if(m.getType().equals("Fighting")){
                 multi = multi * 0.5;
             }
             
             //if the move is Psychic do less damage
             else if(m.getType().equals("Psychic")){
                 multi = multi * 0.5;
             }
             
             //if the move is Bug do more damage
             else if(m.getType().equals("Bug")){
                 multi = multi * 2;
             }
             
             //if the move is ghost do more damage
             else if(m.getType().equals("Ghost")){
                 multi = multi * 2;
             }
             
             
             
             
         //check weaknesses and resistances for Bug type
         } if(type1.equals("Bug") || type2.equals("Bug")){
             
             //if the move is Fire do more damage
             if(m.getType().equals("Fire")){
                 multi = multi * 2;
             }
             
             //if the move is grass do less damage
             else if(m.getType().equals("Grass")){
                 multi = multi * 0.5;
             }
             
             //if the move is Fighting do less damage
             else if(m.getType().equals("Fighting")){
                 multi = multi * 0.5;
             }
             
             
             //if the move is Ground do less damage
             else if(m.getType().equals("Ground")){
                 multi = multi * 0.5;
             }
             
             //if the move is Flying do more damage
             else if(m.getType().equals("Flying")){
                 multi = multi * 2;
             }
             
             //if the move is Rock do more damage
             else if(m.getType().equals("Rock")){
                 multi = multi * 2;
             }
             
             
             
         //check weaknesses and resistances for Rock type
         } if(type1.equals("Rock") || type2.equals("Rock")){
             
             //if the move is Normal do less damage
             if(m.getType().equals("Normal")){
                 multi = multi * 0.5;
             }
             
             //if the move is Fire do less damage
             else if(m.getType().equals("Fire")){
                 multi = multi * 0.5;
             }
             
             //if the move is Water do more damage
             else if(m.getType().equals("Water")){
                 multi = multi * 2;
             }
             
             //if the move is Grass do more damage
             else if(m.getType().equals("Grass")){
                 multi = multi * 2;
             }
             
             //if the move is Fighting do more damage
             else if(m.getType().equals("Fighting")){
                 multi = multi * 2;
             }
             
             //if the move is poison do less damage
             else if(m.getType().equals("Poison")){
                 multi = multi * 0.5;
             }
             
             //if the move is Ground do more damage
             else if(m.getType().equals("Ground")){
                 multi = multi * 2;
             }
             
             //if the move is Flying do less damage
             else if(m.getType().equals("Flying")){
                 multi = multi * 0.5;
             }
             
             
         //check weaknesses and resistances for Ghost type
         } if(type1.equals("Ghost") || type2.equals("Ghost")){
             
             //if the move is Poison do less damage
             if(m.getType().equals("Poison")){
                 multi = multi * 0.5;
             }
             
             //if the move is Bug do less damage
             else if(m.getType().equals("Bug")){
                 multi = multi * 0.5;
             }
             
             //if the move is ghost do more damage
             else if(m.getType().equals("Ghost")){
                 multi = multi * 2;
             }
             
             //if the move is normal type do no damage
             else if(m.getType().equals("Normal")){
                multi = multi * 0;
            }
             
             //if the move is Fighting type do no damage
             else if(m.getType().equals("Fighting")){
                multi = multi * 0;
            }
         
        
         //check weaknesses and resistances for Dragon type
         } if(type1.equals("Dragon") || type2.equals("Dragon")){
             
             //if the move is fire do less damage
             if(m.getType().equals("Fire")){
                 multi = multi * 0.5;
             }
             
             //if the move is water do less damage
             else if(m.getType().equals("Water")){
                 multi = multi * 0.5;
             }
             
             //if the move is electric do less damage
             else if(m.getType().equals("Electric")){
                 multi = multi * 0.5;
             }
             
             //if the move is Grass do less damage
             else if(m.getType().equals("Grass")){
                 multi = multi * 0.5;
             }
             
             //if the move is Ice do more damage
             else if(m.getType().equals("Ice")){
                 multi = multi * 2;
             }
             
             //if the move is Dragon do more damage
             else if(m.getType().equals("Dragon")){
                 multi = multi * 2;
             }
             
             
             
         }
        
        
        return multi;
    }
    
    
    //pokemon clone
    public Pokemon clone() {
        Pokemon p = new Pokemon(name,hp, defence,  attack,  spD,  spA,  speed,  m1,  m2,  m3,  m4,  type1, type2);

        return p;
    }
    
    //pokemon clone without moves
    public Pokemon cloneNoMoves() {
        Pokemon p = new Pokemon(name,hp, defence,  attack,  spD,  spA,  speed, type1, type2);

        return p;
    }

    //to string
    public String toString() {
        return "\nName: " + name + "\nAlive: " + alive + "\nType 1: " + type1 + "\nType 2: " + type2 + "\nHealth: " + hp + "\nAttack: " + attack + "\nDefence: "
                + defence + "\nSpA: " + spA + "\nSpD: " + spD + "\nSpeed: " + speed + "\nMove 1: " + m1 + "\nMove 2: " + m2 + "\nMove 3: " + m3 + "\nMove 4: " + m4;
    }

}
