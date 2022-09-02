package br.edu.catlica.pp;

import java.io.IOException;

public class App {
    public static void main(String[] args) {

        Ler_dados ler = new Ler_dados("C:\\Users\\55839\\Desktop\\dadosINEP_enade.csv");

        ler.infoHomens();

        ler.infoMulheres();

        ler.status();

    }
}
