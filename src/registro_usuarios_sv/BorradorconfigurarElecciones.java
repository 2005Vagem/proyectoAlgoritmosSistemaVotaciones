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
import java.nio.file.StandardCopyOption;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Valeria Guzman
 */
public class BorradorconfigurarElecciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        BorradorconfigurarElecciones obj=new BorradorconfigurarElecciones();
        int op=0;
        String registro="";
        System.out.println("Ingrese op");
        op=scan.nextInt();
        if(op==1){
        registro=obj.crearEle();
        }
        
        if(op==2){
        obj.configFechasElecc(registro);
        
        
        }
        if(op==3){
        obj.eliminarElecc();
        
        }
   
        
    }
    
public String crearEle(){
       
   
   Scanner scan=new Scanner(System.in);
   String tituloElecc;
   String propositoElecc;
   String desElecc;
   String codElecc;
   String registro="";
 
     
       //creacion del archivo
       File elecciones= new File("registro_elecciones.txt");
        try {
            
        System.out.println("Bienvenido a la creacion de Elecciones");
        System.out.println("Ingrese titulo de la eleccion ");
        tituloElecc=scan.nextLine();
                 
        System.out.println("Ingrese el Proposito de la eleccion");
        propositoElecc= scan.nextLine();
                 
        System.out.println("Ingrese la descripcion de la eleccion");
        desElecc=scan.nextLine();
               
        System.out.println("Ingrese el codigo de la eleccion ");
        codElecc=scan.nextLine();
        
       
        registro=tituloElecc+"|"+propositoElecc+"|"+desElecc+"|"+codElecc+"|";
        
        //escritura en el archivo
        FileWriter fw = new FileWriter(elecciones, true);

        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(registro + "\n");
         bw.close();
                  
        } catch (IOException ex){
        System.out.println(ex);
                  
       }
   
       return registro;
   }
   
public void configFechasElecc(String registro){

 File elecciones= new File("registro_elecciones.txt");
    Scanner scan=new Scanner(System.in);
   //variables
   boolean encontrado = false;
   String correoEleUsuario;
   String  codElecc;
   String fechaInicioE;
   String fechaFinE;
   String horaInicioE;
   String horaFinE;
   String fechaInicioIns;
   String fechaFinIns;
   String horaInicioIns;
   String horaFinIns;
   String fechaInicioVotaciones;
   String fechaFinVotaciones;
   String horaInicioVotaciones;
   String horaFinVotaciones;
   String fechas;
    //creacion del archivo
   
       
         try {
           FileReader fr = new FileReader(elecciones);
           BufferedReader br = new BufferedReader(fr);
                        
           File fc = new File("copia_elecciones.txt");
           FileWriter fw = new FileWriter(fc);
           BufferedWriter bw = new BufferedWriter(fw);
                        
           String linea = "";
                        
           System.out.println("Bienvenido a la configuracion de elecciones");
         
           System.out.println("Ingrese el codigo de la eleccion para iniciar la busqueda");
           codElecc=scan.nextLine();
           System.out.println("Ingrese la fecha de inicio de la eleccion");
           fechaInicioE=scan.nextLine();
           System.out.println("Ingrese la fecha de finalizacion de la eleccion");
           fechaFinE=scan.nextLine();
           System.out.println("Ingrese la hora de inicio de la eleccion en formato HH:mm");
           horaInicioE=scan.nextLine();
           System.out.println("Ingrese la hora de finalizacion de la eleccion en formato HH:mm");
           horaFinE=scan.nextLine();
           System.out.println("Ingrese la fecha de inicio de inscripcion de votantes a la eleccion");
           fechaInicioIns=scan.nextLine();
           System.out.println("Ingrese la fecha de finalizacion de inscripcion de votantes a la eleccion");
           fechaFinIns=scan.nextLine();
           System.out.println("Ingrese la hora de inicio de inscripcion de votantes a la eleccion en formato HH:mm");
           horaInicioIns=scan.nextLine();
           System.out.println("Ingrese la hora de finalizacion de inscripcion de votantes a  la eleccion en formato HH:mm");
           horaFinIns=scan.nextLine();
           System.out.println("Ingrese la fecha de inicio de votaciones");
           fechaInicioVotaciones=scan.nextLine();
           System.out.println("Ingrese la fecha de finalizacion de votaciones");
           fechaFinVotaciones=scan.nextLine();
           System.out.println("Ingrese la hora de inicio de votaciones en formato HH:mm");
           horaInicioVotaciones=scan.nextLine();
           System.out.println("Ingrese la hora de finalizacion de votaciones en formato HH:mm");
           horaFinVotaciones=scan.next();
           
           fechas= fechaInicioE+"|"+fechaFinE+"|"+horaInicioE+"|"+horaFinE+"|"+fechaInicioIns+"|"+fechaFinIns+"|"+horaInicioIns+"|"+horaFinIns+"|"+fechaInicioVotaciones+"|"+fechaFinVotaciones+"|"+horaInicioVotaciones+"|"+horaFinVotaciones+"|";
           
           
                        
       
                        
                        while((linea = br.readLine()) != null) {
                            String [] datos = linea.split("\\|");
                            if (datos[3].compareTo(codElecc) == 0) {
                                linea =linea+fechas;
                                encontrado=true;
                            }
                            
                            bw.write(linea+"\n");
                        } 
                        
                        bw.close();
                        br.close();
                        
                        
          Files.move(fc.toPath(), elecciones.toPath(), REPLACE_EXISTING);
          } catch (FileNotFoundException ex) {
            System.out.println("Hubo un error"+ex);
          } catch (IOException ex) {
            System.out.println("Hubo un error"+ex);
          } 
                       
          if (encontrado){
          System.out.println("Las fechas de la eleccion fueron establecidas correctamente");
          }else{System.out.println("Las fechas de la eleccion no fueron establecidas, porque no existe en el archivo");
          }

}




  public void eliminarElecc(){
    
    Scanner scan = new Scanner(System.in);
    
    boolean encontrado = false;
    String codElecc;
    boolean eleccionEliminada=false;
    File elecciones = new File("registro_elecciones.txt");
    
    try {
      FileReader fr = new FileReader(elecciones);
      BufferedReader br = new BufferedReader(fr);
      
      File fc = new File("copia_elecciones.txt");
      FileWriter fw = new FileWriter(fc);
      BufferedWriter bw = new BufferedWriter(fw);
      
      String linea = "";
      
      System.out.println("Ingrese el codigo de la eleccion a eliminar: ");
      codElecc = scan.next();
      
      while((linea = br.readLine()) != null) {
        
      String [] datos = linea.split("\\|");
       // System.out.println(Arrays.toString(datos));
       
      // System.out.println("fecha:"+datos[1]);
        // System.out.println("fecha:"+datos[2]);
         //System.out.println("fecha:"+datos[3]);
         //System.out.println("fecha:"+datos[4]);
           //System.out.println("fecha:"+datos[5]);
          //System.out.println("hora: "+datos[6]);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate fechaInicioElec = LocalDate.parse(datos[4], formatter);
        
        
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaInicioElec = LocalTime.parse(datos[6], formatterHora);
        //System.out.println(fechaInicioElec);
        LocalDateTime inicioEleccion = LocalDateTime.of(fechaInicioElec, horaInicioElec);

        
        if(datos[3].equals(codElecc)){
          
          if(LocalDateTime.now().isBefore(inicioEleccion)){
            System.out.println("La eleccion fue eliminada exitosamente");
            eleccionEliminada = true;
          } else {
            System.out.println("No se puede eliminar la eleccion porque ya inicio");
          }
          
        } 
        
        if (!eleccionEliminada) {
          bw.write(linea + "\n");
        }
        
      }
      
      bw.close();
      br.close();
      
      Files.move(fc.toPath(), elecciones.toPath(),REPLACE_EXISTING);
      
      //if(encontrado) {
        //Files.move(fc.toPath(), elecciones.toPath(), StandardCopyOption.REPLACE_EXISTING);
        //System.out.println("Elección eliminada");  
      //} else {
        //System.out.println("No encontrado");
      //}
      
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
    
  }
  
}
