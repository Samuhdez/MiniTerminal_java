package miniterminal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Samu
 */
public class Miniterminal {
    public static void main(String[] args) throws FileNotFoundException, permisosExcepcion{
        //Scanner para leer datos introducidos por consola.
        Scanner sc = new Scanner(System.in);
        String orden;
        boolean salir = false;
        boolean info=false;
        String salida="no";
        //carpeta donde inicia el terminal, inicia en C\\ en windows.
        File carpeta = new File("\\");
        MiniFileManager manager = new MiniFileManager(carpeta);
        
        do{
            try{
            System.out.print(">>");
            orden = sc.nextLine();
            //split, para dividir en distintas cadenas segun el caracter indicado y guardarlo en un array de Strings Orden.
            String[] Orden = orden.split(" ");                  
            
            //Listar directorio actual
            if(Orden[0].equals("pwd")){ 
                if(Orden.length<=1){
                    manager.getPWD(); 
                }
                else{
                    System.out.println("Orden fallida, " + Orden[0] + " no acepta terminos");
                }
            }
            //Cambiar de directorio, cuando el primer String guardado en orden coincida con cd, llamar al metodo changeDir, e introducir en el metodo la segunda subcadena del array Orden
            if(Orden[0].equals("cd")){
                if(Orden.length<=2 ){
                    String auxRuta = Orden[1];
                    manager.changeDir(auxRuta);
                }
                else{
                    System.out.println("Orden fallida, " + Orden[0] + " solo acepta 1 termino");
                }
            }
            //Listar ficheros del directorio actual
            if(Orden[0].equals("ls")){
                if(Orden.length<=1){
                manager.printList(info);
                }
                if(Orden.length<=2 && Orden.length>1){  
                    String auxRuta = Orden[1];
                    manager.printList2(info, auxRuta);
                }
                if(Orden.length>2){
                    System.out.println("Orden fallida, " + Orden[0] + " solo acepta hasta 1 termino");
                }
            }
            //Listar ficheros + info, es LL (ll), no once (11)
            if(Orden[0].equals("ll")){
                if(Orden.length<=1){                
                    manager.printFullList(info);
                }
                if(Orden.length<=2 && Orden.length>1){  
                    String auxRuta = Orden[1];
                    manager.printFullList2(info, auxRuta);
                }
                if(Orden.length>2){
                    System.out.println("Orden fallida, " + Orden[0] + " solo acepta  hasta 1 termino");
                }
            }
            //Crear directorios
            if(Orden[0].equals("mkdir")){
                if(Orden.length<=2 && Orden.length>1){
                String auxRuta = Orden[1];
                manager.createDir(auxRuta);
                }
                else{
                    System.out.println("Orden fallida, " + Orden[0] + " solo acepta 1 termino");
                }
            }
            //Eliminar directorios
            if(Orden[0].equals("rm")){
                if(Orden.length<=2 && Orden.length>1){
                    String auxRuta = Orden[1];
                    manager.deleteDir(auxRuta);
                }
                else{
                    System.out.println("Orden fallida, " + Orden[0] + " solo acepta 1 termino");
                }
            }
            //Mover de directorio
            if(Orden[0].equals("mv")){
                if(Orden.length<=3 && Orden.length>2 ){
                    String auxRuta = Orden[1];
                    String auxRuta2 = Orden[2];
                    manager.moveDir(auxRuta, auxRuta2);
                }   
                else{
                    if(Orden.length<=2 && Orden.length>1){
                        System.out.println("Orden fallida, " + Orden[0] + " solo acepta 2 terminos");
                    }
                    else{
                        System.out.println("Orden fallida, " + Orden[0] + " necesita ruta inicial y final");
                    }
                }
            }
            //Mostrar menu de ayuda de comandos
            if(Orden[0].equals("help")){
                if(Orden.length<=1){
                    manager.help();
            }
                else{
                    System.out.println("Orden fallida, " + Orden[0] + " solo acepta 1 termino");
                }
            }  
            if(Orden[0].equals("info")){
                if(Orden.length<=2 || Orden.length>1){
                    String auxRuta = Orden[1];
                    manager.Info(auxRuta);
                }
                else{
                    System.out.println("Orden fallida, " + Orden[0] + " acepta unicamente un termino.");
                }
            }
            //Salida del programa
            if(Orden[0].equals("exit")){
                if(Orden.length<=1){
                    salir=true;             
                }
                else{
                    System.out.println("Orden fallida, " + Orden[0] + " exit no acepta terminos");
                }
            }
            if(!Orden[0].equals("exit") && !Orden[0].equals("mv") && !Orden[0].equals("info") && !Orden[0].equals("rm") && !Orden[0].equals("mkdir") && !Orden[0].equals("ll") && !Orden[0].equals("ls") && !Orden[0].equals("help") && !Orden[0].equals("cd") && !Orden[0].equals("pwd")){
                System.out.println("Error " + Orden[0] + " no es reconocible por el sistema" );
            }
            }   
            //Control de errores
            //Ruta no encontrada
            catch(FileNotFoundException ex){
            System.out.println("Error, no existe la ruta.");
            }
            catch(permisosExcepcion ex1){
            System.out.println("Error, no tienes los permisos necesarios.");
            }
        }while(!salir);   //Fin del programa/salida del terminal           
    }
    
}
