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
	
/*	@Test
	public void testFirstGuessRight() {
		Hangman h = new Hangman("casa");
		h.guess("a");
		assertEquals("-a-a", h.getWord());
		assertTrue(h.getMisses().isEmpty());
	} */
	
/*	@Test
	public void testIfTheGameIsOver() {
		Hangman h = new Hangman("casa");
		h.guess("a");
	//	h.guess("c");
	//	h.guess("s");
		assertEquals("aaaa", h.getWord());
		assertTrue(h.getMisses().isEmpty());
		assertEquals(true, h.getGameOver());
	}
	*/
	@Test
	public void testIfTheGameIsNotOver() {
		Hangman h = new Hangman("casa");
		h.guess("b");
		assertTrue(h.getMisses().contains("b"));
		assertEquals(false, h.getGameOver());
	}
	
	@Test
	public void testIfTheGameIsOverByDeath() {
		Hangman h = new Hangman("casa");
		h.guess("b");
		h.guess("d");
		h.guess("e");
		h.guess("f");
		h.guess("g");
		h.guess("h");
		assertTrue(h.getMisses().contains("b"));
		assertTrue(h.getMisses().contains("d"));
		assertTrue(h.getMisses().contains("e"));
		assertTrue(h.getMisses().contains("f"));
		assertTrue(h.getMisses().contains("g"));
		assertTrue(h.getMisses().contains("h"));
		assertEquals(true, h.getGameOver());
	}
}