package group2.asd.uts.edu.au.opal.servlet;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;


public class Validator implements Serializable {

    /*Fields for initialising Input format*/
    private final String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private final String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
    private final String firstLastNamePattern = "[A-Za-z\\s]{1,20}";
    private final String passwordPattern = "[A-za-z0-9]{8,15}";
    private final String usernamePattern = "[A-Za-z0-9]{4,15}";
    private final String phonePattern = "[0-9]{8,13}";
    private final String numberPattern = "[0-9]{1,}";
    private final String cardNumberPattern = "[0-9]{16}";
    private final String cardPinPattern = "[0-9]{4}";
    private final String paymentTypePattern = "[A-Za-z\\s]{4,20}";
    private final String paymentNumberPattern = "[0-9]{6,20}";
    private final String creditCardCvc = "[0-9]{3}";
    private final String paymentExpiry = "[0-9]{2}[/]{1}[0-9]{2}";

    /*Constructor*/
    public Validator(){}

    /*Methods for checking format*/
    public boolean validate(String pattern, String input){
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }

    public boolean validateCardExpiry(String expiry, int cMonth, int cYear) {
        if(!validate(paymentExpiry, expiry)) return false;
        return validateMonthAndYear(expiry, cMonth, cYear);
    }

    public boolean validateCardCvc (final String number) {
        return validate(creditCardCvc, number);
    }

    public boolean checkEmpty(String email, String password){
        return  email.isEmpty() || password.isEmpty();
    }

    public boolean validateEmail(String email){
        return validate(emailPattern, email);
    }

    public boolean validateFirstOrLastName(String name){ return validate(firstLastNamePattern, name); }

    public boolean validateName(String name){
        return validate(namePattern, name);
    }

    public boolean validateUsername(String username){
        return validate(usernamePattern, username);
    }

    public boolean validatePassword(String password){
        return validate(passwordPattern, password);
    }

    public boolean validatePhoneNumber(String number){
        return validate(phonePattern,number);
    }

    public boolean isValidatePassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public boolean validatePaymentType(String type){
        return validate(paymentTypePattern, type);
    }

    public boolean validatePaymentNumber(String number){
        return validate(paymentNumberPattern, number);
    }

    public boolean validateNumber(String number){
        return validate(namePattern, number);
    }

    public boolean validateCardNumber(String number){ return validate(cardNumberPattern, number);}

    public boolean validateCardPin(String number){
        return validate(cardPinPattern, number);
    }


    public boolean validateMonthAndYear(String expiry, int cMonth, int cYear) {
        try {
            String[] splits = expiry.split("/");
            int month = Integer.parseInt(splits[0]);
            int year = Integer.parseInt(splits[1]);
            if(month <= 0 || month >= 13) return false;
            return month + year * 12 >= cYear * 12 + cMonth;
        }catch(Exception e) {
            return false;
        }
    }

    public boolean validateDate(String month, String days) {
        if(validateNumber(month) && validateNumber(days)){
            int intMonth = Integer.parseInt(month);
            int intDays = Integer.parseInt(days);
            return (intMonth <= 12 && intMonth >= 0) && (intDays > 0 && intDays <= getDaysByMonth(intMonth));
        }
        return false;
    }

    public int getDaysByMonth(int month) {
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return -1;

        }
    }

    /*The method for cleaning all error message*/
    public void clean(HttpSession session) {
        session.setAttribute("emailErr", "");
        session.setAttribute("passErr", "");
        session.setAttribute("nameErr", "");
        session.setAttribute("firstnameErr", "");
        session.setAttribute("lastnameErr", "");
        session.setAttribute("existErr", "");
        session.setAttribute("usernameErr", "");
        session.setAttribute("passDiffErr", "");
        session.setAttribute("phoneNumberErr", "");
        session.setAttribute("profileUpdate", "");
        session.setAttribute("userLock", "");
        session.setAttribute("dateFormErr", "");
        session.setAttribute("successInfo", "");
        session.setAttribute("paymentTypeErr","");
        session.setAttribute("paymentNumberErr","");
        session.setAttribute("cardNumberFormErr", "");
        session.setAttribute("cardPinFormErr", "");
        session.setAttribute("cardNumAndPinErr", "");
        session.setAttribute("cardNameErr", "");
        session.setAttribute("cardCvcErr", "");
        session.setAttribute("cardExpiryErr", "");

        /*clean previous input*/
        session.setAttribute("previous_card_number", "");
        session.setAttribute("previous_card_pin", "");
        session.setAttribute("previous_payment_number", "");
        session.setAttribute("previous_payment_owner", "");
        session.setAttribute("previous_payment_cvc", "");
        session.setAttribute("previous_payment_expiry", "");
        session.setAttribute("previous_email", "");
        session.setAttribute("previous_password", "");
    }
}
