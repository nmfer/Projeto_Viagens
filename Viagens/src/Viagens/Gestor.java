package Viagens;

import java.io.*;
import java.util.ArrayList;
import my_inputs.Ler;


public class Gestor{
    private static String username = "admin";
    private static String password = "admin";


    public Gestor(){}

//--------------------------------------------------------------------
    public boolean Login(){
        System.out.println("Login - Inicie sessão");
        System.out.println("Username:");
        String user = Ler.umaString();
        if(checkUsername(user) == true){
            return true;
        }
        //return "Credenciais incorretas";
        return false;
    }
    public boolean checkUsername(String x){
        if(x.equals(Gestor.this.username)){
            System.out.println("Password");
            String pwd = Ler.umaString();
            return checkPassword(pwd);
        }
        System.out.println("Username não encontrado");
        return false;
    }
    public boolean checkPassword(String x){
        if(x.equals(Gestor.this.password)){
            return true;
        }
        return false;
    }
//----------------------------------------------------------------------
    public void main_menu(int opcao){
        //abrir ou localizar os ficheiros antes de fazer qualquer input ou alteração nos mesmos
        ArrayList<Companhias_viagens> cv = new ArrayList<Companhias_viagens>();
        cv = abrir_fich_companhias(cv);
        ArrayList<Estadia> e1 = new ArrayList<Estadia>();
        e1 = abrir_fich_estadias(e1);
        ArrayList<Viagem> v = new ArrayList<Viagem>();
        v = abrir_fich_viagens(v);

        switch(opcao) {
            case 1:
                add_companhia(cv);
                break;
            case 2:
                mostra_companhia(cv);
                break;
            case 3:
                altera_companhia(cv);
                break;
            case 4:
                remover_companhia_viagem(cv);
                break;
            case 5: add_viagem(v);
                break;
            case 6: mostra_viagem(v);
                break;
            case 7:
                break;
            case 8:
                break;
            case 9: add_estadia(e1);
                break;
            case 10: mostra_estadia();
                break;
            case 11:
                break;
            case 12:
                break;
        }
    }
//------------------------------------------------------------------------
    public ArrayList<Companhias_viagens> abrir_fich_companhias(ArrayList<Companhias_viagens> c_v){
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("companhias_viagem.dat"));
            c_v = (ArrayList<Companhias_viagens>)is.readObject();
            is.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return c_v;
    }
//------------------------------------------------------------------------
    public ArrayList<Estadia> abrir_fich_estadias(ArrayList<Estadia> e1){
        //ArrayList<Estadia> e2 = new ArrayList<Estadia>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("estadias.dat"));
            e1 =  (ArrayList<Estadia>)is.readObject();
            is.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        //System.out.println(e2);
        return e1;
    }
//-------------------------------------------------------------------------------
    public ArrayList<Viagem> abrir_fich_viagens(ArrayList<Viagem> v){
        //ArrayList<Estadia> e2 = new ArrayList<Estadia>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("viagens.dat"));
            v =  (ArrayList<Viagem>)is.readObject();
            is.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        //System.out.println(e2);
        return v;
    }
//-------------------------------------------------------------------------------
    public String tipo(){
        System.out.println("1 - Transporte");
        System.out.println("2 - Estadia");
        int opcao = Ler.umInt();
        String tipo = "";
            switch(opcao){
                case 1:
                    tipo = "Transporte";
                    break;
                case 2:
                    tipo = "Estadia";
                    break;
            }
        return tipo;
    }
    public void add_companhia(ArrayList<Companhias_viagens> companhia){
        System.out.println("Nome Companhia:");
        String nome = Ler.umaString();

        System.out.println("Escolha o tipo de transposte associado à empresa:");
        String tipo = tipo();

        Companhias_viagens cv = new Companhias_viagens(nome,tipo);
        companhia.add(cv);

        //atualizar dados
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("companhias_viagem.dat"));
            os.writeInt(companhia.getUltimo());
            os.writeObject(companhia);
            os.flush();
            os.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
//-----------------------------------------------------------------------------------------------------------------
    public void mostra_companhia(ArrayList<Companhias_viagens> c_v){
        for(int i=0;i<c_v.size();i++){
            System.out.println(c_v.get(i));
        }
    }
//-----------------------------------------------------------------------------------------------------------------
    public void altera_companhia(ArrayList<Companhias_viagens> c_v){
        mostra_companhia(c_v);
        ArrayList<Viagem> v = new ArrayList<Viagem>();
        v = abrir_fich_viagens(v);

        System.out.println("Introduza o id da companhia de forma a mudar o nome da mesma");
        String old_name;
        int opcao = Ler.umInt();
        for (int i=0;i<c_v.size();i++){
            if(c_v.get(i).getID() == opcao){
                old_name = c_v.get(i).getName();
                System.out.println("Introduza o novo nome para a companhia "+c_v.get(i).getName());
                String new_name = Ler.umaString();
                c_v.get(i).setName(new_name);
                if(v.isEmpty() != false){
                    for(int j=0;j<v.size();j++) {
                        if (v.get(j).getCompanhia().equals(old_name)) {
                            v.get(j).setCompanhia(new_name);
                        }
                    }
                }
            }
        }

        //atualizar dados
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("companhias_viagem.dat"));
            os.writeObject(c_v);
            os.flush();
            os.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Done");
        }
        if(v.isEmpty() != false){
            try{
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("viagens.dat"));
                os.writeObject(v);
                os.flush();
                os.close();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }finally {
                System.out.println("Done2");
            }
        }

    }
//------------------------------------------------------------------------------------
    public void remover_companhia_viagem(ArrayList<Companhias_viagens> c_v){
        mostra_companhia(c_v);
        System.out.println("Introduza o id da companhia de forma a eliminá-la");
        int opcao = Ler.umInt();
        for(int i=0;i<c_v.size();i++){
            if(c_v.get(i).getID() == opcao){
                c_v.remove(i);
            }
        }
        //atualizar dados
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("companhias_viagem.dat"));
            os.writeObject(c_v);
            os.flush();
            os.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Done");
        }
    }

//-----------------------------------------------------------------------------------
    public void add_viagem(ArrayList<Viagem> v){
        System.out.println("Origem -> Destino");
        String origem = Ler.umaString();
        String destino = Ler.umaString();

        System.out.println("Introduza a data e tempo da viagem");
        System.out.println("Hora:");
        int hora = Ler.umInt();
        System.out.println("Minunto");
        int minuto = Ler.umInt();
        System.out.println("Dia");
        int dia = Ler.umInt();
        System.out.println("Mês");
        int mes = Ler.umInt();
        System.out.println("Ano:");
        int ano = Ler.umInt();
        Tempo t = new Tempo(hora,minuto,dia,mes,ano);
        Viagem vg = new Viagem(origem, destino, t);

        ArrayList<Companhias_viagens> c_v = new ArrayList<Companhias_viagens>();
        c_v = abrir_fich_companhias(c_v);
        ArrayList<Companhias_viagens> c_v1 = new ArrayList<Companhias_viagens>();

        System.out.println("Qual a companhia que oferece");
        for(int i=0;i<c_v.size();i++){
            if(c_v.get(i).getTipo().equals("Transporte")) {
                System.out.println(c_v.get(i));
                c_v1.add(c_v.get(i));
            }
        }

        System.out.println("Introduza o ID da Companhia");
        int opcao = Ler.umInt();
        for(int i=0;i<c_v1.size();i++){
            if(c_v1.get(i).getID() == opcao){
                vg.setCompanhia(c_v1.get(i).getName());
            }
        }
        //ArrayList<Viagem> v = new ArrayList<Viagem>();
        v.add(vg);

        //atualizar os dados
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("viagens.dat"));
            os.writeObject(v);
            os.flush();;
            os.close();
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }

//------------------------------------------------------------------------------------
    public void mostra_viagem(ArrayList<Viagem> v){

        for(int i=0;i<v.size();i++){
            System.out.println(v.get(i));
        }
    }
//----------------------------------------------------------------------------------
    public void add_estadia(ArrayList<Estadia> e1){
        System.out.println("Introduza o nome");
        String nome = Ler.umaString();
        Estadia e2 = new Estadia(nome);

        e1.add(e2);

        //atualizar dados
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("estadias.dat"));
            os.writeObject(e1);
            os.flush();
            os.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
//------------------------------------------------------------------------------------
    public ArrayList<Estadia> mostra_estadia(){
        ArrayList<Estadia> e1= new ArrayList<Estadia>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("estadias.dat"));
            e1 = (ArrayList<Estadia>)is.readObject();
            is.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        System.out.println(e1);
        return e1;
    }
}
