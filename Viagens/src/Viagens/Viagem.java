package Viagens;

import java.io.*;
import java.util.ArrayList;

public class Viagem extends Tempo implements Serializable {
    private String origem;
    private String destino;

    // Colecao de origens
    //private ArrayList<Origem> origens;
    // Colecao de destinos
    //private ArrayList <Destino> destinos;

    private int duracao_hora;
    private int duracao_minuto;
    //private double valorVendas;
    private String companhia = " ";
    private static int ultimo = 0;
    private int cod;
    private double preco_base;
    private double preco;

    private int lotacao;
    //private static int lotacao;



    public Viagem(String origem, String destino, int duracao_hora, int duracao_minuto, double preco_base, Tempo t, int lotacao){
        super(t.getAno(), t.getMes(), t.getDia(), t.getHora(), t.getMinuto());
        this.lotacao = lotacao;
        this.origem = origem;
        this.destino = destino;

        this.duracao_hora = duracao_hora;
        this.duracao_minuto = duracao_minuto;
        this.preco_base = preco_base;
        this.preco = calculate_Preco(preco_base);
        this.cod = ultimo++;
    }

    //getters e setters
    public void setCompanhia(String companhia){ this.companhia = companhia;}
    public void setOrigem(String origem){
        this.origem = origem;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }
    public void setLotacao(int lotacao) { this.lotacao = lotacao;}
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
    public void setPreco_base(double preco_base){
        this.preco_base = preco_base;
    }
    public void setPreco(double preco){
        this.preco = calculate_Preco(preco_base);
    }


    public String getCompanhia(){ return this.companhia;}
    public String getOrigem(){
        return this.origem;
    }
    public String getDestino(){
        return this.destino;
    }
    public int getLotacao() {return this.lotacao;}
    public static int getUltimo() { return ultimo;}
    public int getCod() {return cod;}
    public int getDuracao_hora() {
        return duracao_hora;
    }
    public int getDuracao_minuto() {
        return duracao_minuto;
    }

    public double calculate_Preco(double preco_base){
        double preco_final = preco_base;
        //determinar o preco da viagem tendo em conta a data/data de compra
        if(falta_ano(super.getAno()) >= 1 && falta_mes(super.getMes()) >= 12){
            preco_final = this.preco_base - (this.preco_base * 0.30);
            return preco_final;
        }if(falta_ano(super.getAno()) < 1){
            if(falta_mes(super.getMes()) < 12 && falta_mes(super.getMes()) > 6){
                preco_final = this.preco_base - (this.preco_base * 0.20);
                return preco_final;
            }
            if(falta_mes(super.getMes()) == 6){
                preco_final = this.preco_base - (this.preco_base * 0.15);
                return preco_final;
            }
            if(falta_mes(super.getMes()) < 6 && falta_mes(super.getMes()) >= 4){
                preco_final = this.preco_base - (this.preco_base * 0.1);
                return preco_final;
            }
            if(falta_mes(super.getMes()) < 4 && falta_mes(super.getMes()) >= 3){
                preco_final = this.preco_base - (this.preco_base * 0.05);
                return preco_final;
            }
            if(falta_mes(super.getMes()) < 3 && falta_mes(super.getMes()) >= 1){
                preco_final = this.preco_base + (this.preco_base * 0.1);
                return preco_final;
            }
            if(falta_mes(super.getMes()) < 1){
                if(falta_dia(super.getDia()) < 27 && falta_dia(super.getDia()) >= 15){
                    preco_final = this.preco_base + (this.preco_base * 0.2);
                    return preco_final;
                }
                if(falta_dia(super.getDia()) < 15 && falta_dia(super.getDia()) >= 7){
                    preco_final = this.preco_base + (this.preco_base * 0.35);
                    return preco_final;
                }
                if(falta_dia(super.getDia()) < 7 && falta_dia(super.getDia()) > 1){
                    preco_final = this.preco_base + (this.preco_base * 0.5);
                    return preco_final;
                }
                if(falta_dia(super.getDia()) == 1){
                    preco_final = this.preco_base + (this.preco_base * 0.75);
                    return preco_final;
                }
            }
        }
        if(falta_ano(super.getAno()) == 0 && falta_mes(super.getMes()) == 0 && super.getDia() == 0){
            if(falta_dia(super.getDia()) < 7){
                preco_final = 2 * this.preco_base;
                return preco_final;
            }
        }
        return preco_final;
    }



    @Override
    public String toString(){
        return cod + " = " + origem+" -> "+destino+" na data: "+ super.getDia()+"/"+super.getMes()+"/"+super.getAno()+" às: "+super.getHora()+":"+super.getMinuto()+" pela companhia " +companhia +" -> com o preco = "+preco;
    }

}
