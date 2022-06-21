package uinterface;
import database.DBClass;
import classes.UserClass;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import classes.UserBoletim;
import uinterface.UIBoletim;
import uinterface.UIUserInfo;


public class UIAluno extends javax.swing.JFrame {
    
    private String userType;
    private String userName;
    private String userCode;
    private ResultSet rs;
    
    
    private void createObjAlun(String uType, String uName, String uCode){
        UserClass alunInfo = new UserClass();
        alunInfo.setName(uName);
        alunInfo.setUserType(uType);
        alunInfo.setUserCode(uCode);
        userType = alunInfo.getUserType();
        userName = alunInfo.getName();
        userCode = alunInfo.getUserCode();
        lbIcon.setText("Logado como: "+" "+uName + " ("+uType+")");
        /*this.setNotasOnBoletim(alunInfo);*/
        /*-----------------------------------*/
    }
    
    private void showBoletim(){
         UIBoletim boletimView = new UIBoletim(userCode,userName,userType);
         boletimView.setVisible(true);
    }
    
    private void setNotasOnBoletim(UserClass alun){
        
        /*
        double mediaPT,mediaMT,mediaCC,mediaHT,mediaGG,mediaAT,mediaED;
        int a,i,b;
        a=0;
        i=0;
        b=0;
        mediaPT = 0;
        mediaMT = 0;
        mediaCC = 0;
        mediaHT = 0;
        mediaGG = 0;
        mediaAT = 0;
        mediaED = 0;
        DBClass dbase = new DBClass();
        if(dbase.startConnection()){
            rs = dbase.getAlunoBoletim(alun.getUserCode(), alun.getName());
            if(rs!= null){
                for(a=1; a<=4;a++){
                    try{
                        mediaPT += rs.getDouble("PT"+String.valueOf(a));
                        mediaMT += rs.getDouble("MT"+String.valueOf(a));
                        mediaCC += rs.getDouble("CC"+String.valueOf(a));
                        mediaHT += rs.getDouble("HT"+String.valueOf(a));
                        mediaGG += rs.getDouble("GG"+String.valueOf(a));
                        mediaAT += rs.getDouble("AT"+String.valueOf(a));
                        mediaED += rs.getDouble("ED"+String.valueOf(a));
                    }catch(SQLException ex){        
                    }
                    for(i=0;i<=6;i++){
                        try{
                            b=0;
                            bTable.setValueAt(rs.getDouble("PT"+String.valueOf(a)), b, a);
                            b++;
                            bTable.setValueAt(rs.getDouble("MT"+String.valueOf(a)), b, a);
                            b++;
                            bTable.setValueAt(rs.getDouble("CC"+String.valueOf(a)), b, a);
                            b++;
                            bTable.setValueAt(rs.getDouble("HT"+String.valueOf(a)), b, a);
                            b++;
                            bTable.setValueAt(rs.getDouble("GG"+String.valueOf(a)), b, a);
                            b++;
                            bTable.setValueAt(rs.getDouble("AT"+String.valueOf(a)), b, a);
                            b++;
                            bTable.setValueAt(rs.getDouble("ED"+String.valueOf(a)), b, a);       
                        }catch(SQLException ex){
                        }
                    }
                }
                
                mediaPT = (mediaPT / 4.0);
                mediaMT = (mediaMT / 4.0);
                mediaCC = /(mediaCC / 4.0);
                mediaHT = (mediaHT / 4.0);
                mediaGG = (mediaGG / 4.0);
                mediaAT = (mediaAT / 4.0);
                mediaED = (mediaED / 4.0);
                
                
                double[] mediafinal = {mediaPT,mediaMT,mediaCC,mediaHT,mediaGG,mediaAT,mediaED};
                for(i=0;i<=6;i++){
                    if(mediafinal[i] > 10.0){
                        bTable.setValueAt(10.0,i,5);
                    }else{
                        bTable.setValueAt(String.valueOf(b),i,5);
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar nota do aluno");
        }
        */
        
    }
    
    
    
    
    public UIAluno(String userType, String userName, String userCode) {
        initComponents();
        this.createObjAlun(userType,userName,userCode);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        background = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        lbBoletim = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbUserInfos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setTitle("Controle de Alunos - Sessão (Aluno)");
        setResizable(false);
        getContentPane().setLayout(null);

        lbIcon.setForeground(new java.awt.Color(255, 255, 255));
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/school_icon.png"))); // NOI18N
        lbIcon.setText("{Text}");
        getContentPane().add(lbIcon);
        lbIcon.setBounds(16, 6, 450, 56);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setForeground(new java.awt.Color(255, 255, 255));
        background.setLayout(null);

        jSeparator1.setBackground(new java.awt.Color(0, 153, 204));
        jSeparator1.setForeground(new java.awt.Color(0, 153, 204));
        background.add(jSeparator1);
        jSeparator1.setBounds(0, 70, 860, 10);

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 153, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 51, 204));
        background.add(kGradientPanel1);
        kGradientPanel1.setBounds(0, 0, 860, 70);

        lbBoletim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icon_boletim.png"))); // NOI18N
        lbBoletim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbBoletimMousePressed(evt);
            }
        });
        background.add(lbBoletim);
        lbBoletim.setBounds(370, 230, 100, 100);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ver Boletim");
        background.add(jLabel2);
        jLabel2.setBounds(370, 330, 100, 16);

        lbUserInfos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icon_user.png"))); // NOI18N
        lbUserInfos.setText("jLabel3");
        lbUserInfos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUserInfosMouseClicked(evt);
            }
        });
        background.add(lbUserInfos);
        lbUserInfos.setBounds(370, 360, 100, 100);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ver Minhas Informações");
        background.add(jLabel4);
        jLabel4.setBounds(320, 460, 200, 16);

        getContentPane().add(background);
        background.setBounds(-5, 0, 860, 670);

        setSize(new java.awt.Dimension(864, 672));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbBoletimMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBoletimMousePressed
       showBoletim();
    }//GEN-LAST:event_lbBoletimMousePressed

    private void lbUserInfosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserInfosMouseClicked
        UIUserInfo userInfo = new UIUserInfo(userCode, userName);
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
            java.util.logging.Logger.getLogger(UIAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIAluno("","","").setVisible(true);
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
