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
}
