package uinterface;
import uinterface.UIBoletim;
import uinterface.UIUserInfo;



public class UIProfessor extends javax.swing.JFrame {

    private String uCode, uName, uType;

    public UIProfessor(String uCode, String uName, String uType) {
        initComponents();
        this.uCode = uCode;
        this.uName = uName;
        this.uType = uType;
        lbIcon.setText("Logado como: "+ uName + " ("+uType+")"); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        lbIcon = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbBoletim = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbUserInfos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setTitle("Controle de Alunos - Sessão (Professor)");
        setResizable(false);
        getContentPane().setLayout(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(null);

        kGradientPanel1.setBackground(new java.awt.Color(0, 153, 255));
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 102, 102));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 51, 204));
        kGradientPanel1.setLayout(null);

        lbIcon.setBackground(new java.awt.Color(255, 255, 255));
        lbIcon.setForeground(new java.awt.Color(255, 255, 255));
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/school_icon.png"))); // NOI18N
        lbIcon.setText("{Text}");
        kGradientPanel1.add(lbIcon);
        lbIcon.setBounds(26, 6, 320, 56);

        background.add(kGradientPanel1);
        kGradientPanel1.setBounds(-10, 0, 860, 70);

        jSeparator1.setBackground(new java.awt.Color(0, 153, 204));
        jSeparator1.setForeground(new java.awt.Color(0, 153, 204));
        background.add(jSeparator1);
        jSeparator1.setBounds(0, 70, 860, 10);

        lbBoletim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icon_boletim.png"))); // NOI18N
        lbBoletim.setText("jLabel1");
        lbBoletim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbBoletimMousePressed(evt);
            }
        });
        background.add(lbBoletim);
        lbBoletim.setBounds(370, 200, 100, 100);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Alterar/Ver Boletim do Aluno");
        background.add(jLabel2);
        jLabel2.setBounds(330, 300, 180, 16);

        lbUserInfos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icon_user.png"))); // NOI18N
        lbUserInfos.setText("jLabel3");
        lbUserInfos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUserInfosMouseClicked(evt);
            }
        });
        background.add(lbUserInfos);
        lbUserInfos.setBounds(370, 350, 100, 100);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ver Minhas Informações");
        background.add(jLabel4);
        jLabel4.setBounds(320, 450, 200, 16);

        getContentPane().add(background);
        background.setBounds(0, 0, 820, 650);

        setSize(new java.awt.Dimension(832, 656));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbBoletimMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBoletimMousePressed
        UIBoletim boletim = new UIBoletim(uCode,uName,uType);
        boletim.setVisible(true);
    }//GEN-LAST:event_lbBoletimMousePressed

    private void lbUserInfosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserInfosMouseClicked
        UIUserInfo userInfo = new UIUserInfo(uCode, uName);
        userInfo.setVisible(true);
    }//GEN-LAST:event_lbUserInfosMouseClicked


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
            java.util.logging.Logger.getLogger(UIProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIProfessor("","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbBoletim;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbUserInfos;
    // End of variables declaration//GEN-END:variables
}
