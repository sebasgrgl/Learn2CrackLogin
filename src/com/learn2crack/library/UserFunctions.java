package com.learn2crack.library;

/**
 * Author :Raj Amal
 * Email  :raj.amalw@learn2crack.com
 * Website:www.learn2crack.com
 **/

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import android.content.Context;


public class UserFunctions {

    private JSONParser jsonParser;
    
  /*//URL of the PHP API WORKING LOCAL ASUS WAMPSERVER
    private static String loginURL = "http://192.168.4.110/learn2crack_login_api/";
    private static String registerURL = "http://192.168.4.110/learn2crack_login_api/";
    private static String forpassURL = "http://192.168.4.110/learn2crack_login_api/";
    private static String chgpassURL = "http://192.168.4.110/learn2crack_login_api/";*/
    
  /*//URL of the PHP API WORKING PERSONAL PC
    private static String loginURL = "http://192.168.0.18:82/learn2crack_login_api/";
    private static String registerURL = "http://192.168.0.18:82/learn2crack_login_api/";
    private static String forpassURL = "http://192.168.0.18:82/learn2crack_login_api/";
    private static String chgpassURL = "http://192.168.0.18:82/learn2crack_login_api/";*/

    
    //URL of the PHP API WORKING!!!!!!
    private static String loginURL = "http://unps.comli.com/learn2crack_login_api/index.php";
    private static String registerURL = "http://unps.comli.com/learn2crack_login_api/index.php";
    private static String forpassURL = "http://unps.comli.com/learn2crack_login_api/index.php";
    private static String chgpassURL = "http://unps.comli.com/learn2crack_login_api/index.php";
    
    /*//URL of the PHP API WORKING!!!!!
    private static String loginURL = "http://api.learn2crack.com/android/loginapi/";
    private static String registerURL = "http://api.learn2crack.com/android/loginapi/";
    private static String forpassURL = "http://api.learn2crack.com/android/loginapi/";
    private static String chgpassURL = "http://api.learn2crack.com/android/loginapi/";*/


    private static String login_tag = "login";
    private static String register_tag = "register";
    private static String forpass_tag = "forpass";
    private static String chgpass_tag = "chgpass";


    // constructor
    public UserFunctions(){
        jsonParser = new JSONParser();
    }

    /**
     * Function to Login
     **/

    public JSONObject loginUser(String email, String password){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", login_tag));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));
        JSONObject json = jsonParser.getJSONFromUrl(loginURL,params);
        return json;
    }

    /**
     * Function to change password
     **/

    public JSONObject chgPass(String newpas, String email){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", chgpass_tag));

        params.add(new BasicNameValuePair("newpas", newpas));
        params.add(new BasicNameValuePair("email", email));
        JSONObject json = jsonParser.getJSONFromUrl(chgpassURL,params);
        return json;
    }





    /**
     * Function to reset the password
     **/

    public JSONObject forPass(String forgotpassword){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", forpass_tag));
        params.add(new BasicNameValuePair("forgotpassword", forgotpassword));
        JSONObject json = jsonParser.getJSONFromUrl(forpassURL,params);
        return json;
    }






     /**
      * Function to  Register
      **/
    public JSONObject registerUser(String fname, String lname, String email, String uname, String password){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", register_tag));
        params.add(new BasicNameValuePair("fname", fname));
        params.add(new BasicNameValuePair("lname", lname));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("uname", uname));
        params.add(new BasicNameValuePair("password", password));
        JSONObject json = jsonParser.getJSONFromUrl(registerURL,params);
        return json;
    }


    /**
     * Function to logout user
     * Resets the temporary data stored in SQLite Database
     * */
    public boolean logoutUser(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        db.resetTables();
        return true;
    }

}

