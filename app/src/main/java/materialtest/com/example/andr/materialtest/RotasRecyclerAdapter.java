package materialtest.com.example.andr.materialtest;

import android.app.Activity;
import android.content.Intent;
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
    private Activity activity;

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
        holder.resumoRota.setText(mData.get(position).resumoPassos);
        // LIDAR COM CLICKS
        holder.setClickListener(new RotasRecyclerViewHolder.ClickListener(){

            @Override
            public void onClick(View v, int position, boolean isLongClick) {
                if (!isLongClick){
                    Intent intent = new Intent(activity, PathGoogleMapActivity.class);
                    activity.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public RotasRecyclerAdapter(Activity activity){
        this.activity = activity;
        mData.add(new RotasData("1 - Na parada 020508 pega ônibus 440 (CDU Caxangá/Boa Viagem) \n2 - Ao chegar na praça do Derby, troca para ônibus 042 (Aeroporto) \n3 - Ao chegar na parada 030203 da Av. Guararapes, descer do ônibus e pegar bicicleta\n4 - Pedalar atravessando Ponte Maurício de Nassau\n5 - Virar a primeira à direita, na rua Me. Deus", "60 min", "R$ 4,90", 0, "CDU Caxangá / Boa Viagem - Aeroporto - Bicicleta"));
        mData.add(new RotasData("1 - Na parada 020508 pega ônibus 432 (CDU Várzea)\n2 - Ao chegar na Av. Conde da Boa Vista, parada 090845, descer.\n3 - Pegar bicicleta na estação 210\n4 - Seguir a avenida e atravessar a ponte Capibaribe\n5 - Seguir a Av. Guararapes e atravessar Ponte Maurício de Nassau\n6 - Virar a primeira à direita, na rua Me. Deus", "75 min", "R$ 2,45", 1, "CDU Várzea - Bicicleta"));


        mData.add(new RotasData("1 - Na parada 020507 pega ônibus 060 (TI Tancredo Neves / Macaxeira)\n2 - Descer no terminal Tancredo Neves\n3 - Ir para plataforma 14 e pegar ônibus 132 (TI Tancredo Neves / Cde. Boa Vista)\n4 - Descer na rua Me. Deus, parada 302182", "95 min", "R$ 2,45", 2, "TI Tancredo Neves / Macaxeira - TI Tancredo Neves / Cde. Boa Vista"));
    }


}


