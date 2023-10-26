/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registro_usuarios_sv;

/**
 *
 * @author Valeria Guzman
 */
public class BorradorContraseniaAleatoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
     //crear arrays que contengan los caracteres para formar las contrasenias
     char[]mayus={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
     char[]minus={'a','b', 'c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
     char[]nums={'1','2','3','4','5','6','7','8','9','0'};
     char[]simbolos={'!','*','/','%','$','#'};
     //se unen los arrays en un objeto de StringBuider y dentro de caracteres se unen todos los arrays
     StringBuilder caracteres=new StringBuilder();
     //metodo append convierte algo en una cadena
     caracteres.append(mayus);
     caracteres.append(minus);
     caracteres.append(nums);
     caracteres.append(simbolos);
     //Crear otri String Buider para guardar la contraseña
      StringBuilder contrasenia=new StringBuilder();
      //for que recorre hasta 16 para que la contrasenia sea de 16 caracteres
      for(int i=0;i<=15;i++){
        //contar la cantidad de caracteres
        int cantCaracteres=caracteres.length();
        //numero aleatorio entre esa cantidad de caracteres, se aplica la clase math random
        int numeroAleatorio=(int)(Math.random()*cantCaracteres);
        //generar la contraseña, a caracteres se les convierte en un String, y sacar un numero aleatorio según el indice
        contrasenia.append(caracteres.toString().charAt(numeroAleatorio));
      }
      System.out.println("la contrasenia es:");
      System.out.println(contrasenia.toString());
      
      String contraseniaUsuarioVotante=contrasenia.toString();
      System.out.println("La contrasenia del votante es: "+contrasenia);
    
}
}