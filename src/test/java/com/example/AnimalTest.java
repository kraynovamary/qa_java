package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodTest() {
        Animal animal = new Animal();
        try {
            animal.getFood("Всеядное");
        } catch (Exception e) {
            assertEquals(e.getMessage(),"Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }
}
