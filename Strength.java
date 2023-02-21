package com.cebola.jogos;

import java.util.Scanner;

public class Strength { // Forca

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Lista de palavras
		String[] words = { "banana", "uva", "maça", "pêra", "manga", "kiwi", "abacaxi", "morango" };

		// Escolha uma palavra aleatória da lista
		String word = words[(int) (Math.random() * words.length)];

		// Configura o estado do jogo
		StringBuilder display = new StringBuilder(word.length());
		for (int i = 0; i < word.length(); i++) {
			display.append('-');
		}
		int guesses = 7;
		StringBuilder usedLetters = new StringBuilder();

		// Inicio do jogo
		while (guesses > 0) {
			// Print do estado atual do jogo
			System.out.println("____________________________________________");
			System.out.println("Palavra: " + display);
			System.out.println(" ");
			System.out.println("Suposições deixadas: " + guesses);
			System.out.println("Letras usadas: " + usedLetters);
			System.out.println(" ");

			// Pedir ao usuário um palpite
			System.out.print("Adivinhe uma letra: ");
			String input = scanner.nextLine().toLowerCase();
			char letter = input.charAt(0);

			// Verifique se a letra já foi usada
			if (usedLetters.indexOf(input) != -1) {
				System.out.println("Você já adivinhou essa letra, tente novamente.");
				System.out.println(" ");
				continue;
			}

			// Marque a letra como usada
			usedLetters.append(letter);

			// Verifica se o palpite está correto
			boolean correct = false;
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == letter) {
					display.setCharAt(i, letter);
					correct = true;
				}
			}

			// Diminui o número de palpites se o palpite estiver incorreto
			if (!correct) {
				guesses--;
			}

			// Verifica se o jogo foi ganho
			if (display.indexOf("-") == -1) {
				System.out.println(" ");
				System.out.println("Parabéns, você venceu! A palavra era: " + word);
				return;
			}
		}

		// Se chegou aqui, o jogo acabou e o jogador perdeu
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Desculpe, você perdeu. A palavra era: " + word);
	}
}
