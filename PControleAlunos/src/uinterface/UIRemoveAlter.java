package uinterface;
import database.DBClass;
import javax.swing.JOptionPane;
import classes.UserPersonalInformations;
import javax.swing.table.DefaultTableModel;




public class UIRemoveAlter extends javax.swing.JFrame {

    public UIRemoveAlter() {
        initComponents();
        updateTable();
    }
    
    public void updateTable(){
        String order;
        DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
        tbl.getDataVector().removeAllElements();
        DBClass dbase = new DBClass();
        if(dbase.startConnection()){
            order = String.valueOf(cbOrder.getSelectedItem());
            if(order.equalsIgnoreCase("Código")){
                order = "idUserCode";
                dbase.getAllUserInfos(jTable1,order);
            }else if(order.equalsIgnoreCase("Nome")){
                order = "UserName";
                dbase.getAllUserInfos(jTable1,order);
            }else{
                dbase.getAllUserInfos(jTable1,order);
            }    
        }        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAlterar = new com.k33ptoo.components.KButton();
        btnRemove = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();
        cbOrder = new javax.swing.JComboBox<>();

        setTitle("Remover/Alterar Usuario");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Idade", "CPF", "Cargo", "Turma", "RA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 60, 800, 470);

        btnAlterar.setText("Alterar Selecionado");
        btnAlterar.setkEndColor(new java.awt.Color(0, 0, 153));
        btnAlterar.setkHoverEndColor(new java.awt.Color(0, 153, 204));
        btnAlterar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnAlterar.setkHoverStartColor(new java.awt.Color(0, 51, 153));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlterar);
        btnAlterar.setBounds(660, 540, 185, 30);

        btnRemove.setText("Remover Selecionado");
        btnRemove.setkEndColor(new java.awt.Color(0, 0, 153));
        btnRemove.setkHoverEndColor(new java.awt.Color(0, 153, 204));
        btnRemove.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnRemove.setkHoverStartColor(new java.awt.Color(0, 51, 153));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemove);
        btnRemove.setBounds(40, 540, 185, 30);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Organizar por:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 30, 90, 20);

        cbOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nome", "Idade", "CPF", "Cargo", "Turma", "RA" }));
        cbOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrderActionPerformed(evt);
            }
        });
        jPanel1.add(cbOrder);
        cbOrder.setBounds(120, 30, 270, 22);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 880, 620);

        setSize(new java.awt.Dimension(888, 625));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int[] rows;
        int a;
        DBClass dbase = new DBClass();
        rows = jTable1.getSelectedRows();
        if(dbase.startConnection()){
            for(a=0;a!=rows.length;a++){   
                if(dbase.deleteUser(String.valueOf(jTable1.getValueAt(rows[a], 0)))){
                    JOptionPane.showMessageDialog(null, "Uusário Removido com Sucesso");
                    updateTable();
                }
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int rows;
        int steps = 0;
        int a;
        DBClass dbase = new DBClass();
        UserPersonalInformations userInfo = new UserPersonalInformations();
        rows = jTable1.getSelectedRow();
        System.out.println(rows+" ===== SELECTED");
        
        /*
        if(dbase.startConnection()){
            for(a=0;a!=rows.length;a++){
                userInfo.setUserCode(String.valueOf(jTable1.getValueAt(a, 0)));
                userInfo.setUserNome(String.valueOf(jTable1.getValueAt(a, 1)));
                userInfo.setUserIdade(String.valueOf(jTable1.getValueAt(a, 2)));
                userInfo.setUserCPF(String.valueOf(jTable1.getValueAt(a, 3)));
                userInfo.setUserCargo(String.valueOf(jTable1.getValueAt(a, 4)));
                if(userInfo.getUserCargo() == "Aluno"){
                    userInfo.setUserTurma(String.valueOf(jTable1.getValueAt(a, 5)));
                    userInfo.setUserRA(String.valueOf(jTable1.getValueAt(a, 6)));
                }else{
                    userInfo.setUserTurma("");
                    userInfo.setUserRA("");                    
                }
                steps = dbase.alterUser(userInfo);
                System.out.println(steps);
            }
        }
        */
        if(dbase.startConnection()){
            userInfo.setUserCode(String.valueOf(jTable1.getValueAt(rows, 0)));
            userInfo.setUserNome(String.valueOf(jTable1.getValueAt(rows, 1)));
            userInfo.setUserIdade(String.valueOf(jTable1.getValueAt(rows, 2)));
            userInfo.setUserCPF(String.valueOf(jTable1.getValueAt(rows, 3)));
            userInfo.setUserCargo(String.valueOf(jTable1.getValueAt(rows, 4)));
            if(userInfo.getUserCargo().equals("Aluno")){
                userInfo.setUserTurma(String.valueOf(jTable1.getValueAt(rows, 5)));
                userInfo.setUserRA(String.valueOf(jTable1.getValueAt(rows, 6)));
            }else{
                userInfo.setUserTurma("");
                userInfo.setUserRA("");                    
            }
                steps = dbase.alterUser(userInfo);
        }
        
        
        
        
        if(steps == 1){
            JOptionPane.showMessageDialog(null, "Dados alterados com Sucesso");
            updateTable();
        }else{
            JOptionPane.showMessageDialog(null, "Um ou mais dados não foram possiveis serem alterados\nTente Novamente Mais Tarde");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void cbOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrderActionPerformed
        updateTable();
    }//GEN-LAST:event_cbOrderActionPerformed


    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(UIRemoveAlter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIRemoveAlter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIRemoveAlter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIRemoveAlter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIRemoveAlter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnAlterar;
    private com.k33ptoo.components.KButton btnRemove;
    private javax.swing.JComboBox<String> cbOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
