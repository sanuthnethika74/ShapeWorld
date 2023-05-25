/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapeworld;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Sanuth Nethika
 */
public class Home extends javax.swing.JFrame {

ImageIcon button_normal_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconSelectShape.png"));  
ImageIcon button_hover_img = new javax.swing.ImageIcon(getClass().getResource("/Image/IconSelectShape-hover.png"));
ImageIcon button_normal_img2 = new javax.swing.ImageIcon(getClass().getResource("/Image/IconDrawShape.png"));  
ImageIcon button_hover_img2 = new javax.swing.ImageIcon(getClass().getResource("/Image/IconDrawShape-hover.png"));


    public Home() {
        initComponents();
         this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/Logo.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMainTitle = new javax.swing.JLabel();
        lblSelectShape = new javax.swing.JLabel();
        background2 = new javax.swing.JLabel();
        lblDrawShape = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(1111, 575));
        setResizable(false);
        setSize(new java.awt.Dimension(1111, 575));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMainTitle.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblMainTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblMainTitle.setText("STUDENT DASHBOARD");
        lblMainTitle.setToolTipText("");
        getContentPane().add(lblMainTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 560, 100));

        lblSelectShape.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IconSelectShape.png"))); // NOI18N
        lblSelectShape.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectShapeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSelectShapeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSelectShapeMouseExited(evt);
            }
        });
        getContentPane().add(lblSelectShape, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, -1, -1));

        background2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Main Background Text.png"))); // NOI18N
        background2.setText("Background Image 2");
        getContentPane().add(background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 960, 440));

        lblDrawShape.setForeground(new java.awt.Color(255, 255, 255));
        lblDrawShape.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IconDrawShape.png"))); // NOI18N
        lblDrawShape.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDrawShapeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDrawShapeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDrawShapeMouseExited(evt);
            }
        });
        getContentPane().add(lblDrawShape, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Main-Background-darken.gif"))); // NOI18N
        background.setText("Background Image");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblSelectShapeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectShapeMouseClicked
        ShapeMenu SM = new ShapeMenu();
       SM.show();
       this.hide();
    }//GEN-LAST:event_lblSelectShapeMouseClicked

    private void lblSelectShapeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectShapeMouseEntered
         lblSelectShape.setIcon(button_hover_img);
       
    }//GEN-LAST:event_lblSelectShapeMouseEntered

    private void lblSelectShapeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectShapeMouseExited
        lblSelectShape.setIcon(button_normal_img);
    }//GEN-LAST:event_lblSelectShapeMouseExited

    private void lblDrawShapeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDrawShapeMouseClicked
        DrawShape DS = new DrawShape();
        DS.show();
        this.hide();
    }//GEN-LAST:event_lblDrawShapeMouseClicked

    private void lblDrawShapeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDrawShapeMouseEntered
        lblDrawShape.setIcon(button_hover_img2);
    }//GEN-LAST:event_lblDrawShapeMouseEntered

    private void lblDrawShapeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDrawShapeMouseExited
         lblDrawShape.setIcon(button_normal_img2);
    }//GEN-LAST:event_lblDrawShapeMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel background2;
    private javax.swing.JLabel lblDrawShape;
    private javax.swing.JLabel lblMainTitle;
    private javax.swing.JLabel lblSelectShape;
    // End of variables declaration//GEN-END:variables
}
