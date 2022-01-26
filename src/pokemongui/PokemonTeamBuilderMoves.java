/*
 * Sebastian Latka
 * January 16th, 2020
 * menu to choose the moves of your selected pokemon
 */
package pokemongui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static pokemongui.PokemonTeamBuilderPokemon.pokemonIndex;

/**
 *
 * @author sebastianlatka
 */
public class PokemonTeamBuilderMoves extends JFrame {

    //makes variables for the forms
    PokemonTeamBuilder teamBuilder;
    PokemonTeamBuilderPokemon teamBuilderPokemon;

    //make variables
    private int y = 0;
    private int[] tempIndex;
    private boolean move1 = false, move2 = false, move3 = false, move4 = false, back = false;
    private Move[] move;
    private Pokemon[] pokemon;
    JButton btnTemp1 = new JButton(), btnTemp2 = new JButton(), btnTemp3 = new JButton(), btnTemp4 = new JButton();
    ArrayList<JButton> moveList = new ArrayList();

    //sprites
    ImageIcon sprite;
    URL url;

    //sound 
    musicStuff buttonSound = new musicStuff();

    /**
     * Creates new form PokemonTeamBuilderMoves
     */
    public PokemonTeamBuilderMoves(PokemonTeamBuilder tb, Pokemon pokemon[], Move moves[]) {
        initComponents();
        //center
        setLocationRelativeTo(null);
        //set this forms variables equal to the last
        teamBuilder = tb;
        this.pokemon = pokemon;
        move = moves;

        //set the icon of the frame
        setIconImage(PokemonMenu.pokeBallsprite.getImage());
        
        tempIndex = new int[4];

        Font font = new Font("Euphemia UCAS", Font.BOLD, 14);
        Color c = new Color(153, 153, 153);

        //call the method to update information in labels and buttons
        updateGuiInfo();

        try {
            GridLayout buttonGrid = new GridLayout(PokemonMenu.numMoves + 1, 1, 26, 4);
            pnlInside.setLayout(buttonGrid);
            
            //create a button and an actionlistener for every move in the data file
            for (int i = 0; i < PokemonMenu.numMoves; i++) {
                //make a button with the attributes of a move
                JButton btnMove = new JButton(move[i].getName() + "    PP: " + move[i].getPp() + " -- Dmg: " + move[i].getDamage() + " -- Acc: " + move[i].getAccuracy() + " -- Type: " + move[i].getType() + " -- Category: " + move[i].getPs());
                //add the button the the array list
                moveList.add(btnMove);
                //set the properties of the buttons
                pnlInside.add(btnMove).setSize(195, 32);
                pnlInside.add(btnMove).setFont(font);
                pnlInside.add(btnMove).setLocation(6, y);
                pnlInside.add(btnMove).setBackground(c);
                pnlInside.add(btnMove).setEnabled(false);
                //add an actionlistener for the buttons
                btnMove.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        //play sound
                        buttonSound.playMusic("Pressing A Sound.wav");
                        //checks if the move button 1 has been clicked
                        if (move1 == true) {
                            tempIndex[0] = pnlInside.getComponentZOrder(btnMove);
                            //set the text to the buttons name
                            btnChosenMove1.setText(move[tempIndex[0]].getName());
                            //give the pokemon that you are creating that move
                            pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].setMove(move[tempIndex[0]], 1);
                            //disable the button
                            btnMove.setEnabled(false);
                            //call button state
                            buttonState(1);
                            //sets the move bool to false
                            move1 = false;
                        }
                        //checks if the move button 2 has been clicked
                        if (move2 == true) {
                            tempIndex[1] = pnlInside.getComponentZOrder(btnMove);
                            //set the text to the buttons name
                            btnChosenMove2.setText(move[tempIndex[1]].getName());
                            //give the pokemon that you are creating that move
                            pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].setMove(move[tempIndex[1]], 2);
                            //disable the button
                            btnMove.setEnabled(false);
                            //call button state
                            buttonState(1);
                            //sets the move bool to false
                            move2 = false;
                        }
                        //checks if the move button 3 has been clicked
                        if (move3 == true) {
                            tempIndex[2] = pnlInside.getComponentZOrder(btnMove);
                            //set the text to the buttons name
                            btnChosenMove3.setText(move[tempIndex[2]].getName());
                            //give the pokemon that you are creating that move
                            pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].setMove(move[tempIndex[2]], 3);
                            //disable the button
                            btnMove.setEnabled(false);
                            //call button state
                            buttonState(1);
                            //sets the move bool to false
                            move3 = false;
                        }
                        //checks if the move button 4 has been clicked
                        if (move4 == true) {
                            tempIndex[3] = pnlInside.getComponentZOrder(btnMove);
                            //set the text to the buttons name
                            btnChosenMove4.setText(move[tempIndex[3]].getName());
                            //give the pokemon that you are creating that move
                            pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].setMove(move[tempIndex[3]], 4);
                            //disable the button
                            btnMove.setEnabled(false);
                            //call button state
                            buttonState(1);
                            //sets the move bool to false
                            move4 = false;
                        }
                    }
                });
                y += 38;
            }
            //creates a holder button
            JButton holder = new JButton();
            pnlInside.add(holder);
            moveList.add(holder);
            pnlInside.add(holder).setSize(195, 32);
            pnlInside.add(holder).setLocation(6, y);
            pnlInside.add(holder).setVisible(false);
            tempIndex[0] = PokemonMenu.numMoves;
            tempIndex[1] = PokemonMenu.numMoves;
            tempIndex[2] = PokemonMenu.numMoves;
            tempIndex[3] = PokemonMenu.numMoves;

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        pnlPokemonSprite = new javax.swing.JPanel();
        lblPokemonSprite = new javax.swing.JLabel();
        lblPokemonName = new javax.swing.JLabel();
        lblPokemonType1 = new javax.swing.JLabel();
        lblPokemonLvl = new javax.swing.JLabel();
        lblPokemonType2 = new javax.swing.JLabel();
        btnChosenMove1 = new javax.swing.JButton();
        btnChosenMove3 = new javax.swing.JButton();
        btnChosenMove4 = new javax.swing.JButton();
        btnChosenMove2 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblSubHeader = new javax.swing.JLabel();
        spDisplay = new javax.swing.JScrollPane();
        pnlInside = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokemon Battle Simulator");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));

        lblHeader.setBackground(java.awt.Color.lightGray);
        lblHeader.setFont(new java.awt.Font("Euphemia UCAS", 0, 24)); // NOI18N
        lblHeader.setText(" TeamBuilder");
        lblHeader.setOpaque(true);

        pnlPokemonSprite.setBackground(new java.awt.Color(204, 204, 204));
        pnlPokemonSprite.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlPokemonSprite.setMaximumSize(new java.awt.Dimension(80, 80));
        pnlPokemonSprite.setPreferredSize(new java.awt.Dimension(80, 80));
        pnlPokemonSprite.setRequestFocusEnabled(false);

        lblPokemonSprite.setMaximumSize(new java.awt.Dimension(80, 80));
        lblPokemonSprite.setMinimumSize(new java.awt.Dimension(80, 80));
        lblPokemonSprite.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout pnlPokemonSpriteLayout = new javax.swing.GroupLayout(pnlPokemonSprite);
        pnlPokemonSprite.setLayout(pnlPokemonSpriteLayout);
        pnlPokemonSpriteLayout.setHorizontalGroup(
            pnlPokemonSpriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPokemonSprite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlPokemonSpriteLayout.setVerticalGroup(
            pnlPokemonSpriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPokemonSprite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblPokemonName.setBackground(new java.awt.Color(204, 204, 204));
        lblPokemonName.setFont(new java.awt.Font("Euphemia UCAS", 0, 18)); // NOI18N
        lblPokemonName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPokemonName.setText("Name");
        lblPokemonName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPokemonType1.setBackground(new java.awt.Color(204, 204, 204));
        lblPokemonType1.setFont(new java.awt.Font("Euphemia UCAS", 0, 18)); // NOI18N
        lblPokemonType1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPokemonType1.setText("Type 1");
        lblPokemonType1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPokemonLvl.setBackground(new java.awt.Color(204, 204, 204));
        lblPokemonLvl.setFont(new java.awt.Font("Euphemia UCAS", 0, 18)); // NOI18N
        lblPokemonLvl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPokemonLvl.setText("LVL: 100");
        lblPokemonLvl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPokemonType2.setBackground(new java.awt.Color(204, 204, 204));
        lblPokemonType2.setFont(new java.awt.Font("Euphemia UCAS", 0, 18)); // NOI18N
        lblPokemonType2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPokemonType2.setText("Type 2");
        lblPokemonType2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnChosenMove1.setBackground(new java.awt.Color(204, 204, 204));
        btnChosenMove1.setFont(new java.awt.Font("Euphemia UCAS", 1, 18)); // NOI18N
        btnChosenMove1.setText("Move 1");
        btnChosenMove1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChosenMove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChosenMove1ActionPerformed(evt);
            }
        });

        btnChosenMove3.setBackground(new java.awt.Color(204, 204, 204));
        btnChosenMove3.setFont(new java.awt.Font("Euphemia UCAS", 1, 18)); // NOI18N
        btnChosenMove3.setText("Move 3");
        btnChosenMove3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChosenMove3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChosenMove3ActionPerformed(evt);
            }
        });

        btnChosenMove4.setBackground(new java.awt.Color(204, 204, 204));
        btnChosenMove4.setFont(new java.awt.Font("Euphemia UCAS", 1, 18)); // NOI18N
        btnChosenMove4.setText("Move 4");
        btnChosenMove4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChosenMove4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChosenMove4ActionPerformed(evt);
            }
        });

        btnChosenMove2.setBackground(new java.awt.Color(204, 204, 204));
        btnChosenMove2.setFont(new java.awt.Font("Euphemia UCAS", 1, 18)); // NOI18N
        btnChosenMove2.setText("Move 2");
        btnChosenMove2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChosenMove2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChosenMove2ActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(153, 153, 153));
        btnBack.setFont(new java.awt.Font("Euphemia UCAS", 1, 24)); // NOI18N
        btnBack.setText("Back");
        btnBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), new java.awt.Color(51, 51, 51), null));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblSubHeader.setBackground(java.awt.Color.lightGray);
        lblSubHeader.setFont(new java.awt.Font("Euphemia UCAS", 0, 24)); // NOI18N
        lblSubHeader.setText("Moves");
        lblSubHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblSubHeader.setMaximumSize(new java.awt.Dimension(700, 36));
        lblSubHeader.setMinimumSize(new java.awt.Dimension(700, 36));
        lblSubHeader.setPreferredSize(new java.awt.Dimension(700, 36));

        spDisplay.setBackground(java.awt.Color.lightGray);
        spDisplay.setMaximumSize(new java.awt.Dimension(700, 306));
        spDisplay.setMinimumSize(new java.awt.Dimension(700, 306));

        pnlInside.setMaximumSize(new java.awt.Dimension(697, 303));

        javax.swing.GroupLayout pnlInsideLayout = new javax.swing.GroupLayout(pnlInside);
        pnlInside.setLayout(pnlInsideLayout);
        pnlInsideLayout.setHorizontalGroup(
            pnlInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
        );
        pnlInsideLayout.setVerticalGroup(
            pnlInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );

        spDisplay.setViewportView(pnlInside);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlPokemonSprite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPokemonType1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPokemonType2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPokemonName, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPokemonLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChosenMove3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnChosenMove4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChosenMove1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnChosenMove2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblSubHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblHeader)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(pnlPokemonSprite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPokemonName)
                            .addComponent(lblPokemonLvl)
                            .addComponent(btnChosenMove1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChosenMove2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPokemonType1)
                            .addComponent(lblPokemonType2)
                            .addComponent(btnChosenMove3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChosenMove4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(lblSubHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChosenMove1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnChosenMove1ActionPerformed
    {//GEN-HEADEREND:event_btnChosenMove1ActionPerformed
        move2 = false;
        move3 = false;
        move4 = false;
        buttonState(2);
        move1 = true;
    }//GEN-LAST:event_btnChosenMove1ActionPerformed

    private void btnChosenMove3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnChosenMove3ActionPerformed
    {//GEN-HEADEREND:event_btnChosenMove3ActionPerformed
        move1 = false;
        move2 = false;
        move4 = false;
        buttonState(2);
        move3 = true;
    }//GEN-LAST:event_btnChosenMove3ActionPerformed

    private void btnChosenMove4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnChosenMove4ActionPerformed
    {//GEN-HEADEREND:event_btnChosenMove4ActionPerformed
        move1 = false;
        move2 = false;
        move3 = false;
        buttonState(2);
        move4 = true;
    }//GEN-LAST:event_btnChosenMove4ActionPerformed

    private void btnChosenMove2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnChosenMove2ActionPerformed
    {//GEN-HEADEREND:event_btnChosenMove2ActionPerformed
        move1 = false;
        move3 = false;
        move4 = false;
        buttonState(2);
        move2 = true;
    }//GEN-LAST:event_btnChosenMove2ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed
        //checks if any of the moves arent acutal moves then prompts you to choose all four moves first
        if (pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getMove(1).getName().equals(" ") || pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getMove(2).getName().equals(" ") || pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getMove(3).getName().equals(" ") || pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getMove(4).getName().equals(" ")) {
            //load image
            url = PokemonMenu.class.getResource("pokeball.png");
            ImageIcon JPane = new ImageIcon(url);

            //tell them to pick 4 moves 
            JOptionPane.showMessageDialog(null, "You must choose all 4 moves first!", "Wait a Minute", JOptionPane.INFORMATION_MESSAGE, JPane);
            back = false;
        } else {
            back = true;
        }

        if (back == true) {
            //play sound
            buttonSound.playMusic("Pressing A Sound.wav");

            //set the correct sprite
            url = PokemonMenu.class.getResource(pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getName() + ".png");
            //display the sprite
            sprite = new ImageIcon((new ImageIcon(url).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)));

            //displays the pokemon name
            PokemonTeamBuilder.lblPokemonNameList.get(PokemonTeamBuilder.tbPokemonIndex).setText(pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getName());
            //displays the pokemons sprite
            PokemonTeamBuilder.lblSpriteList.get(PokemonTeamBuilder.tbPokemonIndex).setIcon(sprite);

            //update the gui in the teambuilder
            teamBuilder.updateGui(0);
            teamBuilder.updateGui(1);

            teamBuilder.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    public void buttonState(int index) {
        //play sound
        buttonSound.playMusic("Pressing A Sound.wav");

        //disables all the components
        if (index == 1) {
            for (int i = 0; i < PokemonMenu.numMoves; i++) {
                pnlInside.getComponent(i).setEnabled(false);
            }
        }
        //enables all the buttons except for the ones already chosen
        if (index == 2) {
            try {
                String tempMoveName1 = btnChosenMove1.getText();
                String tempMoveName2 = btnChosenMove2.getText();
                String tempMoveName3 = btnChosenMove3.getText();
                String tempMoveName4 = btnChosenMove4.getText();
                for (int j = 0; j < PokemonMenu.numMoves; j++) {
                    pnlInside.getComponent(j).setEnabled(true);
                    if (tempMoveName1.equals(move[j].getName())) {
                        pnlInside.getComponent(j).setEnabled(false);
                    }
                    if (tempMoveName2.equals(move[j].getName())) {
                        pnlInside.getComponent(j).setEnabled(false);
                    }
                    if (tempMoveName3.equals(move[j].getName())) {
                        pnlInside.getComponent(j).setEnabled(false);
                    }
                    if (tempMoveName4.equals(move[j].getName())) {
                        pnlInside.getComponent(j).setEnabled(false);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void updateGuiInfo() {
        btnBack.setVisible(true);
        //set Icons
        //get and display the pokemon
        url = PokemonMenu.class.getResource(pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getName() + ".png");
        sprite = new ImageIcon(url);
        lblPokemonSprite.setIcon(sprite);
        //sets pokemon information to the correct texts
        lblPokemonName.setText(pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getName());
        lblPokemonType1.setText(pokemon[pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getType1());
        lblPokemonType2.setText(pokemon[pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getType2());
        //sets the moves to the correct text
        btnChosenMove1.setText(pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getMove(1).getName());
        btnChosenMove2.setText(pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getMove(2).getName());
        btnChosenMove3.setText(pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getMove(3).getName());
        btnChosenMove4.setText(pokemon[PokemonTeamBuilderPokemon.pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getMove(4).getName());

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnBack;
    private static javax.swing.JButton btnChosenMove1;
    private static javax.swing.JButton btnChosenMove2;
    private static javax.swing.JButton btnChosenMove3;
    private static javax.swing.JButton btnChosenMove4;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblPokemonLvl;
    private javax.swing.JLabel lblPokemonName;
    private javax.swing.JLabel lblPokemonSprite;
    private javax.swing.JLabel lblPokemonType1;
    private javax.swing.JLabel lblPokemonType2;
    private javax.swing.JLabel lblSubHeader;
    private javax.swing.JPanel pnlInside;
    private javax.swing.JPanel pnlPokemonSprite;
    private javax.swing.JScrollPane spDisplay;
    // End of variables declaration//GEN-END:variables
}
