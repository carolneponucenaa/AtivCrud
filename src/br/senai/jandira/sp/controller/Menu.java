package br.senai.jandira.sp.controller;

import br.senai.jandira.sp.model.Funcionario;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public void executarMenu() throws SQLException {
        boolean continuar = true;
        while(continuar){
            System.out.println("-------------- BEM VINDO --------------------");
            System.out.println("---------------------------------------------");
            System.out.println("-------------- MENU -----------------");
            System.out.println("1- Listar funcionário ");
            System.out.println("2- Cadastrar funcionário");
            System.out.println("3- Editar funcionário ");
            System.out.println("4- Deletar funcionário");
            System.out.println("5- Pesquisar funcionário");
            System.out.println("6- Sair");
            System.out.println("--------------------------------------");

            Scanner scanner = new Scanner(System.in);

            int userOption = scanner.nextInt();
            scanner.nextLine();
            FuncionarioController funcionario =  new FuncionarioController();
            switch (userOption){
                case 1:
                    funcionario.listarFuncionario();
                    break;
                case 2:
                    Funcionario newFuncionario = new Funcionario();
                    newFuncionario.cadastrarFuncionarios();

                    funcionario.cadastrarFuncionario(newFuncionario);
                    break;
                case 3:
                    System.out.println("Informe o nome de deseja atualizar: ");
                    String nomeUpdate = scanner.nextLine();
                    System.out.println("Informe o novo salário: ");
                    Double newSalario = scanner.nextDouble();
                    scanner.nextLine();

                    funcionario.editarFuncionario(nomeUpdate, newSalario);
                    break;

                case 4:
                    System.out.println("Informe o nome que deseja excluir:");
                    String nome = scanner.nextLine();
                    funcionario.deletarFuncionario(nome);
                    break;
                case 5:
                    System.out.println("Informe o nome que deseja pesquisar: ");
                    String nomeConsulta = scanner.nextLine();
                    funcionario.consultarFuncionario(nomeConsulta);
                    break;
                case 6:
                    break;
            }
        }
    }
}
