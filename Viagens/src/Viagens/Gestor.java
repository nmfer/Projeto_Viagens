package Viagens;

import java.io.*;
import java.util.ArrayList;
import my_inputs.Ler;


public class Gestor {
    private static String username = "admin";
    private static String password = "admin";


    public Gestor() {
    }

    //LOGIN
//--------------------------------------------------------------------
    public boolean Login() {
        System.out.println("Login - Inicie sessão");
        System.out.println("Username:");
        String user = Ler.umaString();
        if (checkUsername(user) == true) {
            return true;
        }
        //return "Credenciais incorretas";
        return false;
    }

    public boolean checkUsername(String x) {
        if (x.equals(Gestor.this.username)) {
            System.out.println("Password");
            String pwd = Ler.umaString();
            return checkPassword(pwd);
        }
        System.out.println("Username não encontrado");
        return false;
    }

    public boolean checkPassword(String x) {
        if (x.equals(Gestor.this.password)) {
            return true;
        }
        return false;
    }


    //MAIN MENU
//----------------------------------------------------------------------
    public void main_menu(int opcao) {
        //abrir ou localizar os ficheiros antes de fazer qualquer input ou alteração nos mesmos
        ArrayList<Companhias_viagens> cv = new ArrayList<Companhias_viagens>();
        cv = abrir_fich_companhias(cv);
        ArrayList<Estadia> e1 = new ArrayList<Estadia>();
        e1 = abrir_fich_estadias(e1);
        ArrayList<Viagem> v = new ArrayList<Viagem>();
        v = abrir_fich_viagens(v);
        ArrayList<Companhias_viagens> cv_rem = new ArrayList<Companhias_viagens>();
        cv_rem = abrir_fich_companhias_removidas(cv_rem);

        switch (opcao) {
            case 1:
                mostra_companhia(cv);
                break;
            case 2:
                add_companhia(cv);
                break;
            case 3:
                altera_companhia(cv);
                break;
            case 4:
                remover_companhia_viagem(cv);
                break;
            case 5:
                mostra_viagem(v);
                break;
            case 6:
                if(cv.isEmpty() != true) {
                    add_viagem(v);
                }
                break;
            case 7:
                if(cv.isEmpty() != true) {
                    altera_viagem(v);
                }
                break;
            case 8:
                if(cv.isEmpty() != true) {
                    remove_viagem(v);
                }
                break;
            case 9:
                mostra_estadia(e1);
                break;
            case 10:
                if(cv.isEmpty() != true) {
                    add_estadia(e1);
                }
                break;
            case 11:
                if(cv.isEmpty() != true) {
                    altera_estadia(e1);
                }
                break;
            case 12:
                if(cv.isEmpty() != true) {
                    remove_estadia(e1);
                }
                break;
            case 14:
                mostrar_companhias_removidas(cv_rem);
                break;
        }
    }


    //OPEN FILES
//------------------------------------------------------------------------
    public ArrayList<Companhias_viagens> abrir_fich_companhias(ArrayList<Companhias_viagens> c_v) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("companhias_viagem.dat"));

            int ult = is.readInt();
            Companhias_viagens.setUltimo(ult);

            c_v = (ArrayList<Companhias_viagens>) is.readObject();
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return c_v;
    }

    //------------------------------------------------------------------------
    public ArrayList<Estadia> abrir_fich_estadias(ArrayList<Estadia> e1) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("estadias.dat"));

            int ult = is.readInt();
            Estadia.setUltimo(ult);

            e1 = (ArrayList<Estadia>) is.readObject();
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return e1;
    }

    //-------------------------------------------------------------------------------
    public ArrayList<Viagem> abrir_fich_viagens(ArrayList<Viagem> v) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("viagens.dat"));

            int ult = is.readInt();
            Viagem.setUltimo(ult);

            v = (ArrayList<Viagem>) is.readObject();
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return v;
    }

    //-------------------------------------------------------------------------------
    public ArrayList<Companhias_viagens> abrir_fich_companhias_removidas(ArrayList<Companhias_viagens> c_v_rem) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("companhias_removidas.dat"));

            int ult = is.readInt();
            Companhias_viagens.setUltimo(ult);

            c_v_rem = (ArrayList<Companhias_viagens>) is.readObject();
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return c_v_rem;
    }
    //-------------------------------------------------------------------------------
    public ArrayList<Reserva> abrir_fich_reservas(ArrayList<Reserva> reserva) {
        //ArrayList<Reserva> reserva = new ArrayList<Reserva>();
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

    public void mostra_mais(){
        ArrayList<Viagem> viagem = new ArrayList<Viagem>();
        viagem = abrir_fich_viagens(viagem);

        ArrayList<String> aux1 = new ArrayList<String>();
        ArrayList<String> aux = new ArrayList<String>();
        //for(int i=0; i<viagem.size();i++){
        //    aux = viagem.get(i).getClient();
        //    for(int j=0; j<aux.size(); j++){

        //    }


    }
    public void mostra_Tap(){
        ArrayList<Viagem> v = new ArrayList<>();
        v = abrir_fich_viagens(v);

        for(int i=0; i<v.size();i++){
            if(v.get(i).getCompanhia().equals("Tap")){
                System.out.println(v.get(i));
            }
        }
    }



    //COMPANHIA VIAGEM
//-------------------------------------------------------------------------------
    public void add_companhia(ArrayList<Companhias_viagens> companhia) {
        System.out.println("Nome Companhia:");
        String nome = Ler.umaString();

        System.out.println("Escolha o tipo associado à empresa:");
        System.out.println("1-Transporte");
        System.out.println("2-Estadia");
        String tipo = " ";
        int opcao = Ler.umInt();
        switch (opcao) {
            case 1:
                tipo = "Transporte";
                break;
            case 2:
                tipo = "Estadia";
                break;
        }

        Companhias_viagens cv = new Companhias_viagens(nome, tipo);

        if (cv.equals(companhia) != true) {
            companhia.add(cv);

            //atualizar dados
            try {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("companhias_viagem.dat"));

                os.writeInt(Companhias_viagens.getUltimo());
                os.writeObject(companhia);

                os.flush();
                os.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------------
    public void mostra_companhia(ArrayList<Companhias_viagens> c_v) {
        for (int i = 0; i < c_v.size(); i++) {
            System.out.println(c_v.get(i));
        }
    }

    //-----------------------------------------------------------------------------------------------------------------
    public void altera_companhia(ArrayList<Companhias_viagens> c_v) {
        mostra_companhia(c_v);
        ArrayList<Viagem> v = new ArrayList<Viagem>();
        ArrayList<Estadia> e1 = new ArrayList<Estadia>();
        ArrayList<Reserva> r = new ArrayList<Reserva>();
        v = abrir_fich_viagens(v);
        e1 = abrir_fich_estadias(e1);
        r = abrir_fich_reservas(r);


        System.out.println("Introduza o id da companhia de forma a mudar o nome da mesma");
        String old_name;
        int opcao = Ler.umInt();
        for (int i = 0; i < c_v.size(); i++) {
            if (c_v.get(i).getID() == opcao) {
                old_name = c_v.get(i).getName();
                System.out.println("Introduza o novo nome para a companhia " + c_v.get(i).getName());
                String new_name = Ler.umaString();

                //verififcar se nome existe já existe
                for (int j = 0; j < c_v.size(); j++) {
                    if (new_name.equals(c_v.get(j).getName())) {
                        System.out.println("Companhia nome já existe, introduza outro:");
                        new_name = Ler.umaString();
                    }
                }
                c_v.get(i).setName(new_name);
                if(c_v.get(i).getTipo().equals("Transporte")) {
                    for (int j = 0; j < v.size(); j++) {
                        if (v.get(j).getCompanhia().equals(old_name)) {
                            v.get(j).setCompanhia(new_name);

                            try {
                                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("viagens.dat"));
                                os.writeObject(v);
                                os.flush();
                                os.close();
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
                if(c_v.get(i).getTipo().equals("Estadia")) {
                    for (int j = 0; j < e1.size(); j++) {
                        if (e1.get(j).getCompanhia().equals(old_name)) {
                            e1.get(j).setCompanhia(new_name);

                            try {
                                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("estadia.dat"));
                                os.writeObject(v);
                                os.flush();
                                os.close();
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
                for(int j=0; j<r.size();j++){
                    if(r.get(j).getViagem().equals(old_name)){
                        r.get(j).setViagem(new_name);
                    }
                    if(r.get(j).getEstadia().equals(old_name)){
                        r.get(j).setEstadia(new_name);
                    }
                }
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
        System.out.println(c_v);
        //atualizar dados
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("companhias_viagem.dat"));

            os.writeInt(Companhias_viagens.getUltimo());
            os.writeObject(c_v);

            os.flush();
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //------------------------------------------------------------------------------------
    public void remover_companhia_viagem(ArrayList<Companhias_viagens> c_v) {
        ArrayList<Companhias_viagens> c_v_remove = new ArrayList<Companhias_viagens>();

        System.out.println("Introduza o ID da companhia de forma a eliminá-la");
        mostra_companhia(c_v);

        int opcao = Ler.umInt();
        for (int i = 0; i < c_v.size(); i++) {
            if (c_v.get(i).getID() == opcao) {
                c_v_remove.add(c_v.get(i));
                c_v.remove(i);

                //escrever dados das companhias removidas
                try {
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("companhias_removidas.dat"));

                    os.writeInt(Companhias_viagens.getUltimo());
                    os.writeObject(c_v_remove);

                    os.flush();
                    os.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        //atualizar dados
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("companhias_viagem.dat"));

            os.writeInt(Companhias_viagens.getUltimo());
            os.writeObject(c_v);

            os.flush();
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    //VIAGEM
//-----------------------------------------------------------------------------------
    public void add_viagem(ArrayList<Viagem> v) {
        mostra_viagem(v);

        ArrayList<Companhias_viagens> c_v = new ArrayList<Companhias_viagens>();
        c_v = abrir_fich_companhias(c_v);

        for (int j = 0; j < c_v.size(); j++) {
            if (c_v.get(j).getTipo().equals("Transporte")) {

                String origem;
                String destino;

                boolean x = true;
                do {
                    System.out.println("introduza a origem e destino");
                    origem = Ler.umaString();
                    destino = Ler.umaString();

                    for (int i = 0; i < v.size(); i++) {
                        //comparar com String origem e destino na viagem para ver se já existem
                        String origin = v.get(i).getOrigem();
                        String destiny = v.get(i).getDestino();
                        if (origem.equals(origin) && destino.equals(destiny)) {
                            x = true;
                        }
                    }
                    x = false;
                } while (x == true);

                //Data e Tempo da viagem
                Tempo t = new Tempo();
                System.out.println("Introduza a data e tempo da viagem");

                try {
                    System.out.println("Ano");
                    int ano = Ler.umInt();
                    t.setAno(ano);

                    System.out.println("mes");
                    int mes = Ler.umInt();
                    t.setMes(mes);

                    System.out.println("dia");
                    int dia = Ler.umInt();
                    t.setDia(dia);
                    t.checkDay();

                    System.out.println("Hora");
                    int hora = Ler.umInt();
                    t.setHora(hora);

                    System.out.println("Minuto");
                    int minuto = Ler.umInt();
                    t.setMinuto(minuto);


                    //Tempo t = new Tempo(ano, mes, dia, hora, minuto);

                    System.out.println("Introduza a duração da viagem");
                    System.out.println("Horas");
                    int duracao_hora = Ler.umInt();
                    System.out.println("Minutos");
                    int duracao_minuto = Ler.umInt();
                    System.out.println("Introduza o preço_base da viagem");
                    double preco = Ler.umDouble();

                    System.out.println("Introduza a lotação");
                    int lotacao = Ler.umInt();

                    //instanciar uma nova viagem -> vg
                    Viagem vg = new Viagem(origem, destino, duracao_hora, duracao_minuto, preco, t, lotacao);


                    //mostrar as companhias de transporte
                    System.out.println("Qual a companhia que oferece");
                    for (int i = 0; i < c_v.size(); i++) {
                        if (c_v.get(i).getTipo().equals("Transporte")) {
                            System.out.println(c_v.get(i));

                        }
                    }

                    //definir a companhia da viagem
                    System.out.println("Introduza o ID da Companhia");
                    int opcao = Ler.umInt();
                    for (int i = 0; i < c_v.size(); i++) {
                        if (c_v.get(i).getID() == opcao) {
                            vg.setCompanhia(c_v.get(i).getName());
                        }
                    }
                    //adicionar a instancia vg ao arraylist v
                    v.add(vg);

                    //atualizar os dados
                    try {
                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("viagens.dat"));

                        os.writeInt(Viagem.getUltimo());
                        os.writeObject(v);

                        os.flush();
                        os.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                } catch (TimeException e) {
                    System.out.println(e.getMessage() + e.getClass());
                }
            }
        }
    }


    //------------------------------------------------------------------------------------
    public void mostra_viagem(ArrayList<Viagem> v) {
        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
            System.out.println("Preço_Base-> "+v.get(i).getPreco_base());
            System.out.println(v.get(i).mostra_clientes());
        }
    }

    //----------------------------------------------------------------------
    public void altera_viagem(ArrayList<Viagem> v) {
        System.out.println("Qual a viagem que pretende alterar:");
        mostra_viagem(v);
        int opcao = Ler.umInt();
        int opcao1;
        for (int i = 0; i < v.size(); i++) {
            if (opcao == v.get(i).getCod()) {
                do {
                    System.out.println(v.get(i));
                    System.out.println("\nQual o aspeto que pretende alterar na viagem");
                    System.out.println("1-Origem");
                    System.out.println("2-Destino");
                    System.out.println("3-Ano");
                    System.out.println("4-Mes");
                    System.out.println("5-Dia");
                    System.out.println("6-Hora");
                    System.out.println("7-Minuto");
                    System.out.println("8-Duração da viagem");
                    System.out.println("9-Preço_base da viagem");
                    System.out.println("10-Lotação");
                    System.out.println("0-Cancelar");

                    //selecionar opção
                    opcao1 = Ler.umInt();
                    switch (opcao1) {
                        case 1: //ORIGEM
                            System.out.println("Origem");
                            String origem = Ler.umaString();
                            v.get(i).setOrigem(origem);
                            break;
                        case 2: //DESTINO
                            System.out.println("Destino");
                            String destino = Ler.umaString();
                            v.get(i).setDestino(destino);
                            break;
                        case 3: //ANO
                            System.out.println("Ano");
                            try {
                                int ano = Ler.umInt();
                                v.get(i).setAno(ano);
                            } catch (TimeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 4: //MES
                            System.out.println("Mes");
                            try {
                                int mes = Ler.umInt();
                                v.get(i).setMes(mes);
                            } catch (TimeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 5: //DIA
                            System.out.println("Dia");
                            try {
                                int dia = Ler.umInt();
                                v.get(i).setDia(dia);
                            } catch (TimeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 6: //HORA
                            System.out.println("Hora");
                            try {
                                int hora = Ler.umInt();
                                v.get(i).setHora(hora);
                            } catch (TimeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 7: //MINUTO
                            System.out.println("Minuto");
                            try {
                                int minuto = Ler.umInt();
                                v.get(i).setMinuto(minuto);
                            } catch (TimeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 8: //DURAÇÃO VIAGEM
                            System.out.println("Duração-viagem");
                            try {
                                System.out.println("Horas");
                                int duracao_hora = Ler.umInt();
                                v.get(i).setDuracao_horas(duracao_hora);
                                System.out.println("Minutos");
                                int duracao_minuto = Ler.umInt();
                                v.get(i).setDuracao_minuto(duracao_minuto);

                            } catch (TimeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 9: //PREÇO
                            System.out.println("Preco");
                            double preco = Ler.umDouble();
                            v.get(i).setPreco_base(preco);
                            break;
                        case 10: //LOTAÇÃO
                            System.out.println("Lotação");
                            int lotacao = Ler.umInt();
                            v.get(i).setLotacao(lotacao);
                            break;
                    }

                } while (opcao1 != 0);
            }

        }

        //atualizar os dados
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("viagens.dat"));

            os.writeInt(Viagem.getUltimo());
            os.writeObject(v);

            os.flush();
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }


    //----------------------------------------------------------------------
    public void remove_viagem(ArrayList<Viagem> v) {

        System.out.println("\nQual viagem pretende remover:");
        mostra_viagem(v);
        int opcao = Ler.umInt();
        for (int i = 0; i < v.size(); i++) {
            if (opcao == v.get(i).getCod()) {
                v.remove(i);
            }
        }
        //atualizar dados
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("viagens.dat"));

            os.writeInt(Viagem.getUltimo());
            os.writeObject(v);

            os.flush();

            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    //ESTADIA
//----------------------------------------------------------------------------------
    public void add_estadia(ArrayList<Estadia> e1) {
        //Abrir viagens
        ArrayList<Companhias_viagens> c_v = new ArrayList<Companhias_viagens>();
        c_v = abrir_fich_companhias(c_v);

        System.out.println("Introduza o preço_base da estadia");
        double preco_base = Ler.umDouble();

        System.out.println("Introduza a lotação por quarto");
        int lotacao = Ler.umInt();

        System.out.println("Introduza a local da estadia");
        String local = Ler.umaString();

        System.out.println("Introduza as Carateristicas do quarto");
        String car = Ler.umaString();

        Estadia e2 = new Estadia(car, lotacao, preco_base, local);

        System.out.println("Qual a companhia que oferece");
        //mostra companhia
        for (int i = 0; i < c_v.size(); i++) {
            if (c_v.get(i).getTipo().equals("Estadia")) {
                System.out.println(c_v.get(i));

            }
        }
        //definir a companhia da viagem
        System.out.println("Introduza o ID da Companhia");
        int opcao = Ler.umInt();
        for (int i = 0; i < c_v.size(); i++) {
            if (c_v.get(i).getID() == opcao) {
                e2.setCompanhia(c_v.get(i).getName());
            }
        }
        e1.add(e2);

        //atualizar dados
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("estadias.dat"));

            os.writeInt(Estadia.getUltimo());
            os.writeObject(e1);

            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //------------------------------------------------------------------------------------
    public void mostra_estadia(ArrayList<Estadia> e1) {
        for (int i = 0; i < e1.size(); i++) {
            System.out.println(e1.get(i));
            System.out.println("Preço_Base-> "+e1.get(i).getPreco_base());
            System.out.println(e1.get(i).mostra_clientes());
        }
    }

    //----------------------------------------------------------------------------------
    public void altera_estadia(ArrayList<Estadia> e1) {
        System.out.println("\nQual a estadia que pretende alterar:");
        mostra_estadia(e1);
        int opcao = Ler.umInt();
        int opcao1;
        for (int i = 0; i < e1.size(); i++) {
            if (opcao == e1.get(i).getCod()) {
                do {
                    System.out.println(e1.get(i));
                    System.out.println("Qual o aspeto que pretende alterar na estadia");
                    System.out.println("1-Carateristicas");
                    System.out.println("2-Lotação");
                    System.out.println("3-Local");
                    System.out.println("4-Preço base");
                    System.out.println("0-Cancelar");

                    //selecionar opção
                    opcao1 = Ler.umInt();
                    switch (opcao1) {
                        case 1: //CARATERISTICA
                            System.out.println("Carateristicas");
                            String s = Ler.umaString();
                            e1.get(i).setCar(s);
                            break;
                        case 2: //LOTAÇÃO
                            System.out.println("Lotação");
                            int lotacao = Ler.umInt();
                            e1.get(i).setLotacao_quarto(lotacao);
                            break;
                        case 3: //LOCAL
                            System.out.println("Local");
                            String local = Ler.umaString();
                            e1.get(i).setLocal(local);
                            break;
                        case 4: //PREÇO
                            System.out.println("Preço base");
                            double preco = Ler.umDouble();
                            e1.get(i).setPreco_base(preco);
                            break;
                    }
                }while(opcao1 != 0);
            }
        }
        //atualizar os dados
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("estadias.dat"));

            os.writeInt(Estadia.getUltimo());
            os.writeObject(e1);

            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    //----------------------------------------------------------------------
    public void remove_estadia(ArrayList<Estadia> e1) {
        System.out.println("\nQual estadia pretende remover:");
        mostra_estadia(e1);
        int opcao = Ler.umInt();
        for (int i = 0; i < e1.size(); i++) {
            if (opcao == e1.get(i).getCod()) {
                e1.remove(i);
            }
        }
        //atualizar dados
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("estadias.dat"));

            os.writeInt(Viagem.getUltimo());
            os.writeObject(e1);

            os.flush();
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //------------------------------------------------------------------------------------
    public void mostrar_companhias_removidas(ArrayList<Companhias_viagens> c_v_rem) {
        for (int i = 0; i < c_v_rem.size(); i++) {
            System.out.println(c_v_rem.get(i));
        }
    }
}
