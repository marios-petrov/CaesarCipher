package input_output_handling;


import encryption_algorithm.*;
import input_output_handling.IOHandling;

/**
 * @authors Marios Petrov / Megan Pelletier
 * @version 1.0
 * @since March 2023
 */

public class MyFileReader implements IOHandling {

    public String readFromFile;
    public String writeToFileName;
    public String rawData;
    public String processedData;
    public Encryption eAlgorithm;

    public MyFileReader(String readFromFile, String writeToFileName) {
        this.readFromFile = readFromFile;
        this.writeToFileName = writeToFileName;
        this.rawData = "";
        this.processedData = "";
        this.eAlgorithm = new CaesarCipher(1);
    }

    public MyFileReader(String readFromFile, String writeToFileName,Encryption eAlgorithm) {
        this.readFromFile = readFromFile;
        this.writeToFileName = writeToFileName;
        this.rawData = "";
        this.processedData = "";
        this.eAlgorithm = eAlgorithm;
    }

    public void readData() {
        rawData = readData(readFromFile);
    }

    public void writeData() {
        writeData(processedData, writeToFileName);
    }

    public void processData() {
        if (rawData.startsWith("encrypt:")) {
           String noPrefix = rawData.replaceFirst("encrypt:","");
           processedData = eAlgorithm.encrypt(noPrefix);
        }
        else if (rawData.startsWith("decrypt:")) {
            String noPrefix = rawData.replaceFirst("decrypt:","");
            processedData = eAlgorithm.decrypt(noPrefix);
        }
        else {
            processedData =rawData;
        }
    }
}
