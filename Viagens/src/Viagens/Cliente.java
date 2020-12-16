package Viagens;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Cliente {
    private String name;
    private String email;
    private int numero;
    ArrayList<Viagem> v = new ArrayList<Viagem>();

    public Cliente(){}
    //getters e setters
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }

    @Override
    public String toString(){
        return "Nome= "+this.name+" Email= "+this.email;
    }

    public void mostrar_Viagens(){
        ArrayList<Viagem> viagem = new ArrayList<Viagem>();
        System.out.println(viagem);
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("viagens.dat"));
            viagem = (ArrayList<Viagem>)is.readObject();
            is.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        System.out.println(viagem);
        for(int i=0;i<viagem.size();i++){
            System.out.println(viagem.get(i));
        }
    }
}
