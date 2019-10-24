package bash_interface;

import java.util.*;

/**
 * main
 */
public class Main {
  public static void main(String[] args) {
    Scanner read = new Scanner(System.in);
    System.out.println("Bem-vindo!! O que deseja fazer?\n");
    System.out.println("1 - Logar\t 2 - Cadastrar\t 3 - Editar\t 4 - Sair");
    String text = read.next();
    int resp = Integer.parseInt(text);
    while (resp != 4) {
      switch (resp) {
      case 1:
        System.out.println("Logou");
        break;
      case 2:
        System.out.println("Cadastrou");
        break;
      case 3:
        System.out.println("Editou");
      default:
        System.out.println("\nValor inválido! Digite outra opção:\n");
        System.out.println("1 - Logar\t 2 - Cadastrar\t 3 - Editar\t 4 - Sair");
        resp = read.nextInt();
        continue;
      }
      System.out.println("\nO que mais?\n");
      System.out.println("1 - Logar\t 2 - Cadastrar\t 3 - Editar\t 4 - Sair");
      resp = Integer.parseInt(read.next());
    }
  }
}