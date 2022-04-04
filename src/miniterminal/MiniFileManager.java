package miniterminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Samu
 */
public class MiniFileManager{
    File carpetaActual;

    public MiniFileManager(File carpetaActual) {
        this.carpetaActual = carpetaActual;
    }

    public File getCarpetaActual() {
        return carpetaActual;
    }

    public void setCarpetaActual(File carpetaActual) {
        this.carpetaActual = carpetaActual;
    }
    
    //Metodo getPWD, obtiene la ruta actual a la que apunta la terminal, y la imprime.
    String getPWD(){
        String ruta = carpetaActual.getAbsolutePath();
        System.out.println(ruta);
        return ruta;
    }
    
    //Comprueba que el directorio exista, y si lo hace la terminal apuntara a este      // Las rutas relativas las acepta sino incluyen los "."
    boolean changeDir(String ruta)throws FileNotFoundException{
        File nuevoDir = new File(ruta);
        if(nuevoDir.exists()){
            carpetaActual=nuevoDir;
            System.out.println("Se ha cambiado de directorio");
            return true;           
        }
        String rutaActual = carpetaActual.getAbsolutePath();
        File nuevoDir2 = new File(rutaActual+ruta);
        if(nuevoDir2.exists()){
            carpetaActual=nuevoDir2;
            System.out.println("Se ha cambiado de directorio");
            return true;
        }
        if(!nuevoDir2.exists()){
            throw new FileNotFoundException();
        }
        return true;
    }
    
    //Imprime la lista de directorios y ficheros que se encuentren en la ruta actual, empezando por el mismo.
    void printList(boolean info)throws FileNotFoundException{                
        String ruta = carpetaActual.getAbsolutePath();
        System.out.println(ruta);
        
        File f = new File(ruta);
        if(!f.exists()){
            throw new FileNotFoundException();
        }
        if (f.isFile()) {
            System.out.println("[A]" + f.getName());
        }
        if (f.isDirectory()) {
            System.out.println("[*]" + f.getName());
            for(File ruta2 : f.listFiles()){
                if(ruta2.isDirectory())System.out.println("*" + ruta2.getName()); 
                String aux1=("*" + ruta2.getName());                
        }
            for(File ruta3 : f.listFiles()){            
                if(ruta3.isFile())System.out.println("A" + ruta3.getName());
                String aux2=("A" + ruta3.getName());            
            }
        }    
    }
    
    //Imprime la lista de directorios y ficheros que se encuentren en la ruta indicada, empezando por el mismo.
    void printList2(boolean info, String ruta)throws FileNotFoundException{   
        File f = new File(ruta);
        if(!f.exists()){
            throw new FileNotFoundException();
        }
        if (f.isFile()) {
            System.out.println("[A]" + f.getName());
        }
        if (f.isDirectory()) {
            System.out.println("[*]" + f.getName());
            for(File ruta2 : f.listFiles()){
                if(ruta2.isDirectory())System.out.println("*" + ruta2.getName()); 
                String aux1=("*" + ruta2.getName());                
        }
            for(File ruta3 : f.listFiles()){            
                if(ruta3.isFile())System.out.println("A" + ruta3.getName());
                String aux2=("A" + ruta3.getName());            
            }
        }    
    }
    
    //Imprime la lista de directorios y ficheros que se encuentren en la ruta actual, con su fecha de ultima modificacion y tamaño, empezando por el mismo.
    void printFullList(boolean info)throws FileNotFoundException{       
        String ruta = carpetaActual.getAbsolutePath();
        System.out.println(ruta);
        
        File f = new File(ruta);
        if(!f.exists()){
            throw new FileNotFoundException();
        }
        if (f.isFile()) {
            System.out.println("Nombre: [A]" + f.getName() + " " + "Tiempo(ms): " + f.lastModified() + " Tamaño: " + f.length());
        }
        if (f.isDirectory()) {
            System.out.println("Nombre: [*]" + f.getName() + " " + "Tiempo(ms): " + f.lastModified() + " Tamaño: " + f.length());
            for(File ruta2 : f.listFiles()){
                if(ruta2.isDirectory())System.out.println("*" + ruta2.getName() + " " + "Tiempo(ms): " + ruta2.lastModified() + " Tamaño: " + ruta2.length()); 
                String aux1=("*" + ruta2.getName());               
        }
            for(File ruta3 : f.listFiles()){            
                if(ruta3.isFile())System.out.println("A" + ruta3.getName() + " " + "Tiempo(ms): " + ruta3.lastModified() + " Tamaño: " + ruta3.length());
                String aux2=("A" + ruta3.getName());             
            }
        }   
    }
    
    //Imprime la lista de directorios y ficheros que se encuentren en la ruta indicada, con su fecha de ultima modificacion y tamaño, empezando por el mismo.
    void printFullList2(boolean info, String ruta)throws FileNotFoundException{    
        File f = new File(ruta);
        if(!f.exists()){
            throw new FileNotFoundException();
        }
        if (f.isFile()) {
            System.out.println("Nombre: [A]" + f.getName() + " " + "Tiempo(ms): " + f.lastModified() + " Tamaño: " + f.length());
        }
        if (f.isDirectory()) {
            System.out.println("Nombre: [*]" + f.getName() + " " + "Tiempo(ms): " + f.lastModified() + " Tamaño: " + f.length());
            for(File ruta2 : f.listFiles()){
                if(ruta2.isDirectory())System.out.println("*" + ruta2.getName() + " " + "Tiempo(ms): " + ruta2.lastModified() + " Tamaño: " + ruta2.length()); 
                String aux1=("*" + ruta2.getName());                
            }
            for(File ruta3 : f.listFiles()){            
                if(ruta3.isFile())System.out.println("A" + ruta3.getName() + " " + "Tiempo(ms): " + ruta3.lastModified() + " Tamaño: " + ruta3.length());
                String aux2=("A" + ruta3.getName());             
            }
        }   
    }
    
    //Comprueba que la ruta no exista, sino lo hace la crea.
    boolean createDir(String ruta){   
        File f = new File(ruta);
        if (!f.exists()) {
            if (f.mkdirs()) {
                System.out.println("Directorio creado");
                return true;
            } else {
                System.out.println("Error al crear directorio");
                return false;
            }
        }
        return true;   
    }
    
    //Comprueba si la ruta existe y tenemos permisos para modificarla, si lo hace la elimina.
    boolean deleteDir(String ruta)throws FileNotFoundException, permisosExcepcion{
        File f = new File(ruta);
        if(!f.exists()){
            throw new FileNotFoundException();
        }
        if(!f.canExecute()){
            throw new permisosExcepcion("No tienes permisos para eliminar este fichero o directorio.");
        }
        else{
            int contador=0;
            int contador2=0;
            if (f.isFile()) {
            f.delete();
            contador++;
            System.out.println("Se han eliminado " + contador + "ficheros");           
            return true;
            }             
            File[] Lista = f.listFiles();
            
            for (int i = 0; i < Lista.length ; i++) {                                
                if (f.isFile()) {
                Lista[i].delete();
                contador++;                
                }
                if (f.isDirectory()) {
                    contador2++;                    
                }
            }
            if(contador2==0){
                f.delete();
                System.out.println("Se ha eliminado el directorio y " + contador + " ficheros");                
                return true;
            } 
            System.out.println("Se han eliminado " + contador + "ficheros");
            System.out.println("Se han encontrado " + contador2 + "directorios dentro del actual.");          
            return true;
        }
    }
    
    //Comprueba que ambas rutas existan, despues si tenemos permisos para modificar la antigua y existe, y la nueva no existe, mueve el fichero o directorio a la nueva ruta.
    boolean moveDir(String ruta, String dir)throws FileNotFoundException, permisosExcepcion{
        Scanner sc = new Scanner(System.in);
        File viejaRuta = new File(ruta);
        if(!viejaRuta.exists()){
            throw new FileNotFoundException();
        }
        if(!viejaRuta.canExecute()){
            throw new permisosExcepcion("No tienes permisos para mover o modificar este fichero.");
        }
        File nuevaRuta = new File(dir);
        //Si la nueva ruta existe y es un fichero, te preguntara si deseas sobreescribbir
        if(nuevaRuta.exists() && nuevaRuta.isFile()){
            String decision;
            do{
                System.out.println("Ya hay un archivo en este directorio con el mismo nombre,¿Desea sobreescribirlo?S/N");
                decision = sc.nextLine();
                if(decision=="S"){
                    viejaRuta.renameTo(nuevaRuta);
                }
                if(decision=="N"){
                    System.out.println("Has decidido cancelar la acción");
                    return false;
                }
                else{
                    System.out.println("Error.");
                }
            }while(!decision.equals("S") || !decision.equals("N"));
        }//Si la nueva ruta existe y es un directorio, no permite mover o sobreescribirlo.
        if(nuevaRuta.exists() && nuevaRuta.isDirectory()){
            System.out.println("El directorio no se pudo mover, ya existe uno con ese nombre.");
            return false;
        }
        viejaRuta.renameTo(nuevaRuta);
        //Comprobando si la nueva ruta antes no existia, y ahora si, o sigue sin existir, por lo cual no se creo.
        if(!nuevaRuta.exists()){
            System.out.println("La ruta no ha cambiado");
            throw new FileNotFoundException();
        }
        System.out.println("Se ha completado la accion con exito");
        //devuelve true con la ruta creada.
        return true;
    }
    
    //Muestra informacion sobre los comandos disponibles en la terminal.
    void help(){
        System.out.println("----------------------------------------------");
        System.out.println();
        System.out.println("pwd: Muestra carpeta actual.");
        System.out.println("cd<DIR>: Cambia de carpeta.");
        System.out.println("ls: Lista directorios y ficheros.");
        System.out.println("ll: Lista con mas detalle.");
        System.out.println("mkdir: Crea un nuevo directorio.");
        System.out.println("rm: Borra fichero o directorio.");
        System.out.println("mv: Mueve fichero o directorios.");
        System.out.println("help: Muestra informacion de los comandos.");
        System.out.println("exit: Salida del programa.");
        System.out.println();
        System.out.println("----------------------------------------------");
    }
    //Metodo que se ejecuta al recibir el comando info en la terminal
    //Devuelve peso del fchero/directorio de la ruta indicada en b y Mb, ademas de su ultima fecha de modificación.
    void Info(String ruta)throws FileNotFoundException{  
        
        File infoRuta = new File(ruta);
        //Comprobamos si la ruta existe, sino lanzamos excepción.
        if(!infoRuta.exists()){
            throw new FileNotFoundException();
        }
        //Si es un fichero.
        if(infoRuta.isFile()){
        //Guardamos en una variable el peso de fichero en b y calculamos el peso en Mb. la b de la variable esta en minuscula porque byte va en minuscula.
        long tamañob = infoRuta.length();
        double tamañomb = tamañob/1048576;
        //Guardamos la ultima fecha de modificación y le damos formato paara mostrarla.
        long fechamod = infoRuta.lastModified();
        String pattern = "EEE MMM d hh:mm:ss zz yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date lastModifiedDate = new Date( fechamod );
        System.out.println(infoRuta + "    " + tamañob + " b    " + tamañomb + " Mb    "+ "  " + simpleDateFormat.format(fechamod));
        //Si muestra 0.0 Mb es porque el archivo es tan "pequeño" que un double no llega a recoger los decimales de su peso en Mb. 1 Mb = 1048576 b.
        }
        //Sino es un fichero, es un directorio.
        else{
            long tamañoTotalb=0;
            //Array de ficheros/directorios que contiene.
            File[] ArrayRuta = infoRuta.listFiles();        
            //acumulamos el tamaño de cada fichero
            for (int i = 0; i < ArrayRuta.length ; i++) {                                
                long tamañob = infoRuta.length();
                tamañoTotalb += tamañob;
            }
            //Calculo Mb, formato fecha de modificación.
            double tamañoTotalmb = tamañoTotalb/1048576;
            long fechamod = infoRuta.lastModified();
            String pattern = "EEE MMM d hh:mm:ss zz yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date lastModifiedDate = new Date( fechamod );
            //Imprimimos
            System.out.println(infoRuta + "    " + tamañoTotalb + " b    " + tamañoTotalmb + " Mb    "+ "  " + simpleDateFormat.format(fechamod));
        }
    }
}
