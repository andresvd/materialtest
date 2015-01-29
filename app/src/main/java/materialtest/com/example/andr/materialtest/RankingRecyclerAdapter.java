package materialtest.com.example.andr.materialtest;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by André on 22/01/2015.
 */
public class RankingRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<RankingData> mData = new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;

    public RankingRecyclerAdapter(Context context) {
        // Pass context or other static stuff that will be needed.
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.mData = new ArrayList<>();

        addItem(0, new RankingData("Oi", "#FFFDDD"));
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int position) {
        viewHolder.title.setText(mData.get(position).text);
        Log.d("André", "O dado da posiçao é "+mData.get(position).color);
        viewHolder.icon.setBackgroundColor(Color.parseColor(mData.get(position).color));
        //MaterialDialog.Builder()
        viewHolder.setClickListener(new RecyclerViewHolder.ClickListener() {
            @Override
            public void onClick(View v, int pos, boolean isLongClick) {
                if (isLongClick) {
                    // View v at position pos is long-clicked.
                    Log.d("André", "Long Click!");
                } else {
                    // View v at position pos is clicked.
                    Log.d("André", "Short Click!");
                    //Typeface newFont = Typeface.createFromAsset(context.getAssets(), "fonts/myFont.tff");

                    /*MaterialDialog materialDialog = new MaterialDialog.Builder(context).title(context.getString(R.string.medalha_titulo_centenario_onibus))
                            .content(context.getString(R.string.medalha_corpo_centenario_onibus))
                            .positiveText(R.string.ok)
                            .iconRes(R.drawable.medal_icon).positiveColor(R.color.primaryColor)
                            .show();*/




                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateList(List<RankingData> data) {
        mData = data;
        notifyDataSetChanged();
    }

    public void addItem(int position, RankingData data) {
        Log.d("André", "Adapter adicionou a nova cor");
        mData.add(position, data);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }

}
