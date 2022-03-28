package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class LionDoesHaveManePositiveParametrizedTest {
    private final String sex;
    private final Boolean hasMane;

    public LionDoesHaveManePositiveParametrizedTest(String sex, Boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[] getSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManePositiveTest() throws Exception {
        try {
            Feline feline = new Feline();
            Lion lion = new Lion(sex, feline);
            boolean expected = lion.doesHaveMane();
            assertEquals(expected, hasMane);
        } catch (IllegalArgumentException exception) {
            fail("Используйте допустимые значения пола животного - самец или самка");
            exception.printStackTrace();
        }
    }
}

