//Dimitri & Seb
//Dec 20th
//pokemon battling Jframe
package pokemongui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Dimitri Papadedes
 */
public class PokemonBattle extends JFrame {

    PokemonBattleSwap battleSwap;
    PokemonChooseBattle chooseBattle;
    PokemonMenu mainMenu;
    /**
     * Creates new form PokemonBattle
     *
     * @param pcb
     */
    

    //hp defense attack spd spa speed
    

    Team team;
    Team AI;

    //variables
    boolean clicked = true, battleEnd = false;
    int AI_move = 0;
    URL url;
    ImageIcon sprite = new ImageIcon();
    int health;
    boolean swap = false, AnimateFirst = false;

    //create music objects
    musicStuff battleTheme = new musicStuff();
    musicStuff victory = new musicStuff();
    musicStuff buttonSound = new musicStuff();

    //constructor
    public PokemonBattle(PokemonChooseBattle pcb, PokemonMenu p, AI_Team ai, Player_Team pt) {

        initComponents();

        chooseBattle = pcb;
        mainMenu = p;

        //set the teams
        team = pt;
        AI = ai;

        //set name 
        lblName1.setText(team.battling.getName());
        lblName2.setText(AI.battling.getName());

        //set the health number
        lblHealthMax.setText("" + team.getBattling().getHpMax());
        lblHealth.setText("" + team.getBattling().getHp());

        //set moves
        btnMove1.setText(team.getBattling().getMove(1).getName());
        btnMove2.setText(team.getBattling().getMove(2).getName());
        btnMove3.setText(team.getBattling().getMove(3).getName());
        btnMove4.setText(team.getBattling().getMove(4).getName());

        //set pp
        lblpp1.setText("PP: " + team.getBattling().getMove(1).getPp() + "/" + team.getBattling().getMove(1).getPpMax());
        lblpp2.setText("PP: " + team.getBattling().getMove(2).getPp() + "/" + team.getBattling().getMove(2).getPpMax());
        lblpp3.setText("PP: " + team.getBattling().getMove(3).getPp() + "/" + team.getBattling().getMove(3).getPpMax());
        lblpp4.setText("PP: " + team.getBattling().getMove(4).getPp() + "/" + team.getBattling().getMove(4).getPpMax());

        //set type of move
        lblType1.setText("Type: " + team.getBattling().getMove(1).getType());
        lblType2.setText("Type: " + team.getBattling().getMove(2).getType());
        lblType3.setText("Type: " + team.getBattling().getMove(3).getType());
        lblType4.setText("Type: " + team.getBattling().getMove(4).getType());

        //pass the text area
        Pokemon.setTxtBattleLog(txtBattleLog);

        //set pokeball behind the buttons 
        url = PokemonMenu.class.getResource("pokeball background.png");
        sprite = new ImageIcon(url);
        lblPokeball.setIcon(sprite);

        //get and display the battle area
        //pick a background
        int rand = (int) (Math.random() * 3) + 1;

        if (rand == 1) {
            url = PokemonMenu.class.getResource("dirt.png");
        } else if (rand == 2) {
            url = PokemonMenu.class.getResource("rock.png");
        } else {
            url = PokemonMenu.class.getResource("grass.png");
        }
        sprite = new ImageIcon(url);
        lblArea.setIcon(sprite);

        //center the frame
        setLocationRelativeTo(null);

        //images need to be put directly in the package not in a diffrent folder within 
        //get and display the AI's pokemon 
        url = PokemonMenu.class.getResource(AI.getBattling().getName() + ".png");
        sprite = new ImageIcon(url);
        lblp2.setIcon(sprite);

        //get and display the players pokemon
        url = PokemonMenu.class.getResource("b" + team.getBattling().getName() + ".png");
        sprite = new ImageIcon(url);
        lblp1.setIcon(sprite);

        //set the icon of the frame
        url = PokemonMenu.class.getResource("pokeball.png");
        sprite = new ImageIcon(url);
        setIconImage(sprite.getImage());

        //set the health bar image
        url = PokemonMenu.class.getResource("healthBar1.png");
        sprite = new ImageIcon(url);
        lblHealthIcon.setIcon(sprite);
        url = PokemonMenu.class.getResource("healthBar2.png");
        sprite = new ImageIcon(url);
        lblHealthIcon2.setIcon(sprite);

        //play battle theme
        battleTheme.playMusicLoop("Pokemon Red, Yellow, Blue Battle Music- Trainer.wav");

        //change the colours of the buttons depending on the type
        //base is normal
        Color colour;
        for (int i = 1; i <= 4; i++) {
            //for water type moves
            if (team.getBattling().getMove(i).getType().equals("Water")) {
                colour = new Color(3, 140, 252);
                //for fire type moves
            } else if (team.getBattling().getMove(i).getType().equals("Fire")) {
                colour = new Color(210, 59, 14);
                //ground
            } else if (team.getBattling().getMove(i).getType().equals("Ground")) {
                colour = new Color(168, 105, 2);
                //dragon
            } else if (team.getBattling().getMove(i).getType().equals("Dragon")) {
                colour = new Color(142, 23, 227);
                //electric
            } else if (team.getBattling().getMove(i).getType().equals("Electric")) {
                colour = new Color(255, 234, 0);
                //poison
            } else if (team.getBattling().getMove(i).getType().equals("Poison")) {
                colour = new Color(109, 0, 163);
                //Ice
            } else if (team.getBattling().getMove(i).getType().equals("Ice")) {
                colour = new Color(140, 222, 246);
                //Rock
            } else if (team.getBattling().getMove(i).getType().equals("Rock")) {
                colour = new Color(97, 64, 3);
                //grass
            } else if (team.getBattling().getMove(i).getType().equals("Grass")) {
                colour = new Color(11, 227, 51);
                //bug
            } else if (team.getBattling().getMove(i).getType().equals("Bug")) {
                colour = new Color(157, 219, 81);
                //flying
            } else if (team.getBattling().getMove(i).getType().equals("Flying")) {
                colour = new Color(70, 213, 235);
                //ghost
            } else if (team.getBattling().getMove(i).getType().equals("Ghost")) {
                colour = new Color(113, 79, 158);
                //psychic
            } else if (team.getBattling().getMove(i).getType().equals("Psychic")) {
                colour = new Color(232, 32, 199);
                //fighting
            } else if (team.getBattling().getMove(i).getType().equals("Fighting")) {
                colour = new Color(194, 36, 0);
            } else {
                colour = new Color(217, 221, 222);
            }

            //set the button
            if (i == 1) {
                btnMove1.setBackground(colour);
            } else if (i == 2) {
                btnMove2.setBackground(colour);
            } else if (i == 3) {
                btnMove3.setBackground(colour);
            } else if (i == 4) {
                btnMove4.setBackground(colour);
            }

        }

        //set the health bars
        health1.setMaximum(team.getBattling().getHp());
        health1.setValue(team.getBattling().getHp());
        health2.setMaximum(AI.getBattling().getHp());
        health2.setValue(AI.getBattling().getHp());

    }

    //enable all the buttons from another frame
    public void buttons() {
        btnMove1.setEnabled(true);
        btnMove2.setEnabled(true);
        btnMove3.setEnabled(true);
        btnMove4.setEnabled(true);
        swapBTN.setEnabled(true);
    }

    //reset
    public void reset(Team t) {
        //change the team variable
        team = t;

        //set the health bars back to full
        health1.setMaximum(team.getBattling().getHpMax());

        health1.setValue(team.getBattling().getHp());

        //set moves
        btnMove1.setText(team.getBattling().getMove(1).getName());
        btnMove2.setText(team.getBattling().getMove(2).getName());
        btnMove3.setText(team.getBattling().getMove(3).getName());
        btnMove4.setText(team.getBattling().getMove(4).getName());

        
        
        
        //get and display the players pokemon
        url = PokemonMenu.class.getResource("b" + team.getBattling().getName() + ".png");
        sprite = new ImageIcon(url);
        lblp1.setIcon(sprite);
        
        //separte the turns 
        txtBattleLog.setText(txtBattleLog.getText() + "-----------------------------\n");

        //set pp
        lblpp1.setText("PP: " + team.getBattling().getMove(1).getPp() + "/" + team.getBattling().getMove(1).getPpMax());
        lblpp2.setText("PP: " + team.getBattling().getMove(2).getPp() + "/" + team.getBattling().getMove(2).getPpMax());
        lblpp3.setText("PP: " + team.getBattling().getMove(3).getPp() + "/" + team.getBattling().getMove(3).getPpMax());
        lblpp4.setText("PP: " + team.getBattling().getMove(4).getPp() + "/" + team.getBattling().getMove(4).getPpMax());

        //set type of move
        lblType1.setText("Type: " + team.getBattling().getMove(1).getType());
        lblType2.setText("Type: " + team.getBattling().getMove(2).getType());
        lblType3.setText("Type: " + team.getBattling().getMove(3).getType());
        lblType4.setText("Type: " + team.getBattling().getMove(4).getType());

        //set name 
        lblName1.setText(team.battling.getName());

        //change the colours of the buttons depending on the type
        //base is normal
        Color colour;
        for (int i = 1; i <= 4; i++) {
            //for water type moves
            if (team.getBattling().getMove(i).getType().equals("Water")) {
                colour = new Color(3, 140, 252);
                //for fire type moves
            } else if (team.getBattling().getMove(i).getType().equals("Fire")) {
                colour = new Color(210, 59, 14);
                //ground
            } else if (team.getBattling().getMove(i).getType().equals("Ground")) {
                colour = new Color(168, 105, 2);
                //dragon
            } else if (team.getBattling().getMove(i).getType().equals("Dragon")) {
                colour = new Color(142, 23, 227);
                //electric
            } else if (team.getBattling().getMove(i).getType().equals("Electric")) {
                colour = new Color(255, 234, 0);
                //poison
            } else if (team.getBattling().getMove(i).getType().equals("Poison")) {
                colour = new Color(109, 0, 163);
                //Ice
            } else if (team.getBattling().getMove(i).getType().equals("Ice")) {
                colour = new Color(140, 222, 246);
                //Rock
            } else if (team.getBattling().getMove(i).getType().equals("Rock")) {
                colour = new Color(97, 64, 3);
                //grass
            } else if (team.getBattling().getMove(i).getType().equals("Grass")) {
                colour = new Color(11, 227, 51);
                //bug
            } else if (team.getBattling().getMove(i).getType().equals("Bug")) {
                colour = new Color(157, 219, 81);
                //flying
            } else if (team.getBattling().getMove(i).getType().equals("Flying")) {
                colour = new Color(70, 213, 235);
                //ghost
            } else if (team.getBattling().getMove(i).getType().equals("Ghost")) {
                colour = new Color(113, 79, 158);
                //psychic
            } else if (team.getBattling().getMove(i).getType().equals("Psychic")) {
                colour = new Color(232, 32, 199);
                //fighting
            } else if (team.getBattling().getMove(i).getType().equals("Fighting")) {
                colour = new Color(194, 36, 0);
            } else {
                colour = new Color(217, 221, 222);
            }

            //set the button
            if (i == 1) {
                btnMove1.setBackground(colour);
            } else if (i == 2) {
                btnMove2.setBackground(colour);
            } else if (i == 3) {
                btnMove3.setBackground(colour);
            } else if (i == 4) {
                btnMove4.setBackground(colour);
            }

        }

        //enable all the buttons 
        btnMove1.setEnabled(true);
        btnMove2.setEnabled(true);
        btnMove3.setEnabled(true);
        btnMove4.setEnabled(true);
        swapBTN.setEnabled(true);

        //set the health number
        lblHealthMax.setText("" + team.getBattling().getHpMax());
        lblHealth.setText("" + team.getBattling().getHp());
        
        
        
        boolean hit;
        
        //check if they clicked swap and if they did let the AI attack their new pokemon
            if (clicked) {
            hit = attack(AI.getBattling(), team.getBattling(), AI_move);

            //check if it hit
            if (hit == true) {
                //set the health
                animateHealth();
                animateHealth2();
                animateSwipe2();
                
                if(team.getBattling().getHp() <= 0){
                        team.getBattling().setAlive(false);
                    }
            }
        
        
        }
        
        
        //reset clicked
        clicked = true;
    }

    //type to the battle log
    public void type(String s) {
        txtBattleLog.setText(txtBattleLog.getText() + s + "\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        battlePNL = new javax.swing.JPanel();
        lblSwipe2 = new javax.swing.JLabel();
        health1 = new javax.swing.JProgressBar();
        health2 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblSwipe1 = new javax.swing.JLabel();
        lblName2 = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        lblHealthMax = new javax.swing.JLabel();
        lblHealth = new javax.swing.JLabel();
        lblHealthIcon2 = new javax.swing.JLabel();
        lblHealthIcon = new javax.swing.JLabel();
        lblp1 = new javax.swing.JLabel();
        lblp2 = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBattleLog = new javax.swing.JTextArea();
        lblpp3 = new javax.swing.JLabel();
        lblpp4 = new javax.swing.JLabel();
        lblpp1 = new javax.swing.JLabel();
        lblpp2 = new javax.swing.JLabel();
        lblType4 = new javax.swing.JLabel();
        lblType1 = new javax.swing.JLabel();
        lblType2 = new javax.swing.JLabel();
        lblType3 = new javax.swing.JLabel();
        btnMove1 = new javax.swing.JButton();
        btnMove2 = new javax.swing.JButton();
        btnMove3 = new javax.swing.JButton();
        btnMove4 = new javax.swing.JButton();
        swapBTN = new javax.swing.JButton();
        lblPokeball = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokemon Battle Simulator");
        setBackground(java.awt.Color.lightGray);
        setBounds(new java.awt.Rectangle(0, 23, 600, 700));
        setMinimumSize(new java.awt.Dimension(600, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        battlePNL.setBackground(new java.awt.Color(255, 255, 255));
        battlePNL.setLayout(null);
        battlePNL.add(lblSwipe2);
        lblSwipe2.setBounds(330, 110, 160, 60);

        health1.setBackground(new java.awt.Color(102, 255, 102));
        health1.setForeground(new java.awt.Color(255, 255, 255));
        battlePNL.add(health1);
        health1.setBounds(464, 219, 82, 12);

        health2.setBackground(new java.awt.Color(0, 255, 0));
        health2.setForeground(new java.awt.Color(255, 255, 255));
        battlePNL.add(health2);
        health2.setBounds(54, 64, 92, 12);
        health2.getAccessibleContext().setAccessibleDescription("");

        jLabel2.setFont(new java.awt.Font("Power Green", 1, 14)); // NOI18N
        jLabel2.setText("100");
        battlePNL.add(jLabel2);
        jLabel2.setBounds(120, 40, 41, 16);

        jLabel1.setFont(new java.awt.Font("Power Green", 1, 14)); // NOI18N
        jLabel1.setText("100");
        battlePNL.add(jLabel1);
        jLabel1.setBounds(520, 196, 41, 16);
        jLabel1.getAccessibleContext().setAccessibleDescription("");

        battlePNL.add(lblSwipe1);
        lblSwipe1.setBounds(40, 200, 160, 80);

        lblName2.setFont(new java.awt.Font("Power Green", 0, 20)); // NOI18N
        battlePNL.add(lblName2);
        lblName2.setBounds(10, 25, 120, 40);

        lblName1.setFont(new java.awt.Font("Power Green", 0, 20)); // NOI18N
        battlePNL.add(lblName1);
        lblName1.setBounds(393, 188, 90, 30);

        lblHealthMax.setFont(jLabel1.getFont());
        battlePNL.add(lblHealthMax);
        lblHealthMax.setBounds(510, 227, 50, 20);

        lblHealth.setFont(jLabel1.getFont());
        battlePNL.add(lblHealth);
        lblHealth.setBounds(465, 227, 50, 20);
        lblHealth.getAccessibleContext().setAccessibleDescription("");

        lblHealthIcon2.setMinimumSize(new java.awt.Dimension(250, 98));
        battlePNL.add(lblHealthIcon2);
        lblHealthIcon2.setBounds(-10, 0, 210, 110);

        lblHealthIcon.setMinimumSize(new java.awt.Dimension(250, 98));
        battlePNL.add(lblHealthIcon);
        lblHealthIcon.setBounds(354, 160, 210, 110);

        lblp1.setAlignmentY(0.0F);
        battlePNL.add(lblp1);
        lblp1.setBounds(80, 210, 84, 80);
        battlePNL.add(lblp2);
        lblp2.setBounds(370, 110, 80, 74);

        lblArea.setMaximumSize(new java.awt.Dimension(549, 300));
        lblArea.setName(""); // NOI18N
        battlePNL.add(lblArea);
        lblArea.setBounds(0, 0, 550, 270);

        getContentPane().add(battlePNL, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 24, 549, 268));

        txtBattleLog.setColumns(20);
        txtBattleLog.setFont(new java.awt.Font("Power Green", 0, 20)); // NOI18N
        txtBattleLog.setRows(5);
        txtBattleLog.setEnabled(false);
        jScrollPane1.setViewportView(txtBattleLog);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 292, 549, 110));

        lblpp3.setText("PP:");
        getContentPane().add(lblpp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 700, 70, -1));

        lblpp4.setText("PP:");
        getContentPane().add(lblpp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 700, 70, -1));

        lblpp1.setText("PP:");
        getContentPane().add(lblpp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 70, -1));

        lblpp2.setText("PP:");
        getContentPane().add(lblpp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 560, 70, -1));

        lblType4.setText("Type:");
        getContentPane().add(lblType4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 700, -1, -1));

        lblType1.setText("Type:");
        getContentPane().add(lblType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, -1));

        lblType2.setText("Type:");
        getContentPane().add(lblType2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        lblType3.setText("Type:");
        getContentPane().add(lblType3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, -1, -1));

        btnMove1.setBackground(new java.awt.Color(153, 153, 153));
        btnMove1.setFont(new java.awt.Font("Power Green", 1, 24)); // NOI18N
        btnMove1.setText("\"attack1\"");
        btnMove1.setMaximumSize(new java.awt.Dimension(175, 80));
        btnMove1.setMinimumSize(new java.awt.Dimension(175, 80));
        btnMove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMove1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMove1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 474, 260, 110));

        btnMove2.setBackground(new java.awt.Color(153, 153, 153));
        btnMove2.setFont(new java.awt.Font("Power Green", 1, 24)); // NOI18N
        btnMove2.setText("\"attack2\"");
        btnMove2.setMaximumSize(new java.awt.Dimension(175, 80));
        btnMove2.setMinimumSize(new java.awt.Dimension(175, 80));
        btnMove2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMove2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMove2, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 474, 260, 110));

        btnMove3.setBackground(new java.awt.Color(153, 153, 153));
        btnMove3.setFont(new java.awt.Font("Power Green", 1, 24)); // NOI18N
        btnMove3.setText("\"attack3\"");
        btnMove3.setMaximumSize(new java.awt.Dimension(240, 110));
        btnMove3.setMinimumSize(new java.awt.Dimension(240, 110));
        btnMove3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMove3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMove3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 611, 260, 110));

        btnMove4.setBackground(new java.awt.Color(153, 153, 153));
        btnMove4.setFont(new java.awt.Font("Power Green", 1, 24)); // NOI18N
        btnMove4.setText("\"attack4\"");
        btnMove4.setMaximumSize(new java.awt.Dimension(175, 80));
        btnMove4.setMinimumSize(new java.awt.Dimension(175, 80));
        btnMove4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMove4ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMove4, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 611, 260, 110));

        swapBTN.setBackground(new java.awt.Color(153, 153, 153));
        swapBTN.setFont(new java.awt.Font("Power Green", 1, 24)); // NOI18N
        swapBTN.setText("Swap");
        swapBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swapBTNActionPerformed(evt);
            }
        });
        getContentPane().add(swapBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 108, 50));
        getContentPane().add(lblPokeball, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 350, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMove4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMove4ActionPerformed
        health = team.getBattling().getHp();
        //attacking
        useMove(4);
    }//GEN-LAST:event_btnMove4ActionPerformed

    private void btnMove3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMove3ActionPerformed
health = team.getBattling().getHp();        
//attacking
        useMove(3);
    }//GEN-LAST:event_btnMove3ActionPerformed

    private void btnMove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMove1ActionPerformed
       health = team.getBattling().getHp();
        //attacking
        useMove(1);
    }//GEN-LAST:event_btnMove1ActionPerformed

    private void btnMove2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMove2ActionPerformed
health = team.getBattling().getHp();        
//attacking
        useMove(2);


    }//GEN-LAST:event_btnMove2ActionPerformed

    private void swapBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swapBTNActionPerformed

        //check if the player clicked swap or their pokemon just died
        if (clicked) {
            //make sure the AI picks a move before the swap
            AI_move = ((AI_Team) AI).movePick(team.getBattling());
            
            //click sound
            buttonSound.playMusic("Pressing A Sound.wav");
        }

        swap = true;
        //disable all the buttons 
        btnMove1.setEnabled(false);
        btnMove2.setEnabled(false);
        btnMove3.setEnabled(false);
        btnMove4.setEnabled(false);
        swapBTN.setEnabled(false);

        //create a new Jframe
        battleSwap = new PokemonBattleSwap(this, team);

        battleSwap.setVisible(true);
    }//GEN-LAST:event_swapBTNActionPerformed

    public void useMove(int m) {
        //click sound 
        buttonSound.playMusic("Pressing A Sound.wav");

        //if it hits boolean
        boolean hit;

        //player move 
        int player_move = m;

        //pick the AI move
        AI_move = ((AI_Team) AI).movePick(team.getBattling());

        //check who is faster
        if (team.getBattling().getSpeed() > AI.getBattling().getSpeed()) {

            hit = attack(team.getBattling(), AI.getBattling(), player_move);
            //hit the oppenent
            if (hit == true) {
                animateSwipe1();
                AnimateFirst = false;
            }

            //check if the pokemon got killed
            if (AI.getBattling().getAlive() == true) {

                //check for explosion / things that kill them
                if (team.getBattling().getAlive() == true) {
                    hit = attack(AI.getBattling(), team.getBattling(), AI_move);
                    if (hit == true) {
                        
                        
                    }
                }

            }

        } else {
            hit = attack(AI.getBattling(), team.getBattling(), AI_move);
            //hit the player
            if (hit == true) {
                animateSwipe2();
                animateHealth2();
            }

            //check if the pokemon got killed
            if (team.getBattling().getAlive() == true) {
                //check for explosion / things that kill them
                if (AI.getBattling().getAlive() == true) {
                    hit = attack(team.getBattling(), AI.getBattling(), player_move);
                    //hit the oppenent
                    if (hit == true) {
                        animateSwipe1();
                         
                    }
                }

            }

        }

        //switch move names
        btnMove1.setText(team.getBattling().getMove(1).getName());
        btnMove2.setText(team.getBattling().getMove(2).getName());
        btnMove3.setText(team.getBattling().getMove(3).getName());
        btnMove4.setText(team.getBattling().getMove(4).getName());

        //set pp
        lblpp1.setText("PP: " + team.getBattling().getMove(1).getPp() + "/" + team.getBattling().getMove(1).getPpMax());
        lblpp2.setText("PP: " + team.getBattling().getMove(2).getPp() + "/" + team.getBattling().getMove(2).getPpMax());
        lblpp3.setText("PP: " + team.getBattling().getMove(3).getPp() + "/" + team.getBattling().getMove(3).getPpMax());
        lblpp4.setText("PP: " + team.getBattling().getMove(4).getPp() + "/" + team.getBattling().getMove(4).getPpMax());

        //separte the turns 
        txtBattleLog.setText(txtBattleLog.getText() + "-----------------------------\n");

        btnMove1.setEnabled(true);
        btnMove2.setEnabled(true);
        btnMove3.setEnabled(true);
        btnMove4.setEnabled(true);
        swapBTN.setEnabled(true);

        //set the health
        animateHealth();
       animateHealth2();

    }

    //attacking
    public boolean attack(Pokemon attacker, Pokemon defender, int move) {
     
        //create a boolean to hold weather it hit or not 
        boolean hit = attacker.attack(move, defender);
        //variable for crits
        boolean crit;

        //if the attack does not miss or is not immune 
        if (hit == true) {

            //damage the defender
            crit = defender.damage(attacker, move);

            if (crit == true) {

            } else {
                //output the attack used
                txtBattleLog.setText(txtBattleLog.getText() + attacker.getName() + " used " + attacker.getMove(move).getName()
                        + ".");

            }
            //check if the move effectivness
            if (Pokemon.damageMulti(attacker.getMove(move), defender.getType1(), defender.getType2()) >= 2) {
                //if greater than or equal to 2 tell them it was super effective
                txtBattleLog.setText(txtBattleLog.getText() + " It was super effective!");
            } else if (Pokemon.damageMulti(attacker.getMove(move), defender.getType1(), defender.getType2()) < 1) {
                //if less than 1 tell them it was not very effective
                txtBattleLog.setText(txtBattleLog.getText() + " It was not very effective!");
            }

        } else {

        }

        //skip a line
        txtBattleLog.setText(txtBattleLog.getText() + "\n");

        return hit;
    }

    public void checkDeaths() {
        //check if their pokemon is dead
        if (AI.getBattling().getAlive() == false) {
            //set the health of the AI
            health2.setMaximum(AI.getBattling().getHp());
            health2.setValue(AI.getBattling().getHp());
            //check if the ai is out of pokemon 
            if (AI.getAlive() == 0) {
                //stop battle theme and play victory music 
                victory.playMusicLoop("Pokémon Red & Blue Music Gym Leader Victory Theme.wav");
                battleTheme.stop();

                //load image
                url = PokemonMenu.class.getResource("pokeball.png");
                sprite = new ImageIcon(url);

                //tell them they won
                JOptionPane.showMessageDialog(null, "All of the opponent's pokemon have fainted. You have won!", "You Won!", JOptionPane.INFORMATION_MESSAGE, sprite);
                clear();

                //trash the gui and stop the music 
                victory.stop();
                this.dispose();
                //open the main menu
                mainMenu.setVisible(true);
                //close the swap menu
                battleSwap.setVisible(false);
                //start main menu music 
                mainMenu.music.playMusicLoop("Pokémon Red & Blue Music Opening Theme.wav");

            } else {

                //tell them the pokemon fainted and then swap
                txtBattleLog.setText(txtBattleLog.getText() + AI.getBattling().getName() + " fainted\n");
                txtBattleLog.setText(txtBattleLog.getText() + AI.Switch(0) + "\n");

                //get and display the AI's pokemon
                url = PokemonMenu.class.getResource(AI.getBattling().getName() + ".png");
                sprite = new ImageIcon(url);
                lblp2.setIcon(sprite);

                //set the health bar
                health2.setMaximum(AI.getBattling().getHp());
                health2.setValue(AI.getBattling().getHp());

                //set name
                lblName2.setText(AI.battling.getName());

            }
        }

        //check if your pokemon is dead
        if (team.getBattling().getAlive() == false) {
            //check if all your pokemon are dead and end the battle
            if (team.getAlive() == 0) {
                battleTheme.stop();
                //load image
                url = PokemonMenu.class.getResource("pokeball.png");
                sprite = new ImageIcon(url);
                //tell them they lost
                JOptionPane.showMessageDialog(null, "All your pokemon have fainted. You were defeated", "You Lost!", JOptionPane.INFORMATION_MESSAGE, sprite);
                clear();
                this.dispose();
                //set the main menu to true
                mainMenu.setVisible(true);
                //close the swap menu
                battleSwap.setVisible(false);
                mainMenu.music.playMusicLoop("Pokémon Red & Blue Music Opening Theme.wav");
            } else {

                //tell them their pokemon fainted
                txtBattleLog.setText(txtBattleLog.getText() + team.getBattling().getName() + " fainted\n");
                clicked = false;
                //swap
                swapBTN.doClick();
            }
        }

    }

    public void clear() {
        txtBattleLog.setText("");
    }
    Timer time;
    Timer time3;

    public void animateSwipe2() {

        //action lister 
        ActionListener al = new ActionListener() {
            int count = 0;

            public void actionPerformed(java.awt.event.ActionEvent ae) {

                //animate
                if (count == 0) {

                    url = PokemonMenu.class.getResource("slash1AI.png");
                    sprite = new ImageIcon(url);
                    lblSwipe1.setIcon(sprite);

                    //turn the buttons off
                    btnMove1.setEnabled(false);
                    btnMove2.setEnabled(false);
                    btnMove3.setEnabled(false);
                    btnMove4.setEnabled(false);
                    swapBTN.setEnabled(false);
                } else if (count == 1) {
                    url = PokemonMenu.class.getResource("slash2AI.png");
                    sprite = new ImageIcon(url);
                    lblSwipe1.setIcon(sprite);

                } else if (count == 2) {

                    url = PokemonMenu.class.getResource("slash3AI.png");
                    sprite = new ImageIcon(url);
                    lblSwipe1.setIcon(sprite);

                } else if (count == 3) {

                    url = PokemonMenu.class.getResource("slash4AI.png");
                    sprite = new ImageIcon(url);
                    lblSwipe1.setIcon(sprite);

                } else if (count == 4) {

                    url = PokemonMenu.class.getResource("slash5AI.png");
                    sprite = new ImageIcon(url);
                    lblSwipe1.setIcon(sprite);

                } else if (count == 5) {

                    url = PokemonMenu.class.getResource("slash6AI.png");
                    sprite = new ImageIcon(url);
                    lblSwipe1.setIcon(sprite);

                } else if (count == 6) {

                    url = PokemonMenu.class.getResource("slash7AI.png");
                    sprite = new ImageIcon(url);
                    lblSwipe1.setIcon(sprite);

                } else if (count == 7) {

                    url = PokemonMenu.class.getResource("slash8AI.png");
                    sprite = new ImageIcon(url);
                    lblSwipe1.setIcon(sprite);

                } else if (count == 8) {
                    lblSwipe1.setIcon(null);

                    //reset the count
                    count = 0;
                    time3.stop();
                }

                count++;

            }

        };

        //timer for animations
        if (time3 == null) {
            time3 = new Timer(70, al);
            time3.start();
        } else {
            time3.restart();
        }

    }

    public void animateSwipe1() {

        //action lister 
        ActionListener al = new ActionListener() {
            int count = 0;

            public void actionPerformed(java.awt.event.ActionEvent ae) {

                //animate
                if (count == 0) {

                    url = PokemonMenu.class.getResource("slash1.png");
                    sprite = new ImageIcon(url);
                    lblSwipe2.setIcon(sprite);

                    //turn the buttons off
                    btnMove1.setEnabled(false);
                    btnMove2.setEnabled(false);
                    btnMove3.setEnabled(false);
                    btnMove4.setEnabled(false);
                    swapBTN.setEnabled(false);
                } else if (count == 1) {

                    url = PokemonMenu.class.getResource("slash2.png");
                    sprite = new ImageIcon(url);
                    lblSwipe2.setIcon(sprite);

                } else if (count == 2) {

                    url = PokemonMenu.class.getResource("slash3.png");
                    sprite = new ImageIcon(url);
                    lblSwipe2.setIcon(sprite);

                } else if (count == 3) {

                    url = PokemonMenu.class.getResource("slash4.png");
                    sprite = new ImageIcon(url);
                    lblSwipe2.setIcon(sprite);

                } else if (count == 4) {

                    url = PokemonMenu.class.getResource("slash5.png");
                    sprite = new ImageIcon(url);
                    lblSwipe2.setIcon(sprite);

                } else if (count == 5) {

                    url = PokemonMenu.class.getResource("slash6.png");
                    sprite = new ImageIcon(url);
                    lblSwipe2.setIcon(sprite);

                } else if (count == 6) {

                    url = PokemonMenu.class.getResource("slash7.png");
                    sprite = new ImageIcon(url);
                    lblSwipe2.setIcon(sprite);

                } else if (count == 7) {

                    url = PokemonMenu.class.getResource("slash8.png");
                    sprite = new ImageIcon(url);
                    lblSwipe2.setIcon(sprite);

                } else if (count == 8) {

                    lblSwipe2.setIcon(null);

                    count = 0;
                    time.stop();

                }

                count++;

            }

        };

        //timer for animations
        if (time == null) {
            time = new Timer(70, al);
            time.start();
        } else {
            time.restart();
        }

    }
    //time
    Timer time1, time2;
    //checking if one animation is done
    boolean done1 = false, done2 = false;

    public void animateHealth() {
        done1 = false;
        
        //action lister 
        ActionListener al = new ActionListener() {
        
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                
                
                 
                
                //FIX 
                    if (health > 0 && health != team.getBattling().getHp()) {
                        health--;
                    } else {

                    }
                    lblHealth.setText("" + health);

                //check if the health is equal to the bar
                if (health1.getValue() != team.getBattling().getHp()) {
                    health1.setValue(health1.getValue() - 1);
                   
                    
                    //turn the buttons off
                    btnMove1.setEnabled(false);
                    btnMove2.setEnabled(false);
                    btnMove3.setEnabled(false);
                    btnMove4.setEnabled(false);
                    swapBTN.setEnabled(false);

                } else {
                    
                    //check if the swap screen is open
                    if (swap) {

                    } else {
                        done1 = true;

                        //stop the timer
                        time1.stop();
                        if (done2) {
                            //turn the buttons on
                            btnMove1.setEnabled(true);
                            btnMove2.setEnabled(true);
                            btnMove3.setEnabled(true);
                            btnMove4.setEnabled(true);
                            swapBTN.setEnabled(true);
                            checkDeaths();

                        } else {
                            if (clicked == true) {
                                //turn the buttons on
                                btnMove1.setEnabled(true);
                                btnMove2.setEnabled(true);
                                btnMove3.setEnabled(true);
                                btnMove4.setEnabled(true);
                                swapBTN.setEnabled(true);
                            }
                        }
                        
                        
                    }
                }

            }
        };

        //timer for animations
        if (time1 == null) {
            time1 = new Timer(13, al);
            time1.start();
        } else {
            animateSwipe2();
            time1.restart();
        }

    }

    public void animateHealth2() {
        done2 = false;
        //action lister 
        ActionListener al = new ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent ae) {

                //check if the health is equal to the bar
                if (health2.getValue() != AI.getBattling().getHp()) {
                    health2.setValue(health2.getValue() - 1);
                    //turn the buttons off
                    btnMove1.setEnabled(false);
                    btnMove2.setEnabled(false);
                    btnMove3.setEnabled(false);
                    btnMove4.setEnabled(false);
                    swapBTN.setEnabled(false);

                    //make sure they die
                    if (AI.getBattling().getHp() <= 0) {
                        AI.getBattling().setAlive(false);
                    }

                } else //check if the swap screen is open
                if (swap) {

                } else {
                    done2 = true;

                    //stop the timer
                    time2.stop();
                    if (done1 == true) {

                        //turn the buttons on
                        btnMove1.setEnabled(true);
                        btnMove2.setEnabled(true);
                        btnMove3.setEnabled(true);
                        btnMove4.setEnabled(true);
                        swapBTN.setEnabled(true);
                        checkDeaths();
                    } else {

                    }

                }

            }
        };

        //timer for animations
        if (time2 == null) {
            time2 = new Timer(13, al);
            time2.start();
        } else {
            time2.restart();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel battlePNL;
    private javax.swing.JButton btnMove1;
    private javax.swing.JButton btnMove2;
    private javax.swing.JButton btnMove3;
    private javax.swing.JButton btnMove4;
    private javax.swing.JProgressBar health1;
    private javax.swing.JProgressBar health2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblHealth;
    private javax.swing.JLabel lblHealthIcon;
    private javax.swing.JLabel lblHealthIcon2;
    private javax.swing.JLabel lblHealthMax;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblPokeball;
    private javax.swing.JLabel lblSwipe1;
    private javax.swing.JLabel lblSwipe2;
    private javax.swing.JLabel lblType1;
    private javax.swing.JLabel lblType2;
    private javax.swing.JLabel lblType3;
    private javax.swing.JLabel lblType4;
    private javax.swing.JLabel lblp1;
    private javax.swing.JLabel lblp2;
    private javax.swing.JLabel lblpp1;
    private javax.swing.JLabel lblpp2;
    private javax.swing.JLabel lblpp3;
    private javax.swing.JLabel lblpp4;
    private javax.swing.JButton swapBTN;
    public javax.swing.JTextArea txtBattleLog;
    // End of variables declaration//GEN-END:variables
}
