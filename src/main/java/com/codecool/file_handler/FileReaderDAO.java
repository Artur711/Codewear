package com.codecool.file_handler;

import java.io.IOException;
import java.util.HashMap;

public interface FileReaderDAO {

    public HashMap<String, String> readFile() throws IOException;
}
