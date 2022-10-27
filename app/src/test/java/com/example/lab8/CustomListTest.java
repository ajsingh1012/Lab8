package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * create a mock city for my citylist
     * @return mock city
     */
    public City MockCity(){
        City city = new City("Edmonton", "AB");
        return city;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * get whether a city is in the list
     * increase the list by adding a new city
     * check if city being in the list matches hasCity
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();
        City city = MockCity();
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * check deletion functionality of city
     * make an arraylist with a mock city to ensure it has the right arraylist base
     * check if city is still in the list by checking size
     */
    @Test
    public void deleteCityTest(){
        ArrayList<City> cityList = new ArrayList<>();
        City city = MockCity();
        cityList.add(city);

        list = new CustomList(null, cityList);
        list.deleteCity(city);
        assertEquals(list.getCount(), 0);
    }

    /**
     * check deletion functionality of city
     * make an arraylist with a mock city to ensure it has the right arraylist base
     * check if city is still in the list by checking size
     */
    @Test
    public void deleteCityTestThrows(){
        list = MockCityList();
        City city = MockCity();
        assertThrows( IllegalArgumentException.class, () -> {
            list.deleteCity(city); });
    }

    /**
     * get how many cities are in the list
     * instantiate an empty arraylist and add a mock city to it to ensure it has the city
     * check before and after adding the city that its size matches the intuitive number
     */
    /*@Test
    public void countCitiesTest(){
        list = MockCityList();
        City city = MockCity();


        list.deleteCity(city);
        assertEquals(list.getCount(), 0);
    }*/



}
