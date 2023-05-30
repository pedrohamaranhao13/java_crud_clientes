package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import repositories.ClienteRepository;

public class ClienteController {
	
	public void cadastrarCliente() {
		
		System.out.println("\n*** CADASTRO DE CLIENTE ***\n");
		Scanner scanner = new Scanner(System.in);
		
		Cliente cliente =  new Cliente();
		
		System.out.print("NOME DO CLIENTE.......: ");
		cliente.setNome(scanner.nextLine());
		
		System.out.print("E-MAIL DO CLIENTE.....: ");
		cliente.setEmail(scanner.nextLine());
		
		System.out.print("TELEFONE DO CLIENTE...: ");
		cliente.setTelefone(scanner.nextLine());
		
		System.out.print("CPF DO CLIENTE........: ");
		cliente.setCpf(scanner.nextLine());
		
		ClienteRepository clienteRepository = new ClienteRepository();
		
		try {
			clienteRepository.create(cliente);
			System.out.println("\nCLIENTE CADASTRADO COM SUCESSO!");
		} catch (Exception e) {
			System.out.println("\nNão foi possível cadastrar cliente!");
			e.printStackTrace(); // imprimir log do erro
		}
				
		scanner.close();
	}
	
	public void atualizarCliente() {
		
		System.out.println("\n*** ATUALIZAÇÃO DE CLIENTE ***\n");
		Scanner scanner = new Scanner(System.in);
		
		Cliente cliente =  new Cliente();
		
		System.out.print("ID DO CLIENTE.......: ");
		cliente.setIdCliente(Integer.parseInt(scanner.nextLine()));
		
		System.out.print("NOME DO CLIENTE.......: ");
		cliente.setNome(scanner.nextLine());
		
		System.out.print("E-MAIL DO CLIENTE.....: ");
		cliente.setEmail(scanner.nextLine());
		
		System.out.print("TELEFONE DO CLIENTE...: ");
		cliente.setTelefone(scanner.nextLine());
		
		System.out.print("CPF DO CLIENTE........: ");
		cliente.setCpf(scanner.nextLine());
		
		ClienteRepository clienteRepository = new ClienteRepository();
		
		
		try {
			clienteRepository.update(cliente);
			System.out.println("\nCLIENTE ATUALIZADO COM SUCESSO!");
		} catch (Exception e) {
			System.out.println("\nNão foi possível atualizar cliente!");
			e.printStackTrace(); // imprimir log do erro
		}
				
		scanner.close();
	}
	
	public void excluirCliente() {
		
		System.out.println("\n*** DELETAR CLIENTE ***\n");
		Scanner scanner = new Scanner(System.in);
		
		Cliente cliente =  new Cliente();
		
		System.out.print("ID DO CLIENTE.......: ");
		cliente.setIdCliente(Integer.parseInt(scanner.nextLine()));
		
		ClienteRepository clienteRepository = new ClienteRepository();
		
		try {
			clienteRepository.delete(cliente);
			System.out.println("\nCLIENTE DELETADO COM SUCESSO!");
		} catch (Exception e) {
			System.out.println("\nNão foi possível deletar cliente!");
			e.printStackTrace(); // imprimir log do erro
		}
				
		scanner.close();
	}
	
	public void consultarClientes() {
		System.out.println("\n*** CONSULTA DE CLIENTES ***\n");
		
		ClienteRepository clienteRepository = new ClienteRepository();
		
		try {
				List<Cliente> lista = clienteRepository.findAll();
				
				for(Cliente cliente : lista) { //foreach
					System.out.println("ID DO CLIENTE..........: " + cliente.getIdCliente());
					System.out.println("NOME DO CLIENTE........: " + cliente.getNome());
					System.out.println("E-MAIL DO CLIENTE......: " + cliente.getEmail());
					System.out.println("TELEFONE DO CLIENTE....: " + cliente.getTelefone());
					System.out.println("CPF DO CLIENTE.........: " + cliente.getCpf());
				}
				
		} catch(Exception e) {
			System.out.println("\nFALHA AO CONSULTAR CLIENTES");
			e.printStackTrace();// imprimir log de erro
		}
	}

}
