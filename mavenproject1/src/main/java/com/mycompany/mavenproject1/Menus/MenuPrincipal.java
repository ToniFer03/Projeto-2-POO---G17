package com.mycompany.mavenproject1.Menus;

import com.mycompany.mavenproject1.Classes_Principais.Zoo;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.AdqAnimalCaracGen;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.AdqAnimalRand;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.CalendChines;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.ConstInstal;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.Historico;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.Jumanji;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.ListAnimais;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.ListAnimaisCarcGenetica;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.ListAnimaisMutacao;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.ListInstal;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.Obituario;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.PeriodoConta;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.RetratoFamilia;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.sairMenu;

public class MenuPrincipal extends MenuBase {
    // declare variables
    private Zoo zoo;

    // constructor
    public MenuPrincipal(Zoo zoo) {
        super();
        addOpcaoMenu(new sairMenu(this));
        addOpcaoMenu(new AdqAnimalRand(this));
        addOpcaoMenu(new AdqAnimalCaracGen(this));
        addOpcaoMenu(new ConstInstal(this));
        addOpcaoMenu(new CalendChines(this));
        addOpcaoMenu(new ListAnimais(this));
        addOpcaoMenu(new ListAnimaisCarcGenetica(this));
        addOpcaoMenu(new ListAnimaisMutacao(this));
        addOpcaoMenu(new ListInstal(this));
        addOpcaoMenu(new RetratoFamilia(this));
        addOpcaoMenu(new Obituario(this));
        addOpcaoMenu(new Historico(this));
        addOpcaoMenu(new PeriodoConta(this));
        addOpcaoMenu(new Jumanji(this));
        this.zoo = zoo;
    }

    // show MenuPrincipal options
    @Override
    public void showMenu() {
        System.out.println("\n \n \n");
        System.out.println("Escolha uma das seguintes opções: ");
        System.out.println("[1] - Adquirir animal aleatório");
        System.out.println("[2] - Adquirir animal com característica genética");
        System.out.println("[3] - Construir instalação");
        System.out.println("[4] - Calendário chinês");
        System.out.println("[5] - Listar animais");
        System.out.println("[6] - Listar animais com dada característica genética");
        System.out.println("[7] - Listar animais com dada mutação");
        System.out.println("[8] - Listar instalações");
        System.out.println("[9] - Retrato de família animal");
        System.out.println("[10] - Obituário");
        System.out.println("[11] - Histórico");
        System.out.println("[12] - Período contabilístico");
        System.out.println("[13] - Jumanji");
        System.out.println("[0] - Sair da aplicação");
        System.out.print("Digite a sua opção: ");
        executeItem(getOption());
    }

    // get zoo
    public Zoo getZoo() {
        return zoo;
    }
}