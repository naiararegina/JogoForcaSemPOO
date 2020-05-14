package br.com.bootcamp.jogo;

import java.util.Random;
import java.util.Scanner;

public class Forca {

    private static  String[] dica;

    public static void main(String[] args){
        String palavraChave = null;
        int qtdLetras = 0;
        int acertou = 0;
        int pontuacao = 10;
        String novaDica = "";
        System.out.println("Bem vindo ao Jogo!");
        Scanner in = new Scanner(System.in);
        System.out.print("Qual a dificuldade do jogo?: F(Fácil); N(Normal); D(Dificil) -->");
        String dificuldadeJogo = in.next().toUpperCase ();

        switch (dificuldadeJogo){
            case "F":
               palavraChave = listaPalavraFacil();
                break;
            case "N":
                palavraChave = listaPalavraNormais();
                break;
            case "D":
                palavraChave = listaPalavraDificeis();
                break;
            default:
                System.out.println("Opção invalida");
                break;
        }

        String listaEmString = "";
        montaDica(palavraChave.length());
        for(String s :dica){
            listaEmString = listaEmString + s;

        }

        System.out.println(listaEmString);
        String[] listaLetrasCorretas = palavraChave.split("");

        while (pontuacao > 0){
            if(palavraChave.equals(novaDica)){
                System.out.println("Você acertou a palavra... Parabéns!!!");
                break;
            }

            System.out.println("Qual letra você chuta?");
            String letraDigitada  = in.next().toLowerCase();

            int i = 0;
            qtdLetras = palavraChave.length();
            while (i < qtdLetras) {
                if (listaLetrasCorretas[i].equals(letraDigitada)) {
                    dica[i] = letraDigitada;
                    acertou = 1;
                }
                i++;
            }

            if (acertou == 1){
                acertou = 0;
            } else {
                pontuacao -= 1;
            }

            for (String s : dica){
                novaDica+= s;
            }

            System.out.println("\n Você ainda tem: " + pontuacao + " chances de chutar!! \n");
            System.out.println(novaDica);
        }

    }

    public static String[] montaDica(int qtdLetras){
             dica = new String[qtdLetras];

        for(int i = 0; i < dica.length; i++){
            dica[i] = " __ ";
        }
        return dica;
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
