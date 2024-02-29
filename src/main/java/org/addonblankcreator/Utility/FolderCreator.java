package org.addonblankcreator.Utility;

import java.io.File;
import java.util.HashMap;

/**
 * Interface that used for creating folders.
 * It contains methods to create folders.
 */
public interface FolderCreator {
    /**
     * Method that should use for create folders via full folders structure.
     *
     * @param foldersStructure HashMap of folders structure where
     *                         <p>{@code String} - a path file key name;</p>
     *                         <p>{@code File} - a path of file.</p>
     * @see HashMap
     * @see File
     */
    void createFolders(HashMap<String, File> foldersStructure);
}