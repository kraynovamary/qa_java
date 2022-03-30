package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

//проверяем, что при передаче невалидных аргументов выбрасывается исключение
@RunWith(Parameterized.class)
public class LionExceptionTest{
    private final String sex;

    public LionExceptionTest(String sex) {
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][]{
                {" "},
                {"Лев"},
                {"Lion"},
                {"Female"},
                {"Male"},
        };
    }

    @Test(expected = Exception.class)
    public void validLionSex() throws Exception {
        try {
            Feline feline = new Feline();
            Lion lion = new Lion(sex, feline);
        } catch (IllegalArgumentException e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}