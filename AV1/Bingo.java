package br.edu.ifs.AV1;

import br.edu.ifs.ED.lista.Lista;

import java.util.Random;

public class Bingo {
    final private Lista<Cartela> cartelas;

    /**
     * Cria a classe gerenciadora do bingo, com as cartelas.
     * @param qtd
     * @param qtdLinhas
     * @param qtdColunas
     * @throws Exception
     */
    public Bingo(int qtd, int qtdLinhas, int qtdColunas) throws Exception {
        throw new Exception("Método não implementado");
    }

    public Lista<Cartela> getCartelas(SituacaoCartela situacaoCartela) throws Exception {
        throw new Exception("Método não implementado");

    }
    public Lista<Cartela> getCartelasVencedoras(boolean verificarPorLinha) throws Exception {
        throw new Exception("Método não implementado");
    }

    /**
     * Realiza o sorteio de um número e marca na cartela o número sorteado;
     * @return
     */
    public int SortearNumero() throws Exception {
        throw new Exception("Método não implementado");
    }

    /**
     * Limpa o número sorteado da cartela em questão
     * @param cartela
     * @throws Exception
     */
    public void LimparNumerosSorteados(Cartela cartela) throws Exception {
        throw new Exception("Método não implementado");
    }

    /**
     * Limpa todos os números marcados em todas as cartelas para permitir realizar o bingo com um novo
     * prêmio;
     * @throws Exception
     */
    public void LimparNumerosSorteados() throws Exception {
        throw new Exception("Método não implementado");
    }
    public void RemoverCartelaDoBingo(Cartela cartela) throws Exception {
        throw new Exception("Método não implementado");
    }
    public int obterQuantidadeDeCartelas(SituacaoCartela situacaoCartela) throws Exception {
        throw new Exception("Método não implementado");
    }
}
