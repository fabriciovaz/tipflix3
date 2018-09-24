package tipflix.com.projeto.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Color;

import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

import tipflix.com.projeto.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GeneroMenuFragment extends Fragment {

    public static GeneroMenuFragment newInstance() {
        GeneroMenuFragment fragment = new GeneroMenuFragment();
        return fragment;
    }

    View v;
    String arrayName[]={"Comédia",
            "Terror",
            "suspense",
            "Drama",
            "Ação"};




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.fragment_genero_menu, container, false);


        CircleMenu circleMenu = (CircleMenu) v.findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.ic_add,R.drawable.ic_remove)
                .addSubMenu(Color.parseColor("#258CFF"),R.drawable.comedia)
                .addSubMenu(Color.parseColor("#6d4c41"),R.drawable.terror)
                .addSubMenu(Color.parseColor("#ff0000"),R.drawable.suspense)
                .addSubMenu(Color.parseColor("#03a9f4"),R.drawable.drama)
                .addSubMenu(Color.parseColor("#1a237e"),R.drawable.acao)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int i) {
                        Toast.makeText(getContext(),"você selecionou"+arrayName[i],Toast.LENGTH_SHORT).show();

                    }
                });
        return v;
    }

    }






