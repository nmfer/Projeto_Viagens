package Viagens;

import java.io.Serializable;
import java.util.ArrayList;

public class Reserva implements Serializable {
    private Viagem v;
    private Estadia e1;
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
    public void setViagem(Viagem v){
        this.v = v;
    }

    public void setEstadia(Estadia e1){
        this.e1 = e1;
    }
    public String getEmail(){
        return this.email;
    }

}
