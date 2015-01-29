package materialtest.com.example.andr.materialtest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by André on 28/01/2015.
 */
class RotasRecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView passos;
    public TextView duracaoRota;
    public TextView preco;

    public RotasRecyclerViewHolder(View itemView) {
        super(itemView);
        passos = (TextView) itemView.findViewById(R.id.passos);
        duracaoRota = (TextView) itemView.findViewById(R.id.duracaoRota);
        preco = (TextView) itemView.findViewById(R.id.preco);
    }
}