package bash_interface;

import java.util.*;
import classes.*;

/**
 * main
 */
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner read = new Scanner(System.in);
		System.out.println("Bem-vindo!! O que deseja fazer?\n");
		boolean loggedIn = false;
		User loggedUser = null;
		SysIO system = new SysIO("data.txt");
		HashMap<String, User> data = system.getData();

		int ans;
		do {
			System.out.println("1 - Logar\t 2 - Cadastrar\t 3 - Editar\t 4 - Sair\n");
			ans = Integer.parseInt(read.next());

			switch (ans) {
			case 1:
				// login
				System.out.println("Digite o usuário: ");
				User user = data.get(read.next());
				if (user == null) {
					System.out.println("Usuário inexistente!");
					break;
				}
				System.out.println("Digite a senha: ");
				loggedIn = user.authenticate(read.next());
				if (loggedIn) {
					System.out.println("Login efetuado!");
					loggedUser = user;
				} else {
					System.out.println("Senha incorreta!");
				}
				break;
			case 2:
				// cadastro de novo usuario
				int op;
				System.out.println("\nDeseja cadastrar um: 1 - Administrador\t 2 - Cliente\t 3 - Profissional\n");
				op = Integer.parseInt(read.next());
				if (op == 1) {
					System.out.println("not implemented yet");
				}
				System.out.println("Cadastrou");
				break;
			case 3:
				// update
				System.out.println("Editou");
				break;
			default:
				System.out.println("\nValor inválido! Digite outra opção:\n");
			}
			System.out.println("\nO que mais?\n");
		} while (ans != 4);

		system.save(data, "data.txt");

	}
}