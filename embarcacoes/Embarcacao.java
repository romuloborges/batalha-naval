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
public abstract class Embarcacao {
    
    private int tamanho;
    private int pecasValidas;   //Quantidade de peças ainda não atingidas
    private int posicaoInicio[];
    private int posicaoFim[];

    public Embarcacao(int tamanho, int linhaIni, int colunaIni, int linhaFim, int colunaFim) {
        this.tamanho = tamanho;
        this.pecasValidas = tamanho;
        this.posicaoInicio = new int[2];
        this.posicaoFim = new int[2];
        if(linhaIni != linhaFim && Math.abs(linhaIni-linhaFim) != (tamanho-1)){
            throw new RuntimeException("Posições inválidas");
        }else if(linhaIni == linhaFim && Math.abs(colunaIni-colunaFim) != (tamanho-1)){
            throw new RuntimeException("Posições inválidas");
        }
            //Verificando o que realmente é a posição inicial ou final, vendo da esquerda->direita e cima->baixo
        this.posicaoInicio[0] = (linhaIni < linhaFim) ? linhaIni : linhaFim;
        this.posicaoInicio[1] = (colunaIni < colunaFim) ? colunaIni : colunaFim;
        this.posicaoFim[0] = (linhaIni > linhaFim) ? linhaIni : linhaFim;
        this.posicaoFim[1] = (colunaIni > colunaFim) ? colunaIni : colunaFim;
        
    }
    
    public boolean ataque(int linha, int coluna){
        for(int i=this.getPosicaoInicio()[0]; i<=this.getPosicaoFim()[0]; i++){
            for(int j=this.getPosicaoInicio()[1]; j<=this.getPosicaoFim()[1]; j++){
                if(i==linha && j==coluna){
                    pecasValidas--;
                    return true;
                }
            }
        }

        return false;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int[] getPosicaoInicio() {
        return posicaoInicio;
    }

    public int[] getPosicaoFim() {
        return posicaoFim;
    }

    public int getPecasValidas() {
        return pecasValidas;
    }
    
}
