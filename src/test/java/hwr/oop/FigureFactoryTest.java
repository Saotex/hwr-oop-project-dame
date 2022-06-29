package hwr.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FigureFactoryTest {

    @Test
    void create_FigureOverInterfaceBlack(){
        FigureFactory figureBlack = FigureFactory.createFigure(true);
        assertThat(figureBlack).isInstanceOf(FigureFactory.class).isInstanceOf(Figure.class);
        boolean isBlack = figureBlack.figureColorIsBlack();
        assertThat(isBlack).isTrue();
    }

    @Test
    void create_FigureOverInterfaceWhite(){
        FigureFactory figureWhite = FigureFactory.createFigure(false);
        assertThat(figureWhite).isInstanceOf(FigureFactory.class).isInstanceOf(Figure.class);
        boolean isBlack = figureWhite.figureColorIsBlack();
        assertThat(isBlack).isFalse();
    }
}
