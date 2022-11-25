package br.edu.ifs.ED.lista;

public class ListaEncOrdenadaInteiro extends ListaEncOrdenada<Integer>{
    
    protected No<Integer> referenciaEntrada;

    public ListaEncOrdenadaInteiro() {
        this.referenciaEntrada = null;
    }

    @Override
    public void incluir(Integer elemento) throws Exception {
        No<Integer> novoNo = new No(elemento);

        if(isEmpty()){
            referenciaEntrada = novoNo;
            return;
        }
        No<Integer> auxiliar = referenciaEntrada;
        int posicao = 0;
        while(auxiliar!= null){
            if(auxiliar.getConteudo().compareTo(elemento) > 0){
                break;
            }else{
                auxiliar = auxiliar.getProximoNo();
                posicao++;
            }
        }

       if(posicao==0){
           novoNo.setProximoNo(referenciaEntrada);
           referenciaEntrada = novoNo;
       }else{
           No<T> anterior = getNo(posicao-1);
           novoNo.setProximoNo(auxiliar);
           anterior.setProximoNo(novoNo);
       }

    }
  
    @Override
    public int getPosElemento(Integer elemento) throws Exception {
        int posicao = 0;
        No<Integer> auxiliar = referenciaEntrada;
        while (auxiliar!= null){
            if(auxiliar.getConteudo()==elemento){
                return posicao;
            }else if(auxiliar.getConteudo().compareTo(elemento) > 0){
                throw new Exception("O elemento não está na lista");
            }
            else{
                auxiliar = auxiliar.getProximoNo();
                posicao++;
            }
        }
        throw new Exception("O elemento não está na lista");

    }

    @Override
    public void incluirInicio(Integer elemento) throws Exception {

        if(isEmpty() || elemento.compareTo(referenciaEntrada.getConteudo())<=0){
            No<T> novoNo = new No(elemento);
            novoNo.setProximoNo(referenciaEntrada);
            referenciaEntrada = novoNo;
        }else{
            throw new Exception("O elemento é maior que o elemento inicial");
        }
    }

    @Override
    public void incluir(Integer elemento, int posicao) throws Exception {

        if(posicao<0 || posicao >getTamanho())throw new Exception("Posição solicitada não existe na lista");

        No<Integer> novoNo = new No<>(elemento);

        if(posicao==0) {
            incluirInicio(elemento);
            return;
        }else if(posicao==getTamanho()){
            if(novoNo.getConteudo().compareTo(getNo(getTamanho()-1).getConteudo)>=0) {
                No<Integer> auxilar = getNo(getTamanho() - 1);
                auxilar.setProximoNo(novoNo);
                return;
            }else{
                throw new Exception("O elemento é menor que o ultimo");
            }
        }
        No<Integer> noAnterior = getNo(posicao - 1);
        if(novoNo.getConteudo().compareTo(noAnterior.getConteudo())<0){
            novoNo.setProximoNo(getNo(posicao));
            noAnterior.setProximoNo(novoNo);
            return;
        }
        throw new Exception("O elemento é maior que o anterior");
    }

    @Override
    public boolean contem(Integer elemento) throws Exception {
        No<Integer> auxiliar = referenciaEntrada;
        while (auxiliar!= null){
            if(auxiliar.getConteudo() == elemento){
                return true;
            }else if(auxiliar.getConteudo().compareTo(elemento) > 0) {
                return false;
            }else{
                    auxiliar = auxiliar.getProximoNo();
            }
        }
        return false;
    }

    @Override
    public void setTipoOrdenacao(boolean crescente) throws Exception {
        if (crescente == tipoOrdenacao) {
            return;
        }
        if(getTamanho()<1){
            return;
        }

        tipoOrdenacao = crescente;

        No<Integer> atual = referenciaEntrada;
        No<Integer> anterior = null;

        while (atual != null) {
            No<Integer> auxilar = atual.getProximoNo();
            atual.setProximoNo(anterior);
            anterior = atual;
            atual = auxilar;
        }
        referenciaEntrada = anterior;
    }

    @Override
    public Integer get(int posicao) throws Exception {
        if(posicao<0 || posicao>=getTamanho()) throw new Exception("Posição solicitada não existe na lista");
        return getNo(posicao).getConteudo();
    }
  
    @Override
    protected No<Integer> getNo(int posicao) {
        validaIndice(posicao);
        No<Integer> noAuxiliar = referenciaEntrada;
        No<Integer> noRetorno = null;
        for (int i = 0; i <= posicao; i++) {
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noRetorno;
    }
  
    @Override
    public void remover(int posicao) throws Exception {
        validaIndice(posicao);
        No<Integer> noPivor = getNo(posicao);
        if(posicao == 0){
            referenciaEntrada = noPivor.getProximoNo();
            return;
        }
        No<Integer> noAnterior = getNo(posicao - 1);
        noAnterior.setProximoNo(noPivor.getProximoNo());
        return;
    }
  
    @Override
    public int getTamanho() {
        int tamanhoLista = 0;
        No<Integer> referenciaAux = referenciaEntrada;
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

  
}
