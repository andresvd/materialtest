package materialtest.com.example.andr.materialtest;

/**
 * Created by André on 28/01/2015.
 */
public class RotasData {

    public String passos;
    public String duracaoRota;
    public String preco;
    public String resumoPassos;
    int id;

    public RotasData(String passos, String duracaoRota, String preco, int id, String resumoPassos){
        this.passos = passos;
        this.duracaoRota = duracaoRota;
        this.preco = preco;
        this.id = id;
        this.resumoPassos = resumoPassos;
    }
}
