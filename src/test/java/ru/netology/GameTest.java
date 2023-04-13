package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void testFirstPlayerWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Джо", 20);
        Player player2 = new Player(2, "Мэри", 10);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Джо", "Мэри");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayerWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Джо", 20);
        Player player2 = new Player(2, "Мэри", 45);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Джо", "Мэри");
        int expected = -1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstPlayerNoExisist() {
        Game game = new Game();
        Player player1 = new Player(1, "Джо", 20);
        Player player2 = new Player(2, "Мэри", 10);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Мари", "Мэри"));

    }

    @Test
    public void testSecondPlayerNoExisist() {
        Game game = new Game();
        Player player1 = new Player(1, "Джо", 20);
        Player player2 = new Player(2, "Мэри", 10);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Джо", "Боб"));
    }

    @Test
    public void testBothPlayerNoExisist() {
        Game game = new Game();
        Player player1 = new Player(1, "Джо", 20);
        Player player2 = new Player(2, "Мэри", 10);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Мари", "Боб"));

    }

    @Test
    public void testNoOneWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Джо", 20);
        Player player2 = new Player(2, "Мэри", 20);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Джо", "Мэри");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }
}