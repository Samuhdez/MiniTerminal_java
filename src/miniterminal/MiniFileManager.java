package miniterminal;

import java.io.File;
import java.io.FileNotFoundException;

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
    
    String getPWD(){
        String ruta = carpetaActual.getAbsolutePath();
        System.out.println(ruta);
        return ruta;
    }
    
    boolean changeDir(String ruta)throws FileNotFoundException{
        File nuevoDir = new File(ruta);
        if(!nuevoDir.exists()){
            throw new FileNotFoundException();
        }
        carpetaActual=nuevoDir;
        System.out.println("Se ha cambiado de directorio");
        return true;
    }
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
            //String[] lista = f.list();
            //for (int i = 0; i < lista.length; i++) {
            //    System.out.println(lista[i]);
            //}
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
            //String[] lista = f.list();
            //for (int i = 0; i < lista.length; i++) {
            //    System.out.println(lista[i]);
            //}
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

            //String[] lista = f.list();
            //for (int i = 0; i < lista.length; i++) {
            //    System.out.println(lista[i]);
            //}
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

            //String[] lista = f.list();
            //for (int i = 0; i < lista.length; i++) {
            //    System.out.println(lista[i]);
            //}
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
    boolean deleteDir(String ruta)throws FileNotFoundException{
        File f = new File(ruta);
        if(!f.exists()){
            throw new FileNotFoundException();
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
    boolean moveDir(String ruta, String dir)throws FileNotFoundException{
        File viejaRuta = new File(ruta);
        if(!viejaRuta.exists()){
            throw new FileNotFoundException();
        }
        File nuevaRuta = new File(dir);
        viejaRuta.renameTo(nuevaRuta);
        if(!nuevaRuta.exists()){
            System.out.println("La ruta no ha cambiado");
            throw new FileNotFoundException();
        }
        System.out.println("Se ha completado la accion con exito");
        return true;
    }
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
}
