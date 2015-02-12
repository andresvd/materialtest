package materialtest.com.example.andr.materialtest;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * create an instance of this fragment.
 */
public class MyFragment extends Fragment {
    private TextView textView;
    private RecyclerView mRecyclerView;
    private RankingRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<RankingData> mDataAmigos = new ArrayList<>();

    public static MyFragment getInstance(int position) {
        MyFragment myFragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d("André","Inicializando fragment");
        View layout = inflater.inflate(R.layout.fragment_my, container, false);
        textView = (TextView) layout.findViewById(R.id.position2);
        Bundle bundle = getArguments();
        inicializaNavigationDrawer(layout);
        if (bundle != null) {
            textView.setText("The Page Selected Is " + bundle.getInt("position"));
            if (bundle.getInt("position") == 0){
                fazRankingAmigos();
            } else if (bundle.getInt("position") == 1){
                fazRankingCidade();
            } else if (bundle.getInt("position") == 2){
                fazRankingGeral();
            }



        }


        return layout;
    }

    public void fazRankingAmigos(){
        Log.d("André","Ranking Amigos");
        RankingData dataToAdd = new RankingData("Alberto Augusto", 5000, R.drawable.einstein_icon, 1);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Marília Muriel", 4500, R.drawable.monroe_icon, 2);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Haroldo Portões", 4250, R.drawable.potter_icon, 3);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Pedro Lyra", 4000, R.drawable.administrator72, 3);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Ricardo Silva", 3500, R.drawable.terminator_icon, 4);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Everaldo Cavalcanti", 3000, R.drawable.elvis_icon, 5);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Charles Hélio", 2589, R.drawable.holmes_icon, 6);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Astro Nauta", 2200, R.drawable.astronaut_icon, 7);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Pizza pizza", 1800, R.drawable.piz_icon, 8);
        addItem(dataToAdd, mDataAmigos);
    }

    public void fazRankingCidade(){
        Log.d("André","Ranking Cidade");
        RankingData dataToAdd = new RankingData("Alguém Qualquer", 5500, R.drawable.homen_icon, 1);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Alberto Augusto", 5000, R.drawable.einstein_icon, 1);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Marília Muriel", 4500, R.drawable.monroe_icon, 2);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Chef Chofer", 4350, R.drawable.chef_icon, 1);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Haroldo Portões", 4250, R.drawable.potter_icon, 3);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Pedro Lyra", 4000, R.drawable.administrator72, 3);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("The Only Terminator", 3500, R.drawable.terminator_icon, 4);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Not Dead", 3000, R.drawable.elvis_icon, 5);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Sherlock Holmes", 2589, R.drawable.holmes_icon, 6);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Rock Star", 2400, R.drawable.music_female_icon, 6);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Astro Nauta", 2200, R.drawable.astronaut_icon, 7);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Pizza pizza", 1800, R.drawable.piz_icon, 8);
        addItem(dataToAdd, mDataAmigos);
    }

    public void fazRankingGeral(){
        Log.d("André","Ranking Geral");
        RankingData dataToAdd = new RankingData("Ronaldo Arthur", 15000, R.drawable.rei_icon, 1);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("José Silva", 5500, R.drawable.homen_icon, 1);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Alberto Augusto", 5000, R.drawable.einstein_icon, 1);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Marília Muriel", 4500, R.drawable.monroe_icon, 2);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Charles Rocha", 4350, R.drawable.chef_icon, 1);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Haroldo Portões", 4250, R.drawable.potter_icon, 3);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Pedro Lyra", 4000, R.drawable.administrator72, 3);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("The Only Terminator", 3500, R.drawable.terminator_icon, 4);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Not Dead", 3000, R.drawable.elvis_icon, 5);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Sherlock Holmes", 2589, R.drawable.holmes_icon, 6);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Rock Star", 2400, R.drawable.music_female_icon, 6);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Romero Saulo", 2350, R.drawable.asian_icon, 6);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Paulo Gomes", 2300, R.drawable.music_male_icon, 6);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Astro Nauta", 2200, R.drawable.astronaut_icon, 7);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Pizza pizza", 1800, R.drawable.piz_icon, 8);
        addItem(dataToAdd, mDataAmigos);
        dataToAdd = new RankingData("Lemony S Nicket", 1200, R.drawable.serduchka_icon, 8);
        addItem(dataToAdd, mDataAmigos);
    }

    public void inicializaNavigationDrawer(View layout){
        //RECYCLER VIEW
        // Initializing views.

        mRecyclerView = (RecyclerView) layout.findViewById(R.id.recyclerRanking);

        if (mRecyclerView == null){
            Log.d("André", "A recyclerview é null!!");
        }

        // If the size of views will not change as the data changes.
        //mRecyclerView.setHasFixedSize(true);

        // Setting the LayoutManager.
        Log.d("André", "A Activity é "+getActivity());
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Setting the adapter.
        mAdapter = new RankingRecyclerAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

    }

    // Called when add button is clicked.
    public void addItem(RankingData dataToAdd, List<RankingData> lista) {

        // Add data locally to the list.

        lista.add(dataToAdd);
        Log.d("André", "Adicionando item!");
        // Update adapter.
        mAdapter.addItem(lista.size()-1, dataToAdd);
    }
}
