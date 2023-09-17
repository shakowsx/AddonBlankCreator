package org.addonblankcreator.Utility;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;

public class CreateFoldersFromFiles implements FolderCreator {
    public void createFolders(HashMap<String, File> foldersStructure) {
        // Checking for permission to write to a folder.
        AccessChecker accessChecker = new FileWriteAccess();
        accessChecker.checkWriteAccess(Path.of(System.getProperty("user.dir")));

        // Creating folders.
        Collection<File> folders = foldersStructure.values();
        for (File folder : folders) {
            folder.mkdirs();
            System.out.println("Папка " + folder + " создана...[ok]");
        }
    }
}
