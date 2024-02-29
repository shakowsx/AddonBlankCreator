package org.addonblankcreator.Utility;

import java.io.*;

/**
 * This class copies a file from the 'resources' folder of an executable application.
 */
public class CopyFileFromResources implements CopyFile {
    /**
     * Copies a file from the executable application to the specified path using InputStream and OutputStream.
     *
     * @param fileInputPath  - path to the source file to be copied.
     * @param fileOutputPath - path where the file should be copied.
     * @throws FileNotFoundException - an exception that can be thrown if the source file was not found.
     *
     * @see InputStream
     * @see OutputStream
     */
    public void copy(String fileInputPath, String fileOutputPath) throws FileNotFoundException {
        //Getting InputStream for the source file from resources.
        InputStream inputFile = CopyFileFromResources.class.getClassLoader().getResourceAsStream(fileInputPath);

        //If the source file is not found, displaying an error message and terminating the method.
        if (inputFile == null) {
            System.out.println("Ресурс [" + fileInputPath + "] не найден. Копирование файла в [" +
                    fileOutputPath + "] отменено...[ОШИБКА]");
            return;
        }

        //Creating an OutputStream for the output file.
        OutputStream outputFile = new FileOutputStream(fileOutputPath);

        /*
         Reading data from the source file and writing it to the output file. Uses try-with-resources to
         automatically close resources.
        */
        try (inputFile;outputFile) {
            int data;

            while ((data = inputFile.read()) != -1) {
                outputFile.write(data);
            }
            //If everything went well, a message indicating successful copying is displayed.
            System.out.println("Ресурс [" + fileInputPath + "] успешно скопирован в [" + fileOutputPath + "]...[ok]");
        } catch (IOException e) {
            // If an error occurred while copying, a RuntimeException is thrown
            throw new RuntimeException(e);
        }
    }
}