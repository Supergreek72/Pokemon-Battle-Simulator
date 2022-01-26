//Dimitri Papadedes
//Dec 16th 2019
//Team class for pokemon
package pokemongui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dipap8722
 */
abstract public class Team {
    
    protected Pokemon poke[] = new Pokemon[6];
    protected Pokemon battling;

    //constructor
    public Team() {
        //fill in array
        for (int i = 0; i < poke.length; i++) {
            poke[i] = null;
        }
        battling = null;
    }

    //constructor linked to the first
    public Team(Pokemon p,Pokemon p2,Pokemon p3,Pokemon p4,Pokemon p5, Pokemon p6){
        this();
        //fill array
        poke[0] = p.clone();
        poke[1] = p2.clone();
        poke[2] = p3.clone();
        poke[3] = p4.clone();
        poke[4] = p5.clone();
        poke[5] = p6.clone();
        
        battling = poke[0];
    }

    //get pokemon battling
    public Pokemon getBattling() {
        return battling;
    }

    //set battling
    public void setBattling(int b) {
        battling = poke[b];
    }
    
    
    
    //set a pokemon
    public void setPoke(Pokemon p, int number) {
        poke[number] = p;
    }
    
    

    //get a pokemon
    public Pokemon getPoke(int p) {
        return poke[p];
    }
    
    
    
    //switch the pokemon out 
    public String Switch(int i){
        //if the pokemon you are trying to swap with is dead then dont swap em
        if(poke[i].getAlive() == false){
        
        }else{
            //swap em
            Pokemon temp = battling;
            battling = poke[i];
            poke[i] = temp;
            return  poke[i].getName() + " with " + battling.getName();
           
        }
        
        return "";
    }
    
    //return the amount of alive pokemon
    public int getAlive(){
        int alive = 6;
        
        if(poke[0].getAlive() == false){
            alive--;
        }
        if(poke[1].getAlive() == false){
            alive--;
        }
        if(poke[2].getAlive() == false){
            alive--;
        }
        if(poke[3].getAlive() == false){
            alive--;
        }
        if(poke[4].getAlive() == false){
            alive--;
        }
        if(poke[5].getAlive() == false){
            alive--;
        }
        
        
        return alive;
    }
    
    

    @Override
    //to string
    public String toString() {
        return "Team{" + "pokemon 1:" + poke[0].getName() + "\npokemon 2:" + poke[1].getName() + "\npokemon 3:" + poke[2].getName() + "\npokemon 4:" + poke[3].getName() +  "\npokemon 5:" + poke[4].getName() 
                + "\npokemon 6:" + poke[5].getName() +", battling=" + battling.getName() + '}';
    }
    
    
    
    
    
    
    
    
}
