package Viagens;

import java.io.Serializable;

public class Reserva implements Serializable {
    private String viagem ="";
    private String destino = "";
    private String origem = "";
    private String estadia = "";
    private String local_estadia = "";
    private String email;
    private static int ultimo = 0;
    private int cod;

    public Reserva(String email){
        this.email = email;
        this.cod = ultimo++;
    }

    //getters e setters
    public static void setUltimo(int cod) {Reserva.ultimo = ultimo;}
    public static int getUltimo() { return ultimo;}
    public void setViagem(String viagem){
        this.viagem = viagem;
    }
    public String getViagem(){return this.viagem;}
    public void setEstadia(String estadia){
        this.estadia = estadia;
    }
    public String getEstadia(){return this.estadia;}

    public void setDestino(String destino){
        this.destino = destino;
    }
    public String getDestino(){return this.destino;}
    public void setOrigem(String origem){
        this.origem = origem;
    }
    public String getOrigem(){return this.origem;}
    public void setLocal_estadia(String local_estadia){
        this.local_estadia = local_estadia;
    }
    public String getLocal_estadia(){return this.local_estadia;}

    public String getEmail(){return this.email;}

    public String toString(){
        String s = this.email + "\n";
        if(this.viagem != null){
            s = s + " " + this.viagem + ", " + this.origem + "->" + this.destino + "\n";
        }
        if(this.estadia != null){
            s = s + " " + this.estadia + ", " + this.local_estadia;
        }
        return s;
    }


}
