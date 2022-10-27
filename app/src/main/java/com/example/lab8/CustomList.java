package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }
    /**
     * this adds a city object to the list
     *the second phase, you can add the city
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This returns whether a city object is in the list
     * @param city  the city to test within the list
     * @return  true if the city is in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This deletes a city within the list, throws an exception if such a city does not exist in the
     * list
     * @param city  the city to delete within the list
     * @throws IllegalArgumentException if the city is not already in the list
     */
    public void deleteCity(City city) throws IllegalArgumentException {
        if(!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This function returns the number of cities in the list
     * @return  the number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }


}
