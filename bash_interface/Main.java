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
		String tempUsername;
		User tempUser;
		int op;

		int ans;
		do {
			System.out.println("1 - Logar\t 2 - Cadastrar\t 3 - Editar\t 4 - Sair\n");
			ans = Integer.parseInt(read.next());
			read.nextLine();
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
				System.out.println("Deseja cadastrar um: 1 - Administrador\t2 - Cliente\t3 - Profissional");
				op = read.nextInt();
				read.nextLine();
				if (op < 1 || op > 3) {
					System.out.println("Número inválido");
					break;
				}
				if (op == 1)
					if (!loggedIn || !(loggedUser instanceof Manager)) {
						System.out.println("Você deve estar logado como administrador para realizar essa operação!");
						break;
					}

				System.out.println("Digite o usuário:");
				tempUsername = read.nextLine();
				System.out.println("Digite a senha:");
				String tempPassw = read.nextLine();
				System.out.println("Digite o nome:");
				String tempName = read.nextLine();
				System.out.println("Digite o telefone:");
				String tempPhone = read.next();
				System.out.println("Digite o email:");
				String tempEmail = read.next();
				read.nextLine();
				System.out.println("Digite o endereço:");
				String tempAddr = read.nextLine();
				tempUser = null;

				if (!loggedIn) {
					if (op == 2)
						tempUser = new Client(op, tempUsername, tempPassw, tempName, tempPhone, tempEmail, tempAddr);
					else if (op == 3)
						tempUser = new Worker(op, tempUsername, tempPassw, tempName, tempPhone, tempEmail, tempAddr);
					data.put(tempUsername, tempUser);
					break;
				} else {
					switch (op) {
					case 1:
						tempUser = new Manager(op, tempUsername, tempPassw, tempName, tempPhone, tempEmail, tempAddr);
						break;
					case 2:
						tempUser = new Client(op, tempUsername, tempPassw, tempName, tempPhone, tempEmail, tempAddr);
						break;
					case 3:
						tempUser = new Worker(op, tempUsername, tempPassw, tempName, tempPhone, tempEmail, tempAddr);
						break;
					}
					data.put(tempUsername, tempUser);

				}
				System.out.println("Cadastrou");
				break;
			case 3:
				// update
				if (!loggedIn) {
					System.out.println("Você deve estar logado para realizar essa operação");
					break;
				} else if (loggedUser instanceof Manager) {
					System.out.println("Qual usuário deseja editar?");
					tempUsername = read.nextLine();
				} else
					tempUsername = loggedUser.login;

				if (!data.containsKey(tempUsername)) {
					System.out.println("Usuário inexistente");
					break;
				}

				System.out.println(
						"Digite o campo a ser alterado: 1 - Senha\t2 - Nome\t3 - Telefone\t 4 - Email\t5 - Endereço");
				op = read.nextInt();
				read.nextLine();
				System.out.println("Digite o novo valor para o campo");
				String temp = read.nextLine();
				tempUser = data.get(tempUsername);
				data.remove(tempUsername);

				switch (op) {
				case 1:
					tempUser.setPassword(temp);
					data.put(tempUsername, tempUser);
					break;
				case 2:
					tempUser.setName(temp);
					data.put(tempUsername, tempUser);
					break;
				case 3:
					tempUser.setPhone(temp);
					data.put(tempUsername, tempUser);
					break;
				case 4:
					tempUser.setEmail(temp);
					data.put(tempUsername, tempUser);
					break;
				case 5:
					tempUser.setAddress(temp);
					data.put(tempUsername, tempUser);
					break;
				default:
					System.out.println("Digite um número válido");
				}

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