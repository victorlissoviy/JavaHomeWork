package com.bp.lisovyj.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class FileNumbers {
    private final Logger LOGGER = Logger.getLogger(getClass().getName());
    private final Random random = new Random();

    public void createNumbersFile(String file) {
        LOGGER.entering(getClass().getName(), "createNumbersFile");
        Path path = Paths.get(file);
        if(!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Не можливо створити файл: " + file, e);
                LOGGER.exiting(getClass().getName(), "createNumbersFile");
                return;
            }
        }
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path)){
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    bufferedWriter.write((random.nextInt(99) + 1) + " ");
                }
                bufferedWriter.write("\n");
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Не можливо відкрити або записати в файл", e);
        }
        LOGGER.exiting(getClass().getName(), "createNumbersFile");
    }

    public void createOddNumbersFile(String file, String oddFile){
        LOGGER.entering(getClass().getName(), "createOddNumbersFile");
        Path path = Paths.get(file);
        Path oddPath = Paths.get(oddFile);
        if(!Files.exists(path)){
            LOGGER.log(Level.SEVERE, "Файлу для зчитування (" + file + ") не існує");
            LOGGER.exiting(getClass().getName(), "createNumbersFile");
            return;
        }
        if(!Files.exists(oddPath)){
            try {
                Files.createFile(oddPath);
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Не можливо створити файл: " + oddFile, e);
            }
        }
        try(
                BufferedReader br = Files.newBufferedReader(path);
                BufferedWriter bw = Files.newBufferedWriter(oddPath)
        ){
            String line = br.readLine();
            while(line != null){
                String[] numbers = line.split(" ");
                for(String number : numbers){
                    if(Integer.parseInt(number) % 2 == 0){
                        bw.write("0");
                    }else{
                        bw.write(number);
                    }
                    bw.write(" ");
                }
                bw.write("\n");
                line = br.readLine();
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Помилка при роботі з файлами", e);
        }
        LOGGER.exiting(getClass().getName(), "createOddNumbersFile");
    }

    public static void main(String[] args) {
        System.setProperty("java.util.logging.config.file", "files/logging.properties");
        try {
            LogManager.getLogManager().readConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileNumbers fileNumbers = new FileNumbers();
        fileNumbers.createNumbersFile("files/numbers.txt");
        fileNumbers.createOddNumbersFile("files/numbers.txt","files/odd-numbers.txt");
    }
}
