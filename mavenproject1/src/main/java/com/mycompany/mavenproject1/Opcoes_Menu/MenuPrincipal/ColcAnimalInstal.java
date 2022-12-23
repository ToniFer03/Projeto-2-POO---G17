package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.Scanner;

//referente a opcaao de menu "Colocar animal em instalação"
public class ColcAnimalInstal extends OpcaoMenu {

    private MenuPrincipal menu;

    // constructor
    public ColcAnimalInstal(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        mostrarAnimais();
        menu.showMenu();
    }

    // function that shows all the installations and ask the user to choose one
    private int mostrarInstalacoes() {
        // text to show the user the installations
        System.out.println("\n");
        System.out.println("Instalações no zoo: ");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < menu.getZoo().getInstalacoes().size(); i++) {
            System.out.println(menu.getZoo().getInstalacoes(i).toString());
        }
        System.out.print("Escolha uma instalação: ");
        Scanner sc = new Scanner(System.in);
        int idInstalacao = sc.nextInt();

        // check if the installation exists
        if (menu.getZoo().getInstalacoes(idInstalacao) == null) {
            System.out.println("Instalação não existe, por favor selecione uma instalação válida!");
            return mostrarInstalacoes(); // recursive call if the installation doesn't exist
        } else {
            return idInstalacao; // return the installation id
        }
    }

    // function that show the animals and ask the user to choose one
    private void mostrarAnimais() {
        // text to show the user the animals
        System.out.println("\n");
        System.out.println("Animais no zoo: ");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < menu.getZoo().getAnimaisSemInstacao().size(); i++) {
            System.out.println(menu.getZoo().getAnimaisSemInstacao(i).toString());
        }
        System.out.print("Escolha um animal: ");
        Scanner sc = new Scanner(System.in);
        int idAnimal = sc.nextInt();

        // check if the animal exists
        if (menu.getZoo().getTodosAnimais(idAnimal) == null) {
            System.out.println("Animal não existe, por favor selecione um animal válido!");
            mostrarAnimais(); // recursive call if the animal doesn't exist
        } else {
            colocarAnimal(idAnimal, mostrarInstalacoes()); // call the function to put the animal in the installation
        }
    }

    // function to put the animal in the installation
    private void colocarAnimal(int idAnimal, int idInstalacao) {
        Animal ani = menu.getZoo().getTodosAnimais(idAnimal);
        Instalacao instal = menu.getZoo().getInstalacoes(idInstalacao);

        instal.addAnimal(ani, idInstalacao);
        menu.getZoo().removerAnimalSemInstalacao(ani);
        System.out.println("Animal colocado com sucesso.");
    }
}
