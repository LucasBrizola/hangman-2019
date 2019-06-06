package pucrs.java.maven.hangman.domain;

import java.util.ArrayList;
import java.util.List;

public class Hangman {
	private String secret;
	private String word;
	private List<String> misses;

	public Hangman(String secret) {
		super();
		this.secret = secret;
		this.misses = new ArrayList<String>();
		generateInitialSecret();
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

	public List<String> getMisses() {
		return misses;
	}

	public void guess(String letter) {
		// FIXME: comparar letter e secret!
		letter = letter.toLowerCase();
		misses.add(letter);

	}

}
