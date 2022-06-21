package uinterface;

import classes.UserPersonalInformations;
import database.DBClass;
import javax.swing.JOptionPane;



public class UIUserInfo extends javax.swing.JFrame {

   
    public UIUserInfo(String uCode, String uName) {
        initComponents();
        System.out.println(uCode);
        System.out.println(uName);
        UserPersonalInformations userInfo = new UserPersonalInformations();
        DBClass dbase = new DBClass();
        if(dbase.startConnection()){
                userInfo = dbase.getUserInfos(uCode, uName);
                if(userInfo != null){
                lbUserName.setText("Nome: "+userInfo.getUserNome());
                lbCargo.setText("Cargo: "+userInfo.getUserCargo());
                lbIdade.setText("Idade: "+userInfo.getUserIdade());
                FTFCPF.setText(userInfo.getUserCPF());
                if(!userInfo.getUserCargo().equalsIgnoreCase("Aluno")){
                    /*lbRASalario.setText("Salário: "+userInfo.getSalario()+" (Sujeito à alterações)");*/
                    lbRASalario.setText("");
                    lbTurma.setVisible(false);
                }else{
                    lbRASalario.setText("RA: "+userInfo.getUserRA());
                    lbTurma.setVisible(true);
                    lbTurma.setText("Turma: "+userInfo.getUserTurma());
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao requisitar informações no banco de dados");
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        lbCargo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        FTFCPF = new javax.swing.JFormattedTextField();
        lbIdade = new javax.swing.JLabel();
        lbRASalario = new javax.swing.JLabel();
        lbTurma = new javax.swing.JLabel();

        setTitle("Controle de Alunos -  Sessão (Suas Informações)");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        kGradientPanel1.setkEndColor(new java.awt.Color(204, 0, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 153));
        kGradientPanel1.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/school_icon.png"))); // NOI18N
        jLabel1.setText("Suas Informações");
        kGradientPanel1.add(jLabel1);
        jLabel1.setBounds(180, 20, 60, 60);

        jPanel1.add(kGradientPanel1);
        kGradientPanel1.setBounds(0, 0, 430, 90);

        lbUserName.setForeground(new java.awt.Color(0, 0, 0));
        lbUserName.setText("{User-Name}");
        jPanel1.add(lbUserName);
        lbUserName.setBounds(20, 130, 390, 16);

        lbCargo.setForeground(new java.awt.Color(0, 0, 0));
        lbCargo.setText("{User-Cargo}");
        jPanel1.add(lbCargo);
        lbCargo.setBounds(20, 160, 360, 16);

        jSeparator2.setBackground(new java.awt.Color(51, 204, 255));
        jSeparator2.setForeground(new java.awt.Color(51, 204, 255));
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(0, 90, 420, 10);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Suas Informações");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 100, 380, 25);

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CPF:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 220, 40, 20);

        FTFCPF.setEditable(false);
        FTFCPF.setBorder(null);
        try {
            FTFCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        FTFCPF.setText("24545623465");
        jPanel1.add(FTFCPF);
        FTFCPF.setBounds(50, 216, 340, 30);

        lbIdade.setForeground(new java.awt.Color(0, 0, 0));
        lbIdade.setText("{User-Idade}");
        jPanel1.add(lbIdade);
        lbIdade.setBounds(20, 190, 370, 16);

        lbRASalario.setForeground(new java.awt.Color(0, 0, 0));
        lbRASalario.setText("{User-RA/Salario}");
        jPanel1.add(lbRASalario);
        lbRASalario.setBounds(20, 260, 370, 16);

        lbTurma.setForeground(new java.awt.Color(0, 0, 0));
        lbTurma.setText("{User-Turma}");
        jPanel1.add(lbTurma);
        lbTurma.setBounds(20, 290, 360, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-5, -7, 420, 710);

        setSize(new java.awt.Dimension(428, 359));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


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
            java.util.logging.Logger.getLogger(UIUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIUserInfo("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField FTFCPF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JLabel lbIdade;
    private javax.swing.JLabel lbRASalario;
    private javax.swing.JLabel lbTurma;
    private javax.swing.JLabel lbUserName;
    // End of variables declaration//GEN-END:variables
}
