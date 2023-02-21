package com.cebola.jogos;

import java.util.Random;

public class PasswordGenerator { // GeradorSenha

	private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";

	public static void main(String[] args) {
		// Comprimento da senha
		int comprimento = 10;
		String senha = gerarSenha(comprimento);
		System.out.println("Senha gerada: " + senha);
	}

	public static String gerarSenha(int comprimento) {
		StringBuilder sb = new StringBuilder(comprimento);
		Random random = new Random();

		for (int i = 0; i < comprimento; i++) {
			int index = random.nextInt(CARACTERES.length());
			char randomChar = CARACTERES.charAt(index);
			sb.append(randomChar);
		}

		return sb.toString();
	}
}
