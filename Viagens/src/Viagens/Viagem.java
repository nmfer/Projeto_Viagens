package Viagens;

import java.io.*;
import java.util.ArrayList;

public class Viagem extends Tempo implements Serializable {
    private String origem;
    private String destino;

    // Colecao de origens
    private ArrayList<Origem> origens;
    // Colecao de destinos
    private ArrayList <Destino> destinos;

    private int duracao_hora;
    private int duracao_minuto;
    //private double valorVendas;
    private String companhia = " ";
    private static int ultimo = 0;
    private int cod;
    private double preco_base;

    private int lotacao;
    //private static int lotacao;



    public Viagem(String origem, String destino, int duracao_hora, int duracao_minuto, double preco_base, Tempo t, int lotacao){
        super();
        //Lotacao l = new l(lotacao);
        this.lotacao = lotacao;
        this.origem = origem;
        this.destino = destino;
        this.origens = new ArrayList <Origem>();
        this.destinos = new ArrayList <Destino>();

        this.duracao_hora = duracao_hora;
        this.duracao_minuto = duracao_minuto;
        this.preco_base = preco_base;
        this.cod = ultimo++;
    }

    //getters e setters
    public void setCompanhia(String companhia){ this.companhia = companhia;}
    /*public void setOrigem(String origem){
        this.origem = origem;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }*/

    public static void setUltimo(int cod) {Viagem.ultimo = ultimo;}
    public void setCod(int cod){ this.cod = cod;}
    public void setDuracao_horas(int duracao_hora) throws TimeException{
        if ((duracao_hora >= 0) || (duracao_hora <= 24)) {
            throw new TimeException("Introdução tempo incorreta-> introduza entre: 0h-24h");
        } else {
            this.duracao_hora = duracao_hora;
        }
    }
    public void setDuracao_minuto(int duracao_minuto) throws TimeException{
        if ((duracao_minuto >= 0) || (duracao_minuto <= 59)) {
            throw new TimeException("Introdução tempo incorreta-> introduza entre: 0min-59min");
        } else {
            this.duracao_minuto = duracao_minuto;
        }
    }


    public String getCompanhia(){ return this.companhia;}
    /*public String getOrigem(){
        return this.origem;
    }
    public String getDestino(){
        return this.destino;
    }*/
    public static int getUltimo() { return ultimo;}
    public int getCod() {return cod;}
    public int getDuracao_hora() {
        return duracao_hora;
    }
    public int getDuracao_minuto() {
        return duracao_minuto;
    }






    @Override
    public String toString(){
        return cod + " = " + origem+" -> "+destino+" na data: "+ super.getDia()+"/"+super.getMes()+"/"+super.getAno()+" às: "+super.getHora()+":"+super.getMinuto()+" pela companhia " +companhia;
    }

}
