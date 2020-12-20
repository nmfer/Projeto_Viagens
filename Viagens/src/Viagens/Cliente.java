package Viagens;

import my_inputs.Ler;

import java.io.*;
import java.util.ArrayList;

public class Cliente {
    private String name;
    private String email;
    private int numero;


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

    public ArrayList<Reserva> abrir_fich_reservas() {
        ArrayList<Reserva> reserva = new ArrayList<Reserva>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("reservas.dat"));

            reserva = (ArrayList<Reserva>) is.readObject();
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(e2);
        return reserva;
    }

    public ArrayList<Viagem> abrir_Viagens(){
        ArrayList<Viagem> viagem = new ArrayList<Viagem>();
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("viagens.dat"));

            int ult = is.readInt();
            Viagem.setUltimo(ult);

            viagem = (ArrayList<Viagem>)is.readObject();
            is.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return viagem;

    }
    public void mostrar_Viagem(ArrayList<Viagem> v){
        for(int i=0;i<v.size();i++){
            System.out.println(v.get(i));
        }
    }

    public void comprar_Viagem(){
        ArrayList<Viagem> v = abrir_Viagens();
        mostrar_Viagem(v);
        System.out.println("\n Introduza o código id da viagem que pretende comprar");
        int cod = Ler.umInt();

        for(int i=0;i<v.size();i++){
            if(cod == v.get(i).getCod()){
                ArrayList<Reserva> reserva = new ArrayList<Reserva>();
                System.out.println("Viagem selecionada");
                System.out.println("introduza um email");
                String email = Ler.umaString();
                Reserva r = new Reserva(email);
                r.setViagem(v.get(i));

                reserva.add(r);

                try {
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("reservas.dat"));

//                    os.writeInt(Reserva.getUltimo());
                    os.writeObject(v);

                    os.flush();
                    os.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

                int lotacao = v.get(i).getLotacao();
                lotacao--;
                v.get(i).setLotacao(lotacao);
            }
        }
    }
    public ArrayList<Estadia> abrir_Estadias(){
        ArrayList<Estadia> estadia = new ArrayList<Estadia>();

        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("estadias.dat"));

       //     int ult = is.readInt();
       //     Estadia.setUltimo(ult);

            estadia = (ArrayList<Estadia>)is.readObject();
            is.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return estadia;
    }


    public void mostrar_Estadias(ArrayList<Estadia> e1){
        for(int i=0;i<e1.size();i++){
            System.out.println(e1.get(i));
        }
    }
    public void alugar_estadia(){
        ArrayList<Estadia> e1 = abrir_Estadias();
        mostrar_Estadias(e1);
        System.out.println("\n Introduza o código id da estadia que pretende alugar");
        int cod = Ler.umInt();

        for(int i=0;i<e1.size();i++){
            if(cod == e1.get(i).getCod()){
                ArrayList<Reserva> reserva = new ArrayList<Reserva>();
                System.out.println("Estadia selecionada");
                System.out.println("introduza um email");
                String email = Ler.umaString();
                Reserva r = new Reserva(email);
                r.setEstadia(e1.get(i));

                reserva.add(r);

                try {
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("reservas.dat"));

                    os.writeInt(Reserva.getUltimo());
                    os.writeObject(e1);

                    os.flush();
                    os.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }
        }
    }
    public void display_cliente(){
        //ArrayList<Estadia> e1 = abrir_Estadias();
        //ArrayList<Viagem> v = abrir_Viagens();
        ArrayList<Reserva> r = abrir_fich_reservas();
        System.out.println("introduza o seu email");
        String email = Ler.umaString();

        for(int i=0; i<r.size();i++){
            if(email.equals(r.get(i).getEmail())){
                System.out.println(r.get(i));
            }
        }


    }
}

