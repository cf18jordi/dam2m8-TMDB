package com.example.fragments;

import static com.example.fragments.Config.DefaultConstants.API_KEY;
import static com.example.fragments.Config.DefaultConstants.SESSION_ID;
import static com.example.fragments.Config.DefaultConstants.retrofit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragments.Config.ApiCall;
import com.example.fragments.Model.Film.Favorites;
import com.example.fragments.Model.Film.Film;
import com.example.fragments.Recyclers.SearchMovieRecyclerViewAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MoviesListFragment extends Fragment {

    public String sectionTitle;
    public RecyclerView recyclerView;

    public MoviesListFragment() {
        // Required empty public constructor
    }

    public MoviesListFragment(String title) {
        this.sectionTitle = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerSearch);

        ApiCall apiCall = retrofit.create(ApiCall.class);
        Call<Favorites> call = apiCall.getFavData(API_KEY, SESSION_ID);
        call.enqueue(new Callback<Favorites>(){
            @Override
            public void onResponse(Call<Favorites> call, Response<Favorites> response) {
                if(response.code()!=200){
                    Log.i("testApi", "checkConnection");
                    return;
                }else {
                    ArrayList<Film> arraySearch = new ArrayList<>();
                    arraySearch = response.body().getResult();
                    callRecycler(arraySearch);
                }
            }

            @Override
            public void onFailure(Call<Favorites> call, Throwable t) {

            }
        });


        TextView txtSectionTitle = view.findViewById(R.id.sectionTitle);
        txtSectionTitle.setText(sectionTitle);

        return view;
    }

    public void callRecycler(ArrayList<Film> arraySearch){
        SearchMovieRecyclerViewAdapter adapter = new SearchMovieRecyclerViewAdapter(arraySearch, getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(adapter);
    }
}