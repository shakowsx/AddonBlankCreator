package org.addonblankcreator;

import org.addonblankcreator.Objects.Addon;
import org.addonblankcreator.Utility.*;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        // Checking for permission to write to a folder.
        if (Files.isWritable(Path.of(System.getProperty("user.dir")))) {
            // has write access.
            System.out.println("Проверка наличия прав записи в папке " + Path.of(System.getProperty("user.dir")) +
                    "...[ok]");
        } else {
            // no write access.
            System.out.println("Проверка наличия прав записи в папке" + Path.of(System.getProperty("user.dir")) +
                    "...[ОШИБКА]");
            System.out.println("Для создания файлов требуются права на запись. Убедитесь, в наличии прав на запись" +
                    " и перезапустите программу.");
            System.exit(0);
        }

        // Addon data collection.
        Addon addon = new Addon(
                "",
                "Cart-Power: Blank addon name",
                "Cart-Power: Заготовка имени модуля",
                "Blank description of the addon.",
                "Заготовка описания модуля."
                );

        AddonDetails addonDetails = new AddonDetailsFromConsole();
        addonDetails.setAddonId(addon);
        System.out.println("Создание модуля \"" + addon.getId() + "\"...");

        // Writing addon directories.
        System.out.println("Создание структуры каталога...");
        Addon.createAddonStructure(addon);
        FolderCreator folderCreator = new CreateFoldersFromFiles();
        folderCreator.createFolders(Addon.FOLDER_STRUCTURE);

        // Writing addon.xml file.
        Writer writer = new WritingFileFromCode();
        writer.writeAddonXML(addon);

        // Coping addon icon.
        try {
            CopyFile copyFile = new CopyFileFromResources();
            copyFile.copy(Addon.ICON_INPUT_PATH,Addon.getIconOutputPath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Writing language variables files.
        writer.writeLangVars(addon);

        // Finishing module creation.
        System.out.println("Создание модуля завершено.");
    }
}