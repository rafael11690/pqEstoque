/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author Rafael
 */
public class ValidadorCampos {

    public boolean checarReal(String valor) {
        if (valor.matches("^\\d*[0-9](\\.\\d*[0-9])?$")) {
            return true;
        }
        return false;
    }

    public boolean checarReal2(String valor) {
        if (valor.matches("^\\d*[0-9](\\.(\\d*[0-9])?)?$")) {
            return true;
        }
        return false;
    }

    public boolean checarInteiro(String valor) {
        if (valor.matches("^\\d*[0-9]")) {
            return true;
        }
        return false;
    }

    public boolean checarHora(String valor) {
        if (valor.matches("^([0-2]?[0-9]|[2][0-3]):[0-5][0-9]$")) {
            return true;
        }
        return false;
    }

    public boolean checarData(String valor) {
        if (valor.matches("^([0-2][0-9]|3[0-1])/(1[0-2]|0[1-9])/([0-9]{4,4})")) {
            return true;
        }
        return false;
    }
}
