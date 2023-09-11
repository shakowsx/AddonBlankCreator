package org.addonblankcreator.Utility;

import org.addonblankcreator.Objects.Addon;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CreateFoldersFromFiles implements FolderCreator {

    public void createFolders(List<File> foldersStructure) {
        if (Files.isWritable(Path.of(System.getProperty("user.dir")))) {
            System.out.println("Проверка наличия прав на создание папки прошла успешно...[ok]");
        } else {
            System.out.println("Ошибка! Нет прав на создание папки в " +
                    System.getProperty("user.dir") + " Программа завершена...[ОШИБКА]");
            System.exit(0);
        }

        for (File folder : foldersStructure) {
            folder.mkdirs();
            System.out.println("Папка " + folder + " создана...[ok]");
        }
    }
}
