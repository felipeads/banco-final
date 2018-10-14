package br.com.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.banco.bean.Conta;
import br.com.banco.bean.Extrato;
import br.com.banco.connection.Conexao;

public class BancoDAO {

	public void inserirConta(Conta conta) {
		try {
			Connection con = Conexao.getConnection();
			String insertTableSQL = "INSERT INTO CONTA" + "(CPF, VALOR, NOME) VALUES" + "(?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, conta.getCpf());

			preparedStatement.setDouble(2, conta.getValor());

			preparedStatement.setString(3, conta.getNome());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Problema na inserção de dados");
		}
	}

	public Conta getConta(String cpf) {
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("SELECT nome,cpf,valor, id from conta  WHERE  cpf = " + cpf);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Conta conta = new Conta();
				conta.setNome(rs.getString(1));
				conta.setCpf(rs.getString(2));
				conta.setValor(rs.getDouble(3));
				conta.setId(rs.getLong(4));
				return conta;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Problema na inserção de dados");
		}
		return null;
	}
	
	public Conta getContaPorId(Long id) {
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("SELECT nome,cpf,valor, id from conta  WHERE  id = " + id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Conta conta = new Conta();
				conta.setNome(rs.getString(1));
				conta.setCpf(rs.getString(2));
				conta.setValor(rs.getDouble(3));
				conta.setId(rs.getLong(4));
				return conta;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Problema na inserção de dados");
		}
		return null;
	}

	public void novoValor(Double valorAtual, Double valor, Long idConta) {
		try {
			Connection con = Conexao.getConnection();
			String updateTableSQL = "UPDATE  CONTA SET VALOR=? WHERE ID = ?";
			PreparedStatement preparedStatement = con.prepareStatement(updateTableSQL);
			preparedStatement.setDouble(1, valorAtual + valor);
			preparedStatement.setLong(2, idConta);

			preparedStatement.executeUpdate();

			String insertTableSQL = "INSERT INTO EXTRATO" + "( VALOR, OPERACAO, ID_CONTA) VALUES" + "(?,?,?)";
			preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setDouble(1, valor);
			String operacao = "Débito";
			if (valor < 0) {
				operacao = "Crédito";
			}
			preparedStatement.setString(2, operacao);

			preparedStatement.setLong(3, idConta);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Problema na inserção de dados");
		}
	}

	public List<Extrato> listarExtrato(Long idConta) {
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("SELECT valor,operacao,id_conta, id from extrato  WHERE  id_conta = " + idConta);
			ResultSet rs = preparedStatement.executeQuery();
			List<Extrato> extratos = new ArrayList<>();
			while (rs.next()) {
				Extrato extrato = new Extrato();
				extrato.setValor(rs.getDouble(1));
				extrato.setOperacao(rs.getString(2));
				extrato.setIdConta(rs.getLong(3));
				extrato.setId(rs.getLong(4));
				extratos.add(extrato);
			}
			return extratos;
		} catch (SQLException e) {
			throw new RuntimeException("Problema na listagem de dados");
		}
	}
}
