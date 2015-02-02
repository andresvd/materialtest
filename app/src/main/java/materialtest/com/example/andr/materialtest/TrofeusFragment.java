package materialtest.com.example.andr.materialtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by André on 02/02/2015.
 */
public class TrofeusFragment extends Fragment {

    public List<MissaoData> mMissoes = new ArrayList<>();

    public static TrofeusFragment getInstance(int position) {
        TrofeusFragment fragment = new TrofeusFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);

        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d("André", "Inicializando fragment");
        View layout = inflater.inflate(R.layout.fragment_trofeus, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.getInt("position") == 0){
                layout = inflater.inflate(R.layout.fragment_trofeus, container, false);
            }
            else if (bundle.getInt("position") == 1){
                layout = inflater.inflate(R.layout.fragment_missoes, container, false);
                Log.d("André", "Cheguei até aqui");
                //mudaTextViewsMissoes(layout);
            }
        }
        return layout;
    }

    public void fazMissoes(){
        MissaoData missao = new MissaoData("Centenário do ônibus", "Ande um total de 100 quilômetros de ônibus", 100);
        mMissoes.add(missao);
    }

    public void mudaTextViewsMissoes(View layout){

        ViewGroup parent = (ViewGroup) layout.findViewById(R.id.lista_missoes);

        for (int i =  0; i < parent.getChildCount(); i++){
            View missao = parent.getChildAt(i);
            TextView titulo = (TextView) missao.findViewById(R.id.missaoTitulo);
            titulo.setText("AAAAAAAAAAAA");
            TextView descricao = (TextView) missao.findViewById(R.id.missaoDescricao);
            descricao.setText("Mudei a descrição aqui!");
            TextView pontuacao = (TextView) missao.findViewById(R.id.pontuacao);
            pontuacao.setText("500 pontos");
        }
    }


}
