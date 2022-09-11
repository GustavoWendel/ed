package br.com.caelum.ed.entidades;


public class Vetor {
    private final Aluno[] alunos = new Aluno[100];
    private int totalDeAlunos = 0;

    public void adiciona(Aluno aluno) {
        this.alunos[this.totalDeAlunos] = aluno;
        this.totalDeAlunos++;
    }

    public void adiciona(int posicao, Aluno aluno) {
        if (!this.posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }

        for (int i = this.totalDeAlunos - 1; i >= posicao; i--) {
            this.alunos[i + 1] = this.alunos[i];
        }

        this.alunos[posicao] = aluno;
        totalDeAlunos++;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= this.totalDeAlunos;
    }

    public Aluno pega(int posicao) {
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return this.alunos[posicao];
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao > 0 && posicao < this.totalDeAlunos;
    }

    public void remove(int posicao) {
    }

    public boolean contem(Aluno aluno) {
        for (int i = 0; i < this.totalDeAlunos; i++) {
            if (aluno.equals(this.alunos[i])) {
                return true;
            }
        }
        return false;
    }

    public int tamanho() {
        return this.totalDeAlunos;
    }

    public String toString() {
        if (this.totalDeAlunos == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < this.totalDeAlunos - 1; i++) {
            builder.append(this.alunos[i]);
            builder.append(", ");
        }
        builder.append(this.alunos[this.totalDeAlunos - 1]);
        builder.append("]");
        return builder.toString();
    }

}
