package pucrs.java.maven.hangman.domainTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pucrs.java.maven.hangman.domain.Hangman;

public class HangmanTest {
	@Test
	public void testGameStartForHangman() {
		Hangman h = new Hangman("hangman");
		assertEquals("-------", h.getWord());
		assertTrue(h.getMisses().isEmpty());
	}

	@Test
	public void testGameStartForCasa() {
		Hangman h = new Hangman("casa");
		assertEquals("----", h.getWord());
		assertTrue(h.getMisses().isEmpty());
	}

	@Test
	public void testFirstGuessWrong() {
		Hangman h = new Hangman("hangman");
		h.guess("E");
		assertEquals("-------", h.getWord());
		assertTrue(h.getMisses().contains("e"));
	}
}
