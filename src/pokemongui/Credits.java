//Dimitri Papadedes
//January 10th
//a credits screen
package pokemongui;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import pokemongui.PokemonMenu;
import pokemongui.musicStuff;

/**
 *
 * @author Dimitri Papadedes
 */
public class Credits extends JFrame {

    PokemonMenu mainMenu;
    
    //sound 
    musicStuff buttonSound = new musicStuff();
    
    /**
     * Creates new form Credits
     */
    public Credits(PokemonMenu m) {
        initComponents();
        
        mainMenu = m;
        
        //center
        setLocationRelativeTo(null);
        
        
        //display the image
        URL url = PokemonMenu.class.getResource("Credits.png");
        ImageIcon sprite = new ImageIcon(url);
        lblCredits.setIcon(sprite);
        
        
        //set the icon of the frame
        url = PokemonMenu.class.getResource("pokeball.png");
        sprite = new ImageIcon(url);
        setIconImage(sprite.getImage());
        
        //set Charizard 
        url = PokemonMenu.class.getResource("Start Charizard.png");
        sprite = new ImageIcon(url);
        lblPoke2.setIcon(sprite);
        
        //set snorlax 
        url = PokemonMenu.class.getResource("Start Snorlax.png");
        sprite = new ImageIcon(url);
        lblPoke1.setIcon(sprite);
        
        //set Blastoise 
        url = PokemonMenu.class.getResource("Start Blastoise.png");
        sprite = new ImageIcon(url);
        lblPoke3.setIcon(sprite);
        
        //set Venusaur 
        url = PokemonMenu.class.getResource("Start Venusaur.png");
        sprite = new ImageIcon(url);
        lblPoke4.setIcon(sprite);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFrame = new javax.swing.JPanel();
        backBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCredits = new javax.swing.JLabel();
        lblPoke1 = new javax.swing.JLabel();
        lblPoke4 = new javax.swing.JLabel();
        lblPoke3 = new javax.swing.JLabel();
        lblPoke2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokemon Battle Simulator");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));

        pnlFrame.setLayout(null);

        backBTN.setBackground(new java.awt.Color(153, 153, 153));
        backBTN.setFont(new java.awt.Font("Power Green", 1, 24)); // NOI18N
        backBTN.setText("Back");
        backBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), new java.awt.Color(51, 51, 51), null));
        backBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBTNActionPerformed(evt);
            }
        });
        pnlFrame.add(backBTN);
        backBTN.setBounds(340, 560, 136, 40);

        jLabel1.setFont(new java.awt.Font("Power Green", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Project Manager: Dimitri Papadedes");
        pnlFrame.add(jLabel1);
        jLabel1.setBounds(220, 330, 410, 60);

        jLabel3.setFont(new java.awt.Font("Power Green", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lead Programmer: Dimitri Papadedes");
        pnlFrame.add(jLabel3);
        jLabel3.setBounds(210, 210, 430, 60);
        pnlFrame.add(lblCredits);
        lblCredits.setBounds(260, 50, 319, 100);
        pnlFrame.add(lblPoke1);
        lblPoke1.setBounds(40, 20, 220, 190);
        pnlFrame.add(lblPoke4);
        lblPoke4.setBounds(590, 380, 230, 200);
        pnlFrame.add(lblPoke3);
        lblPoke3.setBounds(50, 390, 230, 200);
        pnlFrame.add(lblPoke2);
        lblPoke2.setBounds(600, 0, 230, 200);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBTNActionPerformed
        //play sound
        buttonSound.playMusic("Pressing A Sound.wav");

        mainMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backBTNActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCredits;
    private javax.swing.JLabel lblPoke1;
    private javax.swing.JLabel lblPoke2;
    private javax.swing.JLabel lblPoke3;
    private javax.swing.JLabel lblPoke4;
    private javax.swing.JPanel pnlFrame;
    // End of variables declaration//GEN-END:variables
}
