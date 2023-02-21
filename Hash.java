package com.cebola.jogos;

import java.util.Scanner;

public class Hash { // Jogo da Velha

	private char[][] board = new char[3][3];
	private char currentPlayer;

	public Hash() {
		// inicializa a placa com células vazias
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}

		// define o jogador inicial como 'X'
		currentPlayer = 'X';
	}

	public void printBoard() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	public boolean makeMove(int row, int col) {
		if (row < 0 || row > 2 || col < 0 || col > 2) {
			return false;
		}

		if (board[row][col] != '-') {
			return false;
		}

		board[row][col] = currentPlayer;

		if (currentPlayer == 'X') {
			currentPlayer = 'O';
		} else {
			currentPlayer = 'X';
		}

		return true;
	}

	public boolean isGameOver() {
		// verifica as linhas
		for (int i = 0; i < 3; i++) {
			if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}

		// verifica as colunas
		for (int j = 0; j < 3; j++) {
			if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
				return true;
			}
		}

		// verifica as diagonais
		if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true;
		}

		if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true;
		}

		// verifica se ainda existem células vazias
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-') {
					return false;
				}
			}
		}

		// se chegarmos aqui, o jogo é um empate
		return true;
	}

	public static void main(String[] args) {
		Hash game = new Hash();
		Scanner scanner = new Scanner(System.in);

		while (!game.isGameOver()) {
			// imprime a placa atual
			game.printBoard();

			// pega o movimento do usuário
			System.out.print("Player " + game.currentPlayer + ", digite vertical (0-2): ");
			int row = scanner.nextInt();
			System.out.print("Player " + game.currentPlayer + ", digite horizontal (0-2):");
			int col = scanner.nextInt();

			if (!game.makeMove(row, col)) {
				System.out.println("Movimento inválido, tente novamente.");
			}
		}

		// imprime a placa final
		game.printBoard();

		// imprime o resultado
		if (game.isGameOver()) {
			System.out.println("Fim do jogo!");
			if (game.currentPlayer == 'X') {
				System.out.println("Jogador O vence!");
			} else {
				System.out.println("Jogador X vence!");
			}
		} else {
			System.out.println("Empate!");
		}
	}
}
