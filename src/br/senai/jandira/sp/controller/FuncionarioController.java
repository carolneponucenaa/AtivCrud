package br.senai.jandira.sp.controller;

import br.senai.jandira.sp.model.Conexao;
import br.senai.jandira.sp.model.Funcionario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {

    Conexao conexao =new Conexao();
    Connection connection = conexao.getConnection();
    public void listarFuncionario() throws SQLException {
        Statement statement = connection.createStatement();
        String queryList = "SELECT * FROM funcionarios";

        ResultSet resultSet = statement.executeQuery(queryList);
        Funcionario funcionario = new Funcionario();
        while (resultSet.next()){
            funcionario.setIdFuncionario(resultSet.getInt("id_funcionario"));
            funcionario.setNome(resultSet.getNString("nome"));
            funcionario.setCargo(resultSet.getNString("cargo"));
            funcionario.setDepartamento(resultSet.getNString("departamento"));
            funcionario.setSalario(resultSet.getDouble("salario"));

            System.out.println(funcionario.getIdFuncionario());
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getCargo());
            System.out.println(funcionario.getDepartamento());
            System.out.println(funcionario.getSalario());
        }
    }
    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException {
        Statement statement = connection.createStatement();

        String queryCadastro = "INSERT INTO funcionarios (id_funcionario, nome, cargo, departamento, salario)values (" +
                funcionario.getIdFuncionario() + ",'" + funcionario.getNome() + "','" + funcionario.getCargo() + "','" +
                funcionario.getDepartamento() + "'," + funcionario.getSalario() + ")";

    }
    public void deletarFuncionario(String nome)throws SQLException {
        Statement statement = connection.createStatement();
        String queryDelete = "DELETE FROM funcionarios WHERE nome='"+ nome+ "'";
        statement.executeUpdate(queryDelete);
        System.out.println("funcionario "+ nome + " deletado com sucesso!!");

    }
    public void editarFuncionario(String nome, double salario) throws SQLException {
        Statement statement = connection.createStatement();
        String queryUpdate = "UPDATE funcionarios SET salario =" +salario+ " WHERE nome = '" + nome+ "'";

        statement.executeUpdate(queryUpdate);
        System.out.println("Dados alterados com sucesso!! ");

    }
    public void consultarFuncionario(String nome) throws SQLException {
        Statement statement = connection.createStatement();
        String queryConsulta = "SELECT * FROM funcionarios WHERE nome = '" + nome +"'";

        ResultSet resultSet = statement.executeQuery(queryConsulta);
        List<Funcionario>listConsulta = new ArrayList<>();

        while (resultSet.next()){
            Funcionario funcionario = new Funcionario();
            funcionario.setIdFuncionario(resultSet.getInt("id_funcionario"));
            funcionario.setNome(resultSet.getNString("nome"));
            funcionario.setCargo(resultSet.getNString("cargo"));
            funcionario.setDepartamento(resultSet.getNString("departamento"));
            funcionario.setSalario(resultSet.getDouble("salario"));

            System.out.println(funcionario.getIdFuncionario());
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getCargo());
            System.out.println(funcionario.getDepartamento());
            System.out.println(funcionario.getSalario());

            listConsulta.add(funcionario);

        }
        for (Funcionario funcionario:listConsulta){
            System.out.println(funcionario.getIdFuncionario());
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getCargo());
            System.out.println(funcionario.getDepartamento());
            System.out.println(funcionario.getSalario());
            System.out.println("-------------------------------------------");
        }


    }
}
