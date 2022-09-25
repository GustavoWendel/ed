package br.com.caelum.ed.entidades;


public class Vetor {
    private Object[] objetos = new Aluno[100];
    private int totalDeAlunos = 0;

    public void adiciona(Aluno aluno) {
        this.garantaEspaco();
        this.objetos[this.totalDeAlunos] = aluno;
        this.totalDeAlunos++;
    }

    public void adiciona(int posicao, Aluno aluno) {
        this.garantaEspaco();
        if (!this.posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }

        for (int i = this.totalDeAlunos - 1; i >= posicao; i--) {
            this.objetos[i + 1] = this.objetos[i];
        }

        this.objetos[posicao] = aluno;
        totalDeAlunos++;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= this.totalDeAlunos;
    }

    public Object pega(int posicao) {
        if (posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return this.objetos[posicao];
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao <= 0 || posicao >= this.totalDeAlunos;
    }

    public void remove(int posicao) {
        if (this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = posicao; i < this.totalDeAlunos - 1; i++) {
            this.objetos[i] = this.objetos[i + 1];
        }
    }

    public boolean contem(Aluno aluno) {
        for (int i = 0; i < this.totalDeAlunos; i++) {
            if (aluno.equals(this.objetos[i])) {
                return true;
            }
        }
        return false;
    }

    public int tamanho() {
        return this.totalDeAlunos;
    }

    private void garantaEspaco() {
        if (this.totalDeAlunos == this.objetos.length) {
           Object[] novaArray = new Aluno[this.objetos.length * 2];
           for (int i = 0; i < this.objetos.length; i++) {
               novaArray[i] = this.objetos[i];
           }
           this.objetos = novaArray;
        }
    }

    public String toString() {
        if (this.totalDeAlunos == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < this.totalDeAlunos - 1; i++) {
            builder.append(this.objetos[i]);
            builder.append(", ");
        }
        builder.append(this.objetos[this.totalDeAlunos - 1]);
        builder.append("]");
        return builder.toString();
    }

}
