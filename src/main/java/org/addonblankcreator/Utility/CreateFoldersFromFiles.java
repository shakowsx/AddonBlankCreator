package org.addonblankcreator.Utility;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;

/**
 * This class creates folders using folders structure.
 *
 * @see File
 */
public class CreateFoldersFromFiles implements FolderCreator {
    /**
     * Creates folders. It takes folder from HasMap of Files one by one and creates them.
     * Before creating it checks for permission to write folder.
     * @param foldersStructure HashMap of folders structure where
     *                         <p>String - a path file key name;</p>
     *                         <p>File - a path of file.</p>
     * @see HashMap
     * @see File
     * @see AccessChecker
     */
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
