package hwr.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FigureFactoryTest {

    @Test
    void create_FigureOverInterfaceBlack(){
        FigureFactory figureBlack = FigureFactory.createFigure(true,1,"A");
        assertThat(figureBlack).isInstanceOf(Object.class).isInstanceOf(FigureFactory.class).isInstanceOf(Figure.class);
        boolean isBlack = figureBlack.isFigureColorBlack();
        assertThat(isBlack).isTrue();
    }

    @Test
    void create_FigureOverInterfaceWhite(){
        FigureFactory figureWhite = FigureFactory.createFigure(false,1,"A");
        assertThat(figureWhite).isInstanceOf(Object.class).isInstanceOf(FigureFactory.class).isInstanceOf(Figure.class);
        boolean isBlack = figureWhite.isFigureColorBlack();
        assertThat(isBlack).isFalse();
    }
}
