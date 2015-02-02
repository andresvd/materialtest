package materialtest.com.example.andr.materialtest;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by André on 22/01/2015.
 */
public class RankingData {
    public String nome;
    public int pontuacao;
    public int imagemResource;
    public int identificador;

    public RankingData (String nome, int pontuacao, int imagemResource, int identificador) {
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.imagemResource = imagemResource;
        this.identificador = identificador;
    }
}
