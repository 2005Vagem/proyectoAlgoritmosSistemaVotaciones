/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registro_usuarios_sv;

/**
 *
 * @author Valeria Guzman
 */
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Valeria Guzman
 */
public class BorradorVerificacionEdad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean elegible=false;
        String fechaNacVotante="";
      Scanner scan=new Scanner(System.in);
      System.out.println("Ingrese fecha Nac: ");
      fechaNacVotante=scan.next();
        
    //DateTimeFormater convierte las fechas en cadenas de texto
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //se convierte la fecha de nacimiento del votante a una cadena, y esto se guarda en la variable FechaNac 
    LocalDate fechaNac = LocalDate.parse(fechaNacVotante, fmt);
    
    //se obtiene la fecha actual, y se guarda en ahora
    LocalDate ahora = LocalDate.now();
    //aqui se calcula el periodo de diferencia entre la fecha de nacimiento y la fecha actual
   Period periodo = Period.between(fechaNac, ahora);
     //numero de años en en el periodo calculado
    int edad = periodo.getYears();

    if (edad >= 18) {
    System.out.println("El votante es elegible");
    elegible=true;
 
    
    } else {
    System.out.println("La persona es menor de edad.");
    elegible=false;
    }
    
    System.out.println(elegible);
        
        
        
        
    }
    
}