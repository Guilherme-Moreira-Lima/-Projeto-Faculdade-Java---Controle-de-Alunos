package database;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import classes.UserPersonalInformations;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DBClass {
    private Connection sqlCon;
    private PreparedStatement sqlSt;
    private ResultSet ReSet;
    private int numberTurmas;
    private ArrayList<String> arrayTurmas = new ArrayList<String>();
    private ArrayList<String> arrayNomes = new ArrayList<String>();
    private ArrayList<String> arrayRA = new ArrayList<String>();
    private ArrayList<String> arrayUser = new ArrayList<String>();
    
    public int numeroTurmas(){
       return numberTurmas;
       
    }
    
    public boolean startConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlCon = DriverManager.getConnection("jdbc:mysql://localhost:/controlealunos_schema","root","");
            return true;
        }catch(ClassNotFoundException | SQLException ex){
            ex.getMessage();
            return false;
        }
    }
    
    public String startLogin(String Code,String Name){
        try{
            sqlSt = sqlCon.prepareStatement("SELECT * FROM controlealunos_schema.userconnection WHERE idUserCode= ? AND UserName = ?");
            sqlSt.setString(1, Code);
            sqlSt.setString(2, Name);
            System.out.println(sqlSt);
            ReSet = sqlSt.executeQuery();
            if(ReSet.next()){
                return ReSet.getString("UserType");
            }else{ 
                return null;
            }
            
        }catch(SQLException ex){  
            return null;
        }
    }
    
    public boolean removeTurma(String turma){
        try{
            sqlSt = sqlCon.prepareStatement("DELETE FROM controlealunos_schema.turmas WHERE idTurmas = ?");
            sqlSt.setString(1, turma);
            sqlSt.executeUpdate();
            return true;
        }catch(SQLException ex){
            return false;
        }        
    }
    
    public int createTurma(String turma){
        try{
            sqlSt = sqlCon.prepareStatement("INSERT INTO controlealunos_schema.turmas VALUES (?)");
            sqlSt.setString(1, turma);
            sqlSt.executeUpdate();
            return 0;
        }catch(SQLException ex){
            System.out.println(ex.getErrorCode());
            return ex.getErrorCode();
        }
    }
    
    ///////////////////////////////////////////////// REGISTER     /////////////////////////////////////////////////
    
    public boolean registerUserInfos(UserPersonalInformations userInfo){
        try{
            //Code, Name, idade,cpf, cargo, turma, ra
                sqlSt = sqlCon.prepareStatement("INSERT INTO controlealunos_schema.userinformations VALUES (?,?,?,?,?,?,?,0.0);"); 
                sqlSt.setString(1, userInfo.getUserCode());
                sqlSt.setString(2, userInfo.getUserNome());
                sqlSt.setInt(3, Integer.parseInt(userInfo.getUserIdade()));
                sqlSt.setString(4, userInfo.getUserCPF());
                System.out.println("CPF ===== "+userInfo.getUserCPF());
                sqlSt.setString(5, userInfo.getUserCargo());
                sqlSt.setString(6, userInfo.getUserTurma());
                sqlSt.setString(7, userInfo.getUserRA());
                sqlSt.executeUpdate();
                return true;           
        }catch(SQLException ex){
            System.out.println("ERRO  information >>>" + ex.getErrorCode());
            return false;
        }
    }
    
    public boolean registerBoletim(UserPersonalInformations userInfo){
        int a;
        try{
            sqlSt = sqlCon.prepareStatement("INSERT INTO controlealunos_schema.alunoboletim VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sqlSt.setString(1, userInfo.getUserCode());
            sqlSt.setString(2, userInfo.getUserNome());
            for(a=3;a<=30;a++){
                sqlSt.setDouble(a, -1);
                System.out.println(a + " -1");
            }
            sqlSt.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.out.println("ERRO boletim >>>" + ex.getErrorCode());
            return false;
        }                
    }
    
    public boolean registerUser(UserPersonalInformations userInfo){
        try{
            //Code,Name,Type,RA,Turma
            sqlSt = sqlCon.prepareStatement("INSERT INTO controlealunos_schema.userconnection VALUES (?,?,?,?,?)");
            sqlSt.setString(1, userInfo.getUserCode());
            sqlSt.setString(2, userInfo.getUserNome());
            sqlSt.setString(3, userInfo.getUserCargo());
            sqlSt.setString(4, userInfo.getUserRA());
            sqlSt.setString(5, userInfo.getUserTurma());
            sqlSt.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.out.println("ERRO connection >>>" + ex.getErrorCode());
            return false;
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ResultSet getAlunoBoletim(String userID, String userName){
        try{
            sqlSt = sqlCon.prepareStatement("SELECT * FROM controlealunos_schema.alunoboletim WHERE AlunoID = ? AND AlunoNome = ?");
            sqlSt.setString(1, userID);
            sqlSt.setString(2, userName);
            ReSet = sqlSt.executeQuery();
            if(ReSet.next()){
                System.out.println("RE-Boletim = Next");
                numberTurmas++;
                return ReSet;
            }else{
                return null;
            }  
        }catch(SQLException ex){
            return null;
        }
    }
    public String[] getAlunoRATurma(String userID, String userName){    
        try{
            sqlSt = sqlCon.prepareStatement("SELECT UserRA,UserTurma FROM controlealunos_schema.userconnection WHERE idUserCode = ? AND UserName = ?");
            sqlSt.setString(1, userID);
            sqlSt.setString(2, userName);
            ReSet = sqlSt.executeQuery();
            if(ReSet.next()){
                String[] s = {ReSet.getString("UserRA"), ReSet.getString("UserTurma")};
                return s;
            }else{
                return null;
            }
        }catch(SQLException ex){
            return null;
        }   
    }
    
    public ArrayList getTurmas(){
        try{
            sqlSt = sqlCon.prepareStatement("SELECT * FROM controlealunos_schema.turmas;");
            ReSet = sqlSt.executeQuery();
            while(ReSet.next()){
                arrayTurmas.add(ReSet.getString("idTurmas"));   
            }
            return arrayTurmas;
        }catch(SQLException ex){
            return null;
        }
    }
    
    
    public ArrayList getAllAlunosNome(String turma){
        arrayNomes.clear();
        try{
            sqlSt = sqlCon.prepareStatement("SELECT UserName FROM controlealunos_schema.userconnection WHERE UserType='Aluno' AND UserTurma=?");
            sqlSt.setString(1, turma);
            System.out.println(sqlSt);
            ReSet = sqlSt.executeQuery();
            while(ReSet.next()){ 
                arrayNomes.add(ReSet.getString("UserName"));   
            }
            if(arrayNomes!=null){
                System.out.println("????????????????????????????????????????NOT NULL");
                return arrayNomes;
            }else{
                return null;
            }  
        }catch(SQLException ex){
            return null;
        }
    }
    
    public ArrayList getAllAlunosRA(String turma){
        arrayRA.clear();
        try{
            sqlSt = sqlCon.prepareStatement("SELECT UserRA FROM controlealunos_schema.userconnection WHERE UserType='Aluno' AND UserTurma=?");
            sqlSt.setString(1, turma);
            System.out.println(sqlSt);
            ReSet = sqlSt.executeQuery();
            while(ReSet.next()){ 
                arrayRA.add(ReSet.getString("UserRA"));   
            }
            return arrayRA;
        }catch(SQLException ex){
            return null;
        }     
    }
    public String getUserCodeOnly(String name, String ra){
        try{
            sqlSt = sqlCon.prepareStatement("SELECT idUserCode FROM controlealunos_schema.userconnection WHERE UserName=? AND UserRA=?");
            sqlSt.setString(1,name);
            sqlSt.setString(2,ra);
            ReSet = sqlSt.executeQuery();
            if(ReSet.next()){
                return ReSet.getString("idUserCode");
            }else{
                return null;
            }
        }catch(SQLException ex){
            return null;
        }
    }
    public boolean salvarAlteracaoBoletim(String uCode, String colname, String rowvalue){
        try{
            sqlSt = sqlCon.prepareStatement("UPDATE controlealunos_schema.alunoboletim SET "+colname+"="+rowvalue+" WHERE AlunoID=?");
            if(rowvalue.equals("-")){
                sqlSt = sqlCon.prepareStatement("UPDATE controlealunos_schema.alunoboletim SET "+colname+"="+-1+" WHERE AlunoID=?");
            }else{
                sqlSt = sqlCon.prepareStatement("UPDATE controlealunos_schema.alunoboletim SET "+colname+"="+rowvalue+" WHERE AlunoID=?");
            }
            sqlSt.setString(1, uCode);
            System.out.println(sqlSt);
            sqlSt.executeUpdate();
            return true;
        }catch(SQLException ex){
            return false;
        }
    }
    public UserPersonalInformations getUserInfos(String uCode, String uName){
        try{
            sqlSt = sqlCon.prepareStatement("SELECT * FROM controlealunos_schema.userinformations WHERE idUserCode = ? AND UserName = ?");
            sqlSt.setString(1, uCode);
            sqlSt.setString(2, uName);
            System.out.println(sqlSt);
            ReSet = sqlSt.executeQuery();
            if(ReSet.next()){
                UserPersonalInformations userInfo = new UserPersonalInformations();
                userInfo.setUserCPF(ReSet.getString("CPF"));
                userInfo.setUserCargo(ReSet.getString("Cargo"));
                userInfo.setUserIdade(ReSet.getString("Idade"));
                userInfo.setUserNome(ReSet.getString("UserName"));
                userInfo.setUserRA(ReSet.getString("RA"));
                /*userInfo.setSalario(ReSet.getDouble("Salario"));*/
                userInfo.setUserTurma(ReSet.getString("Turma"));
                return userInfo;
            }else{
                return null;
            }
        }catch(SQLException ex){
            return null;
        }
    }
    public int raExister(String uRA){
        try{
            sqlSt = sqlCon.prepareStatement("SELECT * FROM controlealunos_schema.userconnection WHERE UserRA = ?");
            sqlSt.setString(1, uRA);
            ReSet = sqlSt.executeQuery();
            if(ReSet.next()){
                if(ReSet.getString("UserRA").equalsIgnoreCase(uRA)){
                    return 1;
                }else{
                    return 0;
                }
            }
        }catch(SQLException ex){
            return -1;
        }
        return -2;
    }
    
    public int codeExister(String uCode){
        try{
            sqlSt = sqlCon.prepareStatement("SELECT * FROM controlealunos_schema.userconnection WHERE idUserCode = ?");
            sqlSt.setString(1, uCode);
            ReSet = sqlSt.executeQuery();
            if(ReSet.next()){
                if(ReSet.getString("idUserCode").equalsIgnoreCase(uCode)){
                    return 1;
                }else{
                    return 0;
                }
            }
        }catch(SQLException ex){
            return -1;
        }
        return -2;
    }
    
    public void getAllUserInfos(JTable tb, String order){
        try{
            sqlSt = sqlCon.prepareStatement("SELECT * FROM controlealunos_schema.userinformations ORDER BY " + order);
            ReSet = sqlSt.executeQuery();
            DefaultTableModel tbl = (DefaultTableModel) tb.getModel();
            while(ReSet.next()){
                Object[] s = {ReSet.getString("idUserCode"), ReSet.getString("UserName"), ReSet.getInt("Idade"), ReSet.getString("CPF"), ReSet.getString("Cargo"), ReSet.getString("Turma"), ReSet.getString("RA")};
                tbl.addRow(s);
            }
        }catch(SQLException ex){
        }
    }
    
    public boolean deleteUser(String uCode){
        try{
            sqlSt = sqlCon.prepareStatement("DELETE FROM controlealunos_schema.userconnection WHERE idUserCode = ?");
            sqlSt.setString(1, uCode);
            sqlSt.executeUpdate();
            sqlSt.clearParameters();
            sqlSt = sqlCon.prepareStatement("DELETE FROM controlealunos_schema.userinformations WHERE idUserCode = ?");
            sqlSt.setString(1, uCode);
            sqlSt.executeUpdate();
            sqlSt.clearParameters();
            sqlSt = sqlCon.prepareStatement("DELETE FROM controlealunos_schema.alunoboletim WHERE AlunoID = ?");
            sqlSt.setString(1, uCode);
            sqlSt.executeUpdate();
            return true;
        }catch(SQLException ex){
            return false;
        }
    }
    
    public int alterUser(UserPersonalInformations userInfo){
        try{
            sqlSt = sqlCon.prepareStatement("UPDATE controlealunos_schema.userconnection SET idUserCode= ?, UserName = ?, UserType = ?, UserRA = ?, UserTurma = ? WHERE idUserCode = ?");
            sqlSt.setString(1, userInfo.getUserCode());
            sqlSt.setString(2, userInfo.getUserNome());
            sqlSt.setString(3, userInfo.getUserCargo());
            sqlSt.setString(4, userInfo.getUserRA());
            sqlSt.setString(5, userInfo.getUserTurma());
            sqlSt.setString(6, userInfo.getUserCode());
            sqlSt.executeUpdate();
            System.out.println("STEP 1");
            sqlSt.clearParameters();
            ////////////////////////////////////////////////////////////////////
                                                                                           //              1             2          3        4          5          6       7
            sqlSt = sqlCon.prepareStatement("UPDATE controlealunos_schema.userinformations SET idUserCode= ?, UserName = ?, Idade = ?, CPF = ?, Cargo = ?, Turma = ?, RA = ?, Salario = 0.0 WHERE idUserCode = ?");
            sqlSt.setString(1, userInfo.getUserCode());
            sqlSt.setString(2, userInfo.getUserNome());
            sqlSt.setInt(3, Integer.valueOf(userInfo.getUserIdade()));
            sqlSt.setString(4, userInfo.getUserCPF());
            sqlSt.setString(5, userInfo.getUserCargo());
            sqlSt.setString(6, userInfo.getUserTurma());
            sqlSt.setString(7, userInfo.getUserRA());
            sqlSt.setString(8, userInfo.getUserCode());
            sqlSt.executeUpdate();
            System.out.println("STEP 2");
            sqlSt.clearParameters(); 
            /////////////////////////////////////////////////////////////////////
            sqlSt = sqlCon.prepareStatement("UPDATE controlealunos_schema.alunoboletim SET AlunoID = ?, AlunoNome = ? WHERE AlunoID = ?");
            sqlSt.setString(1, userInfo.getUserCode());
            sqlSt.setString(2, userInfo.getUserNome());   
            sqlSt.setString(3, userInfo.getUserCode());
            sqlSt.executeUpdate();
            System.out.println("STEP 3");
            return 1;
        }catch(SQLException ex){  
            return 0;
        }
    }
    
}
