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
    private EditText mText;
    private EditText mColor;
    private List<RankingData> mData = new ArrayList<>();

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
        textView = (TextView) layout.findViewById(R.id.position);
        Bundle bundle = getArguments();
        inicializaNavigationDrawer(layout);
        if (bundle != null) {
            textView.setText("The Page Selected Is " + bundle.getInt("position"));
            Log.d("André","Adicionando Cor");
            RankingData dataToAdd = new RankingData("Bla", "FF00e5");
            addItem(dataToAdd);
        }


        return layout;
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
    public void addItem(RankingData dataToAdd) {

        // Add data locally to the list.

        mData.add(dataToAdd);

        // Update adapter.
        mAdapter.addItem(mData.size()-1, dataToAdd);
    }
}
