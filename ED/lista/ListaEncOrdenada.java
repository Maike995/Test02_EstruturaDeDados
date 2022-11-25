package br.edu.ifs.ED.lista;

public class ListaEncOrdenada <T extends Comparable<T>> extends ListaEnc<T>{

private boolean tipoOrdenacao;

    public ListaEncOrdenada() {
        this.tipoOrdenacao = true;
        this.referenciaEntrada = null;
    }

    @Override
    public void incluir(T elemento) throws Exception {
        No<T> novoNo = new No(elemento);

        if(isEmpty()){
            referenciaEntrada = novoNo;
            return;
        }
        No<T> auxiliar = referenciaEntrada;
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

    public int getPosElemento(T elemento) throws Exception {
        int posicao = 0;
        No<T> auxiliar = referenciaEntrada;
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
    public void incluirInicio(T elemento) throws Exception {

        if(isEmpty() || elemento.compareTo(referenciaEntrada.getConteudo())<=0){
            No<T> novoNo = new No(elemento);
            novoNo.setProximoNo(referenciaEntrada);
            referenciaEntrada = novoNo;
        }else{
            throw new Exception("O elemento é maior que o elemento inicial");
        }
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {

        if(posicao<0 || posicao >getTamanho())throw new Exception("Posição solicitada não existe na lista");

        No<T> novoNo = new No<>(elemento);

        if(posicao==0) {
            incluirInicio(elemento);
            return;
        }else if(posicao==getTamanho()){
            if(novoNo.getConteudo().compareTo(getNo(getTamanho()-1).getConteudo)>=0) {
                No<T> auxilar = getNo(getTamanho() - 1);
                auxilar.setProximoNo(novoNo);
                return;
            }else{
                throw new Exception("O elemento é menor que o ultimo");
            }
        }
        No<T> noAnterior = getNo(posicao - 1);
        if(novoNo.getConteudo().compareTo(noAnterior.getConteudo())<0){
            novoNo.setProximoNo(getNo(posicao));
            noAnterior.setProximoNo(novoNo);
            return;
        }
        throw new Exception("O elemento é maior que o anterior");
    }


    @Override
    public boolean contem(T elemento) throws Exception {
        No<T> auxiliar = referenciaEntrada;
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

    public void setTipoOrdenacao(boolean crescente) throws Exception {
        if (crescente == tipoOrdenacao) {
            return;
        }
        if(getTamanho()<1){
            return;
        }

        tipoOrdenacao = crescente;

        No<T> atual = referenciaEntrada;
        No<T> anterior = null;

        while (atual != null) {
            No<T> auxilar = atual.getProximoNo();
            atual.setProximoNo(anterior);
            anterior = atual;
            atual = auxilar;
        }
        referenciaEntrada = anterior;
    }

  
    public void incluirOrdenado(T elemento) throws Exception {
        No<T> novoNo = new No(elemento);

        if(isEmpty()){
            referenciaEntrada = novoNo;
            return;
        }
        No<T> auxiliar = referenciaEntrada;
        int posicao = 0;
        while(auxiliar!= null){
            if(auxiliar.getConteudo().compareTo(elemento) > 0){
                T temporario =  auxiliar.getConteudo();
                auxiliar.setConteudo() = elemento;
                elemento = temporario;
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
}
