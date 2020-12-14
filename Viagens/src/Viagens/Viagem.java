package Viagens;

import java.io.*;
import java.util.ArrayList;

public class Viagem extends Tempo implements Serializable {
    private String origem;
    private String destino;
    private String companhia = " ";
    //ArrayList<Viagem> viagem = new ArrayList<Viagem>();

    public Viagem(Tempo t){ super(t.getHora(), t.getMinuto(), t.getDia(), t.getMes(), t.getAno());}

    public Viagem(String origem, String destino, Tempo t){
        super(t.getHora(), t.getMinuto(), t.getDia(), t.getMes(), t.getAno());
        this.origem = origem;
        this.destino = destino;
    }

    //getters e setters
    public void setCompanhia(String companhia){ this.companhia = companhia;}
    public void setOrigem(String origem){
        this.origem = origem;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }

    public String getCompanhia(){ return this.companhia;}
    public String getOrigem(){
        return this.origem;
    }
    public String getDestino(){
        return this.destino;
    }


    public String toString(){
        return origem+" -> "+destino+" no data: "+ super.getDia()+"/"+super.getMes()+"/"+super.getAno()+" às: "+super.getHora()+":"+super.getMinuto()+"pela companhia" +companhia;
    }

}
