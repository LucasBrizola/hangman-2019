package pucrs.java.maven.hangman.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pucrs.java.maven.hangman.domain.hangman;

public class testGameStart {
	@Test
	public void testgameStart() {
		hangman h = new hangman("hangman");
		assertEquals("hangman", h.getWord());
	}
}
