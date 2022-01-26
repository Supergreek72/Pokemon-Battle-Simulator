/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemongui;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Dimitri
 */
public class musicStuff {

    //create variable
    Clip clip;
    
    //playing looping music 
    void playMusicLoop(String filePath) {

        try {
            InputStream in = PokemonBattle.class.getResourceAsStream(filePath);
            InputStream bufferedIn = new BufferedInputStream(in);

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(bufferedIn);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
           
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    
    //playing music 
    void playMusic(String filePath) {

        try {
            InputStream in = PokemonBattle.class.getResourceAsStream(filePath);
            InputStream bufferedIn = new BufferedInputStream(in);

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(bufferedIn);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            
           
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    
    void stop(){
        clip.stop();
    }

    
    

}
