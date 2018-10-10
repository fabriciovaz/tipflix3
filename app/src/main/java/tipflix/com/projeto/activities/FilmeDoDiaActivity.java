package tipflix.com.projeto.activities;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import tipflix.com.projeto.R;

public class FilmeDoDiaActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String DEVELOPER_KEY = "AIzaSyA_ZQiqee0d3SYOqSUZ1rNR2-FAMXjQeCw";//chave do desenvolvedor
    private static final String VIDEO_ID = "4V44ew-laC4";
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    private int aleatorio;
    YouTubePlayerFragment myYouTubePlayerFragment;

    TextView dataatual;
    private TextView textoNovaFrase;

    private final String liveVideoId = "2ccaHpy5Ewo";

    private String[] filmesIds = {"90bG43JcwRE", "30BIAM8pyto","LKegxGRTYX0","JhY6Yy4wtb4", "xLCn88bfW1o","4V44ew-laC4","2ccaHpy5Ewo"

    };

    private String[] frases = {
            "Não te abras com teu amigo, Que ele um outro amigo tem, E o amigo do teu amigo Possui amigos também...\n" +
                    "Mario Quintana",
            "Tente mover o mundo - o primeiro passo será mover a si mesmo.\n" +

                    "Platão",
            "O importante não é vencer todos os dias, mas lutar sempre.\n" +
                    "\n" +
                    "Waldemar Valle Martins\n" +
                    "   ",
            "Aquele que não tem confiança nos outros, não lhes pode ganhar a confiança.\n" +
                    "\n" +
                    "Lao-Tsé",
            "Se você pretende ser rico, pense em economizar tanto quanto em ganhar.\n" +
                    "\n" +
                    "Benjamin Franklin",
            "De que serve ao homem conquistar o mundo inteiro se perder a alma?\n" +
                    "\n" +
                    "Jesus Cristo",
            "Quer você acredite que consiga fazer uma coisa ou não, você está certo.\n" +
                    "\n" +
                    "Henry Ford"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_do_dia);

        myYouTubePlayerFragment = (YouTubePlayerFragment)getFragmentManager()
                .findFragmentById(R.id.youtubeplayerfragment);
        myYouTubePlayerFragment.initialize(DEVELOPER_KEY, FilmeDoDiaActivity.this);







        dataatual = (TextView) findViewById(R.id.dataatual);
        String currentDateTimeString = DateFormat.getDateInstance().format(new Date());
        dataatual.setText(currentDateTimeString);

        textoNovaFrase = (TextView) findViewById(R.id.textoNovaFrase);
        //Instanciar o Random
        Random randomico = new Random();

        //Informar a quantidade de posições pelo tamanho do Array de forma automática
        aleatorio = randomico.nextInt(frases.length);


        //Mostar o texto usando o nome do Array e o comando de número aleatório
        textoNovaFrase.setText(frases[aleatorio]);


    }


    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    "There was an error initializing the YouTubePlayer (%1$s)",
                    errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                        boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo(filmesIds[aleatorio]);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Repetir a inicialização se o usuário tiver executado uma ação de recuperação
            getYouTubePlayerProvider().initialize(DEVELOPER_KEY, this);
        }
    }
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView)findViewById(R.id.youtubeplayerfragment);


    }
}




