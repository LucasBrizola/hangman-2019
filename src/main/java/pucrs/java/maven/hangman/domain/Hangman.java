package pucrs.java.maven.hangman.domain;

import java.util.ArrayList;
import java.util.List;

public class Hangman {
	private String secret;
	private String word;
	private List<String> misses;
	private boolean gameOver;

	public Hangman(String secret) {
		super();
		this.secret = secret;
		this.misses = new ArrayList<String>();
		generateInitialSecret();
	}

	public Boolean getGameOver() {
		return gameOver;
	}

	public String getWord() {
		return word;
	}

	public String getSecret() {
		return secret;
	}

	private void generateInitialSecret() {
		word = "";
		for (int i = 0; i < this.secret.length(); i++) {
			word += "-";
		}
	}

	private Boolean checkIfTheGameIsOver() {
		if (misses.size() == 6) {
			return true;
		}
		if (word.contains("-")) {
			return false;
		} else {
			return true;
		}
	}

	public List<String> getMisses() {
		return misses;
	}

	public void guess(String letter) {
		letter = letter.toLowerCase();
		char[] letterAsChar = letter.toCharArray();
		boolean checarLetra = secret.contains(letter);
		if (checarLetra == true) {
			for (int i = 0; i < secret.length(); i++) {
				char[] wordAsChar = word.toCharArray();
				char letra = secret.charAt(i);
				if (letterAsChar[0] == letra) {
					wordAsChar[i] = letra;
				}
				word = String.copyValueOf(wordAsChar);
			}

		} else {
			misses.add(letter);
		}
		gameOver = checkIfTheGameIsOver();
		if (gameOver == true) {
			letter = letter.toUpperCase();
			System.out.println("The letter was: "+ letter);
			if(misses.size() <= 5) {
				System.out.println("You have won!");
			}
			else {
				System.out.println("You lost...");
			}
			System.out.println("The game is over, the word was: " + getSecret());
		} else {
			letter = letter.toUpperCase();
			System.out.println("The letter was: "+ letter);
			for (String miss : misses) {
				System.out.println("Letters wrong: "+ miss);
			}

			System.out.println("Next Guess: ");
			System.out.println("");
		}
	}

}
