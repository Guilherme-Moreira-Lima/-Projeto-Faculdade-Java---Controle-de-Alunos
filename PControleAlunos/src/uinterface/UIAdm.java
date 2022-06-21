package uinterface;
import database.DBClass;
import classes.UserClass;
import javax.swing.JOptionPane;
import uinterface.UIUserInfo;
import uinterface.UIRegisterUser;
import uinterface.UITurmas;
import uinterface.UIRemoveAlter;


public class UIAdm extends javax.swing.JFrame {
    
    
    private String userCode;
    private String userName;
    private String userType;
            
    private UserClass userC = new UserClass();

    public UIAdm(String uName, String uCode, String uType) {
        initComponents();
        userCode = uCode;
        userName = uName;
        userType = uType;
        System.out.println(userCode +" | "+ userName);
        lbIcon.setText("Logado como: " + userName);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        lbIcon = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbRegisterUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbCreate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbRemove = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbUserInfos = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setTitle("Controle de Alunos - Sessão Administração");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 51, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 102, 153));
        kGradientPanel1.setLayout(null);

        lbIcon.setBackground(new java.awt.Color(255, 255, 255));
        lbIcon.setForeground(new java.awt.Color(255, 255, 255));
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/school_icon.png"))); // NOI18N
        lbIcon.setText("{Text}");
        kGradientPanel1.add(lbIcon);
        lbIcon.setBounds(30, 15, 320, 56);

        jPanel1.add(kGradientPanel1);
        kGradientPanel1.setBounds(0, 0, 870, 80);

        jSeparator1.setBackground(new java.awt.Color(0, 153, 204));
        jSeparator1.setForeground(new java.awt.Color(0, 153, 204));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 80, 860, 10);

        lbRegisterUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icon_register.png"))); // NOI18N
        lbRegisterUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRegisterUserMouseClicked(evt);
            }
        });
        jPanel1.add(lbRegisterUser);
        lbRegisterUser.setBounds(360, 120, 100, 100);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registrar Usuário");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(250, 220, 330, 16);

        lbCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icon_turma.png"))); // NOI18N
        lbCreate.setText("jLabel3");
        lbCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCreateMouseClicked(evt);
            }
        });
        jPanel1.add(lbCreate);
        lbCreate.setBounds(360, 250, 100, 100);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Criar Turma");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(330, 350, 160, 16);

        lbRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icon_remove.png"))); // NOI18N
        lbRemove.setText("jLabel5");
        lbRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRemoveMouseClicked(evt);
            }
        });
        jPanel1.add(lbRemove);
        lbRemove.setBounds(360, 380, 100, 100);

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Remover/Alterar Usuário");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(320, 480, 180, 16);

        lbUserInfos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icon_user.png"))); // NOI18N
        lbUserInfos.setText("jLabel3");
        lbUserInfos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUserInfosMouseClicked(evt);
            }
        });
        jPanel1.add(lbUserInfos);
        lbUserInfos.setBounds(360, 500, 100, 100);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ver Minhas Informações");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(310, 600, 200, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-10, -10, 860, 680);

        setSize(new java.awt.Dimension(864, 672));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbUserInfosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserInfosMouseClicked
        UIUserInfo userInfo = new UIUserInfo(userCode,userName);
        userInfo.setVisible(true);
    }//GEN-LAST:event_lbUserInfosMouseClicked

    private void lbRegisterUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRegisterUserMouseClicked
        UIRegisterUser uiRegister = new UIRegisterUser();
        uiRegister.setVisible(true);
    }//GEN-LAST:event_lbRegisterUserMouseClicked

    private void lbCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCreateMouseClicked
        UITurmas turma = new UITurmas();
        turma.setVisible(true);
    }//GEN-LAST:event_lbCreateMouseClicked

    private void lbRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRemoveMouseClicked
        UIRemoveAlter uiReAl = new UIRemoveAlter();
        uiReAl.setVisible(true);
    }//GEN-LAST:event_lbRemoveMouseClicked


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
            java.util.logging.Logger.getLogger(UIAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIAdm("","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbCreate;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbRegisterUser;
    private javax.swing.JLabel lbRemove;
    private javax.swing.JLabel lbUserInfos;
    // End of variables declaration//GEN-END:variables
}
