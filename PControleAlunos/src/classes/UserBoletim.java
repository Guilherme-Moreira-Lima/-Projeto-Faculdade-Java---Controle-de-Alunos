package classes;
import classes.UserClass;
import database.DBClass;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;



public class UserBoletim {
    private ResultSet rs;
    
    public String setNotasOnBoletim(UserClass alun, JTable bTable){
        double mediaPT,mediaMT,mediaCC,mediaHT,mediaGG,mediaAT,mediaED;
        int a,i,b;
        a=0;
        i=0;
        b=0;
        mediaPT = 0.0;
        mediaMT = 0.0;
        mediaCC = 0.0;
        mediaHT = 0.0;
        mediaGG = 0.0;
        mediaAT = 0.0;
        mediaED = 0.0;
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
                            if(rs.getDouble("PT"+String.valueOf(a)) != -1){
                                bTable.setValueAt(rs.getDouble("PT"+String.valueOf(a)), b, a);
                            }else{
                                bTable.setValueAt("", b, a);
                            }
                            b++;
                            if(rs.getDouble("MT"+String.valueOf(a)) != -1){
                                bTable.setValueAt(rs.getDouble("MT"+String.valueOf(a)), b, a);
                            }else{
                                
                                bTable.setValueAt("", b, a);
                            }
                            b++;  
                            if(rs.getDouble("CC"+String.valueOf(a)) != -1){
                                bTable.setValueAt(rs.getDouble("CC"+String.valueOf(a)), b, a);
                            }else{
                                bTable.setValueAt("", b, a);
                            }
                            b++;  
                            if(rs.getDouble("HT"+String.valueOf(a)) != -1){
                                bTable.setValueAt(rs.getDouble("HT"+String.valueOf(a)), b, a);
                            }else{
                                bTable.setValueAt("", b, a);
                            }
                            b++; 
                            if(rs.getDouble("GG"+String.valueOf(a)) != -1){
                                bTable.setValueAt(rs.getDouble("GG"+String.valueOf(a)), b, a);
                            }else{
                                bTable.setValueAt("", b, a);
                            }
                            b++;   
                            if(rs.getDouble("AT"+String.valueOf(a)) != -1){
                                bTable.setValueAt(rs.getDouble("AT"+String.valueOf(a)), b, a);
                            }else{
                                bTable.setValueAt("", b, a);
                            }
                            b++;
                            if(rs.getDouble("ED"+String.valueOf(a)) != -1){
                                bTable.setValueAt(rs.getDouble("ED"+String.valueOf(a)), b, a);
                            }else{
                                bTable.setValueAt("", b, a);
                            }                            
                            /*bTable.setValueAt(rs.getDouble("PT"+String.valueOf(a)), b, a);
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
                            */
                        }catch(SQLException ex){
                        }
                    }
                }
                
                mediaPT = /*Math.round*/(mediaPT / 4.0);
                mediaMT = /*Math.round*/(mediaMT / 4.0);
                mediaCC = /*Math.round*/(mediaCC / 4.0);
                mediaHT = /*Math.round*/(mediaHT / 4.0);
                mediaGG = /*Math.round*/(mediaGG / 4.0);
                mediaAT = /*Math.round*/(mediaAT / 4.0);
                mediaED = /*Math.round*/(mediaED / 4.0); 
                
                double[] mediafinal = {mediaPT,mediaMT,mediaCC,mediaHT,mediaGG,mediaAT,mediaED};
                for(i=0;i<=6;i++){
                    if(mediafinal[i] > 10.0){
                        bTable.setValueAt(10.0,i,5);
                        bTable.setValueAt("Aprovado", i, 6);
                    }else{              
                        bTable.setValueAt(String.valueOf(mediafinal[i]),i,5);
                        if(mediafinal[i] >= 6.0){
                            bTable.setValueAt("Aprovado", i, 6);
                        }else if(mediafinal[i] < 0){
                            bTable.setValueAt("Sem Nota", i, 6);
                        }else{
                            bTable.setValueAt("Reprovado", i, 6);
                        }
                    }
                }
            }
        }else{       
            return "Erro ao tentar buscar nota do aluno no banco de dados.\nTente novamente mais tarde.";
        }
        return null;
    }
    public boolean saveAlteracoes(JTable bTable, String uCode){
        int a,b,i;
        DBClass dbase = new DBClass();
        for(a=1;a<=4;a++){
            for(b=0;b<=6;b++){
                i=0;
                if(dbase.startConnection()){
                    if(dbase.salvarAlteracaoBoletim(uCode,"PT"+String.valueOf(a), String.valueOf(bTable.getValueAt(i, a)))){
                        i++;
                        if(dbase.salvarAlteracaoBoletim(uCode,"MT"+String.valueOf(a), String.valueOf(bTable.getValueAt(i, a)))){
                            i++;
                            if(dbase.salvarAlteracaoBoletim(uCode,"CC"+String.valueOf(a), String.valueOf(bTable.getValueAt(i, a)))){
                                i++;
                                if(dbase.salvarAlteracaoBoletim(uCode,"HT"+String.valueOf(a), String.valueOf(bTable.getValueAt(i, a)))){
                                    i++;
                                    if(dbase.salvarAlteracaoBoletim(uCode,"GG"+String.valueOf(a), String.valueOf(bTable.getValueAt(i, a)))){
                                        i++;
                                        if(dbase.salvarAlteracaoBoletim(uCode,"AT"+String.valueOf(a), String.valueOf(bTable.getValueAt(i, a)))){
                                            i++;
                                            if(dbase.salvarAlteracaoBoletim(uCode,"ED"+String.valueOf(a), String.valueOf(bTable.getValueAt(i, a)))){ 
                                            }else{
                                                return false;
                                            }
                                        }else{
                                            return false;
                                        }
                                    }else{
                                        return false;
                                    }
                                }else{
                                    return false;
                                }
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
                /*
                i++;
                dbase.salvarAlteracaoBoletim(uCode,"MT"+String.valueOf(a), String.valueOf(bTable.getValueAt(i, a)));
                i++;
                dbase.salvarAlteracaoBoletim(uCode,"CC"+String.valueOf(a), String.valueOf(bTable.getValueAt(i, a)));
                i++;
                dbase.salvarAlteracaoBoletim(uCode,"HT"+String.valueOf(a), String.valueOf(bTable.getValueAt(i, a)));
                i++;
                dbase.salvarAlteracaoBoletim(uCode,"GG"+String.valueOf(a), String.valueOf(bTable.getValueAt(i, a)));
                i++;
                dbase.salvarAlteracaoBoletim(uCode,"AT"+String.valueOf(a), String.valueOf(bTable.getValueAt(i, a)));
                i++;
                dbase.salvarAlteracaoBoletim(uCode,"ED"+String.valueOf(a), String.valueOf(bTable.getValueAt(i, a))); 
                */
            }
        }
        return true;
    }
}

