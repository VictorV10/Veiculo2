/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author VictorMattos
 */
public class Marca {
   private int CodC;
   private String descricao;
   

    public Marca(int CodC, String descricao) {
        this.CodC = CodC;
        this.descricao = descricao;
    }

    public Marca(String descricao) {
        this.descricao = descricao;
    }

    public Marca() {
    }

    public int getCodigo() {
        return CodC;
    }

    public void setCodigo(int codigo) {
        this.CodC = CodC;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
   
   
   
}
