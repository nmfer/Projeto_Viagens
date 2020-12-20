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
        System.out.println("1 - Mostrar Viagens");
        System.out.println("2 - Comprar Viagem");
        System.out.println("3 - Mostrar Estadia");
        System.out.println("4 - Alugar Estadia");
        System.out.println("0 - Voltar ao menu principal");

        opcao = Ler.umInt();
        return opcao;
    }


    //MENU GESTOR
//------------------------------------------------------------------------------------
    public static void menu_gestor(Gestor g1){
        int opcao;
        do {
            System.out.println("1 - Mostra Companhias");
            System.out.println("2 - Adiciona Companhia");
            System.out.println("3 - Alterar Companhia");
            System.out.println("4 - Remover Companhia ");
            System.out.println("5 - Visualizar Viagem");
            System.out.println("6 - Adicionar Viagem");
            System.out.println("7 - Alterar Viagem");
            System.out.println("8 - Remover Viagens");

            System.out.println("9 - Visualizar Estadias");
            System.out.println("10 - Adicionar Estadia");
            System.out.println("11 - Alterar Estadia");
            System.out.println("12 - Remover Estadia");

            System.out.println("13 - Visualizar companhias removidas");
            System.out.println("0 - Cancelar/voltar");

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
        System.out.println("3 - Consultar Reservas");
        System.out.println("0 - Sair");

        opcao = Ler.umInt();
        return opcao;
    }
//-------------------------------------------------------------------------------------
    public static void main(String[] args) {
        //ArrayList<Companhias_viagens> cv = new ArrayList<>();
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
                                c1.mostrar_Viagem(c1.abrir_Viagens());
                                break;
                            case 2:
                                c1.comprar_Viagem();
                                break;
                            case 3:
                                c1.mostrar_Estadias(c1.abrir_Estadias());
                                break;
                            case 4:
                                c1.alugar_estadia();
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
                    c1.display_cliente();
                    break;
            }
        }while(opcao != 0);
    }
}
