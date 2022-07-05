package hwr.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameTest {

    @Test
    void get_Position_WhiteFigure(){
        Game game = new Game("German");
        FigureFactory figure = game.getValueAt("1A");
        assertThat(figure).isNotNull();
        assertThat(figure.isFigureColorBlack()).isFalse();
        assertThat(figure.getPosition()).isEqualTo("1A");
    }
    @Test
    void move_Figure(){
        Game game = new Game("German");
        game.move("1C","2D");
        FigureFactory figure = game.getValueAt("2D");
        assertThat(figure.getPosition()).isEqualTo("2D");
        assertThat(figure.isFigureColorBlack()).isFalse();
        figure = game.getValueAt("1C");
        assertThat(figure).isNull();
    }

    @Test
    void move_notAllowed_Figure(){

    }
}
