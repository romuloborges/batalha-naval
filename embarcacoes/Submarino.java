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
public class Submarino extends Embarcacao{
    
    public Submarino(int linhaIni, int colunaIni, int linhaFim, int colunaFim) {
        super(2, linhaIni, colunaIni, linhaFim, colunaFim);
    }

    @Override
    public String toString() {
        return "Submarino";
    }
    
    
    
}
