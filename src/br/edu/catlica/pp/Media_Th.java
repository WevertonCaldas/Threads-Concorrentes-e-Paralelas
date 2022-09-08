package br.edu.catlica.pp;

import java.util.ArrayList;
import java.util.List;

public class Media_Th extends Thread{

    private String sexo;

    private float Media;

    private static int calculadas;

    private static float mediaGeral;

    private List<Dados> info = new ArrayList();

    public Media_Th(String sexo, List info){
        this.sexo = sexo;
        this.info = info;
    }

    @Override
    public void run() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        synchronized (Media_Th.class) {
            Media_Th.mediaGeral += Media;
            System.out.println("A Thread " + Thread.currentThread().getId() + " somou a media do sexo " + sexo + ": " + Media);
            calculadas ++;
            if(calculadas == 2){
                Media_Th.mediaGeral = mediaGeral/2;
                System.out.println("Media geral:" + mediaGeral);
            }
        }
    }

    public float getMedia() {
        return Media;
    }

    public void setMedia(float MI) {
        this.Media = MI;
    }
}
