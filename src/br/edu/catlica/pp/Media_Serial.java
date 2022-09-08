package br.edu.catlica.pp;

import java.util.ArrayList;
import java.util.List;

public class Media_Serial {
    private String sexo;
    private float Media;

    private List<Dados> info = new ArrayList();

    public Media_Serial(String sexo, List info){
        this.sexo = sexo;
        this.info = info;
    }

    public void calcular_media() {
        float nota = 0;
        int pessoa = 0;
        for (int i = 1; i < info.size(); i++){
            if (info.get(i).sexo.equals(sexo)) {
                pessoa ++;
                nota = nota + info.get(i).media;;
            }
        }
        setMedia(nota/pessoa);
        System.out.println("Media das notas do sexo " + sexo + ": " + getMedia());
    }

    public float getMedia() {
        return Media;
    }

    public void setMedia(float MI) {
        this.Media = MI;
    }
}
