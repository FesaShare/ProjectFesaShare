/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.validacao;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author USUARIO
 */
public class ValidacaoUsuario {
    public static boolean isPhoneValid(String phone){
        // creating an instance of PhoneNumber Utility class
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        
        // creating a variable of type PhoneNumber
        PhoneNumber phoneNumber = null;
        
         try {
            // the parse method parses the string and
            // returns a PhoneNumber in the format of
            // specified region
            phoneNumber = phoneUtil.parse(phone, "BR");
         }
         
         catch (NumberParseException e) {
            
            // if the phoneUtil is unable to parse any phone
            // number an exception occurs and gets caught in
            // this block
            System.out.println(
                "Unable to parse the given phone number: "
                + phone);
            e.printStackTrace();
        }
  
        // return the boolean value of the validation
        // performed
        return phoneUtil.isValidNumber(phoneNumber);   
    }
    
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
