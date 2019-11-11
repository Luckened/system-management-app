package classes;

import java.io.IOException;
import java.util.*;

public class App {
    Scanner read = new Scanner(System.in);
    boolean loggedIn;
    User loggedUser;
    SysIO sysio;
    HashMap<String, User> data;
    ArrayList<Service> services;
    HashMap<String, Request> requests;
    int ans;

    public App() throws Exception {
        System.out.println("Iniciando sistema...");
        read = new Scanner(System.in);
        loggedIn = false;
        loggedUser = null;
        sysio = new SysIO("data.txt");
        data = sysio.getData(); // obtem os dados cadastrados

        ans = 0;
        services = new ArrayList<Service>();
    }

    public void start() throws IOException {
        System.out.println("\nBem vindo!\nO que deseja fazer?");

        do {
            try {
                if (!loggedIn) {
                    System.out.println("\n1 - Logar\t 2 - Cadastrar\t 3 - Editar  \t 4 - Sair do Sistema\n");
                    ans = Integer.parseInt(read.next());
                    read.nextLine();
                    this.func();
                } else if (loggedIn) {
                    this.loggedInFunc();
                }

                if (ans == 200)
                    System.out.println("\n\nSaindo!\n\n");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Houve algum erro! Tente novamente por favor:");
            }
        } while (ans != 200);
        try {
            sysio.save(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loggedInFunc() {
        // int ans;
        if (loggedUser instanceof Client) {
            System.out.println(
                    "\n1 - Deslogar\t 2 - Editar\t 3 - Cadastrar Serviço\t4 - Cadastrar Pedido\t5 - Sair do Sistema\n");
            ans = Integer.parseInt(read.next());
            read.nextLine();
            switch (ans) {
            case 1:
                // logoff
                this.logoff();
                break;
            case 2:
                // update
                this.editUser();
                break;
            case 3:
                this.registerService();
                break;
            case 4:
                // criar orçamento
                this.makeRequest((Client) loggedUser);
                break;
            case 5:
                ans = 200;
                return;
            default:
                System.out.println();
            }
        } else if (loggedUser instanceof Worker) {
            System.out.println(
                    "\n1 - Deslogar\t 2 - Editar\t 3 - Cadastrar Serviço\t4 - Associar Serviço\t5 - Listar pedidos\t6 - Sair do Sistema\n");
            ans = Integer.parseInt(read.next());
            read.nextLine();
            switch (ans) {
            case 1:
                // logoff
                this.logoff();
                break;
            case 2:
                // edição de usuario
                this.editUser();
                break;
            case 3:
                // cadastro de serviço
                this.registerService();
                break;
            case 4:
                // adicionar serviço que ele pode realizar
                break;
            case 5:
                // listar pedidos
                break;
            case 6:
                ans = 200;
                return;

            }
        }
        if (loggedUser instanceof Manager) {
            System.out.println(
                    "\n1 - Deslogar\t 2 - Cadastrar\t 3 - Editar\t 4 - Cadastrar Serviço\t 5 - Validar serviços\t 6 - Listar pedidos\t 7 - Sair do Sistema\n");
            ans = Integer.parseInt(read.next());
            read.nextLine();
            switch (ans) {
            case 1:
                // logoff
                this.logoff();
                break;
            case 2:
                // cadastro de novo usuario
                this.registerUser();
                break;
            case 3:
                // update
                this.editUser();
                break;
            case 4:
                // cadastrar um pedido
                this.registerService();
                break;
            case 5:
                // Manipulaçao de serviços pelo admin.
                break;
            case 6:
                // listar pedidos
                break;
            case 7:
                ans = 200;
                return;
            }
        }
    }

    private void func() {
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

            break;
        case 2:
            // cadastro de novo usuario
            this.registerUser();
            break;
        case 3:
            // update
            this.editUser();
            break;
        case 4:
            ans = 200;
            return;
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

    private void logoff() {
        loggedIn = false;
        loggedUser = null;
        System.out.println("Usuario deslogado!");
    }

    private void editUser() {
        // update
        String tempUsername;
        User tempUser;
        int op;
        if (!loggedIn) {
            System.out.println("Você deve estar logado para realizar essa operação");
            return;
        } else if (loggedUser instanceof Manager) {
            System.out.println("Qual usuário deseja editar?");
            tempUsername = read.nextLine();
        } else
            tempUsername = loggedUser.login;

        if (!data.containsKey(tempUsername)) {
            System.out.println("Usuário inexistente");
            return;
        }

        System.out
                .println("Digite o campo a ser alterado: 1 - Senha\t2 - Nome\t3 - Telefone\t 4 - Email\t5 - Endereço");
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
    }

    private void registerService() {
        System.out.println("Digite o nome do serviço:");
        String tempServiceType = read.nextLine();

        System.out.println("Digite a descrição:");
        String tempDescription = read.nextLine();

        Service tempService = null;
        tempService = new Service(tempServiceType, tempDescription, 0, false, false, null);
        if (services.contains(tempService)) {
            System.out.println("Serviço já existente");
            return;
        }
        services.add(tempService);
        System.out.println("Cadastrou");
    }

    private void registerUser() {
        int op;
        if (loggedUser instanceof Manager) {
            System.out.println("Deseja cadastrar um:\n\t 1 - Administrador\t2 - Cliente\t3 - Profissional");
            op = read.nextInt();
            read.nextLine();
            if (op < 1 || op > 3) {
                System.out.println("Número inválido");
                return;
            }
        } else {
            System.out.println("Deseja cadastrar um:\n\t2 - Cliente\t3 - Profissional");
            op = read.nextInt();
            read.nextLine();
            if (op < 2 || op > 3) {
                System.out.println("Número inválido");
                return;
            }
        }
        if (op == 1)
            if (!loggedIn || !(loggedUser instanceof Manager)) {
                System.out.println("Você deve estar logado como administrador para realizar essa operação!");
                return;
            }

        System.out.println("Digite o usuário:");
        String tempUsername = read.nextLine();
        if (data.containsKey(tempUsername)) {
            System.out.println("Usuário já existente");
            return;
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
        System.out.println("Chosen: " + op);
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
    }

    private void makeRequest(Client client) {
        System.out.println("Escolha entre os tipos de serviço:");
        int op = 0;
        int i = 0;
        for (Service service : services) {
            i++;
            System.out.println(i + " - " + service.getType());

        }
        op = Integer.parseInt(read.next());
        read.nextLine();

        Service serviceChosen = services.get(op - 1);

        System.out.println("Escolha um dos prestadores desse serviço:");
        // for(Worker worker : serviceChosen.)
    }
}