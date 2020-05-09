package br.com.bootcamp.jogo;

import java.util.Random;
import java.util.Scanner;

public class Forca {

    public static void main(String[] args){
        System.out.println("Bem vindo ao Jogo!");
        Scanner in = new Scanner(System.in);
        System.out.print("Qual a dificuldade do jogo?: F(Fácil); N(Normal); D(Dificil) -->");
        String dificuldadeJogo = in.next();

        switch (dificuldadeJogo){
            case "F":
                System.out.println(listaPalavraFacil());
                break;
            case "N":
                System.out.println(listaPalavraNormais());
                break;
            case "D":
                System.out.println(listaPalavraDificeis());
                break;
            default:
                System.out.println("Opção invalida");
        }


    }

    public static String listaPalavraDificeis(){
        String[] palavras = {"carambola", "lichia","jatoba"};
        Random random = new Random();
        return palavras[random.nextInt(palavras.length-1)];
    }

    public static String listaPalavraNormais(){
        String[] palavras = {"abacaxi", "melancia","melao"};
        Random random = new Random();
        return palavras[random.nextInt(palavras.length-1)];
    }

    public static String listaPalavraFacil(){
        String[] palavras = {"banana", "uva","maca"};
        Random random = new Random();
        return palavras[random.nextInt(palavras.length-1)];
    }
}
