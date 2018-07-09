package com.example.thegerman.movieflicks.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thegerman.movieflicks.R;
import com.example.thegerman.movieflicks.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    // View Loockup cache0
    private static  class ViewHolder{
        ImageView ivMovie;
        TextView tvTitle;
        TextView tvOverview;
    }

    public MovieArrayAdapter(Context context, ArrayList<Movie> movies){
        super(context, 0,movies);
    }

    @Override

    public View getView(int position,  View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie movie = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie_item,parent,false);
            // Lookup view for data population
            viewHolder.ivMovie = (ImageView) convertView.findViewById(R.id.ivMovieImage);
            viewHolder.tvTitle= (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        // Populate the data into the template view using the data object
        viewHolder.ivMovie.setImageResource(0);
        viewHolder.tvTitle.setText(movie.getOriginalTitle());
        viewHolder.tvOverview.setText(movie.getOverview());


        int orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT){
            Picasso.with(getContext()).load(movie.getPosterPath()).placeholder(R.drawable.loading).into(viewHolder.ivMovie);

        }else if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            Picasso.with(getContext()).load(movie.getBackdropPath()).placeholder(R.drawable.loading).into(viewHolder.ivMovie);
        }



        // return convert view

        return convertView;

    }
}
