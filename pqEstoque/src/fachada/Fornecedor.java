/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

/**
 *
 * @author Rafael
 */
public class Fornecedor {

    private int idFornecedor;
    private String empresa, endereco, cnpj, ie, email, telefone1, telefone2, vendedor;

    public Fornecedor() {
    }

    public Fornecedor(String empresa, String endereco, String cnpj, String ie, String email, String telefone1, String telefone2, String vendedor) {
        this.empresa = empresa;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.ie = ie;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.vendedor = vendedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getTelefoneValido() {
        if (telefone1 != null && !telefone1.equals("")) {
            return telefone1;
        } else if (telefone2 != null && !telefone2.equals("")) {
            return telefone2;
        } else {
            return "";
        }
    }
}
