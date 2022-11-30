package br.edu.ifs.AV1;

import br.edu.ifs.ED.lista.Lista;
import br.edu.ifs.ED.lista.ListaEnc;
import br.edu.ifs.ED.lista.ListaEncOrdenada;
import br.edu.ifs.ED.lista.ListaSequencial;

import java.util.Date;
import java.util.List;
import java.util.Random;


public class Cartela implements ICartelaJogo{

    protected Lista<Lista<NumeroCartela>> dados;
    protected Integer identificador = 0;
    protected Date dataGeracao;

// n faço ideia do pq desse idetificador
  protected static int identi = 0;


    
    Random gerador = new Random();
  
    public Cartela( int tamanhoMatriz, int identificador ) throws Exception {
        this(tamanhoMatriz, tamanhoMatriz, identificador);
    }
   /**
     * Cria a cartela com os números conforme a matriz N x M.
     * Um número identificador (geralmente um sequencial) deverá ser informado.
     
     */

    public Cartela( int N, int M, int identificador ) throws Exception {


        aux = n*m;
        
        ListaEncOrdenada<NumeroCartela> linha = new ListaEncOrdenada<>();
        for (int i = 0; i < aux; i++) {
          linha.incluirOrdenado(criaNumero());
        }
        this.dados.get(getTamanho()).incluir(linha);
        }



      
    }

    public int[] criaNumero(){
      int[] numGerado = new int[60];
      for(int i = 0, i<60 , i++){
        numGerado[i] = gerador.nextInt(60+1);
      }
      int numeroUnico = numGerado[gerador.nextInt(60)]
      return numeroUnico;
    }
    
    public int[][] getDados() throws Exception {
        int N = this.dados.getTamanho();
        int M = this.dados.get(0).getTamanho();
        int[][] valores = new int[N][M];
        for (int i = 0; i < N; i++) {
            Lista<NumeroCartela> linha = dados.get(i);
            for (int j = 0; j < M; j++) {
                valores[i][j] = linha.get(j).getNumero();
            }
        }
        return valores;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public Date getDataGeracao() {
        return dataGeracao;
    }

    @Override
    public void marcarNumeroSorteado(int numero) throws Exception {
      dados.setTipoOrdenacao(true);
      int N = this.dados.getTamanho();
      int M = this.dados.get(0).getTamanho();
      for (int i = 0; i < N; i++) {
        Lista<NumeroCartela> linha = dados.get(i);
        for (int j = 0; j < M; j++) {
          if(numero = linha.get(j).getNumero()){
              dados.get(j).setSorteado(true);
              return ;
          }
        }
      }
      throw new Exception("O numero não está na cartela");
    }

    @Override
    public boolean ehCartelaVencedora(boolean verificarPorLinha) throws Exception {
      
      if(verificarPorLinha = true){
        int contadorLinha = 0;
        int verifica = 0;
        int N = this.dados.getTamanho();
        int M = this.dados.get(0).getTamanho();
        for (int i = 0; i < N; i++) {
          Lista<NumeroCartela> linha = dados.get(i);
          for (int j = 0; j < M; j++) {
            if(true = linha.get(j).isSorteado()){
              verifica++;
            }
          }if(verifica = M){
            contadorLinha++;
          }
        }if(contadorLinha = N){
          return true;
        }else{
          return false;
        } 
      }else{
        int contadorGeral = 0;
        int N = this.dados.getTamanho();
        int M = this.dados.get(0).getTamanho();
        for (int i = 0; i < N; i++) {
          Lista<NumeroCartela> linha = dados.get(i);
          for (int j = 0; j < M; j++) {
            if(true = linha.get(j).isSorteado()){
              contadorGeral++;
            }
          }
        }
        if(contador == dados.getTamanho()){
          return true;
        }
        return false;
      }
    }


    /**
     * Retorna uma lista encadeada ordenada com os números da cartela.
     * Poderão existir números duplicados
     * @return
     */
    @Override
    public ListaEncOrdenada<Integer> getNumerosNaoSorteados() {
      
      ListaEncOrdenada<Integer> cartelaOrdenada;
      int N = this.dados.getTamanho();
      int M = this.dados.get(0).getTamanho();
      for (int i = 0; i < N; i++) {
        Lista<NumeroCartela> linha = dados.get(i);
        for (int j = 0; j < M; j++) {
          cartelaOrdenada.incluirOrdenado(linha.get(j).getNumero());
        }
      }
        return cartelaOrdenada;
    }

    /**
     * Deverá observar se os números das duas cartelas são iguais por linha.
     * @param iCartelaJogo
     * @return
     */
    @Override
    public int compareTo(ICartelaJogo iCartelaJogo) {
        return 0;
    }

    private static int idsGeados = 0;

    boolean estahEmUso= false;
    @Override
    public void setEstahEmUso(boolean estahEmUso) {
        this.estahEmUso = estahEmUso;
    }

    @Override
    public boolean estahEmUso() {
        return estahEmUso;
    }

    public static ICartelaJogo gerarCartelaJogo(int N, int M) throws Exception {
        return new Cartela(N, M, ++idsGeados);
    }


}
