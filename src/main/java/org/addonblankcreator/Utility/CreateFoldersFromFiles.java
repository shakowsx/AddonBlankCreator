package org.addonblankcreator.Utility;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;

public class CreateFoldersFromFiles implements FolderCreator {
    public void createFolders(HashMap<String, File> foldersStructure) {
        if (Files.isWritable(Path.of(System.getProperty("user.dir")))) {
            System.out.println("Проверка наличия прав на создание папки прошла успешно...[ok]");
        } else {
            System.out.println("Ошибка! Нет прав на создание папки в " +
                    System.getProperty("user.dir") + " Программа завершена...[ОШИБКА]");
            System.exit(0);
        }

        Collection<File> folders = foldersStructure.values();
        for (File folder : folders) {
            folder.mkdirs();
            System.out.println("Папка " + folder + " создана...[ok]");
        }
    }
}
