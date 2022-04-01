package com.example;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


//проверяем, что при передаче невалидных аргументов выбрасывается исключение
@RunWith(Parameterized.class)
public class LionExceptionTest{
    private final String sex;
    private final Boolean hasMane;

    public LionExceptionTest(String sex, Boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][]{
                {" ", true},
                {"Лев", true},
                {"Lion", false},
                {"Female", false},
                {"Male", true}
        };
    }
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenExceptionThrown_thenRuleIsApplied() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Feline feline = new Feline();
        new Lion(sex, feline);
    }
}