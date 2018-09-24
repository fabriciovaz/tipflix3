package Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import Model.ListaFilmesItem;
import tipflix.com.projeto.R;
import tipflix.com.projeto.activities.FilmesNaListaActivity;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {

    private List<ListaFilmesItem> listaFilmesItems;

    public ListaFilmesAdapter(List<ListaFilmesItem> listaFilmesItems) {
        this.listaFilmesItems = listaFilmesItems;
    }

    @Override
    public ListaFilmesViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the RecyclerView item layout xml.
        View itemView = layoutInflater.inflate(R.layout.lista_filmes_item, parent, false);

        //As views são associadas aos seus objetos pelo Id
        final TextView listaNome = (TextView)itemView.findViewById(R.id.nome_da_lista);
        final TextView listaId = (TextView)itemView.findViewById(R.id.lista_id);
        final ImageView listaCapa = (ImageView)itemView.findViewById(R.id.capa_lista);

        //OnClickListener
        listaCapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get car title text.
                String id = listaNome.getText().toString();
                // Create a snackbar and show it.
                Toast.makeText(v.getContext(), id,Toast.LENGTH_SHORT).show();
                //parent.getContext resolve o problema de contexto do fragment
                Intent intent = new Intent(parent.getContext(), FilmesNaListaActivity.class);
                Bundle bd = new Bundle();


/*
                int n = indexOf(Integer.parseInt(receitaId.getText().toString()),receitaItemList);

                Log.d(TAG, "onClick "+receitaId.getText().toString());
                Log.d(TAG, "onClick1: "+receitaItemList.indexOf(receitaId.getText()));
*/


                bd.putInt("id_lista", Integer.parseInt(listaId.getText().toString()));
                intent.putExtras(bd);


                listaCapa.getContext().startActivity(intent);

            }
        });




        ListaFilmesViewHolder ret = new ListaFilmesViewHolder(itemView);

        return ret;
    }

    @Override
    public void onBindViewHolder(ListaFilmesViewHolder holder, int position) {
        holder.listaNomeHolder.setText(listaFilmesItems.get(position).getNome());
        holder.listaidHolder.setText(Integer.toString(listaFilmesItems.get(position).getIdLista()));
        holder.listaCapaHolder.setImageResource(listaFilmesItems.get(position).getCapaListaImg());

    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if(listaFilmesItems!=null) {
            ret = listaFilmesItems.size();
        }
        return ret;
    }

    public class ListaFilmesViewHolder extends RecyclerView.ViewHolder {
        TextView listaNomeHolder;
        TextView listaidHolder;
        ImageView listaCapaHolder;


        ListaFilmesViewHolder(View view) {
            super(view);
            listaNomeHolder = (TextView) view.findViewById(R.id.nome_da_lista);
            listaidHolder = (TextView) view.findViewById(R.id.lista_id);
            listaCapaHolder = (ImageView) view.findViewById(R.id.capa_lista);
        }
    }




}
