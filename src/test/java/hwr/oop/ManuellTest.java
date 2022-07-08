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
    @Test
    void createDame(){
        Game game = new Game("German");
        while(!game.isGameWon()) {
            spielzug(game,"0,2,1,3");
            spielzug(game,"3,5,2,4");
            spielzug(game,"1,3,0,4");
            spielzug(game,"2,6,3,5");
            spielzug(game,"0,4,2,6");
            spielzug(game,"0,6,1,5");
            spielzug(game,"1,1,0,2");
            spielzug(game,"1,7,0,6");
            spielzug(game,"2,6,1,7"); // <-- Weiße Dame
            spielzug(game,"3,7,2,6");
            spielzug(game,"0,2,1,3");
            spielzug(game,"3,5,4,4");
            spielzug(game,"1,7,3,5");
        }
    }
    static void spielzug(Game game, String positionen){
        String[] pos = positionen.split(",");
        game.move(Integer.parseInt(pos[0]),Integer.parseInt(pos[1]),Integer.parseInt(pos[2]),Integer.parseInt(pos[3]));
    }
}
/*  Spielfeld Achsen
 *   Y
 *   7
 *   6
 *   5
 *   4
 *   3
 *   2
 *   1
 *   0
 *    0 1 2 3 4 5 6 7 X
 * */