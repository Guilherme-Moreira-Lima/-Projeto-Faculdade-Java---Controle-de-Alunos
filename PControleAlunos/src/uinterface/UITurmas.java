package uinterface;
import database.DBClass;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UITurmas extends javax.swing.JFrame {
    
    private ArrayList<String> turmas = new ArrayList<String>();

    public UITurmas() {
        initComponents();
        updateTurmasList();
    }
    
    public void updateTurmasList(){
        int a;
        cbTurmas.removeAllItems();
        DBClass dbase = new DBClass();
        if(dbase.startConnection()){
            turmas = dbase.getTurmas();
            for(a=0;a!=turmas.size();a++){
               cbTurmas.addItem(turmas.get(a));
            }        
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        cbTurmas = new javax.swing.JComboBox<>();
        btnRemove = new com.k33ptoo.components.KButton();
        btnRegister = new com.k33ptoo.components.KButton();
        jLabel2 = new javax.swing.JLabel();
        tfTurmaName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setTitle("Turmas");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 255));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(-10, 160, 490, 20);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Turmas Cadastradas:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(170, 210, 120, 16);

        jPanel1.add(cbTurmas);
        cbTurmas.setBounds(120, 240, 230, 22);

        btnRemove.setText("Remover Turma Selecionada");
        btnRemove.setkBackGroundColor(new java.awt.Color(0, 102, 255));
        btnRemove.setkEndColor(new java.awt.Color(0, 153, 204));
        btnRemove.setkHoverEndColor(new java.awt.Color(0, 0, 153));
        btnRemove.setkHoverForeGround(new java.awt.Color(0, 51, 255));
        btnRemove.setkHoverStartColor(new java.awt.Color(51, 102, 255));
        btnRemove.setkStartColor(new java.awt.Color(0, 0, 153));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemove);
        btnRemove.setBounds(140, 270, 185, 30);

        btnRegister.setText("Registrar Turma");
        btnRegister.setkEndColor(new java.awt.Color(51, 153, 255));
        btnRegister.setkHoverEndColor(new java.awt.Color(0, 0, 153));
        btnRegister.setkHoverForeGround(new java.awt.Color(0, 51, 255));
        btnRegister.setkHoverStartColor(new java.awt.Color(51, 102, 255));
        btnRegister.setkStartColor(new java.awt.Color(0, 102, 204));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister);
        btnRegister.setBounds(140, 120, 185, 30);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nome da Turma:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 50, 220, 16);

        tfTurmaName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(tfTurmaName);
        tfTurmaName.setBounds(200, 80, 64, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Adicionar Turma");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 10, 280, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Remover Turma");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 170, 160, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 480, 340);

        setSize(new java.awt.Dimension(487, 346));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        DBClass dbase = new DBClass();
        if(dbase.startConnection()){
            if(dbase.removeTurma(String.valueOf(cbTurmas.getSelectedItem()))){
                updateTurmasList();
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        DBClass dbase = new DBClass();
        if(dbase.startConnection()){    
            if(dbase.createTurma(tfTurmaName.getText())==0){
                JOptionPane.showMessageDialog(null, "Turma Criada Com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Turma Já Existe!");
            }
            updateTurmasList();
        }
    }//GEN-LAST:event_btnRegisterActionPerformed


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
            java.util.logging.Logger.getLogger(UITurmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UITurmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UITurmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UITurmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UITurmas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnRegister;
    private com.k33ptoo.components.KButton btnRemove;
    private javax.swing.JComboBox<String> cbTurmas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tfTurmaName;
    // End of variables declaration//GEN-END:variables
}
