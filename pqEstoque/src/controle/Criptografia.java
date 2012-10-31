/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class Criptografia {

    public Criptografia() {
    }

    public String criptografaSenhaMD5(String senha) {
        MessageDigest md;
        String s = "";
        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
            s = hash.toString(16);
            if (s.length() % 2 != 0) {
                s = "0" + s;
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}
