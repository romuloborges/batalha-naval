/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embarcacoes;

/**
 *
 * @author gabriel
 */
public class Cruzador extends Embarcacao{
    
    public Cruzador(int linhaIni, int colunaIni, int linhaFim, int colunaFim) {
        super(3, linhaIni, colunaIni, linhaFim, colunaFim);
    }

    @Override
    public String toString() {
        return "Cruzador";
    }
    
    
    
}
