package materialtest.com.example.andr.materialtest;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;


public class FeedbackActivity extends ActionBarActivity {
    private Toolbar toolbar;
    Button buttonRanking;
    Button buttonSair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        buttonRanking = (Button) findViewById(R.id.buttonRanking);
        buttonRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FeedbackActivity.this, TabsRanking.class);
                startActivity(intent);
            }
        });

        buttonSair = (Button) findViewById(R.id.buttonSair);
        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FeedbackActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        this.showDialog("Parabéns! Você ganhou o troféu Salvador de CO2 Ouro", "Depois de muito chão, você finalmente atingiu o ouro! Foram 500 km rodados fora do horário de pico, o que fez suas viagens serem mais rápidas e tranquilas, além de ajudar o meio ambiente! Com isso, você ganhou 750 pontos extras!", R.drawable.bus_medal);


    }


    public void showDialog(String titulo, String descricao, int drawableIcon){
        MaterialDialog materialDialog = new MaterialDialog.Builder(this).title(titulo)
                .content(descricao)
                .positiveText(R.string.ok)
                .iconRes(drawableIcon).positiveColorRes(R.color.primaryColor)
                .show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_feedback, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
