package br.edu.catlica.pp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ler_dados_Th extends Thread{

    private static Scanner input;
    private int MIF;
    private int MIM;
    private float porcetagemMediaMasculina;
    private float porcetagemMediaFeminina;

    private final List<Dados> info = new ArrayList();

    public Ler_dados_Th(String doc){
        String linha;

        try {
            BufferedReader conteudoCSV = new BufferedReader(new FileReader(doc));
            input = new Scanner(conteudoCSV.readLine());
            input.nextLine();
            while ((linha = conteudoCSV.readLine()) != null) {
                String[] dados = linha.split(",");
                int idade = Integer.parseInt(dados[0]);
                String sexo = dados[1];
                float media = Float.parseFloat(dados[2]);
                info.add(new Dados(idade, sexo, media));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    @Override
    public void run() {
        try {



        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    public void infoHomens(){
        int idadeMasculina = 0;
        float quatMedia500 = 0;
        int homens = 0;
        for (int i = 1; i < info.size(); i++){
            if (info.get(i).sexo.equals("M")) {
                idadeMasculina = idadeMasculina + info.get(i).idade;
                homens ++;
                float valorMedia = info.get(i).media;
                if(valorMedia > 500){
                    quatMedia500 ++;
                }
            }
        }
        setMIM(idadeMasculina/homens);
        setPorcetagemMediaMasculina((quatMedia500 * 100)/homens);
    }

    public void infoMulheres(){
        int idadeFeminina = 0;
        float quatMedia500 = 0;
        int mulheres = 0;
        for (int i = 1; i < info.size(); i++){
            if (info.get(i).sexo.equals("F")) {
                idadeFeminina = idadeFeminina + info.get(i).idade;
                mulheres ++;
                float valorMedia = info.get(i).media;
                if(valorMedia > 500){
                    quatMedia500 ++;
                }
            }
        }
        setMIF(idadeFeminina/mulheres);
        setPorcetagemMediaFeminina((quatMedia500 * 100)/mulheres);
    }

    public void status(){
        System.out.println("Media da idade feminina: " + MIF);
        System.out.println("media da idade masculina: " + MIM);

    }

    public int getMIF() {
        return MIF;
    }

    public void setMIF(int MIF) {

        this.MIF = MIF;
    }

    public int getMIM() {

        return MIM;
    }

    public void setMIM(int MIM) {

        this.MIM = MIM;
    }

    public float getPorcetagemMediaMasculina() {

        return porcetagemMediaMasculina;
    }

    public void setPorcetagemMediaMasculina(float porcetagemMediaMasculina) {
        this.porcetagemMediaMasculina = porcetagemMediaMasculina;
    }

    public float getPorcetagemMediaFeminina() {
        return porcetagemMediaFeminina;
    }

    public void setPorcetagemMediaFeminina(float porcetagemMediaFeminina) {
        this.porcetagemMediaFeminina = porcetagemMediaFeminina;
    }
}
