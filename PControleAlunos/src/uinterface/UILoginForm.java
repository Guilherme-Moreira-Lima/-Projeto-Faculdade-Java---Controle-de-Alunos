package uinterface;
import database.DBClass;
import classes.UserClass;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.text.BadLocationException;
import uinterface.UIAluno;
import uinterface.UIProfessor;
import uinterface.UIAdm;


public class UILoginForm extends javax.swing.JFrame {
    
    

    public void ChangeConnStatus(String t,Color x){
        labelSStatus.setText(t);
        labelSStatus.setForeground(x);
    }

    public UILoginForm() {
        initComponents();
        
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        labelSchoolLogo = new javax.swing.JLabel();
        backgroundIconPassword = new javax.swing.JPanel();
        labelUserIcon = new javax.swing.JLabel();
        hr = new javax.swing.JSeparator();
        txtfUsername = new javax.swing.JTextField();
        backgroundIconUser = new javax.swing.JPanel();
        labelUserIcon1 = new javax.swing.JLabel();
        passfSenha = new javax.swing.JPasswordField();
        buttonLogin = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelSStatus = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        kButton1 = new com.k33ptoo.components.KButton();
        kButton2 = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de Alunos - Login");
        setResizable(false);
        getContentPane().setLayout(null);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setForeground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setLayout(null);

        labelSchoolLogo.setBackground(new java.awt.Color(0, 0, 0));
        labelSchoolLogo.setForeground(new java.awt.Color(0, 0, 0));
        labelSchoolLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/school2.png"))); // NOI18N
        backgroundPanel.add(labelSchoolLogo);
        labelSchoolLogo.setBounds(250, 80, 250, 250);

        backgroundIconPassword.setBackground(new java.awt.Color(0, 102, 153));
        backgroundIconPassword.setForeground(new java.awt.Color(0, 102, 153));
        backgroundIconPassword.setLayout(null);

        labelUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/password.png"))); // NOI18N
        backgroundIconPassword.add(labelUserIcon);
        labelUserIcon.setBounds(0, 0, 27, 30);

        backgroundPanel.add(backgroundIconPassword);
        backgroundIconPassword.setBounds(210, 410, 30, 30);

        hr.setBackground(new java.awt.Color(0, 102, 153));
        hr.setForeground(new java.awt.Color(0, 102, 153));
        backgroundPanel.add(hr);
        hr.setBounds(180, 400, 390, 10);

        txtfUsername.setBackground(new java.awt.Color(255, 255, 255));
        txtfUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtfUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        backgroundPanel.add(txtfUsername);
        txtfUsername.setBounds(240, 360, 300, 30);

        backgroundIconUser.setBackground(new java.awt.Color(0, 102, 153));
        backgroundIconUser.setForeground(new java.awt.Color(0, 102, 153));
        backgroundIconUser.setLayout(null);

        labelUserIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/user27.png"))); // NOI18N
        backgroundIconUser.add(labelUserIcon1);
        labelUserIcon1.setBounds(0, 0, 27, 30);

        backgroundPanel.add(backgroundIconUser);
        backgroundIconUser.setBounds(210, 360, 30, 30);

        passfSenha.setBackground(new java.awt.Color(255, 255, 255));
        passfSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passfSenha.setForeground(new java.awt.Color(0, 0, 0));
        passfSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passfSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        backgroundPanel.add(passfSenha);
        passfSenha.setBounds(240, 410, 300, 30);

        buttonLogin.setText("Entrar");
        buttonLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonLogin.setkEndColor(new java.awt.Color(0, 0, 255));
        buttonLogin.setkHoverEndColor(new java.awt.Color(0, 125, 153));
        buttonLogin.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        buttonLogin.setkHoverStartColor(new java.awt.Color(0, 0, 255));
        buttonLogin.setkSelectedColor(new java.awt.Color(0, 0, 255));
        buttonLogin.setkStartColor(new java.awt.Color(0, 125, 153));
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        backgroundPanel.add(buttonLogin);
        buttonLogin.setBounds(240, 450, 280, 30);

        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Projeto Controle de Alunos v1.0.1");
        backgroundPanel.add(jLabel1);
        jLabel1.setBounds(280, 540, 220, 20);

        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Criado por Guilherme Moreira Lima");
        backgroundPanel.add(jLabel2);
        jLabel2.setBounds(280, 560, 220, 20);

        labelSStatus.setBackground(new java.awt.Color(255, 255, 255));
        labelSStatus.setForeground(new java.awt.Color(255, 255, 255));
        labelSStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSStatus.setText("Conectando-se ao Servidor");
        backgroundPanel.add(labelSStatus);
        labelSStatus.setBounds(150, 490, 480, 40);

        jButton1.setText("Aluno");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        backgroundPanel.add(jButton1);
        jButton1.setBounds(610, 550, 160, 30);

        kButton1.setText("Professor");
        kButton1.setkEndColor(new java.awt.Color(51, 51, 51));
        kButton1.setkStartColor(new java.awt.Color(51, 51, 51));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        backgroundPanel.add(kButton1);
        kButton1.setBounds(610, 520, 160, 30);

        kButton2.setText("Adm");
        kButton2.setkEndColor(new java.awt.Color(0, 102, 102));
        kButton2.setkStartColor(new java.awt.Color(102, 0, 204));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });
        backgroundPanel.add(kButton2);
        kButton2.setBounds(610, 490, 160, 30);

        getContentPane().add(backgroundPanel);
        backgroundPanel.setBounds(-10, -10, 820, 660);

        setSize(new java.awt.Dimension(816, 648));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed

        this.ChangeConnStatus("Conexão com o Servidor Estabelecida",Color.black);
        
        /* ------ Objetos ----- */
        DBClass dbase = new DBClass();
        UserClass user = new UserClass();    
        /* ----------------------------*/
        buttonLogin.setEnabled(false);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /* Thread <---- 
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ex){
        }
        */
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        user.setName(txtfUsername.getText());
        user.setUserCode(String.valueOf(passfSenha.getPassword()));
        // ----------------------- Conexão -------------------------------------- ///////////////////////////////////
        if(dbase.startConnection() == true){
            this.ChangeConnStatus("Conexão com o Servidor Estabelecida",Color.blue);
            if(dbase.startLogin(user.getUserCode(), user.getName()) != null){
                user.setUserType(dbase.startLogin(user.getUserCode(), user.getName()));
                /*JOptionPane.showMessageDialog(null, "Usuário foi encontrado no Sistema");*/
                System.out.println("User = "+user.getUserType());
                if(user.getUserType().equalsIgnoreCase("Aluno")){
                    UIAluno alunoScreen = new UIAluno(user.getUserType(),user.getName(),user.getUserCode());
                    alunoScreen.setVisible(true);
                }else if(user.getUserType().equalsIgnoreCase("Professor")){
                     UIProfessor profScreen = new UIProfessor(user.getUserCode(),user.getName(),user.getUserType());
                     profScreen.setVisible(true);
                }else{
                     System.out.println(user.getName());
                     UIAdm admScreen = new UIAdm(user.getName(),user.getUserCode(),user.getUserType());
                     admScreen.setVisible(true);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuário não foi encontrado no Sistema");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao Conectar ao Banco de Dados");
            buttonLogin.setEnabled(true); 
        }
        buttonLogin.setEnabled(true);
        labelSStatus.setText("");
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtfUsername.setText("Guilherme");
        passfSenha.setText("0150121691");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        txtfUsername.setText("Eduardo");
        passfSenha.setText("0000205522");
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        txtfUsername.setText("João");
        passfSenha.setText("0225215256");
    }//GEN-LAST:event_kButton2ActionPerformed
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    
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
            java.util.logging.Logger.getLogger(UILoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UILoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UILoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UILoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UILoginForm().setVisible(true);
            }
        }); 
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundIconPassword;
    private javax.swing.JPanel backgroundIconUser;
    private javax.swing.JPanel backgroundPanel;
    private com.k33ptoo.components.KButton buttonLogin;
    private javax.swing.JSeparator hr;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private javax.swing.JLabel labelSStatus;
    private javax.swing.JLabel labelSchoolLogo;
    private javax.swing.JLabel labelUserIcon;
    private javax.swing.JLabel labelUserIcon1;
    private javax.swing.JPasswordField passfSenha;
    private javax.swing.JTextField txtfUsername;
    // End of variables declaration//GEN-END:variables

    private String toString(char[] password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
