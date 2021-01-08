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

    //ABRIR FICHEIROS
    //------------------------------------------------------------------------------------------------
    public ArrayList<Reserva> abrir_fich_reservas() {
        ArrayList<Reserva> reserva = new ArrayList<Reserva>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("reservas.dat"));

            int ult = is.readInt();
            Reserva.setUltimo(ult);

            reserva = (ArrayList<Reserva>) is.readObject();
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
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
    public ArrayList<Estadia> abrir_Estadias(){
        ArrayList<Estadia> estadia = new ArrayList<Estadia>();

        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("estadias.dat"));

            int ult = is.readInt();
            Estadia.setUltimo(ult);

            estadia = (ArrayList<Estadia>)is.readObject();
            is.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return estadia;
    }
    //------------------------------------------------------------------------------------------------
    public void mostrar_Viagem(ArrayList<Viagem> v){
        if(v.isEmpty()){
            System.out.println("Ainda não existem Viagens disponiveis");
        }else {
            for (int i = 0; i < v.size(); i++) {
                System.out.println(v.get(i));
            }
        }
    }
    public void mostrar_Estadias(ArrayList<Estadia> e1){
        if(e1.isEmpty()){
            System.out.println("Ainda não existem Viagens disponiveis");
        }else {
            for (int i = 0; i < e1.size(); i++) {
                System.out.println(e1.get(i));
            }
        }
    }
    //------------------------------------------------------------------------------------------------

    public void comprar_Viagem(){
        ArrayList<Viagem> v = abrir_Viagens();
        if(v.isEmpty()){
            System.out.println("\nAinda não existem Viagens disponiveis\n");
        }else {
            mostrar_Viagem(v);
            System.out.println("\n Introduza o código id da viagem que pretende comprar");
            int cod = Ler.umInt();

            for (int i = 0; i < v.size(); i++) {
                if (cod == v.get(i).getCod()) {
                    if(v.get(i).confirmar_lotacao() != 0) {
                        ArrayList<Reserva> reserva = abrir_fich_reservas();
                        System.out.println("Viagem selecionada");
                        System.out.println("Introduza um email");
                        String email = Ler.umaString();
                        Reserva r = new Reserva(email);
                        v.get(i).setClient(email);
                        r.setViagem(v.get(i).getCompanhia());
                        r.setDestino(v.get(i).getDestino());
                        r.setOrigem(v.get(i).getOrigem());

                        reserva.add(r);

                        try {
                            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("reservas.dat"));

                            os.writeInt(Reserva.getUltimo());
                            os.writeObject(r);

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
        }
    }

    public void alugar_estadia(){
        ArrayList<Estadia> e1 = abrir_Estadias();
        if(e1.isEmpty()){
            System.out.println("Ainda não existem Estadias disponiveis");
        }else {
            mostrar_Estadias(e1);
            System.out.println("\nIntroduza o código id da estadia que pretende alugar");
            int cod = Ler.umInt();

            for (int i = 0; i < e1.size(); i++) {
                if (cod == e1.get(i).getCod()) {
                    if(e1.get(i).confirmar_lotacao() != 0) {
                        ArrayList<Reserva> reserva = abrir_fich_reservas();
                        System.out.println("Estadia selecionada");
                        System.out.println("introduza um email");
                        String email = Ler.umaString();
                        Reserva r = new Reserva(email);
                        r.setEstadia(e1.get(i).getCompanhia());
                        r.setLocal_estadia(e1.get(i).getLocal());

                        reserva.add(r);

                        try {
                            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("reservas.dat"));

                            os.writeInt(Reserva.getUltimo());
                            os.writeObject(r);

                            os.flush();
                            os.close();
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }
    }
    public void display_cliente(){

        System.out.println("\nIntroduza o seu email");
        String email = Ler.umaString();

        ArrayList<Reserva> r ;//= new ArrayList<Reserva>();
        r = abrir_fich_reservas();

        for(int i=0; i<r.size();i++){
            if(r.get(i).getEmail().equals(email)){
                System.out.println(r.get(i));
            }else{
                System.out.println("Email incorreto\n");
            }
        }


    }
}

