/*
 * Sebastian Latka
 * January 16th, 2020
 * menu to choose your pokemon
 */
package pokemongui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author sebastianlatka
 */
public class PokemonTeamBuilderPokemon extends JFrame {

    //makes variables for the forms
    PokemonTeamBuilder teamBuilder;
    PokemonTeamBuilderMoves teamBuilderMoves;

    //create the variables
    private int y = 0;
    static int[] pokemonIndex = new int[6];
    private String btnPokemonName;

    //create a pokemon variable
    Pokemon[] pokemon;
    //create a move variable
    Move[] moves;

    //create the array list for the pokemon buttons
    static ArrayList<JButton> pokemonList = new ArrayList();

    //sound 
    musicStuff buttonSound = new musicStuff();

    /**
     * Creates new form PokemonTeamBuilderPokemon
     *
     * @param tb
     * @param pokemon
     * @param move
     */
    public PokemonTeamBuilderPokemon(PokemonTeamBuilder tb, Pokemon pokemon[], Move move[]) {
        initComponents();
        //center
        setLocationRelativeTo(null);
        //set this forms variables equal to the last
        teamBuilder = tb;

        this.pokemon = pokemon;
        moves = move;

        this.pokemonIndex = PokemonTeamBuilder.pokemonIndex;
        
        //set the icon of the frame
        setIconImage(PokemonMenu.pokeBallsprite.getImage());
        
        //update the gui info of this class
        updateGuiInfo();

        //make a font
        Font font = new Font("Euphemia UCAS", Font.BOLD, 14);
        //make a colour
        Color c = new Color(153, 153, 153);

        try {
            //make a grid layout for the pokemon buttons
            GridLayout buttonGrid = new GridLayout(PokemonMenu.numPokemon + 1, 1, 26, 4);
            pnlInside.setLayout(buttonGrid);

            //for loop that runs the value of numPokemon
            for (int i = 0; i < PokemonMenu.numPokemon; i++) {
                //if statement that checks if the pokemon has a second type and sets btnPokemonName accordingly
                if (!pokemon[i].getType2().equals(" ")) {
                    btnPokemonName = pokemon[i].getName() + "                                        Type: " + pokemon[i].getType1() + "/" + pokemon[i].getType2();
                } else {
                    btnPokemonName = pokemon[i].getName() + "                                        Type: " + pokemon[i].getType1();
                }
                //create a button with all the name and typing of a pokemon
                JButton btnPokemon = new JButton(btnPokemonName);
                //add the button to the array list
                pokemonList.add(btnPokemon);
                //set the properties of the button
                pnlInside.add(btnPokemon).setSize(195, 32);
                pnlInside.add(btnPokemon).setFont(font);
                pnlInside.add(btnPokemon).setLocation(6, y);
                pnlInside.add(btnPokemon).setBackground(c);
                y += 38;
                //add an action listener so that the button clicks can be registered
                btnPokemon.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        //play sound
                        buttonSound.playMusic("Pressing A Sound.wav");

                        //gets the index of the button that is being clicked
                        pokemonIndex[PokemonTeamBuilder.tbPokemonIndex] = pnlInside.getComponentZOrder(btnPokemon);
                        //set the pokemon name lbl to the name of the selected button
                        lblPokemonName.setText(pokemon[pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getName());
                        lblPokemonLvl.setText("LVL: 100");
                        //set the type lbl's to the types of the pokemon
                        lblPokemonType1.setText(pokemon[pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getType1());
                        lblPokemonType2.setText(pokemon[pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].getType2());
                        //swap screen
                        swapScreen();
                    }
                });
                
                //checks if the pokemon label text is equal to any of the buttons names then clicks that button
                if (teamBuilder.lblPokemonNameList.get(PokemonTeamBuilder.tbPokemonIndex).getText().equals(pokemon[i].getName())) {;
                    btnPokemon.doClick();
                }

            }
            //create a holder button
            JButton holder = new JButton();
            //add the holder button to the pnl
            pnlInside.add(holder);
            //add the holder button to the pokemonlist
            pokemonList.add(holder);
            pnlInside.add(holder).setSize(195, 32);
            pnlInside.add(holder).setLocation(6, y);
            pnlInside.add(holder).setVisible(false);

            //runs the for loop the amount of pokemons
            for (int j = 0; j < pokemon.length; j++) {
                //checks if the name of the lbl inside the teambuilder is equal to one of the pokemon buttons name
                if (PokemonTeamBuilder.lblPokemonName1.getText().equals(pokemonList.get(j).getText().substring(0, pokemonList.get(j).getText().indexOf(" "))) || PokemonTeamBuilder.lblPokemonName2.getText().equals(pokemonList.get(j).getText().substring(0, pokemonList.get(j).getText().indexOf(" "))) || PokemonTeamBuilder.lblPokemonName3.getText().equals(pokemonList.get(j).getText().substring(0, pokemonList.get(j).getText().indexOf(" "))) || PokemonTeamBuilder.lblPokemonName4.getText().equals(pokemonList.get(j).getText().substring(0, pokemonList.get(j).getText().indexOf(" "))) || PokemonTeamBuilder.lblPokemonName5.getText().equals(pokemonList.get(j).getText().substring(0, pokemonList.get(j).getText().indexOf(" "))) || PokemonTeamBuilder.lblPokemonName6.getText().equals(pokemonList.get(j).getText().substring(0, pokemonList.get(j).getText().indexOf(" ")))) {
                    //if so then disable that button 
                    pnlInside.getComponent(j).setEnabled(false);
                }
            }

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
        btnBack = new javax.swing.JButton();
        lblPokemonName = new javax.swing.JLabel();
        lblPokemonType1 = new javax.swing.JLabel();
        lblPokemonType2 = new javax.swing.JLabel();
        lblPokemonLvl = new javax.swing.JLabel();
        btnChosenMove1 = new javax.swing.JButton();
        btnChosenMove2 = new javax.swing.JButton();
        btnChosenMove3 = new javax.swing.JButton();
        btnChosenMove4 = new javax.swing.JButton();
        spDisplay = new javax.swing.JScrollPane();
        pnlInside = new javax.swing.JPanel();
        lblSubHeader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokemon Battle Simulator");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));

        lblHeader.setBackground(java.awt.Color.lightGray);
        lblHeader.setFont(new java.awt.Font("Euphemia UCAS", 0, 24)); // NOI18N
        lblHeader.setText(" TeamBuilder");
        lblHeader.setOpaque(true);

        pnlPokemonSprite.setBackground(new java.awt.Color(204, 204, 204));
        pnlPokemonSprite.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pnlPokemonSpriteLayout = new javax.swing.GroupLayout(pnlPokemonSprite);
        pnlPokemonSprite.setLayout(pnlPokemonSpriteLayout);
        pnlPokemonSpriteLayout.setHorizontalGroup(
            pnlPokemonSpriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        pnlPokemonSpriteLayout.setVerticalGroup(
            pnlPokemonSpriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        btnBack.setBackground(new java.awt.Color(153, 153, 153));
        btnBack.setFont(new java.awt.Font("Euphemia UCAS", 1, 24)); // NOI18N
        btnBack.setText("Back");
        btnBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), new java.awt.Color(51, 51, 51), null));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblPokemonName.setBackground(new java.awt.Color(204, 204, 204));
        lblPokemonName.setFont(new java.awt.Font("Euphemia UCAS", 0, 18)); // NOI18N
        lblPokemonName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPokemonName.setText("Name");
        lblPokemonName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPokemonName.setMaximumSize(new java.awt.Dimension(105, 27));
        lblPokemonName.setMinimumSize(new java.awt.Dimension(105, 27));
        lblPokemonName.setPreferredSize(new java.awt.Dimension(105, 27));

        lblPokemonType1.setBackground(new java.awt.Color(204, 204, 204));
        lblPokemonType1.setFont(new java.awt.Font("Euphemia UCAS", 0, 18)); // NOI18N
        lblPokemonType1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPokemonType1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPokemonType1.setMaximumSize(new java.awt.Dimension(105, 27));
        lblPokemonType1.setMinimumSize(new java.awt.Dimension(105, 27));
        lblPokemonType1.setPreferredSize(new java.awt.Dimension(105, 27));

        lblPokemonType2.setBackground(new java.awt.Color(204, 204, 204));
        lblPokemonType2.setFont(new java.awt.Font("Euphemia UCAS", 0, 18)); // NOI18N
        lblPokemonType2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPokemonType2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPokemonType2.setMaximumSize(new java.awt.Dimension(105, 27));
        lblPokemonType2.setMinimumSize(new java.awt.Dimension(105, 27));
        lblPokemonType2.setPreferredSize(new java.awt.Dimension(105, 27));

        lblPokemonLvl.setBackground(new java.awt.Color(204, 204, 204));
        lblPokemonLvl.setFont(new java.awt.Font("Euphemia UCAS", 0, 18)); // NOI18N
        lblPokemonLvl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPokemonLvl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPokemonLvl.setMaximumSize(new java.awt.Dimension(105, 27));
        lblPokemonLvl.setMinimumSize(new java.awt.Dimension(105, 27));
        lblPokemonLvl.setPreferredSize(new java.awt.Dimension(105, 27));

        btnChosenMove1.setBackground(new java.awt.Color(204, 204, 204));
        btnChosenMove1.setFont(new java.awt.Font("Euphemia UCAS", 1, 18)); // NOI18N
        btnChosenMove1.setText("Move 1");
        btnChosenMove1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChosenMove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChosenMove1ActionPerformed(evt);
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

        spDisplay.setBackground(java.awt.Color.lightGray);
        spDisplay.setMaximumSize(new java.awt.Dimension(697, 303));
        spDisplay.setMinimumSize(new java.awt.Dimension(697, 303));
        spDisplay.setPreferredSize(new java.awt.Dimension(697, 303));

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

        lblSubHeader.setBackground(java.awt.Color.lightGray);
        lblSubHeader.setFont(new java.awt.Font("Euphemia UCAS", 0, 24)); // NOI18N
        lblSubHeader.setText("Pokemon");
        lblSubHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlPokemonSprite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPokemonName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPokemonType1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPokemonType2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPokemonLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChosenMove1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChosenMove3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChosenMove2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChosenMove4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(spDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSubHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(642, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPokemonSprite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChosenMove2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnChosenMove4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChosenMove1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnChosenMove3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPokemonLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPokemonName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPokemonType1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPokemonType2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSubHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(539, Short.MAX_VALUE)
                    .addComponent(btnBack)
                    .addGap(22, 22, 22)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnChosenMove1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnChosenMove1ActionPerformed
    {//GEN-HEADEREND:event_btnChosenMove1ActionPerformed

    }//GEN-LAST:event_btnChosenMove1ActionPerformed

    private void btnChosenMove2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnChosenMove2ActionPerformed
    {//GEN-HEADEREND:event_btnChosenMove2ActionPerformed

    }//GEN-LAST:event_btnChosenMove2ActionPerformed

    private void btnChosenMove3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnChosenMove3ActionPerformed
    {//GEN-HEADEREND:event_btnChosenMove3ActionPerformed

    }//GEN-LAST:event_btnChosenMove3ActionPerformed

    private void btnChosenMove4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnChosenMove4ActionPerformed
    {//GEN-HEADEREND:event_btnChosenMove4ActionPerformed

    }//GEN-LAST:event_btnChosenMove4ActionPerformed

    //method to swap the screens
    public void swapScreen() {
        teamBuilderMoves = new PokemonTeamBuilderMoves(teamBuilder, pokemon, moves);
        teamBuilderMoves.setVisible(true);
        this.setVisible(false);
    }

    //method to set the pokemon moves to null
    public void resetMoves() {
        pokemon[pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].setMove(PokemonTeamBuilder.mFake, 1);
        pokemon[pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].setMove(PokemonTeamBuilder.mFake, 2);
        pokemon[pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].setMove(PokemonTeamBuilder.mFake, 3);
        pokemon[pokemonIndex[PokemonTeamBuilder.tbPokemonIndex]].setMove(PokemonTeamBuilder.mFake, 4);
    }

    //update the gui with correct info
    public void updateGuiInfo() {
        //set all the lbl and buttons texts to nothing and disable the buttons
        lblPokemonName.setText(" ");
        lblPokemonLvl.setText(" ");
        lblPokemonType1.setText(" ");
        lblPokemonType2.setText(" ");
        lblPokemonName.setText(" ");
        btnChosenMove1.setEnabled(false);
        btnChosenMove1.setText(" ");
        btnChosenMove2.setEnabled(false);
        btnChosenMove2.setText(" ");
        btnChosenMove3.setEnabled(false);
        btnChosenMove3.setText(" ");
        btnChosenMove4.setEnabled(false);
        btnChosenMove4.setText(" ");

        btnBack.setVisible(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    public static javax.swing.JButton btnChosenMove1;
    public static javax.swing.JButton btnChosenMove2;
    public static javax.swing.JButton btnChosenMove3;
    public static javax.swing.JButton btnChosenMove4;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblPokemonLvl;
    private javax.swing.JLabel lblPokemonName;
    public static javax.swing.JLabel lblPokemonType1;
    public static javax.swing.JLabel lblPokemonType2;
    private javax.swing.JLabel lblSubHeader;
    public static javax.swing.JPanel pnlInside;
    private javax.swing.JPanel pnlPokemonSprite;
    private javax.swing.JScrollPane spDisplay;
    // End of variables declaration//GEN-END:variables
}
