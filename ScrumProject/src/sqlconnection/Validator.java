/*
 * This is the validation class. In this class we validate our code that communicates with the database.
 */
package sqlconnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import sqlconnection.SQLConnection;

/**
 *
 * @author Tomas
 */
public class Validator {
        
    public static boolean itIsEmpty(JTextField tf, JLabel lbl ){
        if(tf.getText().isEmpty()){
            lbl.setText("Fyll i alla textfält");
            tf.requestFocus();//Sätter fokus vid fel
            return false;
        }
        return true;
    }
    
    
    public static boolean LoginIsValid(String LoginString){
        boolean exists = false;
                ArrayList<String> loginList = new ArrayList<String>();
        try {
            ResultSet userNameRes = SQLConnection.getDatabas().executeQuery("select AnvandarNamn from Anvandare");
            ResultSet passwordRes = SQLConnection.getDatabas().executeQuery("select Losenord from Anvandare");
            while(userNameRes.next()&& passwordRes.next()){
                String ThisUserName = userNameRes.getString(1);
                String ThisPassword = passwordRes.getString(1);
                String Login = ThisUserName+ThisPassword;
                loginList.add(Login);           
            }
            
            for(String log:loginList){
                if(log.equals(LoginString)){
                    exists = true;
                }
            }

        }
      
         catch (Exception ex) {
            System.out.println("fel i validator.LoginIsValid :"+ex);
        }
        return exists;
    }
    
    
    public static boolean PasswordExists(String password){
        Boolean exists = false;
        ArrayList<String> passwords = new ArrayList<String>();
        
        try{
       ResultSet passwordList = SQLConnection.getDatabas().executeQuery("select Losenord from anvandare");
                   while(passwordList.next()){
        String existingPasswords = passwordList.getString(1);
        passwords.add(existingPasswords);
            }
                   for(String pass:passwords){
                       if(pass == password){
                           exists = true;
                       }
                       else{
                           exists = false;
                       }
                   }        
        }
        catch(Exception ex){
            System.out.println(ex);
    }
    return exists;
}
}
