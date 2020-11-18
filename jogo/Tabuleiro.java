/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import embarcacoes.Embarcacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class Tabuleiro {
    
        //Por se tratar de uma matriz quadrada, uma única variável é suficiente
    private int tamanho;
    private int matriz[][];
    private List<Embarcacao> embarcacoes;

    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;
        embarcacoes = new ArrayList<>();
        matriz = new int[tamanho][tamanho];
    }
    
    //TODO: Regras do máximo por cada tipo de embarcação
    public boolean adicionarEmbarcacao(Embarcacao e){
        boolean valido = true;
        
            //Posição da matriz: 0 se vazio, 1 se preenchida
        for(int i=e.getPosicaoInicio()[0]; i<=e.getPosicaoFim()[0]; i++){
            for(int j=e.getPosicaoInicio()[1]; j<=e.getPosicaoFim()[1]; j++){
                if(matriz[i][j] != 0){
                    valido = false;
                    break;
                }
            }
        }
        
        if(valido){
            for(int i=e.getPosicaoInicio()[0]; i<=e.getPosicaoFim()[0]; i++){
                for(int j=e.getPosicaoInicio()[1]; j<=e.getPosicaoFim()[1]; j++){
                    matriz[i][j] = 1;
                }
            } 
            embarcacoes.add(e);
        }
        
        
        return valido;
    }
    
    public String getTabuleiro(){
        String saida = "";
        for(int i=0; i<tamanho; i++){
            for(int j=0; j<tamanho; j++){
                saida+= matriz[i][j] + " ";
            }
            saida+="\n";
        }
        
        return saida;
    }
    
}
