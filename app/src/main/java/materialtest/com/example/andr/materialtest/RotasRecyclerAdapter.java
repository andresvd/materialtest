package materialtest.com.example.andr.materialtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by André on 28/01/2015.
 */
public class RotasRecyclerAdapter extends RecyclerView.Adapter<RotasRecyclerViewHolder>{
    private List<RotasData> mData = new ArrayList<>();


    @Override
    public RotasRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.escolha_rota_item, parent, false);

        return new RotasRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RotasRecyclerViewHolder holder, int position) {
        holder.passos.setText(mData.get(position).passos);
        holder.duracaoRota.setText(mData.get(position).duracaoRota);
        holder.preco.setText(mData.get(position).preco);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public RotasRecyclerAdapter(){
        mData.add(new RotasData("- Primeiro faz isso\n- Depois aquilo\n- Depois aquilo lá", "60 min", "R$2,45"));
        mData.add(new RotasData("- Primeiro faz isso\n- Depois aquilo\n- Depois aquilo lá", "60 min", "R$2,45"));


        mData.add(new RotasData("- Primeiro faz isso\n- Depois aquilo\n- Depois aquilo lá", "60 min", "R$2,45"));
    }


}


