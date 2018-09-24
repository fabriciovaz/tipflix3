package tipflix.com.projeto.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.FilmesAdapter;
import Model.FilmesItem;
import tipflix.com.projeto.R;

public class FilmesNaListaActivity extends AppCompatActivity {

    private List<FilmesItem> filmesItems = null;
    static int ID = 0;
    int idLista=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flimes_na_lista);

        Intent intent = getIntent();
        //int movie_index = intent.getExtras().getInt();
        Bundle bd = getIntent().getExtras();
        // int movie_index = intent.getExtras("movie_index");
        int  idLista = bd.getInt("id_lista",1);


        inicializaItens(idLista);
        RecyclerView FilmesRecyclerView = (RecyclerView)  findViewById(R.id.recycler_filmes_na_lista);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        FilmesRecyclerView.setLayoutManager(gridLayoutManager);
        FilmesAdapter filmeDataAdapter = new FilmesAdapter(filmesItems);
        FilmesRecyclerView.setAdapter(filmeDataAdapter);

    }

    private void inicializaItens(int id){

        if(filmesItems == null){
            switch (id){
                case 1:
                    filmesItems = new ArrayList<FilmesItem>();

                    filmesItems.add(new FilmesItem("filme1",R.drawable.batman,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.arqueiroverde,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.esquadraosuicida,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.vdevinganca,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));

                    break;

                case 2:
                    filmesItems = new ArrayList<FilmesItem>();

                    filmesItems.add(new FilmesItem("filme1",R.drawable.batman,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.arqueiroverde,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.esquadraosuicida,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.vdevinganca,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));

                    break;

                case 3:
                    filmesItems = new ArrayList<FilmesItem>();

                    filmesItems.add(new FilmesItem("filme1",R.drawable.batman,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.arqueiroverde,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.esquadraosuicida,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.vdevinganca,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));

                    break;

                case 4:
                    filmesItems = new ArrayList<FilmesItem>();

                    filmesItems.add(new FilmesItem("filme1",R.drawable.batman,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.arqueiroverde,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.esquadraosuicida,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.vdevinganca,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    break;

                case 5:
                    filmesItems = new ArrayList<FilmesItem>();

                    filmesItems.add(new FilmesItem("filme1",R.drawable.batman,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.arqueiroverde,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.esquadraosuicida,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.vdevinganca,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    break;

                case 6:
                    filmesItems = new ArrayList<FilmesItem>();

                    filmesItems.add(new FilmesItem("filme1",R.drawable.batman,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.arqueiroverde,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.esquadraosuicida,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.vdevinganca,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    break;

                case 7:
                    filmesItems = new ArrayList<FilmesItem>();

                    filmesItems.add(new FilmesItem("filme1",R.drawable.batman,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.arqueiroverde,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.esquadraosuicida,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.vdevinganca,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    break;

                case 8:
                    filmesItems = new ArrayList<FilmesItem>();

                    filmesItems.add(new FilmesItem("filme1",R.drawable.batman,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.arqueiroverde,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.esquadraosuicida,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.vdevinganca,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    break;

                case 9:
                    filmesItems = new ArrayList<FilmesItem>();

                    filmesItems.add(new FilmesItem("filme1",R.drawable.batman,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.arqueiroverde,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.esquadraosuicida,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    filmesItems.add(new FilmesItem("filme1",R.drawable.vdevinganca,geradorId(),"O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
                    break;

            }

            filmesItems = new ArrayList<FilmesItem>();

            filmesItems.add(new FilmesItem("filme1",R.drawable.batman,geradorId()));
            filmesItems.add(new FilmesItem("filme1",R.drawable.esquadraosuicida,geradorId()));
            filmesItems.add(new FilmesItem("filme1",R.drawable.vdevinganca,geradorId()));
            filmesItems.add(new FilmesItem("filme1",R.drawable.hitman,geradorId()));
            filmesItems.add(new FilmesItem("filme1",R.drawable.capitanamerica,geradorId()));
            filmesItems.add(new FilmesItem("filme1",R.drawable.hitman,geradorId()));
            filmesItems.add(new FilmesItem("filme1",R.drawable.capitanamerica,geradorId()));
            filmesItems.add(new FilmesItem("filme1",R.drawable.hitman,geradorId()));


       }
    }

    public int geradorId(){
        ID++;
        return ID;
    }
}





