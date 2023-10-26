
//probandoCambios

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registro_usuarios_sv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Valeria Guzman
 */
public class Registro_Usuarios_SV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int opcionIngreso=0;
        int opIngreso=0;
       Registro_Usuarios_SV obj=new Registro_Usuarios_SV();
        
       File usuarios= new File("registro_usuarios.txt");
       File inicioSesion = new File("archivo_texto.txt");
       // System.out.println(usuarios.getAbsolutePath());
    
        
         
        System.out.println("Sistema de Votaciones");
        System.out.println("Presione 1 para ingresar por favor");
        opIngreso=scan.nextInt();
        //el programa iniciara sesion solamente si se ingresa el numero 1
        if (opIngreso==1){
        String contraseniaAdminUno=" ";
        obj.confEinicio(contraseniaAdminUno);
       
        }
       System.out.println("Bienvenido, estas son sus opciones iniciales disponibles del Sistema de Votaciones");
       
       obj.opInicialSistema();
      
            
            
    }
 
    //final del main
    //Inicio de metodos
    
    public void opInicialSistema(){
        Scanner scan=new Scanner(System.in);
        //variables
        int opcionIngreso=0;
        //creacion de obj para poder llamar a los metodos
        Registro_Usuarios_SV obj=new Registro_Usuarios_SV();
        //menú de de opciones de lo que puede hacer el administrador en el registro de usuarios
        System.out.println("1. Crear usuario del sistema");
        System.out.println("2. Modificar usuario del sistema");
        System.out.println("3. Deshabilitar usuario del sistema");
        System.out.println("4. Reiniciar contrasenia del usuario del sistema");
        System.out.println("5. Ingresar al Sistema de Votaciones");
       
        //blucle do while para que la opcion que ingrese el usuario siempre sea válida
        do{
        System.out.println("Ingrese opcion valida");
        opcionIngreso=scan.nextInt();
        //Menu de codigo que realiza cada opcion 
        switch(opcionIngreso){
            //crear usuario del sistema
            case 1:
             String primerNombre=" ";
             obj.crearUsuario(primerNombre);
            break;
            //Modificar usuario del sistema
            case 2: 
            obj.modificarUsuario();
            break;
            //Deshabilitar usuario del sistema
            case 3:
            obj.deshabilitarUsuario();
            break; 
            //Reinicio de contraseña del usuario 
            case 4: 
            obj.reiniciarContrasenia();
            break;
            //Permite ingresar al sistema donde se tienen las funcionalidades del administrador, registrador de votantes, auditor y votante
            case 5:
            obj.ingresarAlSistema();
            break;
            
         default: System.out.println("Opcion no valida");
        }//el bucle se cumplira siempre que la opcion de ingreso sea mayor a cero o menor o igual a cero
        }while((opcionIngreso>5)||(opcionIngreso<=0));
    
    }
    
    
    
    public String confEinicio(String contraseniaAdmonUno){
     //se crea al archivo llamado archivo_texto donde unicamente se almacenará la contraseña que el usuario administrador ingrese, y una vez este guardada automaticamente al presionar 1 se inicia sesion
     //operador new significa que se va a crear una nueva representacion de archivo
     File inicioSesion = new File("archivo_texto.txt");
     Scanner scan=new Scanner(System.in);
                try{   
                     //crear una variable lector de archivo, se le da como entrada el archivo inicio sesion que es donde se quiere leer 
                    FileReader frI = new FileReader(inicioSesion);
                    //creacion de un nuevo lector de archivos, escribe en el fw
                     BufferedReader brI = new BufferedReader(frI);
                     
                     String linea = "";
                     //variable para almacenar la linea que se esta leyendo  
                     linea = brI.readLine();
                    //verifica que la linea no venga vacia
                    if(linea==null){ System.out.println("Ingrese una contrasenia para el usuario admin:");
                        contraseniaAdmonUno=scan.next();
                        //escribe en el archivo
                        FileWriter fwI = new FileWriter(inicioSesion);
                        BufferedWriter bwI = new BufferedWriter(fwI);
                        //metodo para escribir la contrasenia en el archivo de texto
                        bwI.write(contraseniaAdmonUno);
                        //al cerrar el bw. guarda el registro
                        bwI.close();
                        System.out.println("Configuracion exitosa");
                    } else if(linea!=null){
                        System.out.println("Inicio de Sesion Exitoso");
                    }
       
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
    
      return null;
    }     
    
  //metodo crear usuario  
   public String crearUsuario(String nombrePUsu){
       Scanner scan=new Scanner(System.in);
       
       //variables
     
        String nombreSUsu;
        String apellidosPUsuario;
        String apellidosSUsuario;
        String correoEleUsuario;
        String contraseniaUsuario;
        String rolUsuario = null;
        String rolUsuarioExtra = null;
        String registro = "";
        int nuevaConfirmacionRolUsuario=0;
        String nuevoRolUsuario = null;
        int nuevaConfirmacionAddRol=0;
        int nuevaConfirmacionRolUsuarioAdd=0;
        String nuevoRolUsuarioExtra;
        int confirmacionContraseniaUsuario=0;
        int confirmacionrolUsuario=0;
        int confirmacionAddRol=0;
        int confirmacionrolUsuarioAdd=0;
        String resultado;
        
        
       //creacion del archivo
       File usuarios= new File("registro_usuarios.txt");
        try {
            
        System.out.println("Bienvenido a la creacion de usuarios");
        System.out.println("Ingrese primer nombre del usuario");
        nombrePUsu=scan.next();
                 
        System.out.println("Ingrese segundo nombre del usuario");
        nombreSUsu = scan.next();
                 
        System.out.println("Ingrese primer apellido del usuario");
        apellidosPUsuario=scan.next();
               
        System.out.println("Ingrese segundo apellido del usuario");
        apellidosSUsuario=scan.next();
                 
        System.out.println("Ingrese el correo electronico del usuario");
        correoEleUsuario=scan.next();
        //verificacion de que el usuario esta seguro de la contraseña 
        do{
        System.out.println("Ingrese la contrasenia del usuario");
        contraseniaUsuario=scan.next();
        System.out.println("Esta seguro de esta contrasenia");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.println("Ingrese opcion");
        confirmacionContraseniaUsuario=scan.nextInt();
                 
        }while((confirmacionContraseniaUsuario>=2)||(confirmacionContraseniaUsuario<=0));
        //verificacion de que el usuario esta seguro del rol que eligio
        do{
        System.out.println("Ingrese rol del usuario");
        System.out.println("Los roles disponibles son los siguientes, ingrese la opcion valida");
        System.out.println("1. Administrador");
        System.out.println("2. Registrador de votantes");
        System.out.println("3. Auditor");
        confirmacionrolUsuario=scan.nextInt();
        }while((confirmacionrolUsuario>3)||(confirmacionrolUsuario<=0));
        if(confirmacionrolUsuario==1){
        rolUsuario="Administrador";
        }else if(confirmacionrolUsuario==2){
        rolUsuario="Registrador de votantes";
        }else if(confirmacionrolUsuario==3){
        rolUsuario="Auditor";
        }
                
        //agregar nuevo rol para el usuario
        do{System.out.println("Desea tener algun otro rol");
        System.out.println("1. Si");
        System.out.println("2. No");
        confirmacionAddRol=scan.nextInt();
        }while((confirmacionAddRol>3)||(confirmacionAddRol<=0));
        if (confirmacionAddRol==1){
        do{
        System.out.println("Ingrese rol del usuario");
        System.out.println("Los roles disponibles son los siguientes, ingrese la opcion valida");
        if(confirmacionrolUsuario==1){
        System.out.println("2. Registrador de votantes");
        System.out.println("3. Auditor");
        }  else if(confirmacionrolUsuario==2){
        System.out.println("1. Administrador");
        System.out.println("3. Auditor");
        }else if(confirmacionrolUsuario==3){
        System.out.println("1. Administrador");
        System.out.println("2. Registrador de votantes");
        }
        confirmacionrolUsuarioAdd=scan.nextInt();
        }while((confirmacionrolUsuario>3)||(confirmacionrolUsuario<=0));
        if((confirmacionrolUsuario==1)&&(confirmacionrolUsuarioAdd==2)){
        rolUsuarioExtra="Registrador de votantes";
       }else if((confirmacionrolUsuario==1)&&(confirmacionrolUsuarioAdd==3)){
        rolUsuarioExtra="Auditor";
        }else if ((confirmacionrolUsuario==2)&&(confirmacionrolUsuarioAdd==1)){
        rolUsuarioExtra="Administrador";
        } else if ((confirmacionrolUsuario==2)&&(confirmacionrolUsuarioAdd==3)){
        rolUsuarioExtra="Auditor";
        } else if((confirmacionrolUsuario==3)&&(confirmacionrolUsuarioAdd==1)){
         rolUsuarioExtra="Administrador";
        }else if((confirmacionrolUsuario==3)&&(confirmacionrolUsuarioAdd==2)){
        rolUsuarioExtra="Registrador de votantes";
        }
         //si el usuario no quiere ningun otro rol 
        else if(confirmacionAddRol==2){
        System.out.println("De acuerdo!");
        }
        }
         
        //cadena con todos los datos
        if (confirmacionAddRol==1){
        registro=nombrePUsu+"|"+nombreSUsu+"|"+apellidosPUsuario+"|"+apellidosSUsuario+"|"+correoEleUsuario+"|"+contraseniaUsuario+"|"+rolUsuario+"|"+rolUsuarioExtra+"|";
        //System.out.println(registro);
        } else if(confirmacionAddRol==2){
        registro=nombrePUsu+"|"+nombreSUsu+"|"+apellidosPUsuario+"|"+apellidosSUsuario+"|"+correoEleUsuario+"|"+contraseniaUsuario+"|"+rolUsuario+"|";
        //System.out.println(registro);
        }
                
        //escritura en el archivo
        FileWriter fw = new FileWriter(usuarios, true);

        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(registro + "\n");
         bw.close();
                  
        } catch (IOException ex){
        System.out.println(ex);
                  
       }
 
       return registro;
   }
   
   
   
   ///modificar usuario 
   public void modificarUsuario(){
       
    Scanner scan=new Scanner(System.in);
    //variables 
    String nuevoPNombreUsuario;
    String nuevoSNombreUsuario;
    String nuevoPApellidoUsuario;
    String nuevoSApellidoUsuario;
    String nuevoCorreoUsuario;
    String nuevaContraseniaUsuario;
    int nuevaConfirmacionRolUsuario=0;
    String nuevoRolUsuario = null;
    int nuevaConfirmacionAddRol=0;
    int nuevaConfirmacionRolUsuarioAdd=0;
    String nuevoRolUsuarioExtra;
    String correoEleUsuario;
    int confirmacionrolUsuario=0;
    String rolUsuario = " ";
    int confirmacionrolUsuarioAdd=0;
    boolean encontrado = false;
    String nueRolExtra = null;
    int confirmacionAddRol=0;
    String rolUsuarioExtra = null;
       
    //creacion del archivo
    File usuarios= new File("registro_usuarios.txt");   
    try {
      FileReader fr = new FileReader(usuarios);
      BufferedReader br = new BufferedReader(fr);
      File fc = new File("copia_usuarios.txt");
      FileWriter fw = new FileWriter(fc);
      BufferedWriter bw = new BufferedWriter(fw);
                        
      String linea = "";
                        
      System.out.println("Bienvenido a la modificacion de usuarios del sistema");
      System.out.println("Ingrese el correo electronico del usuario que desea modificar para iniciar la busqueda");
      correoEleUsuario = scan.next();
                       
      System.out.println("Se Le solicitaran los datos nuevos, si el usuario es encontrado esos datos seran modificados, de lo contrario los datos ingresados seran eliminados");
      System.out.println("Ingrese el nuevo primer nombre del usuario");
      nuevoPNombreUsuario=scan.next();
      System.out.println("Ingrese el nuevo segundo nombre del usuario");
      nuevoSNombreUsuario=scan.next();
      System.out.println("Ingrese el nuevo primer apellido del usuario");
      nuevoPApellidoUsuario=scan.next();
      System.out.println("Ingrese el nuevo segundo apellido del usuario");
      nuevoSApellidoUsuario=scan.next();
      System.out.println("Ingrese el nuevo correo electronico del usuario");
      nuevoCorreoUsuario=scan.next();
                                
      do{
       System.out.println("Ingrese el nuevo rol del usuario");
       System.out.println("Los roles disponibles son los siguientes, ingrese la opcion valida");
       System.out.println("1. Administrador");
       System.out.println("2. Registrador de votantes");
       System.out.println("3. Auditor");
       confirmacionrolUsuario=scan.nextInt();
      }while((confirmacionrolUsuario>3)||(confirmacionrolUsuario<=0));
        if(confirmacionrolUsuario==1){
        rolUsuario="Administrador";
        }else if(confirmacionrolUsuario==2){
        rolUsuario="Registrador de votantes";
        }else if(confirmacionrolUsuario==3){
        rolUsuario="Auditor";
        }
                                
        //agregar nuevo rol para el usuario
        do{System.out.println("Desea tener algun otro rol nuevo");
        System.out.println("1. Si");
        System.out.println("2. No");
        confirmacionAddRol=scan.nextInt();
        }while((confirmacionAddRol>3)||(confirmacionAddRol<=0));
                                
        if(confirmacionAddRol==1){
            do{
            System.out.println("Ingrese nuevo rol del usuario");
            System.out.println("Los roles disponibles son los siguientes, ingrese la opcion valida");
             if(confirmacionrolUsuario==1){
              System.out.println("2. Registrador de votantes");
              System.out.println("3. Auditor");
             }  else if(confirmacionrolUsuario==2){
                System.out.println("1. Administrador");
                System.out.println("3. Auditor");
                }else if(confirmacionrolUsuario==3){
                System.out.println("1. Administrador");
                System.out.println("2. Registrador de votantes");
                }
                confirmacionrolUsuarioAdd=scan.nextInt();
                                 
            }while((confirmacionrolUsuario>3)||(confirmacionrolUsuario<=0));  
                                       
            if((confirmacionrolUsuario==1)&&(confirmacionrolUsuarioAdd==2)){
            rolUsuarioExtra="Registrador de votantes";
            }else if((confirmacionrolUsuario==1)&&(confirmacionrolUsuarioAdd==3)){
            rolUsuarioExtra="Auditor";
            }else if ((confirmacionrolUsuario==2)&&(confirmacionrolUsuarioAdd==1)){
            rolUsuarioExtra="Administrador";
            } else if ((confirmacionrolUsuario==2)&&(confirmacionrolUsuarioAdd==3)){
            rolUsuarioExtra="Auditor";
            } else if((confirmacionrolUsuario==3)&&(confirmacionrolUsuarioAdd==1)){
            rolUsuarioExtra="Administrador";
            }else if((confirmacionrolUsuario==3)&&(confirmacionrolUsuarioAdd==2)){
            rolUsuarioExtra="Registrador de votantes";
            }
                         
                                
        }
        //si el usuario no quiere otro rol
        else if(confirmacionAddRol==2){
        System.out.println("De acuerdo!");
        }
                                
        if (confirmacionAddRol==1){
        nueRolExtra=rolUsuario+"|"+rolUsuarioExtra;
        } else if(confirmacionAddRol==2){
        nueRolExtra=rolUsuario;
        }
                                
                                
                                
        String nuevoReg=nuevoPNombreUsuario+"|"+nuevoSNombreUsuario+"|"+nuevoPApellidoUsuario+"|"+nuevoSApellidoUsuario+"|"+nuevoCorreoUsuario;
                                
        while((linea = br.readLine()) != null) {
        String [] datos = linea.split("\\|");
        if (datos[4].compareTo(correoEleUsuario) == 0) {
                    
        nuevaContraseniaUsuario=datos[5];
        String nuevoRegCompleto=nuevoReg+"|"+nuevaContraseniaUsuario+"|"+nueRolExtra+"|";
        linea = nuevoRegCompleto;
        System.out.println("Usuario encontrado, las modificaciones fueron realizadas");
        encontrado=true;
        }
                              
                              
        bw.write(linea+"\n");
                            } 
                        
        bw.close();
        br.close();
                            
        if (encontrado!=true){
        System.out.println("Usuario no encontrado, las modificaciones no fueron realizadas");
                                 
        }
                             
                    
                             
        Files.move(fc.toPath(), usuarios.toPath(), REPLACE_EXISTING);
        } catch (FileNotFoundException ex){
        System.out.println("El usuario no existe"+ex);
        } catch (IOException ex) {
        System.out.println("El usuario no existe"+ex);
        }    
       
       
       
       
   }
   
   //deshabilitacion de usuario
   public void deshabilitarUsuario(){
   Scanner scan=new Scanner(System.in);
   //variables
   boolean encontrado = false;
   String correoEleUsuario;
   
   
    //creacion del archivo
    File usuarios= new File("registro_usuarios.txt");   
       
         try {
           FileReader fr = new FileReader(usuarios);
           BufferedReader br = new BufferedReader(fr);
                        
           File fc = new File("copia_usuarios.txt");
           FileWriter fw = new FileWriter(fc);
           BufferedWriter bw = new BufferedWriter(fw);
                        
           String linea = "";
                        
           System.out.println("Bienvenido a la deshabilitacion de usuarios");
           System.out.println("El usuario que deshabilite sera eliminado, y si desea tenerlo de nuevo en el sistema debera registrarlo con la opcion 1");
           System.out.println("Ingrese el correo electronico del usuario para iniciar la busqueda");
           correoEleUsuario=scan.next();
                        
                        
                        
           while((linea = br.readLine()) != null) {
           String [] datos = linea.split("\\|");
           if (datos[4].compareTo(correoEleUsuario) != 0) {
           bw.write(linea+"\n");
                                
                                
             }else{
            encontrado=true;
            }
          } 
                        
          bw.close();
          br.close();
                        
          Files.move(fc.toPath(), usuarios.toPath(), REPLACE_EXISTING);
          } catch (FileNotFoundException ex) {
            System.out.println("Hubo un error"+ex);
          } catch (IOException ex) {
            System.out.println("Hubo un error"+ex);
          } 
                       
          if (encontrado){
          System.out.println("Usuario deshabilitado correctamente");
          }else{
          System.out.println("Usuario no deshabilitado, porque no existe en el archivo");
          }
            
       
       
   }
   
   
   public void reiniciarContrasenia(){
    Scanner scan=new Scanner(System.in);
    //variables
    String linea;
    boolean encontrado=false;
    String correoEleUsuario;
    String reinicioContraseniaUsuario;
    String rolUno;
    String rolDos;
    
    
    
    File usuarios= new File("registro_usuarios.txt");   
    try {
         FileReader fr = new FileReader(usuarios);
                      
         BufferedReader br = new BufferedReader(fr);
         File fc = new File("copia_usuarios.txt");
         FileWriter fw = new FileWriter(fc);
         BufferedWriter bw = new BufferedWriter(fw);
                        
            
            
         linea = "";
         System.out.println("Ingrese el correo electronico del usuario que desea modificar para iniciar la busqueda");
         correoEleUsuario=scan.next();
         System.out.println("Ingrese la nueva contrasenia del usuario");
         reinicioContraseniaUsuario = scan.next();
                        
                        
        ArrayList<String> lista=new ArrayList<String>();
        while((linea = br.readLine()) != null) {
                           
        String [] datos = linea.split("\\|");
                           
        if (datos[4].compareTo(correoEleUsuario) == 0){
        String[] vector=new String[datos.length];
        
        for(int i=0; i<datos.length; i++){
        lista.add(datos[i]);
                         
        } 
                            
        //System.out.println("posiciones"+vector.length);
        lista.set(5, reinicioContraseniaUsuario);
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
                        
        Files.move(fc.toPath(), usuarios.toPath(), REPLACE_EXISTING);
            
        }catch (FileNotFoundException ex){
        System.out.println("El usuario no existe"+ex);
        } catch (IOException ex) {
        System.out.println("El usuario no existe"+ex);
        }     
       
       
   }
   
   public void ingresarAlSistema(){
       Scanner scan=new Scanner (System.in);
       int opIngreso=0;
       int opVotante=0;
       System.out.println("Ingrese el rol con el que desea trabajar dentro del Sistema: ");
       System.out.println("1. Administrador: Acceso a todo el Sistema");
       System.out.println("2. Registrador de votantes: Acceso a realizar el registro de votantes");
       System.out.println("3. Votante: Acceso a realizar su voto");
       System.out.println("4. Auditor: Acceso a los reportes");
       
       
       do{
           System.out.println("Ingrese opcion valida: ");
           opIngreso=scan.nextInt();
           Registro_Usuarios_SV obj=new Registro_Usuarios_SV();
           switch(opIngreso){
               case 1:
               obj.opAdministrador();
        
               break;
               case 2:
                   
               obj.opcionesVotante();
                   
               break;
               case 3:
                   System.out.println("Bienvenido votante");
                 
                   
               break;
               case 4:
                   System.out.println("Bienvenido auditor ");
                   
               break;
               default: System.out.println("Opcion no valida");
           }
       }while((opIngreso>4)||(opIngreso<=0));
       
   }
   
   public void regVotante(){
        Scanner scan=new Scanner(System.in);
       
       //variables
     
        String nombrePUsu;
        String nombreSUsu;
        String apellidosPUsuario;
        String apellidosSUsuario;
        String correoEleUsuario;
        String cuiUsu;
        String sexoVotante;
        String paisVotante;
        String deptoVotante;
        String muniVotante;
        String direVotante;
        String fechaNacVotante;
        boolean elegible=false;
        String rolUsuario;
        String contraseniaUsuario;
        
       
        String registro = "";
      
      
        
      
       //creacion del archivo
       File votantes= new File("registro_votantes.txt");
        try {
            
        System.out.println("Bienvenido a la creacion de Votantes");
        System.out.println("Ingrese primer nombre del votante");
        nombrePUsu=scan.nextLine();
                 
        System.out.println("Ingrese segundo nombre del votante");
        nombreSUsu = scan.nextLine();
                 
        System.out.println("Ingrese primer apellido del votante");
        apellidosPUsuario=scan.nextLine();
               
        System.out.println("Ingrese segundo apellido del votante");
        apellidosSUsuario=scan.nextLine();
        
        System.out.println("Ingrese el CUI del votante");
        cuiUsu=scan.nextLine();
        
        System.out.println("Ingrese el sexo del votante");
        sexoVotante=scan.nextLine();
        
        System.out.println("Ingrese la fecha de nacimiento del votante en el siguiente formato: dd/MM/yyyy");
        fechaNacVotante=scan.nextLine();
        
        System.out.println("Ingrese el pais de residencia del votante");
        paisVotante=scan.nextLine();
        
        System.out.println("Ingrese el departamento de residencia del votante");
        deptoVotante=scan.nextLine();
        
        System.out.println("Ingrese el municipio de residencia del votante");
        muniVotante=scan.nextLine();
        
        System.out.println("Ingrese la direccion de residencia del votante");
        direVotante=scan.nextLine();
        
                 
        System.out.println("Ingrese el correo electronico del votante");
        correoEleUsuario=scan.nextLine();
        
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
       rolUsuario="Votante";
       
       //al ser votante elegible se generará la nueva contrasenia
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
       
      contraseniaUsuario=contrasenia.toString();
      registro=nombrePUsu+"|"+nombreSUsu+"|"+apellidosPUsuario+"|"+apellidosSUsuario+"|"+cuiUsu+"|"+sexoVotante+"|"+fechaNacVotante+"|"+paisVotante+"|"+deptoVotante+"|"+muniVotante+"|"+direVotante+"|"+correoEleUsuario+"|"+contraseniaUsuario+"|"+rolUsuario+"|";
      System.out.println("La contrasenia del votante es: "+contraseniaUsuario);
    
      } else {
      System.out.println("La persona es menor de edad. No puede ser un votante");
      elegible=false;
      }
        //escritura en el archivo
        FileWriter fw = new FileWriter(votantes, true);

        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(registro + "\n");
         bw.close();
                  
        } catch (IOException ex){
        System.out.println(ex);
                  
       }
       
   }
   
   
   public void modifVotante(){
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
  
   
   public void nuevaContraseniaVotante(){
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
       
       
       
       
    try {
         FileReader fr = new FileReader(votantes);
                      
         BufferedReader br = new BufferedReader(fr);
         File fc = new File("copia_votantes.txt");
         FileWriter fw = new FileWriter(fc);
         BufferedWriter bw = new BufferedWriter(fw);
                        
            
            
         linea = "";
         System.out.println("Ingrese el correo electronico del usuario que desea modificar para iniciar la busqueda");
         correoEleUsuario=scan.next();
         System.out.println("Ingrese la nueva contrasenia, recuerde que debe contener 16 caracteres");
         reinicioContraseniaUsuario = scan.next();
                        
                        
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
        lista.set(12, reinicioContraseniaUsuario);
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
   
   
   public void regFallVotante(){
       
      Scanner scan=new Scanner(System.in);
   //variables
   boolean encontrado = false;
   String correoEleUsuario;
   
   
    //creacion del archivo
    File votantes= new File("registro_votantes.txt");   
       
         try {
           FileReader fr = new FileReader(votantes);
           BufferedReader br = new BufferedReader(fr);
                        
           File fc = new File("copia_votantes.txt");
           FileWriter fw = new FileWriter(fc);
           BufferedWriter bw = new BufferedWriter(fw);
                        
           String linea = "";
                        
           
           System.out.println("Ingrese el correo electronico del Votante que ha fallecido");
           correoEleUsuario=scan.next();
                        
                        
                        
           while((linea = br.readLine()) != null) {
           String [] datos = linea.split("\\|");
           if (datos[11].compareTo(correoEleUsuario) != 0) {
           bw.write(linea+"\n");
                                
                                
             }else{
            encontrado=true;
            }
          } 
                        
          bw.close();
          br.close();
                        
          Files.move(fc.toPath(), votantes.toPath(), REPLACE_EXISTING);
          } catch (FileNotFoundException ex) {
            System.out.println("Hubo un error"+ex);
          } catch (IOException ex) {
            System.out.println("Hubo un error"+ex);
          } 
                       
          if (encontrado){
          System.out.println("El usuario ha sido dado de baja correctamente");
          }else{
          System.out.println("El votante no ha sido dado de baja, porque no existe en el archivo");
          }  
       
       
       
   }
   
   
  public void opcionesVotante(){
    Scanner scan=new Scanner(System.in);   
    int opVotante=0;
    Registro_Usuarios_SV obj= new Registro_Usuarios_SV();
     System.out.println("Bienvenido Registrador de votantes");
                    System.out.println("1. Agregar Votante");
                    System.out.println("2. Modificar Votante");
                    System.out.println("3. Reiniciar Contrasenia del Votante");
                    System.out.println("4. Registrar fallecimiento de Votante");
                   
                 
                    do{
                    
                   System.out.println("Ingrese opcion valida");
                    opVotante=scan.nextInt();
                       switch(opVotante){
                        //agregar votante
                        case 1:
                        obj.regVotante();
                        break;
                        case 2:
                        obj.modifVotante();
                        break;
                        case 3:
                        obj.nuevaContraseniaVotante();
                        break;
                        case 4:
                        obj.regFallVotante();
                        break;
                        default: System.out.println("Opcion no valida, ingrese opcion de nuevo");
                       }
                       
                    }while((opVotante>4)||(opVotante<=0));      
            
  }
  
  public void opcionesUsuario(){
  
    Scanner scan=new Scanner(System.in);
        int opcionIngreso=0;
        Registro_Usuarios_SV obj=new Registro_Usuarios_SV();
        //menú de de opciones de lo que puede hacer el administrador en el registro de usuarios
        System.out.println("1. Crear usuario del sistema");
        System.out.println("2. Modificar usuario del sistema");
        System.out.println("3. Deshabilitar usuario del sistema");
        System.out.println("4. Reiniciar contrasenia del usuario del sistema");
       
        //blucle do while para que la opcion que ingrese el usuario siempre sea válida
        do{
        System.out.println("Ingrese opcion valida");
        opcionIngreso=scan.nextInt();
        //Menu de codigo que realiza cada opcion 
        switch(opcionIngreso){
            //crear usuario del sistema
            case 1:
             String primerNombre=" ";
             obj.crearUsuario(primerNombre);
            break;
            //Modificar usuario del sistema
            case 2: 
            obj.modificarUsuario();
            break;
            //Deshabilitar usuario del sistema
            case 3:
            obj.deshabilitarUsuario();
            break; 
            //Reinicio de contraseña del usuario 
            case 4: 
            obj.reiniciarContrasenia();
            break;
            
         default: System.out.println("Opcion no valida");
        }
        }while((opcionIngreso>4)||(opcionIngreso<=0));
  

  }
  
   
   public String creacionEleccionesSV(){
       
   
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
        System.out.println("La eleccion fue creada con exito");
                  
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
           horaFinVotaciones=scan.nextLine();
           
           fechas= fechaInicioE+"|"+fechaFinE+"|"+horaInicioE+"|"+horaFinE+"|"+fechaInicioIns+"|"+fechaFinIns+"|"+horaInicioIns+"|"+horaFinIns+"|"+fechaInicioVotaciones+"|"+fechaFinVotaciones+"|"+horaInicioVotaciones+"|"+horaFinVotaciones;
           
           
                        
       
                        
                        while((linea = br.readLine()) != null) {
                            String [] datos = linea.split("\\|");
                            if (datos[3].compareTo(codElecc) == 0) {
                                linea =linea+fechas+"|";
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
      
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate fechaInicioElec = LocalDate.parse(datos[4], formatter);
        
        
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaInicioElec = LocalTime.parse(datos[6], formatterHora);
        
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
  
      
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
    
  }
   
   public void opElecciones(){
   Scanner scan=new Scanner(System.in);
   Registro_Usuarios_SV obj=new Registro_Usuarios_SV();
    int op=0;
        String registro="";
        System.out.println("Gestion de elecciones");
        System.out.println("1. Crear Elecciones");
        System.out.println("2. Configurar Fechas de Elecciones");
        System.out.println("3. Eliminacion de Elecciones");
        
        do{
        System.out.println("Ingrese opcion valida de lo que desea hacer con las elecciones:");
        op=scan.nextInt();
        if(op==1){
        registro=obj.creacionEleccionesSV();
        }
        if(op==2){
        obj.configFechasElecc(registro);
        }
        if(op==3){
        obj.eliminarElecc();
        }
        }while((op>3)||(op<=0));
   
   }
 public void crearCandiatos(){
 
   Scanner scan=new Scanner(System.in);
       
       //variables
     
        String nombreCand;
        String formacionCand;
        String experienciaCand;
        String codCand;
        String registro = "";
        String resultado;
        
        
       //creacion del archivo
       File candidatos= new File("registro_candidatos.txt");
        try {
            
        System.out.println("Bienvenido a la creacion de candidatos ");
        System.out.println("Ingrese el nombre del candidato");
        nombreCand=scan.nextLine();
                 
        System.out.println("Ingrese la formacion del candidato");
        formacionCand = scan.nextLine();
                 
        System.out.println("Ingrese la experiencia profesional del candidato");
        experienciaCand=scan.nextLine();
               
  
                 
        System.out.println("Ingrese el codigo unico de identificacion del candidato");
        codCand=scan.nextLine();
       
        //cadena con todos los datos
       
        registro=nombreCand+"|"+formacionCand+"|"+experienciaCand+"|"+codCand+"|";
       
                
        //escritura en el archivo
        FileWriter fw = new FileWriter(candidatos, true);

        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(registro + "\n");
         bw.close();
         
         System.out.println("El registro del Candidato ha sido exitoso");
                  
        } catch (IOException ex){
        System.out.println(ex);
                  
       }
 
 }
   
public void modificarCandidato(){
  Scanner scan=new Scanner(System.in);
    //variables
    String linea;
    boolean encontrado=false;
    String nombreCand;
    String formacionCand;
    String experienciaCand;
    String codCand;
    int opModificacion=0;

    File candidatos= new File("registro_candidatos.txt");   
    
    System.out.println("Las opciones disponibles para editar a un candidato son las siguientes:");
    System.out.println("1.Nombre");
    System.out.println("2.Formacion");
    System.out.println("3.Experiencia Profesional");
    System.out.println("4.Codigo del candidato");
    
    do{
        
    System.out.println("Ingrese opcion:");
    opModificacion=scan.nextInt();
         
    switch (opModificacion){
        //modificacion del nombre del candidato
        case 1:
        try {
         FileReader fr = new FileReader(candidatos);
                      
         BufferedReader br = new BufferedReader(fr);
         File fc = new File("copia_candidatos.txt");
         FileWriter fw = new FileWriter(fc);
         BufferedWriter bw = new BufferedWriter(fw);
        
         linea = "";
         System.out.println("Bienvenido a la modificacion de datos de candidatos");
         System.out.println("Ingrese el codigo del candidato que desea modificar para iniciar la busqueda");
         codCand=scan.next();
         scan.nextLine(); // consume the newline
         System.out.println("Ingrese el nuevo nombre del candidato");
         nombreCand=scan.nextLine();
         
        
                        
        ArrayList<String> lista=new ArrayList<String>();
        while((linea = br.readLine()) != null) {
                           
        String [] datos = linea.split("\\|");
                           
        if (datos[3].compareTo(codCand) == 0){
        String[] vector=new String[datos.length];
        //System.out.println(datos.length);
        for(int i=0; i<datos.length; i++){
    
       // System.out.println(datos[i]);
        lista.add(datos[i]);
      
                         
        } 
                            
        //System.out.println("posiciones"+vector.length);
        
        
        lista.set(0, nombreCand);
       
     
        //System.out.println(lista);  
                         
        //toma todos los elementos y los une en una cadena utilizando como delimitador la barrita
        linea=String.join("|", lista)+"|";
                           
                         
        System.out.println("Candidato encontrado, los datos fueron  modificados");
        encontrado=true;
                           
        }
                           
                       
        bw.write(linea+"\n");
                           
        } 
        bw.close();
        br.close();
                        
        if (encontrado!=true){
        System.out.println("Candidato no encontrado, las modificaciones no fueron realizadas");
                                 
        }
                        
        Files.move(fc.toPath(), candidatos.toPath(), REPLACE_EXISTING);
            
        }catch (FileNotFoundException ex){
        System.out.println("El candidato no existe"+ex);
        } catch (IOException ex) {
        System.out.println("El candidato no existe"+ex);
        }     
        break;
        
        
        
        case 2:
            //modificar formacion del candidato
        try {
         FileReader fr = new FileReader(candidatos);
                      
         BufferedReader br = new BufferedReader(fr);
         File fc = new File("copia_candidatos.txt");
         FileWriter fw = new FileWriter(fc);
         BufferedWriter bw = new BufferedWriter(fw);
        
         linea = "";
         System.out.println("Bienvenido a la modificacion de datos de candidatos");
         System.out.println("Ingrese el codigo del candidato que desea modificar para iniciar la busqueda");
         codCand=scan.next();
         scan.nextLine(); // consume the newline
         System.out.println("Ingrese la nueva formacion del candidato");
         formacionCand=scan.nextLine();
         
        
                        
        ArrayList<String> lista=new ArrayList<String>();
        while((linea = br.readLine()) != null) {
                           
        String [] datos = linea.split("\\|");
                           
        if (datos[3].compareTo(codCand) == 0){
        String[] vector=new String[datos.length];
        //System.out.println(datos.length);
        for(int i=0; i<datos.length; i++){
    
       // System.out.println(datos[i]);
        lista.add(datos[i]);
      
                         
        } 
                            
        //System.out.println("posiciones"+vector.length);
        
        
        lista.set(1, formacionCand);
       
     
        //System.out.println(lista);  
                         
        //toma todos los elementos y los une en una cadena utilizando como delimitador la barrita
        linea=String.join("|", lista)+"|";
                           
                         
        System.out.println("Candidato encontrado, los datos fueron  modificados");
        encontrado=true;
                           
        }          
        bw.write(linea+"\n");
                           
        } 
        bw.close();
        br.close();
                        
        if (encontrado!=true){
        System.out.println("Candidato no encontrado, las modificaciones no fueron realizadas");
                                 
        }                
        Files.move(fc.toPath(), candidatos.toPath(), REPLACE_EXISTING);
            
        }catch (FileNotFoundException ex){
        System.out.println("El candidato no existe"+ex);
        } catch (IOException ex) {
        System.out.println("El candidato no existe"+ex);
        }         
         
        break;
        case 3:
           //modificacion de la experiencia profesional
         try {
         FileReader fr = new FileReader(candidatos);
                      
         BufferedReader br = new BufferedReader(fr);
         File fc = new File("copia_candidatos.txt");
         FileWriter fw = new FileWriter(fc);
         BufferedWriter bw = new BufferedWriter(fw);
        
         linea = "";
         System.out.println("Bienvenido a la modificacion de datos de candidatos");
         System.out.println("Ingrese el codigo del candidato que desea modificar para iniciar la busqueda");
         codCand=scan.next();
         scan.nextLine(); // consume the newline
         System.out.println("Ingrese la nueva experiencia del candidato");
         experienciaCand=scan.nextLine();
         
        
                        
        ArrayList<String> lista=new ArrayList<String>();
        while((linea = br.readLine()) != null) {
                           
        String [] datos = linea.split("\\|");
                           
        if (datos[3].compareTo(codCand) == 0){
        String[] vector=new String[datos.length];
        //System.out.println(datos.length);
        for(int i=0; i<datos.length; i++){
    
       // System.out.println(datos[i]);
        lista.add(datos[i]);
      
                         
        } 
                            
        //System.out.println("posiciones"+vector.length);
        
        
        lista.set(2, experienciaCand);
       
     
        //System.out.println(lista);  
                         
        //toma todos los elementos y los une en una cadena utilizando como delimitador la barrita
        linea=String.join("|", lista)+"|";
                           
                         
        System.out.println("Candidato encontrado, los datos fueron  modificados");
        encontrado=true;
                           
        }
                           
                       
        bw.write(linea+"\n");
                           
        } 
        bw.close();
        br.close();
                        
        if (encontrado!=true){
        System.out.println("Candidato no encontrado, las modificaciones no fueron realizadas");
                                 
        }
                        
        Files.move(fc.toPath(), candidatos.toPath(), REPLACE_EXISTING);
            
        }catch (FileNotFoundException ex){
        System.out.println("El candidato no existe"+ex);
        } catch (IOException ex) {
        System.out.println("El candidato no existe"+ex);
        }          
        break;
        case 4:
        //modificacion del codigo del candiato
            try {
                 String newCodCand;
         FileReader fr = new FileReader(candidatos);
                      
         BufferedReader br = new BufferedReader(fr);
         File fc = new File("copia_candidatos.txt");
         FileWriter fw = new FileWriter(fc);
         BufferedWriter bw = new BufferedWriter(fw);
        
         linea = "";
         System.out.println("Bienvenido a la modificacion de datos de candidatos");
         System.out.println("Ingrese el codigo del candidato que desea modificar para iniciar la busqueda");
         codCand=scan.next();
         scan.nextLine(); // consume the newline
         System.out.println("Ingrese el codigo del candidato");
         newCodCand=scan.nextLine();
         
        
                        
        ArrayList<String> lista=new ArrayList<String>();
        while((linea = br.readLine()) != null) {
                           
        String [] datos = linea.split("\\|");
                           
        if (datos[3].compareTo(codCand) == 0){
        String[] vector=new String[datos.length];
        //System.out.println(datos.length);
        for(int i=0; i<datos.length; i++){
    
       // System.out.println(datos[i]);
        lista.add(datos[i]);
      
                         
        } 
                            
        //System.out.println("posiciones"+vector.length);
        
        
        lista.set(3, newCodCand);
       
     
        //System.out.println(lista);  
                         
        //toma todos los elementos y los une en una cadena utilizando como delimitador la barrita
        linea=String.join("|", lista)+"|";
                           
                         
        System.out.println("Candidato encontrado, los datos fueron  modificados");
        encontrado=true;
                           
        }             
        bw.write(linea+"\n");
                           
        } 
        bw.close();
        br.close();
                        
        if (encontrado!=true){
        System.out.println("Candidato no encontrado, las modificaciones no fueron realizadas");
                                 
        }
                        
        Files.move(fc.toPath(), candidatos.toPath(), REPLACE_EXISTING);
            
        }catch (FileNotFoundException ex){
        System.out.println("El candidato no existe"+ex);
        } catch (IOException ex) {
        System.out.println("El candidato no existe"+ex);
        }     
       
        break;
        default: System.out.println("Opcion no valida");
  
    }

    }while((opModificacion>4)||(opModificacion<=0));

}

public void eliminarCandidato(){
 Scanner scan=new Scanner(System.in);
   //variables
   boolean encontrado = false;
   String correoEleUsuario;
   String codCand;
   
    //creacion del archivo
    File candidatos= new File("registro_candidatos.txt");   
       
         try {
           FileReader fr = new FileReader(candidatos);
           BufferedReader br = new BufferedReader(fr);
                        
           File fc = new File("copia_candidatos.txt");
           FileWriter fw = new FileWriter(fc);
           BufferedWriter bw = new BufferedWriter(fw);
                        
           String linea = "";
                        
           System.out.println("Bienvenido a la eliminacion de candidatos");
           System.out.println("Ingrese el codigo del candidato a eliminar");
           codCand=scan.next();
                        
                        
                        
           while((linea = br.readLine()) != null) {
           String [] datos = linea.split("\\|");
           if (datos[3].compareTo(codCand) != 0) {
           bw.write(linea+"\n");
                                
                                
             }else{
            encontrado=true;
            }
          } 
                        
          bw.close();
          br.close();
                        
          Files.move(fc.toPath(), candidatos.toPath(), REPLACE_EXISTING);
          } catch (FileNotFoundException ex) {
            System.out.println("Hubo un error"+ex);
          } catch (IOException ex) {
            System.out.println("Hubo un error"+ex);
          } 
                       
          if (encontrado){
          System.out.println("Candidato eliminado correctamente");
          }else{
          System.out.println("Candidato no eliminado, porque no existe en el archivo");
          }
            

}

 public void opCandidatos(){
 Scanner scan=new Scanner(System.in);
  Registro_Usuarios_SV obj=new Registro_Usuarios_SV();
     int op=0;
     System.out.println("Las opciones que tiene disponibles para ejecutar con un candidato son las siguientes:");
     System.out.println("1. Crear candidatos");
     System.out.println("2. Modificar Candidatos");
     System.out.println("3. Eliminar Candiatos");
     
     do{
     System.out.println("Ingrese opcion valida");
     op=scan.nextInt();
     switch(op){
         case 1:
           obj.crearCandiatos();
             
         break;
         case 2:
           obj.modificarCandidato();
         break;
         case 3:
            obj.eliminarCandidato();
            break;
         default:System.out.println("Opcion no valida");
   
     }
   
     }while((op>3)||(op<=0));
 
 
 }

 
 public void opAdministrador(){
  Scanner scan=new Scanner(System.in);
  Registro_Usuarios_SV obj=new Registro_Usuarios_SV();
 int opcAdmon=0;
   System.out.println("Bienvenido Administrador");
                   System.out.println("1.Acceso a la creacion de usuarios");
                   System.out.println("2.Acceso a la creacion de votantes");
                   System.out.println("3.Acceso a las elecciones");
                   System.out.println("4.Acceso a los reportes");
                   
                
                    do{
                    
                     System.out.println("Ingrese opcion valida");
                     opcAdmon=scan.nextInt();
                     
                    switch(opcAdmon){
                     //acceso a todas las funcionalidades que pueden hacerse con los usuarios
                     case 1:
                     obj.opcionesUsuario();
                     break;
                     //acceso a todas las funcionalidades que pueden hacerse con los votantes
                     case 2:
                     obj.opcionesVotante();
                     break;
                     case 3:
                         int op=0;
                         System.out.println("Bienvenido administrador acaba de acceder a las elecciones");
                         System.out.println("1. Gestionar Elecciones");
                         System.out.println("2. Gestionar Candidatos");
                         System.out.println("3. Configurar opciones de Eleccion");
                         do{
                         System.out.println("Ingrese opcion valida");
                         op=scan.nextInt();
                         
                         switch(op){
                             case 1:
                               obj.opElecciones();
                             break;
                             case 2:
                              obj.opCandidatos();
                             break;
                             default: System.out.println("Opcion no valida");
                        
                         }
                         
                         }while((op>3)||(op<=0));
                       
                     break;
                     
                     case 4:
                         System.out.println("acceso a los reportes");
                 
                     }   
                  
                    }while((opcAdmon>4)||(opcAdmon<=0));
 
 }
   
   
}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

   


