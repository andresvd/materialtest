package materialtest.com.example.andr.materialtest;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import materialtest.com.example.andr.materialtest.tabs.SlidingTabLayout;


public class RankingActivity extends ActionBarActivity {

    private ViewPager mPager;
    private SlidingTabLayout mTabs;

    private RecyclerView mRecyclerView;
    private RankingRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private EditText mText;
    private EditText mColor;

    private List<RankingData> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mTabs.setDistributeEvenly(true);
        // Cor do indicador
        mTabs.setSelectedIndicatorColors(getResources().getColor(R.color.accentColor));
        // Cor do background
        mTabs.setBackgroundColor(getResources().getColor(R.color.primaryColor));


        mTabs.setViewPager(mPager);

        //RECYCLER VIEW!
        // Initializing views.
        mText = (EditText) findViewById(R.id.textEt);
        mColor = (EditText) findViewById(R.id.colorEt);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

        if (mRecyclerView == null){
            Log.d("André", "A recyclerview é null!!");
        } else {
            Log.d("André", "Existe sim a recyclerview");
        }

        // If the size of views will not change as the data changes.
        mRecyclerView.setHasFixedSize(true);

        // Setting the LayoutManager.
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Setting the adapter.
        mAdapter = new RankingRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        Log.d("André", "A Activity é "+this);
    }

    // Called when add button is clicked.
    public void addItem(View view) {
        Log.d("André", "Estou adicionando uma nova cor!");
        // Add data locally to the list.
        /*RankingData dataToAdd = new RankingData(
                mText.getText().toString(),
                mColor.getText().toString());
        mData.add(dataToAdd);

        // Update adapter.
        mAdapter.addItem(mData.size()-1, dataToAdd);*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ranking, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private TextView textView;

        public static PlaceholderFragment getInstance(int position){
            PlaceholderFragment mFragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            mFragment.setArguments(args);
            return mFragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                                @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_ranking, container, false);
            textView = (TextView) rootView.findViewById(R.id.tab_position);
            Bundle bundle = getArguments();
            if (bundle!=null){
                textView.setText("The page currently selected is "+bundle.getInt("position"));
            }
            return rootView;
        }
    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        String[] tabs;
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tabs);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public Fragment getItem(int position) {
            PlaceholderFragment myFragment = PlaceholderFragment.getInstance(position);
            return myFragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
