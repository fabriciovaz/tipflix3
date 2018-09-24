package tipflix.com.projeto.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import Adapter.ListaFilmesAdapter;
import Model.ListaFilmesItem;
import tipflix.com.projeto.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListasRecyclerFragment extends Fragment {
    public static ListasRecyclerFragment newInstance() {
        ListasRecyclerFragment fragment = new ListasRecyclerFragment();
        return fragment;
    }

    private List<ListaFilmesItem> listaFilmesItems = null;
    static int ID = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listas_recycler, container, false);
        inicializaItens();
        RecyclerView listaFilmesRecyclerView = (RecyclerView)  v.findViewById(R.id.recycler_lista_filmes);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(v.getContext(), 2);
        listaFilmesRecyclerView.setLayoutManager(gridLayoutManager);
        ListaFilmesAdapter receitaDataAdapter = new ListaFilmesAdapter(listaFilmesItems);
        listaFilmesRecyclerView.setAdapter(receitaDataAdapter);

        return v;
    }

    private void inicializaItens(){

        if(listaFilmesItems == null){

            listaFilmesItems = new ArrayList<ListaFilmesItem>();

            listaFilmesItems.add(new ListaFilmesItem("Filmes da DC",R.drawable.dc,geradorId()));
            listaFilmesItems.add(new ListaFilmesItem("Filmes da marvel",R.drawable.marvel,geradorId()));
            listaFilmesItems.add(new ListaFilmesItem("Fantasia",R.drawable.fantasia,geradorId()));
            listaFilmesItems.add(new ListaFilmesItem("Filmes da marvel",R.drawable.ficcao,geradorId()));
            listaFilmesItems.add(new ListaFilmesItem("Filmes da marvel",R.drawable.marvel,geradorId()));
            listaFilmesItems.add(new ListaFilmesItem("Filmes da marvel",R.drawable.ficcao,geradorId()));




        }
    }

    public int geradorId(){
       ID++;
        return ID;
    }

}