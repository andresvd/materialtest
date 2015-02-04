package materialtest.com.example.andr.materialtest;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by André on 02/02/2015.
 */
public class TrofeusFragment extends Fragment {

    public List<MissaoData> mMissoes = new ArrayList<>();
    private ImageView trofeu1;
    private ImageView trofeu2;
    private ImageView trofeu3;
    private ImageView trofeu4;
    private ImageView trofeu5;
    private ImageView trofeu6;

    public View layout;
    public static TrofeusFragment getInstance(int position) {
        TrofeusFragment fragment = new TrofeusFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);

        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d("André", "Inicializando fragment");
        layout = inflater.inflate(R.layout.fragment_trofeus, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.getInt("position") == 0){
                layout = inflater.inflate(R.layout.fragment_trofeus, container, false);
                setClickListenersTrofeus();

            }
            else if (bundle.getInt("position") == 1){
                layout = inflater.inflate(R.layout.fragment_missoes, container, false);
                Log.d("André", "Cheguei até aqui");
                fazMissoes();
                mudaTextViewsMissoes(layout);
            }
        }
        return layout;
    }

    public void setClickListenersTrofeus(){

        trofeu1 = (ImageView) layout.findViewById(R.id.trofeu1);
        trofeu2 = (ImageView) layout.findViewById(R.id.trofeu2);
        trofeu3 = (ImageView) layout.findViewById(R.id.trofeu3);
        trofeu4 = (ImageView) layout.findViewById(R.id.trofeu4);
        trofeu5 = (ImageView) layout.findViewById(R.id.trofeu5);
        trofeu6 = (ImageView) layout.findViewById(R.id.trofeu6);



        trofeu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("Ubiusuário", "Você é um bom usuário! Já realizou mais de 20 rotas e por isso merece este troféu. Continue buscando novas rotas e sua recompensa será ainda maior!", R.drawable.medal_icon);
            }
        });

        trofeu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("Triatlo", "Você é basicamente um atleta olímpico! Utilizou metrô, ônibus e bicicleta em um intervalo de menos de 24 horas. Assim você cuida da saúde do planeta e da sua.", R.drawable.medal_2);
            }
        });

        trofeu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("Twitteiro", "Seus amigos do twitter agora já sabem onde encontrar a app que te ajuda a se mover por esta cidade. Por isso, esta é sua recompensa. Só cuidado para eles não ultrapassarem sua pontuação!", R.drawable.medal_twitter);
            }
        });

        trofeu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("Pop no face", "Seus amigos do facebook agora já sabem como você sempre chega cedo nos lugares! Por suas postagens, a concorrência agora fica mais acirrada.", R.drawable.face);
            }
        });

        trofeu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("Salvador de CO2", "Utilizando transporte público, você diminui a emissão de CO2 e contribui para a minimização da poluição. Andando fora dos horários de pico, você ainda economiza tempo e a viagem flui mais tranquila", R.drawable.bus_medal);
            }
        });

        trofeu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("Coruja!", "Assim como as corujas, você prefere sair e apreciar a beleza da cidade à noite.", R.drawable.owl);
            }
        });
    }

    public void showDialog(String titulo, String descricao, int drawableIcon){
        MaterialDialog materialDialog = new MaterialDialog.Builder(getActivity()).title(titulo)
                .content(descricao)
                .positiveText(R.string.ok)
                .iconRes(drawableIcon).positiveColor(R.color.primaryColor)
                .show();
    }

    public void fazMissoes(){
        adicionaMissao("Centenário do ônibus", "Ande um total de 100 km de ônibus", 200);
        adicionaMissao("Triatlo", "Use os três modais de transporte (bicicleta, ônibus e metrô) em menos de 24 horas", 100);
        adicionaMissao("Subterrâneo", "Percorra um total de 200km em metrô", 200);
        adicionaMissao("Twitteiro", "Divulgue o Ubitrans no twitter", 50);
        adicionaMissao("Ciclista", "Percorra um total de 100 km de bicicleta", 200);
        adicionaMissao("Coruja!", "Percorrer um total de 100 km depois das 21 horas", 200);
        adicionaMissao("Subterrâneo", "Percorra um total de 200km em metrô", 200);
        adicionaMissao("Salvador de CO2", "Percorra um total de 500km fora dos horários de pico", 750);
        adicionaMissao("Subterrâneo", "Percorra um total de 200km em metrô", 200);
        adicionaMissao("Ubiusuário", "Realize 20 rotas no Ubitrans", 200);
        adicionaMissao("Subterrâneo", "Percorra um total de 200km em metrô", 200);
        adicionaMissao("Número 1", "Passe ao menos uma semana sendo o primeiro lugar no ranking entre seus amigos", 100);
        adicionaMissao("Ubifidelidade", "Use o Ubitrans por 30 dias", 250);
        adicionaMissao("Subterrâneo", "Percorra um total de 200km em metrô", 200);
        adicionaMissao("Rapidez ligeira", "Percorra 20 rotas fazendo um tempo mais curto que o estimado inicialmente", 300);
    }

    private void adicionaMissao(String titulo, String descricao, int pontuacao) {
        MissaoData missao = new MissaoData(titulo, descricao, pontuacao);
        mMissoes.add(missao);
    }

    public void mudaTextViewsMissoes(View layout){

        ViewGroup parent = (ViewGroup) layout.findViewById(R.id.lista_missoes);
        View missao = null;
        MissaoData missaoData = null;
        for (int i =  0; i < parent.getChildCount(); i++){
            missao = parent.getChildAt(i);
            missaoData = mMissoes.get(i);
            TextView titulo = (TextView) missao.findViewById(R.id.missaoTitulo);
            titulo.setText(missaoData.titulo);
            TextView descricao = (TextView) missao.findViewById(R.id.missaoDescricao);
            descricao.setText(missaoData.descricao);
            TextView pontuacao = (TextView) missao.findViewById(R.id.missaoPontuacao);
            pontuacao.setText(new StringBuilder().append(missaoData.pontuacao).append(" pts"));
        }
    }


}
