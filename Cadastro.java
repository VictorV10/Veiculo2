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
public class Cadastro {
    
    private int CodCadastro;
    private String Placa;
    private long Renavan;
    private Marca modelo;

    public Cadastro(int CodCadastro, String Placa, long Renavan, Marca modelo) {
        this.CodCadastro = CodCadastro;
        this.Placa = Placa;
        this.Renavan = Renavan;
        this.modelo = modelo;
    }

    public Cadastro(String placa, long Renavan, Marca marca) {
        
    }

    public Cadastro() {
    }

    @Override
    public String toString() {
        return "Cadastro{" + "CodCadastro=" + CodCadastro + ", Placa=" + Placa + ", Renavan=" + Renavan + ", modelo=" + modelo + '}';
    }
    
    public int getCodCadastro() {
        return CodCadastro;
    }

    public void setCodCadastro(int CodCadastro) {
        this.CodCadastro = CodCadastro;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public double getRenavan() {
        return Renavan;
    }

    public void setRenan(long Renavan) {
        this.Renavan = Renavan;
    }

    public Marca getModelo() {
        return modelo;
    }

    public void setModelo(Marca modelo) {
        this.modelo = modelo;
    }
    
    
    
}
