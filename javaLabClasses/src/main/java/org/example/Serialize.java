package org.example;

import  java.io.File;
import  java.io.FileNotFoundException;
import  java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
public interface Serialize<T> {

    String serialize(T obj) throws Exception;

    T deserialize(String data) throws Exception;

    default void writeToFile(String data, String filename) throws IOException{
        var outputStream = new FileOutputStream(filename);
        outputStream.write(data.getBytes());
        outputStream.close();
    }

    default void serializeToFile(T obj, String filename) throws Exception{
        var data = serialize(obj);
        writeToFile(data, filename);
    }

    default String readFromFile(String filename) throws FileNotFoundException{
        var file = new File(filename);
        var scanner = new Scanner(file);
        StringBuilder data = new StringBuilder();
        while (scanner.hasNextLine()){
            data.append(scanner.nextLine());
        }
        scanner.close();
        return data.toString();
    }

    default T deserializeFromFile(String filename) throws Exception{
        var data = readFromFile(filename);
        return deserialize(data);
    }

}

