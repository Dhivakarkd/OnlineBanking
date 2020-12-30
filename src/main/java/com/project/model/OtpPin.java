package com.project.model;

import java.util.Random;

public class OtpPin {
	public static String OTP() 
    { 
        Random random = new Random();  
        
        int value;
        while(true) { 
            
            value = random.nextInt();
            if (value >999 && value < 10000)
            	break;
        }
       
        return ""+value; 
    } 

}
