package org.addonblankcreator;

import org.addonblankcreator.Objects.Addon;
import org.addonblankcreator.Utility.*;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        // Checking for permission to write to a folder.
        AccessChecker accessChecker = new FileWriteAccess();
        accessChecker.checkWriteAccess(Path.of(System.getProperty("user.dir")));

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
        AddonWriter writer = new WritingFileFromCode();
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