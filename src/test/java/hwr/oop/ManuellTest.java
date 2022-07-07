package hwr.oop;

import org.junit.jupiter.api.Test;

public class ManuellTest {

    @Test
    void play_game(){
        Game game = new Game("German");
        while(!game.isGameWon()) {
            game.amZug();
            String[] positionen = game.getPositionFromPlayer();
            game.move(Integer.parseInt(positionen[0]),Integer.parseInt(positionen[1]),Integer.parseInt(positionen[2]),Integer.parseInt(positionen[3]));
            game.spielfeld();
        }
    }
}
