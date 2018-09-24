package tipflix.com.projeto;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import Adapter.MovieAdapter;
import Common.Common;
import Model.Movie;
import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import tipflix.com.projeto.activities.MovieDetail;


import android.util.Log;

import java.util.List;

import Api.RetrofitConfig;
import Api.Service;
import Model.Pojo;
import Model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviePageFragment extends Fragment {

    public static MoviePageFragment newInstance() {
        MoviePageFragment fragment = new MoviePageFragment();
        return fragment;
    }

    public static int PAGE = 1;
    //public static String API_KEY = "0138389c9cb33b3d807451c0822a9bbb";
    public static String API_KEY = "51b19cc78e37eba81f64faf6b072637f";
    public static String LANGUAGE = "pt-BR";
    public static String CATEGORY = "now_playing";
    public static String CATEGORY_1 = "popular_movies";
    public static String CATEGORY_2 = "top_rated";
    public static String CATEGORY_3 = "upcoming";
    public static String REGION = "BR";
    public View v;
    public List<Result> listResults;
    public List<Result> listResults1;
    String path = "https://image.tmdb.org/t/p/w780";
    public List<Movie> listaFilmesCopiaApi;
    public String imagemPoster;


    FeatureCoverFlow coverFlow;
    MovieAdapter adapter;
    TextSwitcher mTitle;
    private FrameLayout fragmentContainer;


    public MoviePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_movie_page, container, false);
        fragmentContainer = (FrameLayout) v.findViewById(R.id.fragment_movie_page_1);

        //*****************API********************
        initData();

        Service service = RetrofitConfig.getClient().create(Service.class);
        Call<Pojo> call = service.getMovies(CATEGORY, API_KEY,LANGUAGE,PAGE,REGION);
       // Call<Pojo> call1 = service.getMovies(CATEGORY_2, API_KEY,LANGUAGE,PAGE,REGION);


        call.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                //A resposta da API é armazenada no pojo
                Pojo pojo = response.body();


                //Ligação entre a API e a lista que é utilizada no recycler
                listResults = pojo.getResults();
                Log.d("Deu certo", listResults.get(0).toString());

                //um for para colocar as informações de cada Result da lista dentro da  movie list

                for( Result resultIndice : listResults )
                {
                    if (resultIndice.getBackdropPath()==null){
                imagemPoster="https://solier.com.ua/image/cache/no_image-800x800.png";
                    }else {
                        imagemPoster=path+resultIndice.getBackdropPath();
                    }
                    Common.movieList.add(new Movie(resultIndice.getTitle(),imagemPoster,resultIndice.getOverview()));

                }
            }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {
                Log.d("Falha", t.getMessage());
            }
        });



        //************




        adapter = new MovieAdapter(Common.movieList, getContext());
        coverFlow = (FeatureCoverFlow)v.findViewById(R.id.coverFlow);
        mTitle = (TextSwitcher)v.findViewById(R.id.mtitle);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                TextView text = (TextView)inflater.inflate(R.layout.layout_title,null);
                return text;
            }
        });
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(Common.movieList.get(position).getTitle());

            }

            @Override
            public void onScrolling() {

            }
        });
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle b = new Bundle();
                b.putInt("a",i);
                Intent intent = new Intent(getContext(),MovieDetail.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        return v;




    }


    /**
     * Called when a fragment will be displayed
     */
    public void willBeDisplayed() {
        // Do what you want here, for example animate the content
        if (fragmentContainer != null) {
            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
            fragmentContainer.startAnimation(fadeIn);
        }
    }

    /**
     * Called when a fragment will be hidden
     */
    public void willBeHidden() {
        if (fragmentContainer != null) {
            Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
            fragmentContainer.startAnimation(fadeOut);
        }

    }




    private void initData() {
        Common.movieList.add(new Movie("Batman vs Superman","https://www.kveller.com/wp-content/uploads/2016/05/BATMAN-SUPERMAN.jpg","O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
        Common.movieList.add(new Movie("Mulher Maravilha","https://i.ytimg.com/vi/Xq-El--5qjI/maxresdefault.jpg","Treinada desde cedo para ser uma guerreira imbatível, Diana Prince nunca saiu da paradisíaca ilha em que é reconhecida como princesa das Amazonas. Quando o piloto Steve Trevor se acidenta e cai em uma praia do local, ela descobre que uma guerra sem precedentes está se espalhando pelo mundo e decide deixar seu lar certa de que pode parar o conflito. Lutando para acabar com todas as lutas, Diana percebe o alcance de seus poderes e sua verdadeira missão na Terra."));
        Common.movieList.add(new Movie("Capitão América: Guerra Civil","https://i1.wp.com/melhoresdomundo.net/wp-content/uploads/2015/05/civilwar.jpg","O ataque de Ultron faz com que os políticos decidam controlar os Vingadores, já que seus atos afetam toda a humanidade. Tal decisão coloca o Capitão América em rota de colisão com o Homem de Ferro."));
        Common.movieList.add(new Movie("Homem-Aranha","https://www.meridionalfm.com.br/midia/noticias/not_203e3c6f949dc4b364231c675ff99ddc.png","Depois de ser picado por uma aranha geneticamente modificada, Peter Parker ganha super poderes e as habilidades da aranha para se agarrar a qualquer superfície. Ele promete usá-los para combater o crime e começa a entender as palavras de seu querido tio Ben: com grandes poderes vêm grandes responsabilidades."));
        Common.movieList.add(new Movie("X-Men: Dias de Um Futuro Esquecido","https://www.blahcultural.com/wp-content/uploads/2014/10/x-men.jpg","Convencido de que os mutantes são uma ameaça para a humanidade, o Dr. Bolivar Trask desenvolve os Sentinelas, gigantescos robôs, que os perseguem impiedosamente. Os poucos sobreviventes têm que viver escondidos. Entre eles está Wolverine, que viaja no tempo, rumo aos anos 1970, a fim de impedir que este futuro trágico para os mutantes se torne realidade."));

    }


}




/*
package tipflixcoverflowitemclick.com.tipflixcoverflowitemclick;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.List;

import Adapter.AdapterCategory;
import Adapter.MovieAdapter;
import Api.RetrofitConfig;
import Api.Service;
import Common.Common;
import Model.Movie;
import Model.Pojo;
import Model.Result;
import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tipflixcoverflowitemclick.com.tipflixcoverflowitemclick.activities.MovieDetail;

import static android.provider.ContactsContract.CommonDataKinds.StructuredPostal.REGION;
import static android.provider.MediaStore.Video.VideoColumns.CATEGORY;
import static android.provider.MediaStore.Video.VideoColumns.LANGUAGE;


*/
/**
 * A simple {@link Fragment} subclass.
 *//*

public class MoviePageFragment extends Fragment {

    public static MoviePageFragment newInstance() {
        MoviePageFragment fragment = new MoviePageFragment();
        return fragment;
    }
    public static int PAGE = 1;
    //public static String API_KEY = "0138389c9cb33b3d807451c0822a9bbb";
    public static String API_KEY = "51b19cc78e37eba81f64faf6b072637f";
    public static String LANGUAGE = "pt-BR";
    public static String CATEGORY = "now_playing";
    public static String REGION = "BR";
    public View v;
    public List<Result> listResults;

    FeatureCoverFlow coverFlow;
    MovieAdapter adapter;
    TextSwitcher mTitle;
    private FrameLayout fragmentContainer;


    public MoviePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_movie_page, container, false);
        fragmentContainer = (FrameLayout) v.findViewById(R.id.fragment_movie_page_1);
        Service service = RetrofitConfig.getClient().create(Service.class);
        Call<Pojo> call = service.getMovies(CATEGORY, API_KEY,LANGUAGE,PAGE,REGION);


        call.enqueue(new Callback<Pojo>() {
                         @Override
                         public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                             //A resposta da API é armazenada no pojo
                             Pojo pojo = response.body();


                             //Ligação entre a API e a lista que é utilizada no recycler
                             listResults = pojo.getResults();
                             Log.i("Deu certo", listResults.get(0).toString());

                             //um for para colocar as informações de cada Result da lista dentro da  movie list
                             for( Result resultIndice : listResults )
                             {
                                 Common.movieList.add(new Movie(resultIndice.getTitle(),resultIndice.getBackdropPath(),resultIndice.getOverview()));
                             }
                         }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {
                Log.i("Falha", t.getMessage());
            }
        });

                             //A lista movie list devidamente preenchida com os valore dos results é passada para o adapter do cover flow
                             //initData(); Por isso não usamos esse método!
                             adapter = new MovieAdapter(Common.movieList, getContext());
                             coverFlow = (FeatureCoverFlow)v.findViewById(R.id.coverFlow);
                             mTitle = (TextSwitcher)v.findViewById(R.id.mtitle);
                             mTitle.setFactory(new ViewSwitcher.ViewFactory() {
                                 @Override
                                 public View makeView() {
                                     LayoutInflater inflater = LayoutInflater.from(getContext());
                                     TextView text = (TextView)inflater.inflate(R.layout.layout_title,null);
                                     return text;
                                 }
                         });


        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                //configura o titulo
                mTitle.setText(Common.movieList.get(position).getTitle());

            }
            @Override
            public void onScrolling() {

            }
        });


        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle b = new Bundle();
                b.putInt("a",i);
                Intent intent = new Intent(getContext(),MovieDetail.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        return v;
    }


    */
/**
     * Called when a fragment will be displayed
     *//*

    public void willBeDisplayed() {
        // Do what you want here, for example animate the content
        if (fragmentContainer != null) {
            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
            fragmentContainer.startAnimation(fadeIn);
        }
    }

    */
/**
     * Called when a fragment will be hidden
     *//*

    public void willBeHidden() {
        if (fragmentContainer != null) {
            Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
            fragmentContainer.startAnimation(fadeOut);
        }

    }




    private void initData() {
        Common.movieList.add(new Movie("Batman vs Superman","https://www.kveller.com/wp-content/uploads/2016/05/BATMAN-SUPERMAN.jpg","O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
        Common.movieList.add(new Movie("Mulher Maravilha","https://i.ytimg.com/vi/Xq-El--5qjI/maxresdefault.jpg","Treinada desde cedo para ser uma guerreira imbatível, Diana Prince nunca saiu da paradisíaca ilha em que é reconhecida como princesa das Amazonas. Quando o piloto Steve Trevor se acidenta e cai em uma praia do local, ela descobre que uma guerra sem precedentes está se espalhando pelo mundo e decide deixar seu lar certa de que pode parar o conflito. Lutando para acabar com todas as lutas, Diana percebe o alcance de seus poderes e sua verdadeira missão na Terra."));
        Common.movieList.add(new Movie("Capitão América: Guerra Civil","https://i1.wp.com/melhoresdomundo.net/wp-content/uploads/2015/05/civilwar.jpg","O ataque de Ultron faz com que os políticos decidam controlar os Vingadores, já que seus atos afetam toda a humanidade. Tal decisão coloca o Capitão América em rota de colisão com o Homem de Ferro."));
        Common.movieList.add(new Movie("Homem-Aranha","https://www.meridionalfm.com.br/midia/noticias/not_203e3c6f949dc4b364231c675ff99ddc.png","Depois de ser picado por uma aranha geneticamente modificada, Peter Parker ganha super poderes e as habilidades da aranha para se agarrar a qualquer superfície. Ele promete usá-los para combater o crime e começa a entender as palavras de seu querido tio Ben: com grandes poderes vêm grandes responsabilidades."));
        Common.movieList.add(new Movie("X-Men: Dias de Um Futuro Esquecido","https://www.blahcultural.com/wp-content/uploads/2014/10/x-men.jpg","Convencido de que os mutantes são uma ameaça para a humanidade, o Dr. Bolivar Trask desenvolve os Sentinelas, gigantescos robôs, que os perseguem impiedosamente. Os poucos sobreviventes têm que viver escondidos. Entre eles está Wolverine, que viaja no tempo, rumo aos anos 1970, a fim de impedir que este futuro trágico para os mutantes se torne realidade."));

    }


}
*/
