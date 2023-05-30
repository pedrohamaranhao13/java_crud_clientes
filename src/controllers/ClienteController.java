package controllers;

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

}
