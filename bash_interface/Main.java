package bash_interface;

import java.util.*;
/**
 * main
 */
public class Main {
  public static void main(String [] args) {
    Scanner read = new Scanner(System.in);
    System.out.println("Bem-vindo!! O que deseja fazer?");
    System.out.println("1 - Login");
    System.out.println("2 - Cadastrar");
    int resp = read.nextInt();

    switch(resp){
      case 1: 
      break;
      case 2:
      break;
      default:
        
    }
  }
}