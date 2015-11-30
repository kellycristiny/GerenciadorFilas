package br.edu.kelly.telas;

import br.edu.kelly.modelo.Fila;

public class Tela01GUI extends javax.swing.JFrame {
    private Fila fila;
    /**
     * Creates new form Tela01GUI
     */
    public Tela01GUI(Fila fila) {
        initComponents();
        this.fila = fila;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbEntrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/kelly/telas/257.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/kelly/telas/1_Primary_logo_on_transparent_114x75.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(400, 400));
        jLabel2.setMinimumSize(new java.awt.Dimension(400, 400));
        jLabel2.setPreferredSize(new java.awt.Dimension(400, 400));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 70, 120, 90);

        jbEntrar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jbEntrar.setText("Entrar");
        jbEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEntrar);
        jbEntrar.setBounds(30, 290, 110, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/kelly/telas/257.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(400, 400));
        jLabel1.setMinimumSize(new java.awt.Dimension(400, 400));
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 400));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -20, 500, 370);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEntrarActionPerformed
        new Tela02GUI(fila).setVisible(true);      
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEntrarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbEntrar;
    // End of variables declaration//GEN-END:variables
}
