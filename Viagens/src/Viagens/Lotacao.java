package Viagens;

import java.io.Serializable;

public class Lotacao implements Serializable {
    private int lotacao;

    public Lotacao(int lotacao){
        this.lotacao = lotacao;
    }

    public void setLotacao(int lotacao){
        this.lotacao = lotacao;
    }
    public int getLotacao(){
        return this.lotacao;
    }

}
