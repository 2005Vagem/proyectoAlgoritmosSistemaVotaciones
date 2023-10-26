/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registro_usuarios_sv;

/**
 *
 * @author Valeria Guzman
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Valeria Guzman
 */
public class BorradorModificarVotante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    Scanner scan=new Scanner(System.in);
    //variables
    String linea;
    boolean encontrado=false;
    String correoEleUsuario;
    String reinicioContraseniaUsuario;
    String rolUno;
    String rolDos;
    int opModificacion=0;
    String paisVotante;
    String deptoVotante;
    String muniVotante;
    String direVotante;
    String nuevoCorreoElectronico;
    String nuevoCorreoEleUsuario;
        
     
    
    File votantes= new File("registro_votantes.txt");   
    
    System.out.println("Las opciones disponibles para editar a un votante son las siguientes:");
    System.out.println("1.Direccion completa");
    System.out.println("2. Correo electronico");
    System.out.println("Ingrese opcion:");
    opModificacion=scan.nextInt();
         
    if(opModificacion==1){
    
     try {
         FileReader fr = new FileReader(votantes);
                      
         BufferedReader br = new BufferedReader(fr);
         File fc = new File("copia_votantes.txt");
         FileWriter fw = new FileWriter(fc);
         BufferedWriter bw = new BufferedWriter(fw);
                        
            
            
         linea = "";
         System.out.println("Ingrese el correo electronico del usuario que desea modificar para iniciar la busqueda");
         correoEleUsuario=scan.next();
           System.out.println("Ingrese el pais de residencia del votante");
           paisVotante=scan.next();
        
           System.out.println("Ingrese el departamento de residencia del votante");
           deptoVotante=scan.next();
        
           System.out.println("Ingrese el municipio de residencia del votante");
           scan.nextLine();
           muniVotante=scan.nextLine();
        
           System.out.println("Ingrese la direccion de residencia del votante");
           direVotante=scan.nextLine();
                        
                        
        ArrayList<String> lista=new ArrayList<String>();
        while((linea = br.readLine()) != null) {
                           
        String [] datos = linea.split("\\|");
                           
        if (datos[11].compareTo(correoEleUsuario) == 0){
        String[] vector=new String[datos.length];
        //System.out.println(datos.length);
        for(int i=0; i<datos.length; i++){
    
       // System.out.println(datos[i]);
        lista.add(datos[i]);
      
                         
        } 
                            
        //System.out.println("posiciones"+vector.length);
        
        
        lista.set(7, paisVotante);
        lista.set(8,deptoVotante);
        lista.set(9, muniVotante);
        lista.set(10, direVotante);
     
        //System.out.println(lista);  
                         
        //toma todos los elementos y los une en una cadena utilizando como delimitador la barrita
        linea=String.join("|", lista)+"|";
                           
                         
        System.out.println("Usuario encontrado, los datos fueron  modificados");
        encontrado=true;
                           
        }
                           
                       
        bw.write(linea+"\n");
                           
        } 
        bw.close();
        br.close();
                        
        if (encontrado!=true){
        System.out.println("Usuario no encontrado, las modificaciones no fueron realizadas");
                                 
        }
                        
        Files.move(fc.toPath(), votantes.toPath(), REPLACE_EXISTING);
            
        }catch (FileNotFoundException ex){
        System.out.println("El usuario no existe"+ex);
        } catch (IOException ex) {
        System.out.println("El usuario no existe"+ex);
        }     
  
    }
    
    if (opModificacion==2){
    
     try {
         FileReader fr = new FileReader(votantes);
                      
         BufferedReader br = new BufferedReader(fr);
         File fc = new File("copia_votantes.txt");
         FileWriter fw = new FileWriter(fc);
         BufferedWriter bw = new BufferedWriter(fw);
                        
            
            
         linea = "";
         System.out.println("Ingrese el correo electronico del usuario que desea modificar para iniciar la busqueda");
         correoEleUsuario=scan.next();
         System.out.println("Ingrese el nuevo correo del usuario");
          nuevoCorreoEleUsuario = scan.next();
                        
                        
        ArrayList<String> lista=new ArrayList<String>();
        while((linea = br.readLine()) != null) {
                           
        String [] datos = linea.split("\\|");
                           
        if (datos[11].compareTo(correoEleUsuario) == 0){
        String[] vector=new String[datos.length];
        //System.out.println(datos.length);
        for(int i=0; i<datos.length; i++){
    
       // System.out.println(datos[i]);
        lista.add(datos[i]);
      
                         
        } 
                            
        //System.out.println("posiciones"+vector.length);
        lista.set(11, nuevoCorreoEleUsuario);
        //System.out.println(lista);  
                         
        //toma todos los elementos y los une en una cadena utilizando como delimitador la barrita
        linea=String.join("|", lista)+"|";
                           
                         
        System.out.println("Usuario encontrado, la contrasenia fue reiniciada");
        encontrado=true;
                           
        }
                           
                       
        bw.write(linea+"\n");
                           
        } 
        bw.close();
        br.close();
                        
        if (encontrado!=true){
        System.out.println("Usuario no encontrado, las modificaciones no fueron realizadas");
                                 
        }
                        
        Files.move(fc.toPath(), votantes.toPath(), REPLACE_EXISTING);
            
        }catch (FileNotFoundException ex){
        System.out.println("El usuario no existe"+ex);
        } catch (IOException ex) {
        System.out.println("El usuario no existe"+ex);
        }     
 
    }
    
    
    
    
    }

}
