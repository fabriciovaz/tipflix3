package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import Model.Movie;
import tipflix.com.projeto.R;
//import tipflixcoverflowitemclick.com.tipflixcoverflowitemclick.R;

public class MovieAdapter extends BaseAdapter {

    List<Movie> movieList;
    Context context;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View rootView = view;
        if (rootView == null){



        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.layout_item,null);
        TextView name = (TextView)itemView.findViewById(R.id.label);
        ImageView imageView = (ImageView)itemView.findViewById(R.id.image);


        //Aqui é configurada a imagem e o título
        Picasso.get().load(movieList.get(i).getUrl()).into(imageView);
        name.setText(movieList.get(i).getTitle());


            return itemView;
        }
        return rootView;
    }
}
