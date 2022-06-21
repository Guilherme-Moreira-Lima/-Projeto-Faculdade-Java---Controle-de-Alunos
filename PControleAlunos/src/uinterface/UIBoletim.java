package uinterface;
import classes.UserClass;
import classes.UserBoletim;
import database.DBClass;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class UIBoletim extends javax.swing.JFrame {
    
    private String uCode, uName, uType, uRA, uTurma;
    private int b=0;
    private ArrayList<String> turmas = new ArrayList<String>();
    private ArrayList<String> nomes = new ArrayList<String>();
    private ArrayList<String> ras = new ArrayList<String>();    
    
    
    public void generateBoletim(){  
        int a=0;
        UserClass uClass = new UserClass();
        DBClass dbase = new DBClass();
        UserBoletim uBoletim = new UserBoletim();
        
        if(dbase.startConnection()){
            uRA = dbase.getAlunoRATurma(uCode, uName)[0];
            uTurma = dbase.getAlunoRATurma(uCode, uName)[1];         
            turmas = dbase.getTurmas();
        }
        System.out.println("CONFIG BOLETIM===="+uName+" <<< Name " + uCode+"<<<<<<<<<< Code");
        uClass.setName(uName);
        uClass.setUserCode(uCode);
        uClass.setUserType(uType);
        configBoletim(uClass,uBoletim);
        System.out.println(turmas.size());
        for(a=0; a!=turmas.size();a++){
            cbTurma.addItem(turmas.get(a));
        }
    }
    
    public void configBoletim(UserClass uClass, UserBoletim boletim){
        lbBoletimDesc.setText("Boletim do Aluno(a): " + uName + " | RA:" + uRA + " | Turma:" + uTurma);
        boletim.setNotasOnBoletim(uClass, bTable);
    }
    
    public void resetNomesList(){
        int a;
        nomes.clear();
        ras.clear();
        cbAlunoNome.removeAllItems();
        DBClass dbase = new DBClass();
        if(dbase.startConnection()){
            nomes = dbase.getAllAlunosNome(String.valueOf(cbTurma.getSelectedItem()));
            ras = dbase.getAllAlunosRA(String.valueOf(cbTurma.getSelectedItem()));
            System.out.println("QUANTIDADE DE NOMES == "+nomes.size());
            if(nomes.size() > 0){
                for(a=0; a!=nomes.size();a++){
                    cbAlunoNome.addItem(String.valueOf(nomes.get(a) + " | RA: " + ras.get(a)));
                }
            }else{
                System.out.println("a34h129ejhndatkendtw8de");
                cbAlunoNome.addItem("Nenhum Aluno Foi Registrado Nessa Sala Ainda");
            }
        }
    }
    
    public void changeUser(){
        int a,b,c;
        DBClass dbase = new DBClass();
        UserClass uClass = new UserClass();
        UserBoletim uBoletim = new UserBoletim();
        if(dbase.startConnection() && nomes.size() > 0){
            uName = nomes.get(cbAlunoNome.getSelectedIndex());
            uCode = dbase.getUserCodeOnly(String.valueOf(nomes.get(cbAlunoNome.getSelectedIndex())), String.valueOf(ras.get(cbAlunoNome.getSelectedIndex())));
            uTurma = dbase.getAlunoRATurma(uCode, uName)[1];
            uRA = dbase.getAlunoRATurma(uCode, uName)[0];
            lbBoletimDesc.setText("Boletim do Aluno(a): " + uName + " | RA:" + uRA + " | Turma:" + uTurma);
            uClass.setName(uName);
            uClass.setUserCode(uCode);
            uClass.setUserType("Aluno");
            configBoletim(uClass, uBoletim);
            //////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.print("\nCALL GENERATE BOLETIM AGAIN\n");
            System.out.print("User="+uName+"\n");
            System.out.print("RA="+uRA+"\n");
            System.out.print("Code="+uCode+"\n");
            System.out.print("----------------------------------------------\n"); 
            btnSaveNotas.setEnabled(true);
            btnSaveNotas.setVisible(true);
        }else{
            for(a=1;a<=6;a++){
                for(b=0;b<=6;b++){
                    bTable.setValueAt("",b,a);
                }
            }
            btnSaveNotas.setEnabled(false);
            btnSaveNotas.setVisible(false);
            lbBoletimDesc.setText("Boletim não encontrado");
        }
    }

    public UIBoletim(String userCode, String userName, String userType) {
        initComponents();
        uCode = userCode;
        uName = userName;
        uType = userType;
        System.out.println("##############################Boletim#################################");
        System.out.println(uCode);
        System.out.println(uName);
        /*if(userType.equalsIgnoreCase("Aluno")){
            generateBoletim();
        }*/generateBoletim();
        if(!uType.equalsIgnoreCase("Professor")){
            btnSaveNotas.setEnabled(false);
            btnSaveNotas.setVisible(false);
            bTable.setEnabled(false);
            cbTurma.setVisible(false);
            lbCb1.setVisible(false);
            lbCb2.setVisible(false);
            cbAlunoNome.setVisible(false);
        }else{
            btnSaveNotas.setEnabled(true);
            btnSaveNotas.setVisible(true); 
            bTable.setEnabled(true);
            cbTurma.setVisible(true);
            lbCb1.setVisible(true);
            lbCb2.setVisible(true);
            cbAlunoNome.setVisible(true);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSaveNotas = new com.k33ptoo.components.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bTable = new javax.swing.JTable();
        lbBoletimDesc = new javax.swing.JLabel();
        cbTurma = new javax.swing.JComboBox<>();
        lbCb1 = new javax.swing.JLabel();
        cbAlunoNome = new javax.swing.JComboBox<>();
        lbCb2 = new javax.swing.JLabel();

        setTitle("Boletim");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        btnSaveNotas.setText("Salvar Alterações e Calcular Média");
        btnSaveNotas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSaveNotas.setkEndColor(new java.awt.Color(0, 0, 255));
        btnSaveNotas.setkHoverEndColor(new java.awt.Color(0, 125, 153));
        btnSaveNotas.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSaveNotas.setkHoverStartColor(new java.awt.Color(0, 0, 255));
        btnSaveNotas.setkSelectedColor(new java.awt.Color(0, 0, 255));
        btnSaveNotas.setkStartColor(new java.awt.Color(0, 125, 153));
        btnSaveNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNotasActionPerformed(evt);
            }
        });
        jPanel1.add(btnSaveNotas);
        btnSaveNotas.setBounds(200, 290, 280, 30);

        jScrollPane1.setWheelScrollingEnabled(false);

        bTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Português", null, null, null, null, null, null},
                {"Matemática", null, null, null, null, null, null},
                {"Ciências", null, null, null, null, null, null},
                {"História", null, null, null, null, null, null},
                {"Geografia", null, null, null, null, null, null},
                {"Artes", null, null, null, null, null, null},
                {"Ed.Física", null, null, null, null, null, null}
            },
            new String [] {
                "Disciplinas", "1 ° Bim", "2 ° Bim", "3 ° Bim", "4 ° Bim", "Média", "Resultado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bTable.setToolTipText("*OBS: O(A) Aluno(a) só será reprovado(a), caso o(a) mesmo(a) não tenha atingido a meta necessária em 3 ou mais matérias.");
        bTable.setEnabled(false);
        bTable.setShowGrid(true);
        jScrollPane1.setViewportView(bTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 700, 170);

        lbBoletimDesc.setBackground(new java.awt.Color(0, 0, 0));
        lbBoletimDesc.setForeground(new java.awt.Color(0, 0, 0));
        lbBoletimDesc.setText("jLabel1");
        jPanel1.add(lbBoletimDesc);
        lbBoletimDesc.setBounds(10, 80, 700, 16);

        cbTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTurmaActionPerformed(evt);
            }
        });
        jPanel1.add(cbTurma);
        cbTurma.setBounds(10, 30, 130, 22);

        lbCb1.setBackground(new java.awt.Color(0, 0, 0));
        lbCb1.setForeground(new java.awt.Color(0, 0, 0));
        lbCb1.setText("Selecione Turma:");
        jPanel1.add(lbCb1);
        lbCb1.setBounds(10, 10, 130, 16);

        cbAlunoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlunoNomeActionPerformed(evt);
            }
        });
        jPanel1.add(cbAlunoNome);
        cbAlunoNome.setBounds(200, 30, 310, 22);

        lbCb2.setForeground(new java.awt.Color(0, 0, 0));
        lbCb2.setText("Selecione o Aluno:");
        jPanel1.add(lbCb2);
        lbCb2.setBounds(200, 10, 310, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 740, 440);

        setSize(new java.awt.Dimension(753, 442));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTurmaActionPerformed
        resetNomesList();
    }//GEN-LAST:event_cbTurmaActionPerformed

    private void cbAlunoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlunoNomeActionPerformed
        if(cbAlunoNome.isVisible() && uType.equalsIgnoreCase("Professor")){
            changeUser();
        }
    }//GEN-LAST:event_cbAlunoNomeActionPerformed

    private void btnSaveNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNotasActionPerformed
        UserBoletim uBoletim = new UserBoletim();
        bTable.setEnabled(false);
        if(uBoletim.saveAlteracoes(bTable, uCode)){
            JOptionPane.showMessageDialog(null,"Alterações salvas com sucesso.");
            bTable.setEnabled(true);
            changeUser();
        }else{
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar salvar as alterações feitas,\n tente novamente mais tarde!");
            bTable.setEnabled(true);
            changeUser();
        }
        
    }//GEN-LAST:event_btnSaveNotasActionPerformed


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
            java.util.logging.Logger.getLogger(UIBoletim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIBoletim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIBoletim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIBoletim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIBoletim("","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bTable;
    private com.k33ptoo.components.KButton btnSaveNotas;
    private javax.swing.JComboBox<String> cbAlunoNome;
    private javax.swing.JComboBox<String> cbTurma;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBoletimDesc;
    private javax.swing.JLabel lbCb1;
    private javax.swing.JLabel lbCb2;
    // End of variables declaration//GEN-END:variables
}
