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
        game.spielfeld();
    }
}
