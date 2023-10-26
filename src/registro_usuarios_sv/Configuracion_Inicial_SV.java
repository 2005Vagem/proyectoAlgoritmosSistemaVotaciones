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
import java.lang.System.Logger;
import java.util.Scanner;

/**
 *
 * @author Valeria Guzman
 */
public class Configuracion_Inicial_SV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Configuracion_Inicial_SV obj=new Configuracion_Inicial_SV();
     
       Scanner scan=new Scanner (System.in);
     
    
       int opIngreso=0;
        
        
        System.out.println("Sistema de Votaciones");
        System.out.println("Presione 1 para ingresar por favor");
        opIngreso=scan.nextInt();
        if (opIngreso==1){
        String contraseniaAdminUno=" ";
        obj.confEinicio(contraseniaAdminUno);
       
        }
       System.out.println("Bienvenido");
       
    }
    

      //final main
     //método crear archivo
    public String confEinicio(String contraseniaAdmonUno){
     File f = new File("archivo_texto.txt");
     Scanner scan=new Scanner(System.in);
      try{   
          FileReader fr = new FileReader(f);
                     BufferedReader br = new BufferedReader(fr);
                     String linea = "";
                        
                     linea = br.readLine();
                
                    if(linea==null){ System.out.println("Ingrese una contrasenia para el usuario admin:");
                        contraseniaAdmonUno=scan.next();
                        
                        FileWriter fw = new FileWriter(f);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(contraseniaAdmonUno);
                        bw.close();
                        System.out.println("Configuracion exitosa");
                    } else if(linea!=null){
                        System.out.println("Inicio de Sesion Exitoso");
                    }
       
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
    
      return null;
    }    
}   


        
 
        
    
       // do {
        //System.out.print("Ingrese una contrasenia para el usuario admin: ");
        //contraseniaAdmon=scan.nextLine();
       // if (contraseniaAdmonUno.equals(contraseniaAdmon)){
         //    System.out.println("La contrasenia es correcta");
           //  System.out.println("Inicio de sesion exitoso");
        //} else{
          //   System.out.println("La contrasenia es incorrecta");
            // System.out.println("Ingrese la contrasenia de nuevo");
                     
        
        //}while(!contraseniaAdmonUno.equals(contraseniaAdmon));
        
    //}
    
