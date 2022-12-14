package com.mycompany.mavenproject1.Opcoes_Menu.MenuAdqAnimalCar;

import com.mycompany.mavenproject1.Classes_Aux.AuxRand;
import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;
import com.mycompany.mavenproject1.Menus.MenuAdqAnimalCarc;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.Historico;

import java.util.Scanner;

public class carcEspecie extends OpcaoMenu {

    private MenuAdqAnimalCarc menu;
    private final int precoCaracteristica;

    // constructor
    public carcEspecie(MenuAdqAnimalCarc menu) {
        super();
        this.menu = menu;
        this.precoCaracteristica = 500;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        showText();
        menu.showMenu();
    }

    // function that shows the text of this option
    private void showText() {
        Scanner input = new Scanner(System.in);

        if (CaracteristicasEspecie.getCaracteristicasEspecie().size() == 0) {
            System.out.println("Não existem caracteristicas de especie disponiveis!");
            menu.showMenu();
        } else {
            // asks the user to select a characteristic
            System.out.println("\n");
            System.out.println("Selecione a caracteristica que deseja adquirir:");
            for (int i = 0; i < CaracteristicasEspecie.getCaracteristicasEspecie().size(); i++) {
                System.out.println(
                        "[" + i + "] - "
                                + CaracteristicasEspecie.getCaracteristicasEspecie().get(i).getCaracteristicas());
            }

            System.out.print("Opção: ");
            int opcao = input.nextInt();

            try {
                createRandomAnimal(opcao);

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Opção inválida! Voltando ao menu anterior...");
                menu.showMenu();
            }
        }

    }

    // function that creates a random animal with the desired characteristic
    private void createRandomAnimal(int opcao) throws IndexOutOfBoundsException {
        Animal ani = AuxRand.randomAnimal(); // creates a random animal
        double precoAnimal = AuxRand.getRandomPreco() + precoCaracteristica; // gets the random price of the animal

        // checks if the zoo has enough money to buy the animal
        if (menu.getMenu().getZoo().getSaldoContabilistico() < precoAnimal) {
            System.out.println("Não tem dinheiro suficiente para adquirir este animal!");
            menu.showMenu();
        } else {
            // checks if the animal has the desired characteristic
            if (ani.getCaracteristicasEspecie()
                    .contains(CaracteristicasEspecie.getCaracteristicasEspecie().get(opcao))) {
                System.out.println("\n");
                System.out.println("Foi adquirido o seguinte animal: ");
                System.out.println(ani.basicInfo()); // adicionar maneira de ver as caracteristicas da especie

                // adds the animal to the zoo and decreases the zoo's money
                menu.getMenu().getZoo().addAnimalZoo(ani);
                menu.getMenu().getZoo().decreaseZooMoney(AuxRand.getRandomPreco() +
                        precoCaracteristica);
                Historico.addAnimalAdquerido(ani);
            } else {
                // calls the funtion again until the animal has the desired characteristic
                createRandomAnimal(opcao);
            }
        }
    }
}
