package pucrs.java.maven.hangman.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pucrs.java.maven.hangman.domain.Hangman;

public class testGameStart {
	@Test
	public void testgameStart() {
		Hangman h = new Hangman("hangman");
		assertEquals("hangman", h.getWord());
	}
}
