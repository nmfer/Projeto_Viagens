package Viagens;
import my_inputs.Ler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {

    //MENU VIAGENS
//-----------------------------------------------------------------------------------
    public static int menu_viagens(){
        int opcao;
        System.out.println("Vamos viajar? De que forma?");
        System.out.println("1 - Avião");
        System.out.println("2 - Comboio");
        System.out.println("3 - Barco");
        System.out.println("0 - Voltar ao menu principal");

        opcao = Ler.umInt();
        return opcao;
    }


    //MENU GESTOR
//------------------------------------------------------------------------------------
    public static void menu_gestor(Gestor g1){
        int opcao;
        do {
            System.out.println("1 - Adicionar Companhia");
            System.out.println("2 - Mostra Companhias");
            System.out.println("3 - Alterar Companhia");
            System.out.println("4 - Remover Companhia ");
            System.out.println("5 - Adicionar Viagem"); //origem/destino/custo
            System.out.println("6 - Alterar viagem");
            System.out.println("7 - Remover viagem");
            System.out.println("8 - Visualizar viagens");
            //ver as viagens e os respetivos clientes que reservaram aas mesmas
            System.out.println("9 - Adicionar Estadia");
            System.out.println("10 - Remover Estadia");
            System.out.println("11 - Alterar Estadia");
            //ver as estadias?? ou no 8 - visualizar viagens; por cada clienete apresentar se há ou não estadia reservada e caso seja apresenta o mesmo
            System.out.println("12 - Visualizar viagens antigas");
            System.out.println("13 - Aluguer carros");

            opcao = Ler.umInt(); //introduz a opção escolhida
            g1.main_menu(opcao); //"manda" para o Main Menu do Gestor
        }while(opcao!=0);
    }



    //MENU MAIN
//-------------------------------------------------------------------------------------
    public static int main_menu(){
        int opcao;
        System.out.println("BEM VINDO!!"+"\nO que pretende fazer?");
        System.out.println("1 - Consultar Viagens");
        System.out.println("2 - Gestor -> Iniciar sessão");
        System.out.println("3 - Consultar Bilhetes");
        System.out.println("0 - Sair");

        opcao = Ler.umInt();
        return opcao;
    }
//-------------------------------------------------------------------------------------
    public static void main(String[] args) {
        ArrayList<Companhias_viagens> cv = new ArrayList<>();
        /*try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("companhias_viagem.dat"));
            cv = (ArrayList<Companhias_viagens>)is.readObject();
            is.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }*/
        Gestor g1 = new Gestor(); //instanciar gestor

        Cliente c1 = new Cliente();
        int opcao; //= Main.main_menu();
        do{
            opcao = Main.main_menu();
            switch(opcao){
                case 1: //CONSULTAR VIAGENS
                    int opcao1;// = Main.menu_viagens();
                    do{
                        //-------------------------------------------------
                        opcao1 = Main.menu_viagens();
                        switch(opcao1){
                            case 1:
                                c1.mostrar_Viagens();
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        //---------------------------------------------------
                        }
                    }while(opcao1 != 0);
                    break;
                case 2://GESTOR LOGIN
                    if(g1.Login() == true){
                        Main.menu_gestor(g1);
                    }
                    break;
                case 3:
                //case 4:
            }
        }while(opcao != 0);
    }
}
