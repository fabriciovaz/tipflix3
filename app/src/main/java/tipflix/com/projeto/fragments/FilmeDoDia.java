package tipflix.com.projeto.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

import tipflix.com.projeto.R;
import tipflix.com.projeto.activities.FilmeDoDiaActivity;
import tipflix.com.projeto.activities.FilmesNaListaActivity;
import tipflix.com.projeto.activities.GridFilmeListaActivity;
import tipflix.com.projeto.activities.MainActivity;
import tipflix.com.projeto.activities.Splash;

public class FilmeDoDia extends Fragment {

    View v;

    public static FilmeDoDia newInstance() {
        FilmeDoDia fragment = new FilmeDoDia();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      v=inflater.inflate(R.layout.fragment_filme_do_dia, container, false);

        Intent intent = new Intent(v.getContext(), FilmeDoDiaActivity.class);
        startActivity(intent);

        return v;
    }




}


