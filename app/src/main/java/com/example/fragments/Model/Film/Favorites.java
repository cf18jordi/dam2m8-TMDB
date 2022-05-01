package com.example.fragments.Model.Film;

import java.util.ArrayList;

public class Favorites {
    int page;
    ArrayList<Film> results;
    int total_pages;
    int total_results;

    public Favorites(int page, ArrayList<Film> results, int total_pages, int total_results) {
        this.page = page;
        this.results = results;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public ArrayList<Film> getResult() {
        return results;
    }


}

