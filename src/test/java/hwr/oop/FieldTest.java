package hwr.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FieldTest {

    @Test
    void field_initial_positions(){
        Field field = new Field("German");
        for (int i = 0; i < 8; i++) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                System.out.print(field.getPositionList()[i][j].getState()+"  ");
            }
        }
        assertThat(field.getPositionList()[0][0].getState()).isEqualTo(1);
        assertThat(field.getPositionList()[6][0].getState()).isEqualTo(2);
        assertThat(field.getPositionList()[3][3].getState()).isEqualTo(0);
        assertThat(field.getPositionList()[0][1].isDame()).isFalse();
        assertThat(field.getPositionList()[0][0].getPosition()).isEqualTo("00");
    }
    @Test
    void spielfeld(){
        Game game = new Game("German");
        assertThat(game.field.getPositionList()[2][0].getState()).isEqualTo(1);
        assertThat(game.field.getPositionList()[3][1].getState()).isEqualTo(0);
        System.out.println("  ");
        System.out.println("  ");
        game.move(0,2,1,3);
        game.spielfeld();
        assertThat(game.field.getPositionList()[2][0].getState()).isEqualTo(0);
        assertThat(game.field.getPositionList()[3][1].getState()).isEqualTo(1);
    }

    @Test
    void setState(){
        Game game = new Game("German");
        System.out.println("  ");
        System.out.println("  ");
        assertThat(game.field.getPositionList()[0][2].getState()).isEqualTo(1);
        game.field.getPositionList()[0][2].setState(2);
        assertThat(game.field.getPositionList()[0][2].getState()).isEqualTo(2);
        game.spielfeld();
    }

    @Test
    void spielzüge(){
        Game game = new Game("German");
        System.out.println("  ");
        System.out.println("  ");
        game.move(2,2,3,3);
        game.move(3,5,4,4);
        game.move(0,2,1,3);
        game.move(4,4,2,2);
        game.move(3,3,4,4);
        game.move(1,5,2,4);
        game.move(1,1,3,3);
        game.spielfeld();
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
}
