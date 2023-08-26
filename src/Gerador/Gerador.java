package Gerador;

import java.util.Random;

public class Gerador {
    
    private static String CARACTERES_PERMITIDOS = new String();
    private static final String CARACTERES_ESPECIAIS = "!@#$%&*()_+-={}[]\\|;:'\",.<>?";
    private static final String CARACTERES_NORMAIS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String gerarSenha(int comprimento, boolean podeCaraceteres) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(comprimento);
        if (podeCaraceteres == true){
            CARACTERES_PERMITIDOS = CARACTERES_NORMAIS + CARACTERES_ESPECIAIS;
        }else{
            CARACTERES_PERMITIDOS = CARACTERES_NORMAIS;
        }
        for (int i = 0; i < comprimento; i++) {
            int index = random.nextInt(CARACTERES_PERMITIDOS.length());
            char caractere = CARACTERES_PERMITIDOS.charAt(index);
            sb.append(caractere);
        }
        return sb.toString();
    }
}
