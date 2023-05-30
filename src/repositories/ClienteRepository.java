package repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import factories.ConnectionFactory;

public class ClienteRepository {

	// método para receber e cadastrar um cliente no banco de dados
	public void create(Cliente cliente) throws Exception {
		
		// abrindo conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory(); 
		Connection connection = connectionFactory.getConnection();
		
		// escrevendo um comando em liguagem SQL para inserir um cliente no banco de dados
		PreparedStatement statement = connection.prepareStatement("INSERT INTO CLIENTE(nome, email, telefone, cpf) VALUES(?,?,?,?)");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.setString(4, cliente.getCpf());
		statement.execute();
		
		// fechando a conexão
		connection.close();
		
	}
	
	// método para receber e atualizar um cliente em banco de dados
	public void update(Cliente cliente) throws Exception {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		// escrevendo um comando em linguagem SQL para atualizar um cliente no banco de dados 
		PreparedStatement statement = connection.prepareStatement("UPDATE CLIENTE SET nome=?, email=? , telefone=?, cpf=? WHERE idcliente=?");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.setString(4, cliente.getCpf());
		statement.setInt(5, cliente.getIdCliente());
		statement.execute();
		
	
		connection.close();
	}
	
	// método para receber e excluir um cliente no banco de dados
	public void delete(Cliente cliente) throws Exception {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("DELETE FROM CLIENTE WHERE idcliente=? ORDER BY idcliente");
		statement.setInt(1, cliente.getIdCliente());
		statement.execute();
		
		connection.close();
	}
	
	// método para consultar todos os clientes cadastrados no banco de dados
	public List<Cliente> findAll() throws Exception {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM CLIENTE");
		ResultSet resultSet = statement.executeQuery();
		
		// declarando listagem de clientes
		List<Cliente> lista = new ArrayList<Cliente>();
		
		// percorrendo cada registro obtido do banco de dados
		while(resultSet.next()) {
			
			Cliente cliente = new Cliente();
			
			cliente.setIdCliente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));
			cliente.setTelefone(resultSet.getString("telefone"));
			cliente.setCpf(resultSet.getString("cpf"));
			
			lista.add(cliente);
		}
		
		connection.close();
		return lista;
	}
}
