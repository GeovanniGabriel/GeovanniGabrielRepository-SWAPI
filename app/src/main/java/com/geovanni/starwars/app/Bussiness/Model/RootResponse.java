package com.geovanni.starwars.app.Bussiness.Model;

/**
 * Created by gabri on 18/07/2017.
 */

public class RootResponse {
    private String starships;

    private String planets;

    private String species;

    private String films;

    private String vehicles;

    private String people;

    public String getStarships ()
    {
        return starships;
    }

    public void setStarships (String starships)
    {
        this.starships = starships;
    }

    public String getPlanets ()
    {
        return planets;
    }

    public void setPlanets (String planets)
    {
        this.planets = planets;
    }

    public String getSpecies ()
    {
        return species;
    }

    public void setSpecies (String species)
    {
        this.species = species;
    }

    public String getFilms ()
    {
        return films;
    }

    public void setFilms (String films)
    {
        this.films = films;
    }

    public String getVehicles ()
    {
        return vehicles;
    }

    public void setVehicles (String vehicles)
    {
        this.vehicles = vehicles;
    }

    public String getPeople ()
    {
        return people;
    }

    public void setPeople (String people)
    {
        this.people = people;
    }
}
