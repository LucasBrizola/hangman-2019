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
		}
		else{
		return true;
		}
	}

	public List<String> getMisses() {
		return misses;
	}

	public void guess(String letter) {
		// FIXME: comparar letter e secret!
		letter = letter.toLowerCase();
		boolean checarLetra = secret.contains(letter);
		if (checarLetra == true) {
			for (int i = 0; i < secret.length(); i++) {

				System.out.println(secret);
				System.out.println(word);
				char letra = secret.charAt(i);
				String letra1 = String.valueOf(letra);
				if (letra1.equals(letter)) {
					word = word.replace("-", letter);
				}

			}

		} else {
			misses.add(letter);
		}
		gameOver = checkIfTheGameIsOver();
		if (gameOver == true) {
			System.out.println("The game is over, the word was: " + getWord());
		} else {
			System.out.println("Next Guess: ");
			System.out.println("misses.size = "+misses.size());
		}
	}

}
