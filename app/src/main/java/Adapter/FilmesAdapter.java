package Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Model.FilmesItem;
import tipflix.com.projeto.R;
import tipflix.com.projeto.activities.GridFilmeListaActivity;

public class FilmesAdapter extends RecyclerView.Adapter<FilmesAdapter.FilmesViewHolder> {

    private List<FilmesItem> FilmesItems;

    public FilmesAdapter(List<FilmesItem> FilmesItems) {
        this.FilmesItems = FilmesItems;
    }

    @Override
    public FilmesViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the RecyclerView item layout xml.
        View itemView = layoutInflater.inflate(R.layout.filmes_item, parent, false);

        //As views são associadas aos seus objetos pelo Id
        final TextView Nome = (TextView)itemView.findViewById(R.id.nome_filme);
        final TextView Id = (TextView)itemView.findViewById(R.id.id_do_filme);
        final ImageView poster = (ImageView)itemView.findViewById(R.id.poster_1);

        //OnClickListener
        poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get car title text.
                String id = Nome.getText().toString();
                // Create a snackbar and show it.
                Toast.makeText(v.getContext(), id,Toast.LENGTH_SHORT).show();
                //parent.getContext resolve o problema de contexto do fragment
                Intent intent = new Intent(parent.getContext(), GridFilmeListaActivity.class);
                Bundle bd = new Bundle();


               /* int n = indexOf(Integer.parseInt(receitaId.getText().toString()),receitaItemList);

                Log.d(TAG, "onClick "+receitaId.getText().toString());
                Log.d(TAG, "onClick1: "+receitaItemList.indexOf(receitaId.getText()));


                bd.putInt("imagem", receitaItemList.get(n).getImagemId());
                intent.putExtras(bd);*/

                poster.getContext().startActivity(intent);

            }
        });




        FilmesViewHolder ret = new FilmesViewHolder(itemView);

        return ret;
    }

    @Override
    public void onBindViewHolder(FilmesViewHolder holder, int position) {
        holder.NomeHolder.setText(FilmesItems.get(position).getNomeFilme ());
        holder.idHolder.setText(Integer.toString(FilmesItems.get(position).getId()));
        holder.posterHolder.setImageResource(FilmesItems.get(position).getPoster());

    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if(FilmesItems!=null) {
            ret = FilmesItems.size();
        }
        return ret;
    }

    public class FilmesViewHolder extends RecyclerView.ViewHolder {
        TextView NomeHolder;
        TextView idHolder;
        ImageView posterHolder;


        FilmesViewHolder(View view) {
            super(view);
            NomeHolder = (TextView) view.findViewById(R.id.nome_filme);
            idHolder = (TextView) view.findViewById(R.id.id_do_filme);
            posterHolder = (ImageView) view.findViewById(R.id.poster_1);
        }
    }




}
