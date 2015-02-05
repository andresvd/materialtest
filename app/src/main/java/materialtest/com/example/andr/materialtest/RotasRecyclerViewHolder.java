package materialtest.com.example.andr.materialtest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by André on 28/01/2015.
 */
class RotasRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    public TextView passos;
    public TextView duracaoRota;
    public TextView preco;
    public TextView resumoRota;
    private ClickListener clickListener;

    public RotasRecyclerViewHolder(View itemView) {
        super(itemView);
        passos = (TextView) itemView.findViewById(R.id.passos);
        duracaoRota = (TextView) itemView.findViewById(R.id.duracaoRota);
        preco = (TextView) itemView.findViewById(R.id.preco);
        resumoRota = (TextView) itemView.findViewById(R.id.resumoPassos);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public interface ClickListener {

        /**
         * Called when the view is clicked.
         *
         * @param v view that is clicked
         * @param position of the clicked item
         * @param isLongClick true if long click, false otherwise
         */
        public void onClick(View v, int position, boolean isLongClick);

    }

    /* Setter for listener. */
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public void onClick(View v) {

        // If not long clicked, pass last variable as false.
        clickListener.onClick(v, getPosition(), false);
    }

    @Override
    public boolean onLongClick(View v) {

        // If long clicked, passed last variable as true.
        clickListener.onClick(v, getPosition(), true);
        return true;
    }
}