package classes;

import java.io.IOException;
import java.util.*;

public class App {
    Scanner read = new Scanner(System.in);
    boolean loggedIn;
    User loggedUser;
    SysIO sysio;
    HashMap<String, User> data;

    public App() throws Exception {
        System.out.println("Iniciando sistema...");
        read = new Scanner(System.in);
        loggedIn = false;
        loggedUser = null;
        sysio = new SysIO("data.txt");
        data = sysio.getData(); // obtem os dados cadastrados
    }

    public void start() throws IOException {
        System.out.println("Bem vindo!\nO que deseja fazer?");
        int ans;
        do {
            System.out.println("1 - Logar\t 2 - Cadastrar\t 3 - Editar\t 4 - Sair\n");
            ans = Integer.parseInt(read.next());
            read.nextLine();

            this.func(ans);

            if (ans == 4)
                System.out.println("\n\nSaindo!\n\n");
        } while (ans != 4);
        try {
            sysio.save(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void func(int ans) {
        switch (ans) {
        case 1:
            // login
            System.out.println("Digite o usuário: ");
            String username = read.next();
            System.out.println("Digite a senha: ");
            String password = read.next();
            if (login(username, password)) {
                loggedIn = true;
                System.out.println("Logado com sucesso.");
            } else {
                if (loggedUser == null)
                    loggedIn = false;
                System.out.println("Usuário ou senha incorretos.");
            }
            System.out.println("loggedin = " + loggedIn);
            System.out.println("loggeduser = " + loggedUser);
            break;
        case 2:
            // cadastro de novo usuario
            System.out.println("Deseja cadastrar um: 1 - Administrador\t2 - Cliente\t3 - Profissional");
            int op = read.nextInt();
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
            String tempUsername = read.nextLine();
            if (data.containsKey(tempUsername)) {
                System.out.println("Usuário já existente");
                break;
            }
            System.out.println("Digite a senha:");
            String tempPassword = read.nextLine();
            System.out.println("Digite o nome:");
            String tempName = read.nextLine();
            System.out.println("Digite o telefone:");
            String tempPhone = read.next();
            System.out.println("Digite o email:");
            String tempEmail = read.next();
            read.nextLine();
            System.out.println("Digite o endereço:");
            String tempAddr = read.nextLine();
            User tempUser = null;

            switch (op) {
            case 1:
                tempUser = new Manager(op, tempUsername, tempPassword, tempName, tempPhone, tempEmail, tempAddr);
                break;
            case 2:
                tempUser = new Client(op, tempUsername, tempPassword, tempName, tempPhone, tempEmail, tempAddr);
                break;
            case 3:
                tempUser = new Worker(op, tempUsername, tempPassword, tempName, tempPhone, tempEmail, tempAddr);
                break;
            }
            System.out.println(tempUser.login + tempUser.password + tempUser.phone);

            data.put(tempUsername, tempUser);
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
        }
    }

    private boolean login(String username, String password) {
        User user = data.get(username);
        if (user == null)
            return false;
        if (user.authenticate(password)) {
            loggedUser = user;
            return true;
        } else {
            return false;
        }
    }

}