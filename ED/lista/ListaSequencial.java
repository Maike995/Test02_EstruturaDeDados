package br.edu.ifs.ED.lista;

import java.lang.reflect.InvocationTargetException;

public class ListaSequencial<T extends Comparable<T>> extends Lista<T>{


    T[] lista;
    int qtdMax;
    int finalLista;
  
    public ListaSequencial(Class<T> dataType){
        super();
        qtdMax = 10;
        this.lista = (T[]) java.lang.reflect.Array.newInstance(dataType, qtdMax);
        finalLista = -1;
    }

    @Override
    public void limpar() {
        finalLista = -1;
    }
  
    @Override
    public T get(int posicao) throws Exception {
        if(posicao < 0 || posicao >= getTamanho()){
            throw new Exception("Posicao invalida");
        }
        return lista[posicao];
    }

    @Override
    public int getPosElemento(T elemento) throws Exception {
      for(int i = 0; i<=getTamanho();i++){
         if(elemento==lista[i]){
            return i;
         }
      }
    }

    @Override
    public void incluir(T elemento) throws Exception {
      if(getTamanho<0){
        lista[0] = elemento;;
      }
      if(getTamanho>=0){
        lista[getTamanho()+1] = elemento; 
      }
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
      if(getTamanho()<0){
        lista[0] = elemento;;
      }
      int aux = 0;
      if(getTamanho()>=0){
        for(int i = 0; i<=getTamanho();i++){
          aux = lista[i];
          lista[i] = elemento;
          elemento = aux;
        }
      }
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
      if(posicao < 0 || posicao >= getTamanho()){
            throw new Exception("Posicao invalida");
        }
      if(getTamanho()<0){
        lista[0] = elemento;;
      }
      int aux = 0;
      if(getTamanho()>=0){
        for(int i = posicao; i<=getTamanho();i++){
          aux = lista[i];
          lista[i] = elemento;
          elemento = aux;
        }
      }
    }

    @Override
    public void remover(int posicao) throws Exception {
      if(posicao < 0 || posicao >= getTamanho()){
            throw new Exception("Posicao invalida");
      }
      if(getTamanho() == 0){
        limpar();
      }
      if(getTamanho()>=0){
        for(int i = posicao; i<=getTamanho();i++){
          lista[i] = lista[i+1];
          lista[i+1] = 0;
        }
      }
    }
  
    @Override
    public int getTamanho() {
        return finalLista;
    }

    @Override
    public boolean contem(T elemento) throws Exception {
      for(int i = 0; i<=getTamanho();i++){
         if(elemento==lista[i]){
            return true;
         }
      }
      return false;
    }
}
