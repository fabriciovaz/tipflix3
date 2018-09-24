package tipflix.com.projeto.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import tipflix.com.projeto.R;

public class GridFilmeListaActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_filme_lista);

        mainGrid = (GridLayout)findViewById(R.id.mainGrid);

        //Definir evento
        // setSingleEvent(mainGrid);

        setToggleEvent(mainGrid);

    }

    private void setToggleEvent(GridLayout mainGrid) {
        // dá um loop em todos os itens filhos da grade principal
        for (int i =0;i<mainGrid.getChildCount();i++){

            // você pode ver, cada item filho é linear layout, então apenas passamos objeto para linearLayout
            final LinearLayout linearLayout = (LinearLayout) mainGrid.getChildAt(i);
            final int finalI = i;


            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(GridFilmeListaActivity.this,"clicado no índice:"+ finalI,Toast.LENGTH_SHORT).show();
                    Bundle b1 = new Bundle();
                   // b1.putInt("a",1);
                    Intent intent2 = new Intent(GridFilmeListaActivity.this, MainActivity.class);
                    startActivity(intent2);

                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid) {
        // dá um loop em todos os itens filhos da grade principal
        for (int i =0;i<mainGrid.getChildCount();i++){


            // você pode ver, todo item filho é cardview, então apenas passamos objeto para cardview
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // aqui você pode substituir o torrado com start new activity code
                    Toast.makeText(GridFilmeListaActivity.this,"clicado no indice"+ finalI,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
