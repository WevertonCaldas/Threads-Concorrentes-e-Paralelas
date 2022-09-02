package br.edu.catlica.pp;

public class Dados {
    int idade;
    String sexo;
    float media;

    public Dados(int idade, String sexo, float media) {
        this.idade = idade;
        this.sexo = sexo;
        this.media = media;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return idade +
                ", '" + sexo + '\'' +
                ", " + media;
    }

}
