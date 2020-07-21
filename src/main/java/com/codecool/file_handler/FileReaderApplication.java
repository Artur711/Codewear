package com.codecool.file_handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class FileReaderApplication implements FileReaderDAO {
    private String path;

    public FileReaderApplication(String path) {
        this.path = path;
    }

    @Override
        public HashMap<String, String> readFile() throws IOException {

        HashMap<String, String> hashMapFile = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(this.path));
            String st;

            while ((st = br.readLine()) != null) {
                String[] tabRow =  st.split("~");
                hashMapFile.put(tabRow[0], tabRow[1]);
            }


        } catch (FileNotFoundException e) {
            System.out.println("The file doesn't exist!!!");
        }

        return hashMapFile;
    }
}
