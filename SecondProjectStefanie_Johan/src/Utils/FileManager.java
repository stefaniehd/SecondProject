/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Stefanie
 */
public class FileManager {
    
    /**
     * reads a text file
     * @param fileName (the name of the text file)
     * @return the text from the file
     */
    public String read(String fileName) {
        String texto = "";
        FileReader archivo = null;
        String linea = "";
        try {
            File f = new File(fileName);
            if (!f.exists()) {
                f.createNewFile();
            }
            archivo = new FileReader(fileName);
            BufferedReader lector = new BufferedReader(archivo);
            while ((linea = lector.readLine()) != null) {
                texto += linea + "\n";
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Archivo no encontrado");
        } catch (IOException e) {
            throw new RuntimeException("Ocurrio un error de entrada / salida");
        } finally {
            if (archivo != null) {
                try {
                    archivo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return texto;
    }

    /**
     * 
     * @param fileName / this parameter is used to know the file required
     * @param text / this parameter is used to write into the file
     * this method writes into the file required
     */
    public void write(String fileName, String text) {
        FileWriter salida = null;
        try {
            salida = new FileWriter(fileName);
            BufferedWriter escritor = new BufferedWriter(salida);
            salida.write(text.replaceAll("\n", "\r\n"));
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

