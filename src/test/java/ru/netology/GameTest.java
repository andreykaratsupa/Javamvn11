package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void FirstPlayerWin() {
        Player Biden = new Player(1, "Biden", 200);
        Player Trump = new Player(1, "Trump", 250);
        Game game = new Game();

        game.register(Biden);
        game.register(Trump);
        int actual = game.round("Trump", "Biden");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SecondPlayerWin() {
        Player Biden = new Player(1, "Biden", 200);
        Player Trump = new Player(1, "Trump", 150);
        Game game = new Game();

        game.register(Biden);
        game.register(Trump);
        int actual = game.round("Trump", "Biden");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void DrawPlayers() {
        Player Biden = new Player(1, "Biden", 200);
        Player Trump = new Player(1, "Trump", 200);
        Game game = new Game();

        game.register(Biden);
        game.register(Trump);
        int actual = game.round("Biden", "Trump");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FirstPlayerNotExist() {
        Player Biden = new Player(1, "Biden", 200);
        Player Trump = new Player(1, "Trump", 250);
        Game game = new Game();

        game.register(Biden);
        game.register(Trump);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Obama", "Trump"));
    }

    @Test
    public void SecondPlayerNotExist() {
        Player Biden = new Player(1, "Biden", 200);
        Player Trump = new Player(1, "Trump", 250);
        Game game = new Game();

        game.register(Biden);
        game.register(Trump);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Biden", "Obama"));
    }

    @Test
    public void PlayersNotExist() {
        Player Biden = new Player(1, "Biden", 200);
        Player Trump = new Player(1, "Trump", 250);
        Game game = new Game();

        game.register(Biden);
        game.register(Trump);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Obama", "Bush"));
    }
}