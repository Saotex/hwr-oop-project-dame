package hwr.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FigureFactoryTest {

    @Test
    void create_FigureOverInterfaceBlack(){
        FigureFactory figureBlack = FigureFactory.createBlackFigure();
        assertThat(figureBlack).isInstanceOf(Object.class).isInstanceOf(FigureFactory.class).isInstanceOf(BlackFigure.class);
    }

    @Test
    void create_FigureOverInterfaceWhite(){
        FigureFactory figureWhite = FigureFactory.createWhiteFigure();
        assertThat(figureWhite).isInstanceOf(Object.class).isInstanceOf(FigureFactory.class).isInstanceOf(WhiteFigure.class);
    }
}
