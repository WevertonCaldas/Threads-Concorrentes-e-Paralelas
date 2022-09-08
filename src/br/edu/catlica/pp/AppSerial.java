package br.edu.catlica.pp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppSerial {
    public static void main(String[] args) {

        long tempoInicial = System.currentTimeMillis();

        String linha;

        try {
            BufferedReader conteudoCSV = new BufferedReader(new FileReader("C:\\Users\\55839\\Desktop\\dadosINEP_enade.csv"));
            Scanner input = new Scanner(conteudoCSV.readLine());
            input.nextLine();
            List<Dados> info = new ArrayList();
            while ((linha = conteudoCSV.readLine()) != null) {
                String[] dados = linha.split(",");
                int idade = Integer.parseInt(dados[0]);
                String sexo = dados[1];
                float media = Float.parseFloat(dados[2]);
                info.add(new Dados(idade, sexo, media));
            }
            Media_Serial calcularM = new Media_Serial("M", info);
            calcularM.calcular_media();
            Media_Serial calcularF = new Media_Serial("F", info);
            calcularF.calcular_media();

        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("o metodo executou em " + (System.currentTimeMillis() - tempoInicial + " milisegundos"));

    }
}
