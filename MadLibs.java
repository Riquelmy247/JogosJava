package com.cebola.jogos;

import java.util.Scanner;

public class MadLibs {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Bem-vindo ao Mad Libs!");

		// Obter entrada do usuário
		System.out.print("Digite um adjetivo: ");
		String adjetivo = scanner.nextLine();
		System.out.print("Digite um substantivo: ");
		String substantivo = scanner.nextLine();
		System.out.print("Digite um verbo: ");
		String verbo = scanner.nextLine();
		System.out.print("Digite um advérbio: ");
		String adverb = scanner.nextLine();

		// Saída da história
		System.out.println(
				"Era uma vez um " + adjetivo + " " + substantivo + " que queria " + verbo + " " + adverb + ".");
	}
}
