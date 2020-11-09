/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.security.SecureRandom;
import java.util.Base64;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author marlo0212
 */
@Named
@RequestScoped
public class GenerateLinkUndPasswort {
    
    /**
     * geklaut bei https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string
     * @return -- nehme ich fuer aktivierungslink und die ersten 8 zeichen als temp passwort zur aktivierung des kontos
     **/
  public static String generateRandomBase64Token(String session) {
    int l=session.length();
    SecureRandom secureRandom = new SecureRandom();
    byte[] token = new byte[l];
    secureRandom.nextBytes(token);
    return Base64.getUrlEncoder().withoutPadding().encodeToString(token); //base64 encoding
}  
}
