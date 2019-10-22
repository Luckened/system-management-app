package bash_interface;

import java.util.*;

/**
 * main
 */
public class Main {
  public static void main(String[] args) {
    Scanner read = new Scanner(System.in);
    System.out.println("Bem-vindo!! O que deseja fazer?");
    // System.out.println("1 - Login");
    System.out.println("1 - Cadastrar");
    System.out.println("2 - Editar");
    System.out.println("3 - Sair");
    int resp = read.nextInt();

    while (resp != 3) {

      switch (resp) {
      case 1:

        break;
      case 2:
        break;
      default:

      }

      System.out.println("Algo mais?");
    }
  }
}