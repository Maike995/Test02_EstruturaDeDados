package br.edu.ifs.ED.lista;

public class ListaEnc<T extends Comparable<T>> extends Lista<T> {
    protected No<T> referenciaEntrada;

    public ListaEnc() {
        this.referenciaEntrada = null;
    }


    @Override
    public void incluir(T elemento) throws Exception {
        No<T> novoNo = new No(elemento);
        if (this.isEmpty()) {
            referenciaEntrada = novoNo;
            return;
        }
        No<T> noAuxiliar = referenciaEntrada;
        for (int i = 0; i < getTamanho() - 1; i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        noAuxiliar.setProximoNo(novoNo);
    }


    public T get(int posicao) throws Exception {
        if(posicao<0 || posicao>=getTamanho()) throw new Exception("Posição solicitada não existe na lista");
        return getNo(posicao).getConteudo();
    }

    protected No<T> getNo(int posicao) {
        validaIndice(posicao);
        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;
        for (int i = 0; i <= posicao; i++) {
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noRetorno;
    }

    public int getPosElemento(T elemento) throws Exception {
       int posicao = 0;
       No<T> auxiliar = referenciaEntrada;
       while (auxiliar!= null){
           if(auxiliar.getConteudo()==elemento){
               return posicao;
           }else{
               auxiliar = auxiliar.getProximoNo();
               posicao++;
           }
       }
       throw new Exception("O elemento não está na lista");

    }

    @Override
    public void incluirInicio(T elemento) throws Exception {

        No<T> novoNo = new No(elemento);
        novoNo.setProximoNo(referenciaEntrada);
        referenciaEntrada = novoNo;
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {

        if(posicao<0 || posicao >getTamanho())throw new Exception("Posição solicitada não existe na lista");

        No<T> novoNo = new No<>(elemento);

        if(posicao==0) {
            novoNo.setProximoNo(referenciaEntrada);
            referenciaEntrada = novoNo;
            return;
        }else if(posicao==getTamanho()){
            No<T> auxilar = getNo(getTamanho()-1);
            auxilar.setProximoNo(novoNo);
            return;
        }
        No<T> noAnterior = getNo(posicao - 1);
        novoNo.setProximoNo(getNo(posicao));
        noAnterior.setProximoNo(novoNo);

    }

    @Override
    public void remover(int posicao) throws Exception {
        validaIndice(posicao);
        No<T> noPivor = getNo(posicao);
        if(posicao == 0){
            referenciaEntrada = noPivor.getProximoNo();
            return;
        }
        No<T> noAnterior = getNo(posicao - 1);
        noAnterior.setProximoNo(noPivor.getProximoNo());
        return;
    }

    @Override
    public int getTamanho() {
        int tamanhoLista = 0;
        No<T> referenciaAux = referenciaEntrada;
        while (true) {
            if (referenciaAux != null) {
                tamanhoLista++;
                if (referenciaAux.getProximoNo() != null) {
                    referenciaAux = referenciaAux.getProximoNo();
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return tamanhoLista;
    }

    @Override
    public void limpar() {
        this.referenciaEntrada = null;
    }

    @Override
    public boolean contem(T elemento) throws Exception {
        No<T> auxiliar = referenciaEntrada;
        while (auxiliar!= null){
            if(auxiliar.getConteudo() == elemento){
                return true;
            }else{
                auxiliar = auxiliar.getProximoNo();
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return referenciaEntrada == null ? true : false;
    }

    protected void validaIndice(int posicao) {
        if (posicao >= getTamanho()) {
            int ultimoaPosicao = getTamanho() - 1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice "
                    + posicao + " desta lista. Esta lista só vai até o índice "
                    + ultimoaPosicao + '.');
        }
    }

    
  
}
