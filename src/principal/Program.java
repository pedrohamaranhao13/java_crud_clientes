package principal;

import controllers.ClienteController;

public class Program {
	
	public static void main(String[] args) {
		
		ClienteController clienteController = new ClienteController();
		clienteController.cadastrarCliente();
	}

}
