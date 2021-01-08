package Viagens;

import java.io.Serializable;
import java.util.ArrayList;

public class Estadia extends Tempo implements Serializable {
    private String car;
    private int cod;
    private static int ultimo = 0;
    private String local;
    private String companhia;
    private int lotacao;
    private double preco_base;
    private ArrayList<String> client;

    public Estadia (String car, int lotacao, double preco_base, String local){
        this.car = car;
        this.local = local;
        this.lotacao = lotacao;
        this.preco_base = preco_base;
        this.cod = this.ultimo++;
        this.client = new ArrayList<String>();
    }


    //getters e setters
    public void setCar(String car){
        this.car = car;
    }
    public String getCar(){
        return this.car;
    }

    public void setCod(int cod){this.cod = cod; }
    public int getCod(){
        return this.cod;
    }

    public void setPreco_base(double preco_base) {
        this.preco_base = preco_base;
    }
    public double getPreco_base() { return this.preco_base;}

    public void setLocal(String local){ this.local = local;}
    public String getLocal() {return this.local;}

    public void setLotacao_quarto(int lotacao){
        this.lotacao = lotacao;
    }
    public int getLotacao() { return this.lotacao;}

    public static void setUltimo(int ultimo){Estadia.ultimo = ultimo;}
    public static int getUltimo(){return ultimo;}

    public void setCompanhia(String companhia){
        this.companhia = companhia;
    }
    public String getCompanhia(){
        return this.companhia;
    }

    public void setClient(String email){
        this.client.add(email);
    }
    public ArrayList<String> getClient() {
        return this.client;
    }


    public int confirmar_lotacao(){
        if(this.lotacao == 0) {
            System.out.println("Já não existe lotação -> a atualizar/remover a viagem, pedimos desculpa o incómodo");
            return 0;
        }else{
            return 1;
        }
    }

    public String mostra_clientes(){
        String s = "";
        for(int i=0; i<client.size();i++){
            s = s + client.get(i) + "\n";
        }
        return s;
    }

    @Override
    public String toString(){
        String s = this.cod+"_ "+ this.companhia+ "-> " +this.car+ " -> " +this.preco_base+ " pessoas " +this.lotacao+ " em "+this.local+"\n";

        return s;
    }
}
