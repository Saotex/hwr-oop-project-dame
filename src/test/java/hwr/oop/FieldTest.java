package hwr.oop;

import org.junit.jupiter.api.Test;

public class FieldTest {


    @Test
    void createGermanField(){
        Field spielfeld = new Field(8);
    }

    @Test
    void createRechteckigesField(){
        Field spielfeld = new Field(8,9);
    }

    @Test
    void cantCreateField_FieldToSmallY(){
        Field spielfeld = new Field(8,5);
    }

    @Test
    void cantCreateFiekd_FieldToSmallX(){
        Field spielfeld = new Field(2,6);
    }
}
