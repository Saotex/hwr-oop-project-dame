package hwr.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FieldTest {

    @Test
    void field_german_creation_game(){
        Field field = new Field("German");
        List list = field.getList();
        assertThat(list.size()).isEqualTo(24);
    }

    @Test
    void field_german_get_position(){
        Field field = new Field("German");
        List list = field.getList();
        FigureFactory figure = (FigureFactory) list.get(0);
        assertThat(figure.getPosition()).isEqualTo("1A");
        assertThat(figure.isFigureColorBlack()).isFalse();
    }
}
