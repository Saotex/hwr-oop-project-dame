package hwr.oop;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DameTest {

    @Test
    void field_initial_positions(){
        Field field = new Field();
        for (int i = 7; i >= 0; i--) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                System.out.print(field.getPositionList()[i][j].getState()+"  ");
            }
        }
        System.out.println();
        assertThat(field.getPositionList()[0][0].getState()).isEqualTo(1);
        assertThat(field.getPositionList()[6][0].getState()).isEqualTo(2);
        assertThat(field.getPositionList()[3][3].getState()).isEqualTo(0);
        assertThat(field.getPositionList()[0][1].isDame()).isFalse();
    }
    @Test
    void spielfeld(){
        Game game = new Game();
        assertThat(game.field.getPositionList()[2][0].getState()).isEqualTo(1);
        assertThat(game.field.getPositionList()[3][1].getState()).isEqualTo(0);
        System.out.println("  ");
        System.out.println("  ");
        game.move("0,2,1,3");
        game.spielfeld();
        assertThat(game.field.getPositionList()[2][0].getState()).isEqualTo(0);
        assertThat(game.field.getPositionList()[3][1].getState()).isEqualTo(1);
    }

    @Test
    void setState(){
        Game game = new Game();
        System.out.println("  ");
        System.out.println("  ");
        assertThat(game.field.getPositionList()[0][2].getState()).isEqualTo(1);
        game.field.getPositionList()[0][2].setState(2);
        assertThat(game.field.getPositionList()[0][2].getState()).isEqualTo(2);
        game.spielfeld();
    }

    @Test
    void spielzüge(){
        Game game = new Game();
        game.move("2,2,3,3");
        game.move("3,5,4,4");
        game.move("0,2,1,3");
        game.move("4,4,2,2");
        game.move("1,1,3,3");
        int countWhite = 0;
        int countBlack = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (game.field.getPositionList()[i][j].getState() == 2){
                    countBlack++;
                } else if (game.field.getPositionList()[i][j].getState() == 1) {
                    countWhite++;
                }
            }
        }
        assertThat(countWhite).isEqualTo(11);
        assertThat(countBlack).isEqualTo(11);
    }

    @Test
    void dame_move(){
        Game game = new Game();
        game.move("0,2,1,3");
        game.move("3,5,2,4");
        game.move("1,3,0,4");
        game.move("2,6,3,5");
        game.move("0,4,2,6");
        game.move("0,6,1,5");
        game.move("1,1,0,2");
        game.move("1,7,0,6");
        game.move("2,6,1,7");
        game.move("3,7,2,6");
        game.move("0,2,1,3");
        game.move("3,5,4,4");
        game.move("1,7,3,5");
        assertThat(game.field.getPositionList()[5][3].isDame()).isTrue();
    }

    @Test
    void setDame_Dame_set(){
        Field field = new Field();
        Figure f = field.getPositionList()[0][2];
        f.setDame();
        assertThat(f.isDame()).isTrue();
    }

    @Test
    void isGameWon(){
        Game game = new Game();
        String data = "isGameWon";
        String exampleString = "isGameWon";
        InputStream stream = new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8));
        System.setIn(stream);
        game.move("load");
        assertThat(game.isWhite).isTrue();
        assertThat(game.isGameWon()).isTrue();
    }

    @Test
    void saveLoadGameWon(){
        Game game = new Game();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                game.field.getPositionList()[i][j].setState(0);
            }
        }
        game.field.getPositionList()[0][0].setState(1);
        assertThat(game.field.getPositionList()[0][0].getState()).isEqualTo(1);
        assertThat(game.isGameWon()).isTrue();


        String data = "test";
        String exampleString = "test";
        InputStream stream = new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8));
        System.setIn(stream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        game.move("save");

        String saveOutput = outContent.toString();

        assertThat(saveOutput.contains("Erfolgreich erstellt")).isTrue();

        game.field.getPositionList()[0][0].setState(2);
        assertThat(game.field.getPositionList()[0][0].getState()).isEqualTo(2);
        assertThat(game.isGameWon()).isTrue();

        data = "test";
        exampleString = "test";
        stream = new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8));
        System.setIn(stream);

        game.move("load");

        assertThat(game.field.getPositionList()[0][0].getState()).isEqualTo(1);
        assertThat(game.isGameWon()).isTrue();
    }
}
