package com.example;

import org.junit.Test;

import java.util.List;

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
    public void getFoodTest() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        Animal animal = new Animal();
        List<String> actual = animal.getFood("Травоядное");
        assertEquals(expected, actual);
    }
}
