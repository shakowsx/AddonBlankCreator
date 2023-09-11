package org.addonblankcreator.Utility;

import java.io.*;

public class CopyFileFromResources implements CopyFile {
    public void copy(String fileInputPath, String fileOutputPath) throws FileNotFoundException {
        InputStream inputFile = CopyFileFromResources.class.getClassLoader().getResourceAsStream(fileInputPath);
        if (inputFile == null) {
            System.out.println("Ресурс [" + fileInputPath + "] не найден. Копирование файла в [" +
                    fileOutputPath + "] отменено...[ОШИБКА]");
            return;
        }
        OutputStream outputFile = new FileOutputStream(fileOutputPath);
        try (inputFile;outputFile) {
            int data;

            while ((data = inputFile.read()) != -1) {
                outputFile.write(data);
            }
            System.out.println("Ресурс [" + fileInputPath + "] успешно скопирован в [" + fileOutputPath + "]...[ok]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* Test
    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        }
        finally {
            if(source != null) {
                source.close();
            }
            if(destination != null) {
                destination.close();
            }
        }
    }*/
}
