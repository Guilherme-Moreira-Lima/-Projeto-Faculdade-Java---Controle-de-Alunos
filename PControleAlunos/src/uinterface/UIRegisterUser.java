package uinterface;
import database.DBClass;
import classes.UserPersonalInformations;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UIRegisterUser extends javax.swing.JFrame {
    
    
    
    
    public UIRegisterUser() {
        int a;
        ArrayList<String> turmas = new ArrayList<String>();
        initComponents();
        DBClass dbase = new DBClass();
        if(dbase.startConnection()){
            turmas = dbase.getTurmas();
            for(a=0;a!=turmas.size();a++){
                cbTurma.addItem(turmas.get(a));
            }
        }
        
    }
    
    public void clearSections(){
        cbTurma.setSelectedIndex(0);
        cbUserType.setSelectedIndex(0);
        lbRA.setText("");
        lbTurma.setText("");
        tfRA.setText("");
        tfUserCode.setText("");
        tfUserCpf.setText("");
        tfUserName.setText("");
    }
    

    public void prepareStatement(){
        System.out.println("PREPARE STATEMENT");
        String cpf = tfUserCpf.getText().replace(".", "");
        cpf = cpf.replace("/", "");
        System.out.println("CPF == "+cpf);
        UserPersonalInformations userInfo = new UserPersonalInformations();
        userInfo.setUserNome(tfUserName.getText());
        userInfo.setUserIdade(String.valueOf(spUserIdade.getValue()));
        userInfo.setUserCPF(cpf);
        userInfo.setUserCode(tfUserCode.getText());
        if(cbUserType.getSelectedIndex()==0){
            userInfo.setUserCargo("Aluno");
            userInfo.setUserRA(tfRA.getText());
            userInfo.setUserTurma(String.valueOf(cbTurma.getSelectedItem()));
        }else if(cbUserType.getSelectedIndex()==1){
            userInfo.setUserCargo("Professor");
        }else{
            userInfo.setUserCargo("Administração");
        }
        DBClass dbase = new DBClass();
        if(dbase.startConnection()){
            if(dbase.raExister(tfRA.getText())==1 && cbUserType.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null, "O 'RA' descrito já está em uso, tente outro");
            }else{
                if(dbase.codeExister(tfUserCode.getText())==1){
                    JOptionPane.showMessageDialog(null, "O 'Código de Uusário' descrito já está em uso, tente outro");
                }else{
                    if(dbase.registerUser(userInfo)){
                        if(dbase.registerUserInfos(userInfo)){
                            if(cbUserType.getSelectedIndex()==0){
                                if(dbase.registerBoletim(userInfo)){
                                    JOptionPane.showMessageDialog(null, "Usuário Registrado com Sucesso!");
                                    clearSections();
                                }else{
                                    JOptionPane.showMessageDialog(null, "Houve um erro ao Registrar o Usuário, Tente Novamente Mais Tarde!");
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Usuário Registrado com Sucesso!");
                                clearSections();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Houve um erro ao Registrar o Usuário, Tente Novamente Mais Tarde!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Houve um erro ao Registrar o Usuário, Tente Novamente Mais Tarde!");
                    }
                    /*
                    dbase.registerUser(userInfo);
                    dbase.registerUserInfos(userInfo);
                    dbase.registerBoletim(userInfo);    
                    */
                }
            }
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        cbUserType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnRegister = new com.k33ptoo.components.KButton();
        tfUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spUserIdade = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfUserCpf = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbRA = new javax.swing.JLabel();
        lbTurma = new javax.swing.JLabel();
        cbTurma = new javax.swing.JComboBox<>();
        tfRA = new javax.swing.JFormattedTextField();
        tfUserCode = new javax.swing.JFormattedTextField();

        jLabel11.setText("jLabel11");

        setTitle("Registrar");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 102, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 204, 204));
        kGradientPanel1.setLayout(null);
        jPanel1.add(kGradientPanel1);
        kGradientPanel1.setBounds(-10, 0, 790, 70);

        cbUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aluno(a)", "Professor(a)", "Administrador(a)" }));
        cbUserType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbUserTypeItemStateChanged(evt);
            }
        });
        jPanel1.add(cbUserType);
        cbUserType.setBounds(10, 100, 140, 22);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registrar um:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 80, 140, 16);

        btnRegister.setText("Registrar");
        btnRegister.setkEndColor(new java.awt.Color(0, 51, 153));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister);
        btnRegister.setBounds(240, 290, 230, 30);
        jPanel1.add(tfUserName);
        tfUserName.setBounds(10, 160, 320, 30);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome do Usuário:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 140, 110, 16);

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(380, 140, 20, 20);

        spUserIdade.setModel(new javax.swing.SpinnerNumberModel(7, 7, 120, 1));
        jPanel1.add(spUserIdade);
        spUserIdade.setBounds(340, 160, 67, 30);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Idade:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(340, 140, 60, 16);

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(120, 140, 20, 20);

        try {
            tfUserCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(tfUserCpf);
        tfUserCpf.setBounds(420, 160, 150, 30);

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(690, 140, 20, 20);

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CPF:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(420, 140, 60, 16);

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Codigo de Usuário:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(580, 140, 150, 16);

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(450, 140, 20, 20);

        lbRA.setForeground(new java.awt.Color(0, 0, 0));
        lbRA.setText("RA:");
        jPanel1.add(lbRA);
        lbRA.setBounds(10, 200, 80, 16);

        lbTurma.setForeground(new java.awt.Color(0, 0, 0));
        lbTurma.setText("Turma:");
        jPanel1.add(lbTurma);
        lbTurma.setBounds(200, 200, 50, 16);

        jPanel1.add(cbTurma);
        cbTurma.setBounds(200, 220, 90, 30);

        try {
            tfRA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(tfRA);
        tfRA.setBounds(10, 220, 160, 30);

        try {
            tfUserCode.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(tfUserCode);
        tfUserCode.setBounds(580, 160, 150, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 770, 390);

        setSize(new java.awt.Dimension(784, 395));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        if(tfUserCode.getText().isBlank() || tfUserCpf.getText().isBlank() || tfUserName.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha os campos vazios!");
        }else{
            if(cbUserType.getSelectedIndex()==0){
                if(tfRA.getText().isBlank()){
                    JOptionPane.showMessageDialog(null, "Preencha os campos vazios!");
                }else{
                    prepareStatement();
                }
            }else{
                prepareStatement();
            }      
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void cbUserTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbUserTypeItemStateChanged
        if(cbUserType.getSelectedIndex() == 0){
            lbRA.setVisible(true);
            lbTurma.setVisible(true);
            tfRA.setVisible(true);
            cbTurma.setVisible(true);
        }else{
            lbRA.setVisible(false);
            lbTurma.setVisible(false);
            tfRA.setVisible(false);
            cbTurma.setVisible(false);
        }
    }//GEN-LAST:event_cbUserTypeItemStateChanged


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
            java.util.logging.Logger.getLogger(UIRegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIRegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIRegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIRegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIRegisterUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnRegister;
    private javax.swing.JComboBox<String> cbTurma;
    private javax.swing.JComboBox<String> cbUserType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbRA;
    private javax.swing.JLabel lbTurma;
    private javax.swing.JSpinner spUserIdade;
    private javax.swing.JFormattedTextField tfRA;
    private javax.swing.JFormattedTextField tfUserCode;
    private javax.swing.JFormattedTextField tfUserCpf;
    private javax.swing.JTextField tfUserName;
    // End of variables declaration//GEN-END:variables
}
