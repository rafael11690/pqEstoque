/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pqestoque;

import java.util.Locale;
import javax.swing.UIManager;
import visao.JFramePrincipal;

/**
 *
 * @author Rafael
 */
public class PqEstoque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new com.jtattoo.plaf.acryl.AcrylLookAndFeel());
            // UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());

        } catch (Exception exception) {
        }
        Locale l = new Locale("pt", "br");
        Locale.setDefault(l);
        JFramePrincipal principal = new JFramePrincipal();
        principal.setVisible(true);
    }
}
