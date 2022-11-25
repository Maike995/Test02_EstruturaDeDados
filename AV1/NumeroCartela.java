package br.edu.ifs.AV1;

public class NumeroCartela implements Comparable<NumeroCartela> {
    public int getNumero() {
        return valor;
    }
    int valor;
    private boolean sorteado = false;

    public boolean isSorteado() {
        return sorteado;
    }

    public void setSorteado(boolean sorteado) {
        this.sorteado = sorteado;
    }
    public NumeroCartela(int numero){
        this.valor = numero;
    }
    @Override
    public String toString(){
        return "[" +this.getNumero() + (this.isSorteado()? "*":"") +"]";
    }

    @Override
    public int compareTo(NumeroCartela numeroCartela) {
        return ((Integer)numeroCartela.getNumero()).compareTo(this.getNumero());
    }
}
