package materialtest.com.example.andr.materialtest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by André on 22/01/2015.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    public TextView nome;
    public ImageView imagem;
    public TextView pontuacao;
    private ClickListener clickListener;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        nome = (TextView) itemView.findViewById(R.id.nome);
        imagem = (ImageView) itemView.findViewById(R.id.imagem);
        pontuacao = (TextView) itemView.findViewById(R.id.pontuacao);

        // We set listeners to the whole item view, but we could also
        // specify listeners for the title or the icon.
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }


    /* Interface for handling clicks - both normal and long ones. */
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
